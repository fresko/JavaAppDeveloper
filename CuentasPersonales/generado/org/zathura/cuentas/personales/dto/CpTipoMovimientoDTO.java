package org.zathura.cuentas.personales.dto;

import org.zathura.cuentas.personales.CpTipoMovimiento;

import java.io.Serializable;

import java.util.Date;

import javax.faces.event.ActionEvent;


/**
*
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* support Andrés Mauricio Cárdenas mauriciocardenasp@gmail.com
*/
public class CpTipoMovimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcion;
    private Long idTipoMovimiento;
    private String observacion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdTipoMovimiento() {
        return idTipoMovimiento;
    }

    public void setIdTipoMovimiento(Long idTipoMovimiento) {
        this.idTipoMovimiento = idTipoMovimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
