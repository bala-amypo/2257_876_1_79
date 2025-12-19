package com.example.demo.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.List;
import lombok.*;
@Entity
@Table(name = "vehicles", uniqueConstraints = @UniqueConstraint(columnNames = "vehicleNumber"))
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehicle {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@ManyToOne(fetch = FetchType.LAZY, optional = false)
@JoinColumn(name = "user_id")
private User user;
@NotBlank
@Size(min = 2, max = 50)
private String vehicleNumber;
@NotNull
@Positive
private Double capacityKg;
@NotNull
@Positive
private Double fuelEfficiency;
@OneToMany(mappedBy = "vehicle", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
private List<Shipment> shipments;
}