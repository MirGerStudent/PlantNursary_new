package plant_nursery.app.core.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import plant_nursery.app.core.model.enums.GroundType;
import plant_nursery.app.core.model.enums.PlaceType;
import plant_nursery.app.core.model.enums.WinterHardinessType;

@Getter
@Setter
@ToString
@Entity
@Table(name = "plant")
@NoArgsConstructor
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plant_type_id")
    @JsonProperty
    private PlaceType plantType;

    @JsonProperty
    private String name;

    @JsonProperty
    private Float height;

    @JsonProperty
    private Float diameter;

    @ManyToOne
    @JoinColumn(name = "winter_hardiness_type_id")
    @JsonProperty
    private WinterHardinessType winterHardinessType;

    @ManyToOne
    @JoinColumn(name = "place_type_id")
    @JsonProperty
    private PlaceType placeType;

    @ManyToOne
    @JoinColumn(name = "ground_type_id")
    @JsonProperty
    private GroundType groundType;

    @JsonProperty
    private String peculiarities;
}