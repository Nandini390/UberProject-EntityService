package org.example.uberprojectentityservice.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NamedLocation extends BaseModel{

    @OneToOne
    private ExactLocation exactLocation;
    private String name;
    private String zipCode;
    private String city;
    private String country;
    private String state;
}
