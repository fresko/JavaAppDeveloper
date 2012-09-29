package org.zathura.cuentas.personales.control;

import org.zathura.cuentas.personales.CpGrupoMovimiento;
import org.zathura.cuentas.personales.dto.CpGrupoMovimientoDTO;

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
public interface ICpGrupoMovimientoLogic {
    public List<CpGrupoMovimiento> getCpGrupoMovimiento()
        throws Exception;

    public void saveCpGrupoMovimiento(String descripcion,
        Long idGrupoMovimiento, String observacion,
        Long idTipoMovimiento_CpTipoMovimiento) throws Exception;

    public void deleteCpGrupoMovimiento(Long idGrupoMovimiento)
        throws Exception;

    public void updateCpGrupoMovimiento(String descripcion,
        Long idGrupoMovimiento, String observacion,
        Long idTipoMovimiento_CpTipoMovimiento) throws Exception;

    public CpGrupoMovimiento getCpGrupoMovimiento(Long idGrupoMovimiento)
        throws Exception;

    public List<CpGrupoMovimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CpGrupoMovimiento> findPageCpGrupoMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception;

    public Long findTotalNumberCpGrupoMovimiento() throws Exception;

    public List<CpGrupoMovimientoDTO> getDataCpGrupoMovimiento()
        throws Exception;
}
