package objetos;
import java.util.ArrayList;
import java.util.List;

public class RegistroClientesVehiculo {
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;

    public RegistroClientesVehiculos() {
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }

    public Cliente registrarCliente(String nombre, String correo) {
        if (nombre == null || correo == null || nombre.isEmpty() || correo.isEmpty()) {
            return null; // Campos obligatorios faltantes
        }

        Cliente nuevoCliente = new Cliente(nombre, correo);
        if (clientes.contains(nuevoCliente)) {
            return null; // Cliente ya registrado
        }

        clientes.add(nuevoCliente);
        return nuevoCliente;
    }

    public Vehiculo registrarVehiculo(String placa, String marca, int anio) {
        if (placa == null || marca == null || placa.isEmpty() || marca.isEmpty() || anio < 0) {
            return null; // Campos obligatorios faltantes o valor numérico negativo
        }

        Vehiculo nuevoVehiculo = new Vehiculo(placa, marca, anio);
        if (vehiculos.contains(nuevoVehiculo)) {
            return null; // Vehículo ya registrado
        }

        vehiculos.add(nuevoVehiculo);
        return nuevoVehiculo;
    }

    public static void main(String[] args) {
        RegistroClientesVehiculos registro = new RegistroClientesVehiculos();

        Cliente cliente1 = registro.registrarCliente("Juan Perez", "juan@example.com");
        if (cliente1 != null) {
            System.out.println("Cliente registrado: " + cliente1.getNombre());
        } else {
            System.out.println("Error al registrar el cliente.");
        }

        Vehiculo vehiculo1 = registro.registrarVehiculo("ABC123", "Toyota", 2020);
        if (vehiculo1 != null) {
            System.out.println("Vehículo registrado: " + vehiculo1.getPlaca());
        } else {
            System.out.println("Error al registrar el vehículo.");
        }

        // Intentar registrar un cliente con el mismo correo (debería fallar)
        Cliente cliente2 = registro.registrarCliente("Maria Lopez", "juan@example.com");
        if (cliente2 != null) {
            System.out.println("Cliente registrado: " + cliente2.getNombre());
        } else {
            System.out.println("Error al registrar el cliente.");
        }

        // Intentar registrar un vehículo con la misma placa (debería fallar)
        Vehiculo vehiculo2 = registro.registrarVehiculo("ABC123", "Honda", 2019);
        if (vehiculo2 != null) {
            System.out.println("Vehículo registrado: " + vehiculo2.getPlaca());
        } else {
            System.out.println("Error al registrar el vehículo.");
        }
    }
}
