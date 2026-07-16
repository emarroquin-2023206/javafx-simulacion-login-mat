/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eduardomarroquin.view;

import com.eduardomarroquin.controller.ImageController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *Decidi crear esta clase para manejas de manera mas facil los tools de la estetica :D
 * @author Fel
 */
public class MensajeView extends BorderPane {

    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;
    private VBox cajaVertical;
    private ImageView imgMensaje;
    private Label lblMensaje;
    private Button btnAceptar;
    private Stage escenarioMensaje;
    private String RUTA_ESTILOS = "/com/eduardomarroquin/styles/";

    public MensajeView(String mensaje, boolean mostrarImagen) {
        this.getStylesheets().add(RUTA_ESTILOS + "LoginStyles.css");
        this.setPadding(new Insets(20));
        this.setBorder(new Border(
                new BorderStroke(Paint.valueOf("#39C5BB"),
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(24), //estilo de línea
                        new BorderWidths(3))
        ));
        this.setBackground(new Background(
                new BackgroundFill(Paint.valueOf("#121212"),
                        new CornerRadii(25), Insets.EMPTY)));

        barraDeVentana = new HBox(20);
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("JAVAFX - MAT - SIMULADOR LOGIN");
        lblTituloVentana.setTextFill(Paint.valueOf("#FFFFFF"));
        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);
        this.setTop(barraDeVentana);

        cajaVertical = new VBox(15);
        cajaVertical.setAlignment(Pos.CENTER);

        if (mostrarImagen) {
            imgMensaje = new ImageView(new ImageController().getImageLogin("alerta"));
            imgMensaje.setFitHeight(100);
            imgMensaje.setFitWidth(100);
            imgMensaje.setCache(true);
            cajaVertical.getChildren().add(imgMensaje);
        }

        lblMensaje = new Label(mensaje);
        lblMensaje.setTextFill(Paint.valueOf("#FFFFFF"));
        lblMensaje.setWrapText(true);
        lblMensaje.setMaxWidth(260);
        lblMensaje.setAlignment(Pos.CENTER);
        lblMensaje.setStyle("-fx-font-size: 14px; -fx-text-alignment: center;");

        btnAceptar = new Button("OK");

        cajaVertical.getChildren().addAll(lblMensaje, btnAceptar);
        this.setCenter(cajaVertical);

        btnCerrarVentana.setOnMouseClicked((evento) -> cerrar());
        btnAceptar.setOnMouseClicked((evento) -> cerrar());
    }

    /**
     * Muestra la ventana de mensaje, modal sobre el escenario que se le pase.
     */
    public void mostrar(Stage propietario) {
        escenarioMensaje = new Stage();
        escenarioMensaje.initOwner(propietario);
        escenarioMensaje.initModality(Modality.APPLICATION_MODAL);
        escenarioMensaje.initStyle(StageStyle.TRANSPARENT);

        Scene escena = new Scene(this);
        escena.setFill(Color.TRANSPARENT);
        escenarioMensaje.setScene(escena);
        escenarioMensaje.sizeToScene();
        escenarioMensaje.showAndWait();
    }

    private void cerrar() {
        if (escenarioMensaje != null) {
            escenarioMensaje.close();
        }
    }
}
