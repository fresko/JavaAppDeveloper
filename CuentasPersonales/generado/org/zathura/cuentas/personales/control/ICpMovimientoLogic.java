package org.zathura.cuentas.personales.control;

import org.zathura.cuentas.personales.CpMovimiento;
import org.zathura.cuentas.personales.dto.CpMovimientoDTO;

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
public interface ICpMovimientoLogic {
    public List<CpMovimiento> getCpMovimiento() throws Exception;

    public void saveCpMovimiento(String descripcionMovimiento,
        Long idMovimiento, String observaciones,
        Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
        throws Exception;
    
    public void saveCpMovimientoWithoutId(String descripcionMovimiento,
            String observaciones,
            Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
            throws Exception;

    public void deleteCpMovimiento(Long idMovimiento) throws Exception;

    public void updateCpMovimiento(String descripcionMovimiento,
        Long idMovimiento, String observaciones,
        Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
        throws Exception;

    public CpMovimiento getCpMovimiento(Long idMovimiento)
        throws Exception;

    public List<CpMovimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CpMovimiento> findPageCpMovimiento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCpMovimiento() throws Exception;

    public List<CpMovimientoDTO> getDataCpMovimiento()
        throws Exception;
}
