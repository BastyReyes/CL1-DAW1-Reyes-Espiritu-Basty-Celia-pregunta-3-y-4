package pe.edu.i202030280.cl1_jpa_data_reyes_espiritu_basty_celia.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    private String Name;

    @ManyToOne
    @JoinColumn(name = "CountryCode", nullable = false)
    private Country country;

    private String District;

    private Integer Population;
}

