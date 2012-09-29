package org.zathura.cuentas.personales.control;

import org.zathura.cuentas.personales.CpTipoMovimiento;
import org.zathura.cuentas.personales.dto.CpTipoMovimientoDTO;

import java.math.BigDecimal;

import java.util.*;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
public interface ICpTipoMovimientoLogic {
    public List<CpTipoMovimiento> getCpTipoMovimiento()
        throws Exception;

    public void saveCpTipoMovimiento(String descripcion, Long idTipoMovimiento,
        String observacion) throws Exception;

    public void deleteCpTipoMovimiento(Long idTipoMovimiento)
        throws Exception;

    public void updateCpTipoMovimiento(String descripcion,
        Long idTipoMovimiento, String observacion) throws Exception;

    public CpTipoMovimiento getCpTipoMovimiento(Long idTipoMovimiento)
        throws Exception;

    public List<CpTipoMovimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CpTipoMovimiento> findPageCpTipoMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCpTipoMovimiento() throws Exception;

    public List<CpTipoMovimientoDTO> getDataCpTipoMovimiento()
        throws Exception;
}
