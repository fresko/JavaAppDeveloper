package org.zathura.cuentas.personales.dto;

import org.zathura.cuentas.personales.CpDetalleMovimiento;

import java.io.Serializable;

import java.util.Date;

import javax.faces.event.ActionEvent;


/**
*
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* support Andrés Mauricio Cárdenas mauriciocardenasp@gmail.com
*/
public class CpDetalleMovimientoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long anno;
    private Date fehcaRegistro;
    private Long idDetalleMovimiento;
    private Long mes;
    private String observaciones;
    private String pendiente;
    private Long valorMovimiento;
    private Long valorPago;
    private Long idMovimiento_CpMovimiento;

    public Long getAnno() {
        return anno;
    }

    public void setAnno(Long anno) {
        this.anno = anno;
    }

    public Date getFehcaRegistro() {
        return fehcaRegistro;
    }

    public void setFehcaRegistro(Date fehcaRegistro) {
        this.fehcaRegistro = fehcaRegistro;
    }

    public Long getIdDetalleMovimiento() {
        return idDetalleMovimiento;
    }

    public void setIdDetalleMovimiento(Long idDetalleMovimiento) {
        this.idDetalleMovimiento = idDetalleMovimiento;
    }

    public Long getMes() {
        return mes;
    }

    public void setMes(Long mes) {
        this.mes = mes;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getPendiente() {
        return pendiente;
    }

    public void setPendiente(String pendiente) {
        this.pendiente = pendiente;
    }

    public Long getValorMovimiento() {
        return valorMovimiento;
    }

    public void setValorMovimiento(Long valorMovimiento) {
        this.valorMovimiento = valorMovimiento;
    }

    public Long getValorPago() {
        return valorPago;
    }

    public void setValorPago(Long valorPago) {
        this.valorPago = valorPago;
    }

    public Long getIdMovimiento_CpMovimiento() {
        return idMovimiento_CpMovimiento;
    }

    public void setIdMovimiento_CpMovimiento(Long idMovimiento_CpMovimiento) {
        this.idMovimiento_CpMovimiento = idMovimiento_CpMovimiento;
    }
}
