package org.zathura.cuentas.personales.control;

import org.zathura.cuentas.dataaccess.daoFactory.JPADaoFactory;
import org.zathura.cuentas.dataaccess.entityManager.EntityManagerHelper;
import org.zathura.cuentas.exceptions.*;
import org.zathura.cuentas.personales.*;
import org.zathura.cuentas.personales.dto.CpMovimientoDTO;
import org.zathura.cuentas.utilities.Utilities;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.GeneratedValue;


/**
 * interface CpMovimientoLogic
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
public class CpMovimientoLogic implements ICpMovimientoLogic {
    public List<CpMovimiento> getCpMovimiento() throws Exception {
        List<CpMovimiento> list = new ArrayList<CpMovimiento>();

        try {
            list = JPADaoFactory.getInstance().getCpMovimientoDAO().findAll(0);
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "CpMovimiento");
        } finally {
        }

        return list;
    }

    public void saveCpMovimiento(String descripcionMovimiento,
        Long idMovimiento, String observaciones,
        Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
        throws Exception {
        CpMovimiento entity = null;

        try {
            if ((descripcionMovimiento != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        descripcionMovimiento, 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcionMovimiento");
            }

            if (idMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException("idMovimiento");
            }

            if ((idMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idMovimiento");
            }

            if ((observaciones != null) &&
                    (Utilities.checkWordAndCheckWithlength(observaciones, 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observaciones");
            }

            if (idGrupoMovimiento_CpGrupoMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idGrupoMovimiento_CpGrupoMovimiento");
            }

            if ((idGrupoMovimiento_CpGrupoMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idGrupoMovimiento_CpGrupoMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idGrupoMovimiento_CpGrupoMovimiento");
            }

            if (idUsuario_CpUsuarios == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idUsuario_CpUsuarios");
            }

            if ((idUsuario_CpUsuarios != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idUsuario_CpUsuarios, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idUsuario_CpUsuarios");
            }

            ICpGrupoMovimientoLogic logicCpGrupoMovimiento1 = new CpGrupoMovimientoLogic();
            ICpUsuariosLogic logicCpUsuarios2 = new CpUsuariosLogic();
            CpGrupoMovimiento cpGrupoMovimientoClass = logicCpGrupoMovimiento1.getCpGrupoMovimiento(idGrupoMovimiento_CpGrupoMovimiento);
            CpUsuarios cpUsuariosClass = logicCpUsuarios2.getCpUsuarios(idUsuario_CpUsuarios);

            if (cpGrupoMovimientoClass == null) {
                throw new ZMessManager().new ForeignException(
                    "cpGrupoMovimiento");
            }

            if (cpUsuariosClass == null) {
                throw new ZMessManager().new ForeignException("cpUsuarios");
            }

            entity = getCpMovimiento(idMovimiento);

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new CpMovimiento();
            entity.setDescripcionMovimiento(descripcionMovimiento);
            entity.setIdMovimiento(idMovimiento);
            entity.setObservaciones(observaciones);
            entity.setCpGrupoMovimiento(cpGrupoMovimientoClass);
            entity.setCpUsuarios(cpUsuariosClass);
            EntityManagerHelper.beginTransaction();
            JPADaoFactory.getInstance().getCpMovimientoDAO().save(entity);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    /**
     *  Metodo que Ingresa un movimiento y el id se autogenera por medio de una la anotation @GeneratedValue(generator = "movimintoIdSec")
     *  que llama una secuencia de base dedatos (cuando es BD oracle) , no se necesita igresar un id .
     * @param descripcionMovimiento
     * @param observaciones
     * @param idGrupoMovimiento_CpGrupoMovimiento
     * @param idUsuario_CpUsuarios
     * @throws Exception
     */
    public void saveCpMovimientoWithoutId(String descripcionMovimiento,
             String observaciones,
            Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
            throws Exception {
            CpMovimiento entity = null;

            try {
                if ((descripcionMovimiento != null) &&
                        (Utilities.checkWordAndCheckWithlength(
                            descripcionMovimiento, 50) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "descripcionMovimiento");
                }
              

                if ((observaciones != null) &&
                        (Utilities.checkWordAndCheckWithlength(observaciones, 50) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "observaciones");
                }

                if (idGrupoMovimiento_CpGrupoMovimiento == null) {
                    throw new ZMessManager().new EmptyFieldException(
                        "idGrupoMovimiento_CpGrupoMovimiento");
                }

                if ((idGrupoMovimiento_CpGrupoMovimiento != null) &&
                        (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                            idGrupoMovimiento_CpGrupoMovimiento, 22, 0) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "idGrupoMovimiento_CpGrupoMovimiento");
                }

                if (idUsuario_CpUsuarios == null) {
                    throw new ZMessManager().new EmptyFieldException(
                        "idUsuario_CpUsuarios");
                }

                if ((idUsuario_CpUsuarios != null) &&
                        (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                            idUsuario_CpUsuarios, 22, 0) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "idUsuario_CpUsuarios");
                }

                ICpGrupoMovimientoLogic logicCpGrupoMovimiento1 = new CpGrupoMovimientoLogic();
                ICpUsuariosLogic logicCpUsuarios2 = new CpUsuariosLogic();
                CpGrupoMovimiento cpGrupoMovimientoClass = logicCpGrupoMovimiento1.getCpGrupoMovimiento(idGrupoMovimiento_CpGrupoMovimiento);
                CpUsuarios cpUsuariosClass = logicCpUsuarios2.getCpUsuarios(idUsuario_CpUsuarios);

                if (cpGrupoMovimientoClass == null) {
                    throw new ZMessManager().new ForeignException(
                        "cpGrupoMovimiento");
                }

                if (cpUsuariosClass == null) {
                    throw new ZMessManager().new ForeignException("cpUsuarios");
                }

               // entity = getCpMovimiento(idMovimiento);

               // if (entity != null) {
                 //   throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
               // }

                entity = new CpMovimiento();
                entity.setDescripcionMovimiento(descripcionMovimiento);
                entity.setObservaciones(observaciones);
                entity.setCpGrupoMovimiento(cpGrupoMovimientoClass);
                entity.setCpUsuarios(cpUsuariosClass);
                EntityManagerHelper.beginTransaction();
                JPADaoFactory.getInstance().getCpMovimientoDAO().save(entity);
                EntityManagerHelper.commit();
            } catch (Exception e) {
                EntityManagerHelper.rollback();
                throw e;
            } finally {
                EntityManagerHelper.closeEntityManager();
            }
        }

    public void deleteCpMovimiento(Long idMovimiento) throws Exception {
        CpMovimiento entity = null;

        if (idMovimiento == null) {
            throw new ZMessManager().new EmptyFieldException("idMovimiento");
        }

        List<CpDetalleMovimiento> cpDetalleMovimientos = null;
        entity = getCpMovimiento(idMovimiento);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException("CpMovimiento");
        }

        try {
            cpDetalleMovimientos = JPADaoFactory.getInstance()
                                                .getCpDetalleMovimientoDAO()
                                                .findByProperty("cpMovimiento.idMovimiento",
                    idMovimiento, 0);

            if (Utilities.validationsList(cpDetalleMovimientos) == true) {
                throw new ZMessManager().new DeletingException(
                    "cpDetalleMovimientos");
            }

            EntityManagerHelper.beginTransaction();
            JPADaoFactory.getInstance().getCpMovimientoDAO().delete(entity);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public void updateCpMovimiento(String descripcionMovimiento,
        Long idMovimiento, String observaciones,
        Long idGrupoMovimiento_CpGrupoMovimiento, Long idUsuario_CpUsuarios)
        throws Exception {
        CpMovimiento entity = null;

        try {
            if ((descripcionMovimiento != null) &&
                    (Utilities.checkWordAndCheckWithlength(
                        descripcionMovimiento, 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "descripcionMovimiento");
            }

            if (idMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException("idMovimiento");
            }

            if ((idMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idMovimiento");
            }

            if ((observaciones != null) &&
                    (Utilities.checkWordAndCheckWithlength(observaciones, 50) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observaciones");
            }

            if (idGrupoMovimiento_CpGrupoMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idGrupoMovimiento_CpGrupoMovimiento");
            }

            if ((idGrupoMovimiento_CpGrupoMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idGrupoMovimiento_CpGrupoMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idGrupoMovimiento_CpGrupoMovimiento");
            }

            if (idUsuario_CpUsuarios == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idUsuario_CpUsuarios");
            }

            if ((idUsuario_CpUsuarios != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idUsuario_CpUsuarios, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idUsuario_CpUsuarios");
            }

            ICpGrupoMovimientoLogic logicCpGrupoMovimiento1 = new CpGrupoMovimientoLogic();

            ICpUsuariosLogic logicCpUsuarios2 = new CpUsuariosLogic();
            CpGrupoMovimiento cpGrupoMovimientoClass = logicCpGrupoMovimiento1.getCpGrupoMovimiento(idGrupoMovimiento_CpGrupoMovimiento);
            CpUsuarios cpUsuariosClass = logicCpUsuarios2.getCpUsuarios(idUsuario_CpUsuarios);

            if (cpGrupoMovimientoClass == null) {
                throw new ZMessManager().new ForeignException(
                    "cpGrupoMovimiento");
            }

            if (cpUsuariosClass == null) {
                throw new ZMessManager().new ForeignException("cpUsuarios");
            }

            entity = getCpMovimiento(idMovimiento);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setDescripcionMovimiento(descripcionMovimiento);
            entity.setIdMovimiento(idMovimiento);
            entity.setObservaciones(observaciones);
            entity.setCpGrupoMovimiento(cpGrupoMovimientoClass);
            entity.setCpUsuarios(cpUsuariosClass);
            EntityManagerHelper.beginTransaction();
            JPADaoFactory.getInstance().getCpMovimientoDAO().update(entity);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public CpMovimiento getCpMovimiento(Long idMovimiento)
        throws Exception {
        CpMovimiento entity = null;

        try {
            entity = JPADaoFactory.getInstance().getCpMovimientoDAO()
                                  .findById(idMovimiento);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("CpMovimiento");
        } finally {
        }

        return entity;
    }

    public List<CpMovimientoDTO> getDataCpMovimiento()
        throws Exception {
        try {
            List<CpMovimiento> cpMovimiento = JPADaoFactory.getInstance()
                                                           .getCpMovimientoDAO()
                                                           .findAll(0);
            

            List<CpMovimientoDTO> cpMovimientoDTO = new ArrayList<CpMovimientoDTO>();

            for (CpMovimiento cpMovimientoTmp : cpMovimiento) {
                CpMovimientoDTO cpMovimientoDTO2 = new CpMovimientoDTO();

                cpMovimientoDTO2.setIdMovimiento(cpMovimientoTmp.getIdMovimiento());
                cpMovimientoDTO2.setDescripcionMovimiento((cpMovimientoTmp.getDescripcionMovimiento() != null)
                    ? cpMovimientoTmp.getDescripcionMovimiento() : null);
                cpMovimientoDTO2.setObservaciones((cpMovimientoTmp.getObservaciones() != null)
                    ? cpMovimientoTmp.getObservaciones() : null);
                cpMovimientoDTO2.setIdGrupoMovimiento_CpGrupoMovimiento((cpMovimientoTmp.getCpGrupoMovimiento()
                                                                                        .getIdGrupoMovimiento() != null)
                    ? cpMovimientoTmp.getCpGrupoMovimiento()
                                     .getIdGrupoMovimiento() : null);
                cpMovimientoDTO2.setIdUsuario_CpUsuarios((cpMovimientoTmp.getCpUsuarios()
                                                                         .getIdUsuario() != null)
                    ? cpMovimientoTmp.getCpUsuarios().getIdUsuario() : null);
                if((cpMovimientoTmp.getCpGrupoMovimiento()
                        .getIdGrupoMovimiento() != null)){
                	 CpGrupoMovimiento cpGrupoMovimiento = JPADaoFactory.getInstance().getCpGrupoMovimientoDAO().findById(cpMovimientoTmp.getCpGrupoMovimiento()
                             .getIdGrupoMovimiento());
                	 cpMovimientoDTO2.setDescripcionGrupo(cpGrupoMovimiento.getDescripcion());
                }
                cpMovimientoDTO.add(cpMovimientoDTO2);
            }

            return cpMovimientoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<CpMovimiento> findPageCpMovimiento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<CpMovimiento> entity = null;

        try {
            entity = JPADaoFactory.getInstance().getCpMovimientoDAO()
                                  .findPageCpMovimiento(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("CpMovimiento");
        }

        return entity;
    }

    public Long findTotalNumberCpMovimiento() throws Exception {
        Long entity = null;

        try {
            entity = JPADaoFactory.getInstance().getCpMovimientoDAO()
                                  .findTotalNumberCpMovimiento();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("CpMovimiento Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    public List<CpMovimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<CpMovimiento> list = new ArrayList<CpMovimiento>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between \'" + value +
                        "\' and \'" + value2 + "\')")
                        : (tempWhere + " AND (model." + variable +
                        " between \'" + value + "\' and \'" + value2 + "\')");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = JPADaoFactory.getInstance().getCpMovimientoDAO()
                                .findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
