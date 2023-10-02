//package co.edu.uniquindio.pagaFacil.model;
//import java.util.ArrayList;
//import java.util.List;
//import lombok.*;
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//
//public class RegistroClientesVehiculo {
//    private List<Cliente> clientes;
//    private List<Vehiculo> vehiculos;
//
//    public RegistroClientesVehiculo() {
//        this.clientes = new ArrayList<>();
//        this.vehiculos = new ArrayList<>();
//    }
//
//    public Cliente registrarCliente(String nombre, String correo) {
//        if (nombre == null || correo == null || nombre.isEmpty() || correo.isEmpty()) {
//            return null; // Campos obligatorios faltantes
//        }
//
//        Cliente nuevoCliente = new Cliente(nombre, correo);
//        if (clientes.contains(nuevoCliente)) {
//            return null; // Cliente ya registrado
//        }
//
//        clientes.add(nuevoCliente);
//        return nuevoCliente;
//    }
//
//    public Vehiculo registrarVehiculo(String placa, String marca, int anio) {
//        if (placa == null || marca == null || placa.isEmpty() || marca.isEmpty() || anio < 0) {
//            return null; // Campos obligatorios faltantes o valor numérico negativo
//        }
//
//        Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, anio);
//        if (vehiculos.contains(nuevoVehiculo)) {
//            return null; // Vehículo ya registrado
//        }
//
//        vehiculos.add(nuevoVehiculo);
//        return nuevoVehiculo;
//    }
//}
