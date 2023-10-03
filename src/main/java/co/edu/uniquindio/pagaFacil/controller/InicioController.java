package co.edu.uniquindio.pagaFacil.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
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
    }

}

