/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eduardomarroquin.controller;

import com.eduardomarroquin.model.Usuario;
import com.eduardomarroquin.view.LoginView;
import com.eduardomarroquin.view.MensajeView;
import javafx.stage.Stage;

/**
 *
 * @author informatica
 */
public class LoginController {
    private final LoginView LOGIN_VIEW;
    private double ejeY = 0;
    private double ejeX = 0;
    private Stage escenario = SceneManager.getInstanciaSceneManager().getEscenarioPrincipal();

    public LoginController(LoginView loginView) {
        this.LOGIN_VIEW = loginView;
        construirAcciones();
    }
     
    public void construirAcciones(){
        this.LOGIN_VIEW.getBtnCerrarVentana().setOnMouseClicked(
        (evento) ->{
            System.exit(0);
        }
        );
        this.LOGIN_VIEW.setOnMouseClicked(
        (evento)->{
            ejeX = evento.getSceneX();
            ejeY = evento.getSceneY();
            System.out.println("X" + ejeX);
            System.out.println("Y" + ejeY);
        }
        );
        this.LOGIN_VIEW.setOnMouseDragged(
        (evento)->{
            double ejeXVentanaDesplazamiento = evento.getScreenX() ;
            double ejeYVentanaDesplazamiento = evento.getScreenY();
            
           
            System.out.println("X d" + (ejeXVentanaDesplazamiento - ejeX));
            System.out.println("Y d" + (ejeYVentanaDesplazamiento - ejeY));
            escenario.setX(ejeXVentanaDesplazamiento - ejeX);
            escenario.setY(ejeYVentanaDesplazamiento - ejeY);
        }
        );
        this.LOGIN_VIEW.getBtnIniciarSesion().setOnMouseClicked(
        (evento)->{
            iniciarSesion();
        });

       
        this.LOGIN_VIEW.getTxtNombreUsuario().textProperty().addListener(
        (observable, valorAnterior, valorNuevo) -> {
            if (!valorNuevo.trim().isEmpty()) {
                this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().removeAll("empty", "error");
            }
        });
        this.LOGIN_VIEW.getPwdClave().textProperty().addListener(
        (observable, valorAnterior, valorNuevo) -> {
            if (!valorNuevo.trim().isEmpty()) {
                this.LOGIN_VIEW.getPwdClave().getStyleClass().removeAll("empty", "error");
            }
        });
    }
    private AuthSistema authSistema = new AuthSistema();
    public void iniciarSesion(){
        String userName = this.LOGIN_VIEW.getTxtNombreUsuario().getText().trim();
        String clave =  this.LOGIN_VIEW.getPwdClave().getText().trim();
        if(userName.isEmpty()){
            mostrarMensaje("No deje el campo usuario vacio");
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("empty");
        }else if (clave.isEmpty()){
            this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().remove("empty");
            this.LOGIN_VIEW.getPwdClave().getStyleClass().add("empty");
            mostrarMensaje("No deje el campo contraseña vacio");
            
        }else{
            Usuario usuario = authSistema.login(userName, clave);
            if(usuario == null){
                this.LOGIN_VIEW.getTxtNombreUsuario().getStyleClass().add("error");
                this.LOGIN_VIEW.getPwdClave().getStyleClass().add("error");
                mostrarMensaje("Valide sus credenciales");
            }
            else{
                SceneManager.getInstanciaSceneManager().ventanaBienvenida(usuario);
            }
        }
    }

    
    private void mostrarMensaje(String mensaje) {
        MensajeView mensajeView = new MensajeView(mensaje, true);
        mensajeView.mostrar(escenario);
    }
}