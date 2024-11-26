package pe.edu.i202030280.cl1_jpa_data_reyes_espiritu_basty_celia.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryLanguagePK implements Serializable {

    @Column(name = "CountryCode")
    private String CountryCode;
    private String Language;
}
