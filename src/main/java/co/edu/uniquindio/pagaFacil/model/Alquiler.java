package co.edu.uniquindio.pagaFacil.model;

import lombok.*;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alquiler {
 Vehiculo vehiculo;
 LocalDate fechaAlquiler;
 LocalDate fechaRegreso;
 public double calcularCostoTotal() {
  long diasAlquilados = ChronoUnit.DAYS.between(fechaAlquiler, fechaRegreso);
  return diasAlquilados * vehiculo.getPrecioAlquiler();
 }
}
