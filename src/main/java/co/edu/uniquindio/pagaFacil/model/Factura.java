package co.edu.uniquindio.pagaFacil.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Factura {
    private Alquiler alquiler;
    private double costoTotal;
}
