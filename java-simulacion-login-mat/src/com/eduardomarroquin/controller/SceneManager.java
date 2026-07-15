/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eduardomarroquin.controller;

import com.eduardomarroquin.view.LoginView;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;

/**
 *
 *
 *
 * @author informatica
 *
 */
public class SceneManager {

    private static SceneManager instanciaSceneManager;
    private Stage escenarioPrincipal, escenarioSecundario;
    private Scene escenaPrinicpal;

    private SceneManager() {

    }

    public void cambiarEscenaPrincipal(Pane Panel, int ancho, int alto) {

        try {

            escenaPrinicpal = new Scene(Panel, ancho, alto);
            escenarioPrincipal.setScene(escenaPrinicpal);
            escenarioPrincipal.sizeToScene();
            escenarioPrincipal.show();

        } catch (NullPointerException ObjetoNulo) {

            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Cambiar Escenario Principal");
            ObjetoNulo.printStackTrace();

        } catch (Exception errorPadre) {

            JOptionPane.showMessageDialog(null, "Error padre: Ventana login");
            errorPadre.printStackTrace();
        }
    }

    public void ventanaLogin() {

        try {

            //Metodo que oculta las opciones de ventana por defecto
            this.escenarioPrincipal.initStyle(StageStyle.TRANSPARENT);
            LoginView login = LoginView.getInstanciaLoginView();
            cambiarEscenaPrincipal(login, 370, 425);
            this.escenaPrinicpal.setFill(Color.TRANSPARENT);
            new LoginController(login);
        } catch (NullPointerException objetoNulo) {

            JOptionPane.showMessageDialog(null, "Error de objeto nulo: Ventana Login");
            objetoNulo.printStackTrace(); //Imprime todo el camino hacia el error

        } catch (Exception errorPadre) {

            JOptionPane.showMessageDialog(null, "Error padre: Ventana Login");
            errorPadre.printStackTrace();
        }
    }

    public static SceneManager getInstanciaSceneManager() {

        if (instanciaSceneManager == null) {
            instanciaSceneManager = new SceneManager();
        }

        return instanciaSceneManager;
    }

    public static void setInstanciaSceneManager(SceneManager instanciaSceneManager) {

        SceneManager.instanciaSceneManager = instanciaSceneManager;
    }

    public Stage getEscenarioPrincipal() {

        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Stage escenarioPrincipal) {

        this.escenarioPrincipal = escenarioPrincipal;
    }

    public Stage getEscenarioSecundario() {

        return escenarioSecundario;
    }

    public void setEscenarioSecundario(Stage escenarioSecundario) {

        this.escenarioSecundario = escenarioSecundario;
    }

    public Scene getEscenaPrinicpal() {

        return escenaPrinicpal;
    }

    public void setEscenaPrinicpal(Scene escenaPrinicpal) {

        this.escenaPrinicpal = escenaPrinicpal;
    }
}
