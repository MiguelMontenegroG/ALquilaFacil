package co.edu.uniquindio.pagaFacil.app;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PagaFacilApp {
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader( PagaFacilApp.class.getResource("/inicio.fxml") );
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("pagaFacil");
        stage.show();

    }


    public static void main(String[] args) {

    }
}
