package org.zathura.cuentas.personales.control;

import org.zathura.cuentas.personales.CpDetalleMovimiento;
import org.zathura.cuentas.personales.dto.CpDetalleMovimientoDTO;

import java.math.BigDecimal;

import java.util.*;


/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
public interface ICpDetalleMovimientoLogic {
    public List<CpDetalleMovimiento> getCpDetalleMovimiento()
        throws Exception;

    public void saveCpDetalleMovimiento(Long anno, Date fehcaRegistro,
        Long idDetalleMovimiento, Long mes, String observaciones,
        String pendiente, Long valorMovimiento, Long valorPago,
        Long idMovimiento_CpMovimiento) throws Exception;
    
    public void saveCpDetalleMovimientoWithOutId(Long anno, Date fehcaRegistro,
            Long mes, String observaciones,
            String pendiente, Long valorMovimiento, Long valorPago,
            Long idMovimiento_CpMovimiento) throws Exception;

    public void deleteCpDetalleMovimiento(Long idDetalleMovimiento)
        throws Exception;

    public void updateCpDetalleMovimiento(Long anno, Date fehcaRegistro,
        Long idDetalleMovimiento, Long mes, String observaciones,
        String pendiente, Long valorMovimiento, Long valorPago,
        Long idMovimiento_CpMovimiento) throws Exception;

    public CpDetalleMovimiento getCpDetalleMovimiento(Long idDetalleMovimiento)
        throws Exception;

    public List<CpDetalleMovimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CpDetalleMovimiento> findPageCpDetalleMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCpDetalleMovimiento() throws Exception;

    public List<CpDetalleMovimientoDTO> getDataCpDetalleMovimiento()
        throws Exception;
}
