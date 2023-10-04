package co.edu.uniquindio.pagaFacil.controller;

import co.edu.uniquindio.pagaFacil.exception.CampoObligatorio;
import co.edu.uniquindio.pagaFacil.exception.InformacionNoExiste;
import co.edu.uniquindio.pagaFacil.exception.InformacionRepetirException;
import co.edu.uniquindio.pagaFacil.model.AlquilaFacil;
import co.edu.uniquindio.pagaFacil.model.Cliente;
import co.edu.uniquindio.pagaFacil.model.Vehiculo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
            Vehiculo vehiculo = alquilaFacil.registrarVehiculo(
                    placaVehiculoTextField.getText(),
                    vehiculoTextField.getText(),
                    marcaVehiculoTextField.getText(),
                    modeloVehiculoTextField.getText(),
                    Double.parseDouble(kilometrajeVehiculoTextField.getText()),
                    Double.parseDouble(valorAlquilerVehiculoTextField.getText()),
            );

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

}


