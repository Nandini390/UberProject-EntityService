package org.example.uberprojectentityservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@Table(indexes={
//        @Index(columnList = "driver_id")
//})
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","bookings"})
public class Booking extends BaseModel{

    @Enumerated(value= EnumType.STRING)
    private BookingStatus bookingStatus;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Long totalDistance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="driver_id")
    private Driver driver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="passenger_id")
    private Passenger passenger;

    @OneToOne(cascade = CascadeType.ALL)
    private ExactLocation startLocation;

    @OneToOne(cascade =CascadeType.ALL)
    private ExactLocation endLocation;
}
