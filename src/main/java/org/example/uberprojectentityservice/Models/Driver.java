package org.example.uberprojectentityservice.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","bookings"})
public class Driver extends BaseModel{

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @Column(unique = true)
    private String licenseNumber;

    @Pattern(regexp = "\\d{12}", message = "Aadhar must be 12 digits")
    @Column(unique = true)
    private String aadharCard;

    @Column(unique = true)
    private String phoneNumber;

    @OneToOne(mappedBy = "driver",cascade = CascadeType.ALL)
    private Car car;

    @Enumerated(value = EnumType.STRING)
    private DriverApprovalStatus driverApprovalStatus=DriverApprovalStatus.PENDING;

    @OneToOne
    private ExactLocation lastKnownLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;

    @DecimalMin(value ="0.00",message = "Rating must be greater than or equal to 0.00")
    @DecimalMax(value ="5.00", message= " Rating must be less than or equal to 5.00")
    private Double rating=0.0;

    private Boolean isAvailable=false;

    @Column(nullable = true)
    private String denialReason;

    //1:n, driver:booking
    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings= new ArrayList<>();

}
