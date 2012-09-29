package org.zathura.cuentas.personales.dto;

import org.zathura.cuentas.personales.CpUsuarios;

import java.io.Serializable;

import java.util.Date;

import javax.faces.event.ActionEvent;


/**
*
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* support Andrés Mauricio Cárdenas mauriciocardenasp@gmail.com
*/
public class CpUsuariosDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String activo;
    private String apellido;
    private String contrasena;
    private String correo;
    private Long idUsuario;
    private Long movil;
    private String nombre;
    private String observaciones;

    public String getActivo() {
        return activo;
    }

    public void setActivo(String activo) {
        this.activo = activo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Long getMovil() {
        return movil;
    }

    public void setMovil(Long movil) {
        this.movil = movil;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
