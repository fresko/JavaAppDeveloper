package org.zathura.cuentas.presentation.businessDelegate;

import org.zathura.cuentas.personales.CpDetalleMovimiento;
import org.zathura.cuentas.personales.CpGrupoMovimiento;
import org.zathura.cuentas.personales.CpMovimiento;
import org.zathura.cuentas.personales.CpTipoMovimiento;
import org.zathura.cuentas.personales.CpUsuarios;
import org.zathura.cuentas.personales.control.CpDetalleMovimientoLogic;
import org.zathura.cuentas.personales.control.CpGrupoMovimientoLogic;
import org.zathura.cuentas.personales.control.CpMovimientoLogic;
import org.zathura.cuentas.personales.control.CpTipoMovimientoLogic;
import org.zathura.cuentas.personales.control.CpUsuariosLogic;
import org.zathura.cuentas.personales.control.ICpDetalleMovimientoLogic;
import org.zathura.cuentas.personales.control.ICpGrupoMovimientoLogic;
import org.zathura.cuentas.personales.control.ICpMovimientoLogic;
import org.zathura.cuentas.personales.control.ICpTipoMovimientoLogic;
import org.zathura.cuentas.personales.control.ICpUsuariosLogic;
import org.zathura.cuentas.personales.dto.*;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://code.google.com/p/zathura
*
*/
public class BusinessDelegatorView {
    private BusinessDelegatorView() {
    }

    public static List<CpDetalleMovimiento> getCpDetalleMovimiento()
        throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();

        return cpDetalleMovimientoLogic.getCpDetalleMovimiento();
    }

    public static void saveCpDetalleMovimiento(Long anno, Date fehcaRegistro,
        Long idDetalleMovimiento, Long mes, String observaciones,
        String pendiente, Long valorMovimiento, Long valorPago,
        Long idMovimiento_CpMovimiento) throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();
        cpDetalleMovimientoLogic.saveCpDetalleMovimiento(anno, fehcaRegistro,
            idDetalleMovimiento, mes, observaciones, pendiente,
            valorMovimiento, valorPago, idMovimiento_CpMovimiento);
    }
   
    public static void saveCpDetalleMovimientoWithOutId(Long anno, Date fehcaRegistro,
            Long mes, String observaciones,
            String pendiente, Long valorMovimiento, Long valorPago,
            Long idMovimiento_CpMovimiento) throws Exception {
            ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();
            cpDetalleMovimientoLogic.saveCpDetalleMovimientoWithOutId(anno, fehcaRegistro,
                mes, observaciones, pendiente,
                valorMovimiento, valorPago, idMovimiento_CpMovimiento);
        }
    
    public static void deleteCpDetalleMovimiento(Long idDetalleMovimiento)
        throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();
        cpDetalleMovimientoLogic.deleteCpDetalleMovimiento(idDetalleMovimiento);
    }

    public static void updateCpDetalleMovimiento(Long anno, Date fehcaRegistro,
        Long idDetalleMovimiento, Long mes, String observaciones,
        String pendiente, Long valorMovimiento, Long valorPago,
        Long idMovimiento_CpMovimiento) throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();
        cpDetalleMovimientoLogic.updateCpDetalleMovimiento(anno, fehcaRegistro,
            idDetalleMovimiento, mes, observaciones, pendiente,
            valorMovimiento, valorPago, idMovimiento_CpMovimiento);
    }

    public static CpDetalleMovimiento getCpDetalleMovimiento(
        Long idDetalleMovimiento) throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();
        CpDetalleMovimiento cpDetalleMovimiento = null;

        try {
            cpDetalleMovimiento = cpDetalleMovimientoLogic.getCpDetalleMovimiento(idDetalleMovimiento);
        } catch (Exception e) {
            throw e;
        }

        return cpDetalleMovimiento;
    }

    public static List<CpDetalleMovimiento> findByCriteriaInCpDetalleMovimiento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();

        return cpDetalleMovimientoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public static List<CpDetalleMovimiento> findPageCpDetalleMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();

        return cpDetalleMovimientoLogic.findPageCpDetalleMovimiento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public static Long findTotalNumberCpDetalleMovimiento()
        throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();

        return cpDetalleMovimientoLogic.findTotalNumberCpDetalleMovimiento();
    }

    public static List<CpDetalleMovimientoDTO> getDataCpDetalleMovimiento()
        throws Exception {
        ICpDetalleMovimientoLogic cpDetalleMovimientoLogic = new CpDetalleMovimientoLogic();

        return cpDetalleMovimientoLogic.getDataCpDetalleMovimiento();
    }

    public static List<CpGrupoMovimiento> getCpGrupoMovimiento()
        throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();

        return cpGrupoMovimientoLogic.getCpGrupoMovimiento();
    }

    public static void saveCpGrupoMovimiento(String descripcion,
        Long idGrupoMovimiento, String observacion,
        Long idTipoMovimiento_CpTipoMovimiento) throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();
        cpGrupoMovimientoLogic.saveCpGrupoMovimiento(descripcion,
            idGrupoMovimiento, observacion, idTipoMovimiento_CpTipoMovimiento);
    }

    public static void deleteCpGrupoMovimiento(Long idGrupoMovimiento)
        throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();
        cpGrupoMovimientoLogic.deleteCpGrupoMovimiento(idGrupoMovimiento);
    }

    public static void updateCpGrupoMovimiento(String descripcion,
        Long idGrupoMovimiento, String observacion,
        Long idTipoMovimiento_CpTipoMovimiento) throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();
        cpGrupoMovimientoLogic.updateCpGrupoMovimiento(descripcion,
            idGrupoMovimiento, observacion, idTipoMovimiento_CpTipoMovimiento);
    }

    public static CpGrupoMovimiento getCpGrupoMovimiento(Long idGrupoMovimiento)
        throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();
        CpGrupoMovimiento cpGrupoMovimiento = null;

        try {
            cpGrupoMovimiento = cpGrupoMovimientoLogic.getCpGrupoMovimiento(idGrupoMovimiento);
        } catch (Exception e) {
            throw e;
        }

        return cpGrupoMovimiento;
    }

    public static List<CpGrupoMovimiento> findByCriteriaInCpGrupoMovimiento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();

        return cpGrupoMovimientoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public static List<CpGrupoMovimiento> findPageCpGrupoMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();

        return cpGrupoMovimientoLogic.findPageCpGrupoMovimiento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public static Long findTotalNumberCpGrupoMovimiento()
        throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();

        return cpGrupoMovimientoLogic.findTotalNumberCpGrupoMovimiento();
    }

    public static List<CpGrupoMovimientoDTO> getDataCpGrupoMovimiento()
        throws Exception {
        ICpGrupoMovimientoLogic cpGrupoMovimientoLogic = new CpGrupoMovimientoLogic();

        return cpGrupoMovimientoLogic.getDataCpGrupoMovimiento();
    }

    public static List<CpMovimiento> getCpMovimiento()
        throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();

        return cpMovimientoLogic.getCpMovimiento();
    }

    public static void saveCpMovimiento(String descripcionMovimiento,
        Long idMovimiento, String observaciones,
        Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
        throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();
        cpMovimientoLogic.saveCpMovimiento(descripcionMovimiento, idMovimiento,
            observaciones, idGrupoMovimiento_CpGrupoMovimiento,
            idUsuario_CpUsuarios);
    }
    
    /**
     *  Guarda Movimiento siningresar Idmovimiento, el id se genera automaticmanete a traves de una secuencia invocada desde anotation
     * @param descripcionMovimiento
     * @param observaciones
     * @param idGrupoMovimiento_CpGrupoMovimiento
     * @param idUsuario_CpUsuarios
     * @throws Exception
     */
    public static void saveCpMovimientoWithoutId(String descripcionMovimiento,
            String observaciones,
            Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
            throws Exception {
            ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();
            cpMovimientoLogic.saveCpMovimientoWithoutId(descripcionMovimiento,
            		observaciones, idGrupoMovimiento_CpGrupoMovimiento,
                    idUsuario_CpUsuarios);
        }

    public static void deleteCpMovimiento(Long idMovimiento)
        throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();
        cpMovimientoLogic.deleteCpMovimiento(idMovimiento);
    }

    public static void updateCpMovimiento(String descripcionMovimiento,
        Long idMovimiento, String observaciones,
        Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
        throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();
        cpMovimientoLogic.updateCpMovimiento(descripcionMovimiento,
            idMovimiento, observaciones, idGrupoMovimiento_CpGrupoMovimiento,
            idUsuario_CpUsuarios);
    }

    public static CpMovimiento getCpMovimiento(Long idMovimiento)
        throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();
        CpMovimiento cpMovimiento = null;

        try {
            cpMovimiento = cpMovimientoLogic.getCpMovimiento(idMovimiento);
        } catch (Exception e) {
            throw e;
        }

        return cpMovimiento;
    }

    public static List<CpMovimiento> findByCriteriaInCpMovimiento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();

        return cpMovimientoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public static List<CpMovimiento> findPageCpMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();

        return cpMovimientoLogic.findPageCpMovimiento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public static Long findTotalNumberCpMovimiento() throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();

        return cpMovimientoLogic.findTotalNumberCpMovimiento();
    }

    public static List<CpMovimientoDTO> getDataCpMovimiento()
        throws Exception {
        ICpMovimientoLogic cpMovimientoLogic = new CpMovimientoLogic();

        return cpMovimientoLogic.getDataCpMovimiento();
    }

    public static List<CpTipoMovimiento> getCpTipoMovimiento()
        throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();

        return cpTipoMovimientoLogic.getCpTipoMovimiento();
    }

    public static void saveCpTipoMovimiento(String descripcion,
        Long idTipoMovimiento, String observacion) throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();
        cpTipoMovimientoLogic.saveCpTipoMovimiento(descripcion,
            idTipoMovimiento, observacion);
    }

    public static void deleteCpTipoMovimiento(Long idTipoMovimiento)
        throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();
        cpTipoMovimientoLogic.deleteCpTipoMovimiento(idTipoMovimiento);
    }

    public static void updateCpTipoMovimiento(String descripcion,
        Long idTipoMovimiento, String observacion) throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();
        cpTipoMovimientoLogic.updateCpTipoMovimiento(descripcion,
            idTipoMovimiento, observacion);
    }

    public static CpTipoMovimiento getCpTipoMovimiento(Long idTipoMovimiento)
        throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();
        CpTipoMovimiento cpTipoMovimiento = null;

        try {
            cpTipoMovimiento = cpTipoMovimientoLogic.getCpTipoMovimiento(idTipoMovimiento);
        } catch (Exception e) {
            throw e;
        }

        return cpTipoMovimiento;
    }

    public static List<CpTipoMovimiento> findByCriteriaInCpTipoMovimiento(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();

        return cpTipoMovimientoLogic.findByCriteria(variables,
            variablesBetween, variablesBetweenDates);
    }

    public static List<CpTipoMovimiento> findPageCpTipoMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();

        return cpTipoMovimientoLogic.findPageCpTipoMovimiento(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public static Long findTotalNumberCpTipoMovimiento()
        throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();

        return cpTipoMovimientoLogic.findTotalNumberCpTipoMovimiento();
    }

    public static List<CpTipoMovimientoDTO> getDataCpTipoMovimiento()
        throws Exception {
        ICpTipoMovimientoLogic cpTipoMovimientoLogic = new CpTipoMovimientoLogic();

        return cpTipoMovimientoLogic.getDataCpTipoMovimiento();
    }

    public static List<CpUsuarios> getCpUsuarios() throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();

        return cpUsuariosLogic.getCpUsuarios();
    }

    public static void saveCpUsuarios(String activo, String apellido,
        String contrasena, String correo, Long idUsuario, Long movil,
        String nombre, String observaciones) throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();
        cpUsuariosLogic.saveCpUsuarios(activo, apellido, contrasena, correo,
            idUsuario, movil, nombre, observaciones);
    }

    public static void deleteCpUsuarios(Long idUsuario)
        throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();
        cpUsuariosLogic.deleteCpUsuarios(idUsuario);
    }

    public static void updateCpUsuarios(String activo, String apellido,
        String contrasena, String correo, Long idUsuario, Long movil,
        String nombre, String observaciones) throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();
        cpUsuariosLogic.updateCpUsuarios(activo, apellido, contrasena, correo,
            idUsuario, movil, nombre, observaciones);
    }

    public static CpUsuarios getCpUsuarios(Long idUsuario)
        throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();
        CpUsuarios cpUsuarios = null;

        try {
            cpUsuarios = cpUsuariosLogic.getCpUsuarios(idUsuario);
        } catch (Exception e) {
            throw e;
        }

        return cpUsuarios;
    }

    public static List<CpUsuarios> findByCriteriaInCpUsuarios(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();

        return cpUsuariosLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public static List<CpUsuarios> findPageCpUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();

        return cpUsuariosLogic.findPageCpUsuarios(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public static Long findTotalNumberCpUsuarios() throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();

        return cpUsuariosLogic.findTotalNumberCpUsuarios();
    }

    public static List<CpUsuariosDTO> getDataCpUsuarios()
        throws Exception {
        ICpUsuariosLogic cpUsuariosLogic = new CpUsuariosLogic();

        return cpUsuariosLogic.getDataCpUsuarios();
    }
}
