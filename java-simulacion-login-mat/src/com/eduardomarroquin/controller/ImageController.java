/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eduardomarroquin.controller;

import javafx.scene.image.Image;

/**
 *
 * @author informatica
 */
public class ImageController {

    private final String RUTA_IMAGENES = "/com/eduardomarroquin/resources/";
    Image imagenAMostrar;
    
    public Image getImageLogin(String nombreImagen) {
        switch (nombreImagen) {
            case "logo":
                imagenAMostrar = new Image(RUTA_IMAGENES + "hatsune-miku-miku.gif");
                break;
            default:
                imagenAMostrar = new Image(RUTA_IMAGENES + "hatsune-miku-miku.gif");
        }
        return imagenAMostrar;
    }
}
