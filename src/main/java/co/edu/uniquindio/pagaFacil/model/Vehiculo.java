package co.edu.uniquindio.pagaFacil.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vehiculo {
    private String plalca;
    private String nombre;
    private String marca;
    private String modelo;
    private String foto;
    private String kilometraje;
    private Float precioAlquiler;
    private Boolean Automatico;

}
