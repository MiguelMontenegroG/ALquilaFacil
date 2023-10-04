package co.edu.uniquindio.pagaFacil.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
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

    public Vehiculo(String placa, String nombre, String marca, String modelo, String foto, Double kilometraje, Double precioAlquiler, Boolean automatico, int numeroSillas, List<LocalDate> fechasDisponibles) {
        this.placa = placa;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.foto = foto;
        this.kilometraje = kilometraje;
        this.precioAlquiler = precioAlquiler;
        Automatico = automatico;
        this.numeroSillas = numeroSillas;
        this.fechasDisponibles = fechasDisponibles;
    }

    public Vehiculo(String placa, String nombre, String marca, String modelo, String foto, Double kilometraje, Double precioAlquiler, Boolean automatico, int numeroSillas) {

    }

    public void agregarFechaDisponible(LocalDate fecha) {
        fechasDisponibles.add(fecha);
    }

    public void eliminarFechaDisponible(LocalDate fecha) {
        fechasDisponibles.remove(fecha);
    }


}
