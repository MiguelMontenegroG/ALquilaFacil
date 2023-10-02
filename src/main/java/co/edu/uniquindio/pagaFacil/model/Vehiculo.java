package co.edu.uniquindio.pagaFacil.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Vehiculo {
    private String placa;
    private String nombre;
    private String marca;
    private String modelo;
    private String foto;
    private Double kilometraje;
    private Double precioAlquiler;
    private Boolean Automatico;
    private int numeroSillas;
    private List<LocalDate> fechasDisponibles = new ArrayList<>();

    public void agregarFechaDisponible(LocalDate fecha) {
        fechasDisponibles.add(fecha);
    }

    public void eliminarFechaDisponible(LocalDate fecha) {
        fechasDisponibles.remove(fecha);
    }


}
