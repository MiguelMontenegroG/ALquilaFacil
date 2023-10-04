package co.edu.uniquindio.pagaFacil.controller;

import co.edu.uniquindio.pagaFacil.exception.CampoObligatorio;
import co.edu.uniquindio.pagaFacil.exception.InformacionNoExiste;
import co.edu.uniquindio.pagaFacil.exception.InformacionRepetirException;
import co.edu.uniquindio.pagaFacil.model.AlquilaFacil;
import co.edu.uniquindio.pagaFacil.model.Alquiler;
import co.edu.uniquindio.pagaFacil.model.Cliente;
import co.edu.uniquindio.pagaFacil.model.Vehiculo;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InicioController {

    @FXML
    private TextField nombreClienteTextField;
    @FXML
    private TextField cedulaClienteTextField;
    @FXML
    private TextField telefonoClienteTextField;
    @FXML
    private TextField correoClienteTextField;
    @FXML
    private TextField ciudadClienteTextField;
    @FXML
    private TextField direccionClienteTextField;
    @FXML
    private Button registrarClienteButton;

    @FXML
    private TextField vehiculoTextField;
    @FXML
    private TextField placaVehiculoTextField;
    @FXML
    private TextField marcaVehiculoTextField;
    @FXML
    private TextField modeloVehiculoTextField;
    @FXML
    private TextField kilometrajeVehiculoTextField;
    @FXML
    private TextField valorAlquilerVehiculoTextField;
    @FXML
    private Button registrarVehiculoButton;

    @FXML
    private TableView<String> vehiculosEnAlquilerTableView;
    @FXML
    private TableColumn<String, String> columnaVehiculo;
    @FXML
    private TableColumn<String, String> columnaPlaca;
    @FXML
    private TableColumn<String, String> columnaMarca;
    @FXML
    private TableColumn<String, String> columnaModelo;
    @FXML
    private TableColumn<String, String> columnaKilometraje;
    @FXML
    private TableColumn<String, String> columnaValorDia;
    @FXML
    private DatePicker fechaInicioAlquilerDatePicker;
    @FXML
    private DatePicker fechaFinAlquilerDatePicker;
    @FXML
    private Button valorarAlquilerButton;
    @FXML
    private ImageView fotoVehiculoImageView;
    @FXML
    private TableView<String> movimientosTableView;
    @FXML
    private TableColumn<String, String> columnaVehiculoMovimiento;
    @FXML
    private TableColumn<String, String> columnaAlquilerMovimiento;
    @FXML
    private DatePicker fechaMovimientosDatePicker;
    @FXML
    private Button buscarMovimientosButton;
    @FXML
    private DatePicker fechaInicioGananciaDatePicker;
    @FXML
    private DatePicker fechaFinGananciaDatePicker;
    @FXML
    private Button buscarGananciasButton;
    @FXML
    private Button buscarMarcaMasVendidaButton;
    private ObservableList<String> movimientosData = FXCollections.observableArrayList();

    private List<Vehiculo> filtrarVehiculosPorFecha(LocalDate fecha) {
        List<Vehiculo> vehiculosAlquilados = new ArrayList<>();

        Alquiler[] listaDeAlquileres = new Alquiler[0];
        for (Alquiler alquiler : listaDeAlquileres) {
            if (alquiler.getFechaInicio().isBefore(Instant.from(fecha)) && alquiler.getFechaFin().isAfter(Instant.from(fecha))) {
                Vehiculo vehiculoAlquilado = alquiler.getVehiculo();
                vehiculosAlquilados.add(vehiculoAlquilado);
            }
        }

        return vehiculosAlquilados;
    }

    @FXML
    private TabPane tabPane;

    @FXML
    private void initialize() {
        columnaVehiculo.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        columnaPlaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        columnaMarca.setCellValueFactory(new PropertyValueFactory<>("marca"));
        columnaModelo.setCellValueFactory(new PropertyValueFactory<>("modelo"));
        columnaKilometraje.setCellValueFactory(new PropertyValueFactory<>("kilometraje"));
        columnaValorDia.setCellValueFactory(new PropertyValueFactory<>("valorDia"));

        vehiculosEnAlquilerTableView.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends Vehiculo> observable, Vehiculo vehiculoAnterior, Vehiculo vehiculoNuevo) -> {
                    if (vehiculoNuevo != null) {
                        Object valorDia = vehiculoNuevo.getPrecioAlquiler();
                        System.out.println("Vehículo seleccionado: " + vehiculoNuevo.getNombre());
                    } else {
                        System.out.println("Ningún vehículo seleccionado.");
                    }
                }
        );

        ObservableList<String> movimientosData = FXCollections.observableArrayList();

        movimientosTableView.setItems(movimientosData);

    }

    private AlquilaFacil alquilaFacil;


    @FXML
    private void registrarClienteButton() {
        try {
            Cliente cliente = alquilaFacil.registrarCliente(
                    cedulaClienteTextField.getText(),
                    nombreClienteTextField.getText(),
                    telefonoClienteTextField.getText(),
                    correoClienteTextField.getText(),
                    ciudadClienteTextField.getText(),
                    direccionClienteTextField.getText()
            );
            mostrarAlerta("Cliente registrado", "Se ha registrado correctamente el cliente " + cliente.getNombre(), Alert.AlertType.INFORMATION);
        } catch (CampoObligatorio | InformacionRepetirException | InformacionNoExiste e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    private void mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void registrarVehiculoButton() {
        try {
            String nombre;
            Vehiculo vehiculo = alquilaFacil.registrarVehiculo(
                    placaVehiculoTextField.getText(),
                    vehiculoTextField.getText(),
                    marcaVehiculoTextField.getText(),
                    modeloVehiculoTextField.getText(),
                    Double.parseDouble(kilometrajeVehiculoTextField.getText()),
                    Double.parseDouble(valorAlquilerVehiculoTextField.getText()),

                    String nombre = vehiculoTextField.getText();
                    String placa = placaVehiculoTextField.getText();
                    String marca = marcaVehiculoTextField.getText();
                    String modelo = modeloVehiculoTextField.getText();
                    double kilometraje = Double.parseDouble(kilometrajeVehiculoTextField.getText());
                    double valorDia = Double.parseDouble(valorAlquilerVehiculoTextField.getText());

                    Vehiculo vehiculo2 = new Vehiculo(nombre, placa, marca, modelo, kilometraje, valorDia);

                    vehiculosEnAlquilerTableView.getItems().add(String.valueOf(vehiculo));
            ;

            mostrarAlerta("Vehículo registrado", "Se ha registrado correctamente el vehículo con placa " + vehiculo.getPlaca(), Alert.AlertType.INFORMATION);
        } catch (CampoObligatorio | InformacionRepetirException | InformacionNoExiste | NumberFormatException e) {
            mostrarAlerta("Error", e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void setValorarAlquilerButton() {
        Vehiculo vehiculoSeleccionado = vehiculosEnAlquilerTableView.getSelectionModel().getSelectedItem();

        if (vehiculoSeleccionado != null) {
            LocalDate fechaInicio = fechaInicioAlquilerDatePicker.getValue();
            LocalDate fechaFin = fechaFinAlquilerDatePicker.getValue();

            if (fechaInicio != null && fechaFin != null) {
                int diasDeAlquiler = (int) ((LocalDate) fechaInicio).until(fechaFin).getDays();
                double valorPorDia = vehiculoSeleccionado.getPrecioAlquiler();
                double valorTotal = diasDeAlquiler * valorPorDia;

                mostrarAlerta("Valor de alquiler", "El valor de alquiler de " + diasDeAlquiler + " días es de: $" + valorTotal, Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "Selecciona fechas de inicio y fin de alquiler.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Error", "Selecciona un vehículo en la tabla.", Alert.AlertType.ERROR);
        }
    }

    mostrarAlerta(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void buscarMovimientos() {
        LocalDate fechaSeleccionada = fechaMovimientosDatePicker.getValue();

        if (fechaSeleccionada != null) {
            List<Vehiculo> vehiculosAlquilados = filtrarVehiculosPorFecha(fechaSeleccionada);

            movimientosData.clear();

            for (Vehiculo vehiculo : vehiculosAlquilados) {
                movimientosData.add("Vehículo: " + vehiculo.getNombre() + ", Alquiler: " + vehiculo.getPrecioAlquiler());
            }
        }
    }
    @FXML
    private void buscarMarcaMasVendidaButton() {
        ObservableList<Vehiculo> data = vehiculosEnAlquilerTableView.getItems();
        Map<String, Integer> conteoMarcas = new HashMap<>();

        for (Vehiculo vehiculo : data) {
            String marca = vehiculo.getMarca();
            conteoMarcas.put(marca, conteoMarcas.getOrDefault(marca, 0) + 1);
        }

        String marcaMasVendida = "";
        int cantidadMasVendida = 0;

        for (Map.Entry<String, Integer> entry : conteoMarcas.entrySet()) {
            if (entry.getValue() > cantidadMasVendida) {
                marcaMasVendida = entry.getKey();
                cantidadMasVendida = entry.getValue();
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("La marca más vendida es: " + marcaMasVendida + " con " + cantidadMasVendida + " unidades vendidas.");
        alert.showAndWait();
    }
    private List<Double> valoresTotalesDeAlquiler = new ArrayList<>();

    @FXML
    private void setValorarAlquilerButton() {
        Vehiculo vehiculoSeleccionado = vehiculosEnAlquilerTableView.getSelectionModel().getSelectedItem();

        if (vehiculoSeleccionado != null) {
            LocalDate fechaInicio = fechaInicioAlquilerDatePicker.getValue();
            LocalDate fechaFin = fechaFinAlquilerDatePicker.getValue();

            if (fechaInicio != null && fechaFin != null) {
                int diasDeAlquiler = (int) fechaInicio.until(fechaFin).getDays();
                double valorPorDia = vehiculoSeleccionado.getPrecioAlquiler();
                double valorTotal = diasDeAlquiler * valorPorDia;

                valoresTotalesDeAlquiler.add(valorTotal);

                mostrarAlerta("Valor de alquiler", "El valor de alquiler de " + diasDeAlquiler + " días es de: $" + valorTotal, Alert.AlertType.INFORMATION);
            } else {
                mostrarAlerta("Error", "Selecciona fechas de inicio y fin de alquiler.", Alert.AlertType.ERROR);
            }
        } else {
            mostrarAlerta("Error", "Selecciona un vehículo en la tabla.", Alert.AlertType.ERROR);
        }
    }


    @FXML
    private void buscarGananciasButton() {
        LocalDate fechaInicio = fechaInicioGananciaDatePicker.getValue();
        LocalDate fechaFin = fechaFinGananciaDatePicker.getValue();

        if (fechaInicio != null && fechaFin != null) {
            double ganancias = alquileresTableView.getItems().stream()
                    .filter(alquiler -> alquiler.getFechaInicio().isAfter(fechaInicio) && alquiler.getFechaFin().isBefore(fechaFin))
                    .mapToDouble(Alquiler::getValorTotal)
                    .sum();

            mostrarAlerta("Ganancias en el rango de fechas seleccionado", "Las ganancias son: $" + ganancias, Alert.AlertType.INFORMATION);
        } else {
            mostrarAlerta("Error", "Selecciona fechas de inicio y fin.", Alert.AlertType.ERROR);
        }
    }

    private List<Alquiler> obtenerAlquileres() {
        List<Alquiler> listaDeAlquileres = null;
        return listaDeAlquileres;
    }
}


