package co.edu.uniquindio.pagaFacil.model;

import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlquilaFacil {
    private List<Cliente> clientes = new ArrayList<>();
    private List<Vehiculo> vehiculos = new ArrayList<>();


    private  String nombre;
    private  String direccion;

    /**
     * Registro de clientes
     * @param cedula
     * @param nombreCompleto
     * @param telefono
     * @param email
     * @param ciudad
     * @param direccion
     * @return
     * @throws IllegalArgumentException
     */
    public Cliente registrarCliente(String cedula, String nombreCompleto, String telefono, String email, String ciudad, String direccion)
            throws IllegalArgumentException {
        // Validar campos obligatorios
        if (cedula.isEmpty() || nombreCompleto.isEmpty() || telefono.isEmpty() || email.isEmpty() || ciudad.isEmpty() || direccion.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        // Validar que la cédula no esté registrada previamente
        for (Cliente cliente : clientes) {
            if (cliente.getCedula().equals(cedula)) {
                throw new IllegalArgumentException("Cliente con la misma cédula ya registrado.");
            }
        }

        Cliente nuevoCliente = new Cliente(cedula, nombre, telefono, email, ciudad, direccion);
        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    /**
     * registro de vehiculos
     * @param placa
     * @param nombre
     * @param marca
     * @param modelo
     * @param foto
     * @param kilometraje
     * @param precioAlquiler
     * @param automatico
     * @param numeroSillas
     * @return
     * @throws IllegalArgumentException
     */
    public Vehiculo registrarVehiculo(String placa, String nombre, String marca, String modelo, String foto,
                                      Double kilometraje, Double precioAlquiler, Boolean automatico, int numeroSillas)
            throws IllegalArgumentException {
        // Validar campos obligatorios
        if (placa.isEmpty() || nombre.isEmpty() || marca.isEmpty() || modelo.isEmpty() || foto.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }

        // Validar que el precio de alquiler y el kilometraje no sean negativos
        if (precioAlquiler < 0 || kilometraje < 0) {
            throw new IllegalArgumentException("El precio de alquiler y el kilometraje no pueden ser negativos.");
        }

        // Validar que la placa no esté registrada previamente
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo.getPlaca().equals(placa)) {
                throw new IllegalArgumentException("Vehículo con la misma placa ya registrado.");
            }
        }

        Vehiculo nuevoVehiculo = new Vehiculo(placa,nombre,marca,modelo,foto,kilometraje,precioAlquiler,automatico,numeroSillas);
        vehiculos.add(nuevoVehiculo);
        return nuevoVehiculo;
    }
    public List<Vehiculo> obtenerVehiculosDisponiblesEnRangoOrdenados(LocalDate fechaInicio, LocalDate fechaFin) {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculoEstaDisponibleEnRango(vehiculo, fechaInicio, fechaFin))
                .sorted(Comparator.comparingDouble(Vehiculo::getPrecioAlquiler))
                .collect(Collectors.toList());
    }

    private boolean vehiculoEstaDisponibleEnRango(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin) {
        for (LocalDate fecha = fechaInicio; !fecha.isAfter(fechaFin); fecha = fecha.plusDays(1)) {
            if (!vehiculo.getFechasDisponibles().contains(fecha)) {
                return false;
            }
        }
        return true;
    }
}
