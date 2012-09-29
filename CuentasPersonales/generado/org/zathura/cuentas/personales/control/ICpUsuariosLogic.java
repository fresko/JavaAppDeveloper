package org.zathura.cuentas.personales.control;

import org.zathura.cuentas.personales.CpUsuarios;
import org.zathura.cuentas.personales.dto.CpUsuariosDTO;

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
public interface ICpUsuariosLogic {
    public List<CpUsuarios> getCpUsuarios() throws Exception;

    public void saveCpUsuarios(String activo, String apellido,
        String contrasena, String correo, Long idUsuario, Long movil,
        String nombre, String observaciones) throws Exception;

    public void deleteCpUsuarios(Long idUsuario) throws Exception;

    public void updateCpUsuarios(String activo, String apellido,
        String contrasena, String correo, Long idUsuario, Long movil,
        String nombre, String observaciones) throws Exception;

    public CpUsuarios getCpUsuarios(Long idUsuario) throws Exception;

    public List<CpUsuarios> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<CpUsuarios> findPageCpUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCpUsuarios() throws Exception;

    public List<CpUsuariosDTO> getDataCpUsuarios() throws Exception;
}
