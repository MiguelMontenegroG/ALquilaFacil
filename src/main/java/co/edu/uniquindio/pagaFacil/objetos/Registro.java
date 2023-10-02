package co.edu.uniquindio.pagaFacil.objetos;


import co.edu.uniquindio.pagaFacil.objetos.Cliente;
import co.edu.uniquindio.pagaFacil.objetos.Vehiculo;

import java.util.ArrayList;
import java.util.List;

public class Registro {
    private List<Cliente> clientes;
    private List<Vehiculo> vehiculos;

    public Registro() {
        this.clientes = new ArrayList<>();
        this.vehiculos = new ArrayList<>();
    }
}