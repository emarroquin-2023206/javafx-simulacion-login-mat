/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eduardomarroquin.view;
 
import com.eduardomarroquin.controller.ImageController;
import com.eduardomarroquin.model.Usuario;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author informatica
 */
public class BienvenidaView extends VBox {

    private static BienvenidaView instanciaBienvenidaView;
    private HBox barraDeVentana;
    private Button btnCerrarVentana;
    private Label lblTituloVentana;
    private VBox cajaVertical;
    private ImageView imgBienvenida;
    private Label lblBienvenida;
    private Label lblNombreUsuario;
    private Label lblRolUsuario;
    private Button btnCerrarSesion;
    private String RUTA_ESTILOS = "/com/eduardomarroquin/styles/";

    private Stage escenarioBienvenida;
    private double ejeY = 0;
    private double ejeX = 0;

    private BienvenidaView() {
        this.getStylesheets().add(RUTA_ESTILOS + "LoginStyles.css");
        this.setPadding(new Insets(20));
        this.setBorder(new Border(
                new BorderStroke(Paint.valueOf("#39C5BB"),
                        BorderStrokeStyle.SOLID,
                        new CornerRadii(24), //estilo de línea 
                        new BorderWidths(3))
        ));
        this.setBackground(new Background(new BackgroundFill(Paint.valueOf("#121212"), new CornerRadii(25), Insets.EMPTY)));

        barraDeVentana = new HBox(20);
        btnCerrarVentana = new Button("X");
        lblTituloVentana = new Label("JAVAFX - MAT - SIMULADOR LOGIN");
        lblTituloVentana.setTextFill(Paint.valueOf("#FFFFFF"));
        barraDeVentana.getChildren().addAll(btnCerrarVentana, lblTituloVentana);

        cajaVertical = new VBox(15);
        cajaVertical.setAlignment(Pos.CENTER);

        imgBienvenida = new ImageView(new ImageController().getImageLogin("bienvenida"));
        imgBienvenida.setFitHeight(100);
        imgBienvenida.setFitWidth(100);
        imgBienvenida.setCache(true);

        lblBienvenida = new Label("¡Bienvenido!");
        lblBienvenida.setTextFill(Paint.valueOf("#39C5BB"));
        lblBienvenida.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        lblNombreUsuario = new Label();
        lblNombreUsuario.setTextFill(Paint.valueOf("#FFFFFF"));
        lblNombreUsuario.setStyle("-fx-font-size: 14px;");

        lblRolUsuario = new Label();
        lblRolUsuario.setTextFill(Paint.valueOf("#FFFFFF"));

        btnCerrarSesion = new Button("Cerrar Sesión");

        cajaVertical.getChildren().addAll(imgBienvenida, lblBienvenida, lblNombreUsuario, lblRolUsuario, btnCerrarSesion);

        this.setAlignment(Pos.CENTER);
        this.getChildren().addAll(barraDeVentana, cajaVertical);

        construirAcciones();
    }

    private void construirAcciones() {
        this.btnCerrarVentana.setOnMouseClicked((evento) -> cerrar());
        this.btnCerrarSesion.setOnMouseClicked((evento) -> cerrar());

        this.setOnMouseClicked((evento) -> {
            ejeX = evento.getSceneX();
            ejeY = evento.getSceneY();
        });
        this.setOnMouseDragged((evento) -> {
            double ejeXVentanaDesplazamiento = evento.getScreenX();
            double ejeYVentanaDesplazamiento = evento.getScreenY();
            escenarioBienvenida.setX(ejeXVentanaDesplazamiento - ejeX);
            escenarioBienvenida.setY(ejeYVentanaDesplazamiento - ejeY);
        });
    }

    public void mostrarDatosUsuario(Usuario usuario) {
        this.lblNombreUsuario.setText("Usuario: " + usuario.getNombreCompleto());
        this.lblRolUsuario.setText("Rol: " + usuario.getRol());
    }

 
    public void mostrar(Stage propietario) {
        if (escenarioBienvenida == null) {
            escenarioBienvenida = new Stage();
            escenarioBienvenida.initOwner(propietario);
            escenarioBienvenida.initStyle(StageStyle.TRANSPARENT);

            Scene escena = new Scene(this);
            escena.setFill(Color.TRANSPARENT);
            escenarioBienvenida.setScene(escena);
            escenarioBienvenida.sizeToScene();
        }
        escenarioBienvenida.show();
        escenarioBienvenida.toFront();
    }

    private void cerrar() {
        if (escenarioBienvenida != null) {
            escenarioBienvenida.hide();
        }
    }

    public static BienvenidaView getInstanciaBienvenidaView() {

        if (instanciaBienvenidaView == null) {
            instanciaBienvenidaView = new BienvenidaView();
        }

        return instanciaBienvenidaView;
    }

    public static void setInstanciaBienvenidaView(BienvenidaView instanciaBienvenidaView) {

        BienvenidaView.instanciaBienvenidaView = instanciaBienvenidaView;
    }

    public HBox getBarraDeVentana() {
        return barraDeVentana;
    }

    public void setBarraDeVentana(HBox barraDeVentana) {
        this.barraDeVentana = barraDeVentana;
    }

    public Button getBtnCerrarVentana() {
        return btnCerrarVentana;
    }

    public void setBtnCerrarVentana(Button btnCerrarVentana) {
        this.btnCerrarVentana = btnCerrarVentana;
    }

    public Label getLblTituloVentana() {
        return lblTituloVentana;
    }

    public void setLblTituloVentana(Label lblTituloVentana) {
        this.lblTituloVentana = lblTituloVentana;
    }

    public VBox getCajaVertical() {
        return cajaVertical;
    }

    public void setCajaVertical(VBox cajaVertical) {
        this.cajaVertical = cajaVertical;
    }

    public ImageView getImgBienvenida() {
        return imgBienvenida;
    }

    public void setImgBienvenida(ImageView imgBienvenida) {
        this.imgBienvenida = imgBienvenida;
    }

    public Label getLblBienvenida() {
        return lblBienvenida;
    }

    public void setLblBienvenida(Label lblBienvenida) {
        this.lblBienvenida = lblBienvenida;
    }

    public Label getLblNombreUsuario() {
        return lblNombreUsuario;
    }

    public void setLblNombreUsuario(Label lblNombreUsuario) {
        this.lblNombreUsuario = lblNombreUsuario;
    }

    public Label getLblRolUsuario() {
        return lblRolUsuario;
    }

    public void setLblRolUsuario(Label lblRolUsuario) {
        this.lblRolUsuario = lblRolUsuario;
    }

    public Button getBtnCerrarSesion() {
        return btnCerrarSesion;
    }

    public void setBtnCerrarSesion(Button btnCerrarSesion) {
        this.btnCerrarSesion = btnCerrarSesion;
    }
}

 