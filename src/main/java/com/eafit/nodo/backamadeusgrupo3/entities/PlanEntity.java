package com.eafit.nodo.backamadeusgrupo3.entities;

import com.eafit.nodo.backamadeusgrupo3.entities.embeddable.FlightOption;
import com.eafit.nodo.backamadeusgrupo3.entities.embeddable.HotelOption;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity(name = "plans")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class PlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 500)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 255)
    private String destinationName;

    @Column(nullable = false, length = 255)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private DestinationInfoEntity destination;

    @ElementCollection
    private List<FlightOption> flightOptions;

    @ElementCollection
    private List<HotelOption> hotelOptions;
}