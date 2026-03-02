package org.example.uberprojectentityservice.Models;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ExactLocation extends BaseModel{
    private double lattitude;
    private double longitude;
}
