package co.edu.uniquindio.pagaFacil.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alquiler {
 LocalDate fechaAlquiler;
 LocalDate fechaRegreso;
}
