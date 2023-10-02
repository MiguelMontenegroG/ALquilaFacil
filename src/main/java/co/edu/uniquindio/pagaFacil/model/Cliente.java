package co.edu.uniquindio.pagaFacil.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    private  String cedula;
    private  String nombre;
    private String teléfono;
    private String email;
    private String ciudad;
    private  String dirección;



}
