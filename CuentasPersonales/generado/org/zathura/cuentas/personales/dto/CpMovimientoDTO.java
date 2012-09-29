package org.zathura.cuentas.personales.dto;

import org.zathura.cuentas.personales.CpMovimiento;

import java.io.Serializable;

import java.util.Date;

import javax.faces.event.ActionEvent;


/**
*
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* support Andrés Mauricio Cárdenas mauriciocardenasp@gmail.com
*/
public class CpMovimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String descripcionMovimiento;
    private Long idMovimiento;
    private String observaciones;
    private Long idGrupoMovimiento_CpGrupoMovimiento;
    private Long idUsuario_CpUsuarios;
    private String descripcionGrupo;

    public String getDescripcionMovimiento() {
        return descripcionMovimiento;
    }

    public void setDescripcionMovimiento(String descripcionMovimiento) {
        this.descripcionMovimiento = descripcionMovimiento;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Long getIdGrupoMovimiento_CpGrupoMovimiento() {
        return idGrupoMovimiento_CpGrupoMovimiento;
    }

    public void setIdGrupoMovimiento_CpGrupoMovimiento(
        Long idGrupoMovimiento_CpGrupoMovimiento) {
        this.idGrupoMovimiento_CpGrupoMovimiento = idGrupoMovimiento_CpGrupoMovimiento;
    }

    public Long getIdUsuario_CpUsuarios() {
        return idUsuario_CpUsuarios;
    }

    public void setIdUsuario_CpUsuarios(Long idUsuario_CpUsuarios) {
        this.idUsuario_CpUsuarios = idUsuario_CpUsuarios;
    }

	public String getDescripcionGrupo() {
		return descripcionGrupo;
	}

	public void setDescripcionGrupo(String descripcionGrupo) {
		this.descripcionGrupo = descripcionGrupo;
	}
    
    
}
