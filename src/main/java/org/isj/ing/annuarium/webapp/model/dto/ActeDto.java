package org.isj.ing.annuarium.webapp.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ActeDto {
    private String numero;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String lieuNaissance;
    private String nomPrenomMere;
    private String nomPrenomPere;
}
