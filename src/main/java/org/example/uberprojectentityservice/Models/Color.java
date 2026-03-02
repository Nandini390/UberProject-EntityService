package org.example.uberprojectentityservice.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Color extends BaseModel{
    @Column(nullable = false,unique = true)
    private String color;
}
