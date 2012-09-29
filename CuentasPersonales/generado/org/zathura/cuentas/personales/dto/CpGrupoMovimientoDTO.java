package org.zathura.cuentas.personales.dto;

import org.zathura.cuentas.personales.CpGrupoMovimiento;

import java.io.Serializable;

import java.util.Date;

import javax.faces.event.ActionEvent;


/**
*
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* support Andrés Mauricio Cárdenas mauriciocardenasp@gmail.com
*/
public class CpGrupoMovimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcion;
    private Long idGrupoMovimiento;
    private String observacion;
    private Long idTipoMovimiento_CpTipoMovimiento;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getIdGrupoMovimiento() {
        return idGrupoMovimiento;
    }

    public void setIdGrupoMovimiento(Long idGrupoMovimiento) {
        this.idGrupoMovimiento = idGrupoMovimiento;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Long getIdTipoMovimiento_CpTipoMovimiento() {
        return idTipoMovimiento_CpTipoMovimiento;
    }

    public void setIdTipoMovimiento_CpTipoMovimiento(
        Long idTipoMovimiento_CpTipoMovimiento) {
        this.idTipoMovimiento_CpTipoMovimiento = idTipoMovimiento_CpTipoMovimiento;
    }
}
