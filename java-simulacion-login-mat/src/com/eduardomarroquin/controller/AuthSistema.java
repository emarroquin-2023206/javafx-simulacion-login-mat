/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eduardomarroquin.controller;

import com.eduardomarroquin.model.Rol;
import com.eduardomarroquin.model.Usuario;
import java.util.ArrayList;

/**
 *
 * @author informatica
 */
public class AuthSistema {
    
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public AuthSistema() {
        Usuario usuarioAdmin = new Usuario("Admin", "Admin", "Admin", Rol.ADMIN);
        Usuario usuarioUser = new Usuario("user", "user", "user", Rol.USER);
        Usuario userYo = new Usuario("Fel", "123", "Eduardo Marroquin", Rol.USER);
    }
    public Usuario login(String nombreUsuario, String clave){
        for(Usuario usuarioBuscado :  listaUsuarios)
            if(usuarioBuscado.getUserName().equals(nombreUsuario) && usuarioBuscado.getPassword().equals(clave)){
                return usuarioBuscado;
            }
                
        return null;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> usuarios) {
        this.listaUsuarios = listaUsuarios;
    }
 
 
}
