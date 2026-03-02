package org.example.uberprojectentityservice.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseModel{

    @Column(unique = true, nullable = false)
    private String plateNumber;

    private String company;

    private String model;

    @Enumerated(value= EnumType.STRING)
    private CarType carType;

    @ManyToOne
    private Color color;

    @OneToOne
    private Driver driver;
}
