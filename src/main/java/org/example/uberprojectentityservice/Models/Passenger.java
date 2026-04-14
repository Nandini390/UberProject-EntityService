package org.example.uberprojectentityservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","bookings"})
public class Passenger extends BaseModel{

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    @OneToMany(mappedBy = "passenger")
    private List<Booking> bookings= new ArrayList<>();

    @OneToOne
    private Booking activeBooking;

    @DecimalMin(value ="0.00",message = "Rating must be greater than or equal to 0.00")
    @DecimalMax(value ="5.00", message= " Rating must be less than or equal to 5.00")
    private Double rating=0.0;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;
}
