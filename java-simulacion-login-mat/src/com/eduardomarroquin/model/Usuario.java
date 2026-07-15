/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eduardomarroquin.model;

/**
 *
 * @author informatica
 */
public class Usuario {
    //Atributos Privados
    private String userName, password, nombreCompleto;
    private Rol rol;
    
    //Constructores
    public Usuario(){
    }

    public Usuario(String userName, String password, String nombreCompleto, Rol rol) {
        this.userName = userName;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
    }
   
    //Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    
    
    
    
    
    
}
