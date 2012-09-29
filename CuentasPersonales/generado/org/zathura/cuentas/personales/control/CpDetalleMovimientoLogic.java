package org.zathura.cuentas.personales.control;

import org.zathura.cuentas.dataaccess.daoFactory.JPADaoFactory;
import org.zathura.cuentas.dataaccess.entityManager.EntityManagerHelper;
import org.zathura.cuentas.exceptions.*;
import org.zathura.cuentas.personales.*;
import org.zathura.cuentas.personales.dto.CpDetalleMovimientoDTO;
import org.zathura.cuentas.utilities.Utilities;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * interface CpDetalleMovimientoLogic
 * @author Zathura Code Generator http://code.google.com/p/zathura
 *
 */
public class CpDetalleMovimientoLogic implements ICpDetalleMovimientoLogic {
    public List<CpDetalleMovimiento> getCpDetalleMovimiento()
        throws Exception {
        List<CpDetalleMovimiento> list = new ArrayList<CpDetalleMovimiento>();

        try {
            list = JPADaoFactory.getInstance().getCpDetalleMovimientoDAO()
                                .findAll(0);
        } catch (Exception e) {
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "CpDetalleMovimiento");
        } finally {
        }

        return list;
    }

    public void saveCpDetalleMovimiento(Long anno, Date fehcaRegistro,
        Long idDetalleMovimiento, Long mes, String observaciones,
        String pendiente, Long valorMovimiento, Long valorPago,
        Long idMovimiento_CpMovimiento) throws Exception {
        CpDetalleMovimiento entity = null;

        try {
            if ((anno != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        anno, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("anno");
            }

            if (idDetalleMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idDetalleMovimiento");
            }

            if ((idDetalleMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idDetalleMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idDetalleMovimiento");
            }

            if ((mes != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        mes, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("mes");
            }

            if ((observaciones != null) &&
                    (Utilities.checkWordAndCheckWithlength(observaciones, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observaciones");
            }

            if ((pendiente != null) &&
                    (Utilities.checkWordAndCheckWithlength(pendiente, 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "pendiente");
            }

            if ((valorMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        valorMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorMovimiento");
            }

            if ((valorPago != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        valorPago, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorPago");
            }

            if (idMovimiento_CpMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idMovimiento_CpMovimiento");
            }

            if ((idMovimiento_CpMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idMovimiento_CpMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idMovimiento_CpMovimiento");
            }

            ICpMovimientoLogic logicCpMovimiento1 = new CpMovimientoLogic();
            CpMovimiento cpMovimientoClass = logicCpMovimiento1.getCpMovimiento(idMovimiento_CpMovimiento);

            if (cpMovimientoClass == null) {
                throw new ZMessManager().new ForeignException("cpMovimiento");
            }

            entity = getCpDetalleMovimiento(idDetalleMovimiento);

            if (entity != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            entity = new CpDetalleMovimiento();
            entity.setAnno(anno);
            entity.setFehcaRegistro(fehcaRegistro);
            entity.setIdDetalleMovimiento(idDetalleMovimiento);
            entity.setMes(mes);
            entity.setObservaciones(observaciones);
            entity.setPendiente(pendiente);
            entity.setValorMovimiento(valorMovimiento);
            entity.setValorPago(valorPago);
            entity.setCpMovimiento(cpMovimientoClass);
            EntityManagerHelper.beginTransaction();
            JPADaoFactory.getInstance().getCpDetalleMovimientoDAO().save(entity);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }
    
    public void saveCpDetalleMovimientoWithOutId(Long anno, Date fehcaRegistro,
            Long mes, String observaciones,
            String pendiente, Long valorMovimiento, Long valorPago,
            Long idMovimiento_CpMovimiento) throws Exception {
            CpDetalleMovimiento entity = null;

            try {
                if ((anno != null) &&
                        (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                            anno, 22, 0) == false)) {
                    throw new ZMessManager().new NotValidFormatException("anno");
                }

                if ((mes != null) &&
                        (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                            mes, 22, 0) == false)) {
                    throw new ZMessManager().new NotValidFormatException("mes");
                }

                if ((observaciones != null) &&
                        (Utilities.checkWordAndCheckWithlength(observaciones, 100) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "observaciones");
                }

                if ((pendiente != null) &&
                        (Utilities.checkWordAndCheckWithlength(pendiente, 1) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "pendiente");
                }

                if ((valorMovimiento != null) &&
                        (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                            valorMovimiento, 22, 0) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "valorMovimiento");
                }

                if ((valorPago != null) &&
                        (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                            valorPago, 22, 0) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "valorPago");
                }

                if (idMovimiento_CpMovimiento == null) {
                    throw new ZMessManager().new EmptyFieldException(
                        "idMovimiento_CpMovimiento");
                }

                if ((idMovimiento_CpMovimiento != null) &&
                        (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                            idMovimiento_CpMovimiento, 22, 0) == false)) {
                    throw new ZMessManager().new NotValidFormatException(
                        "idMovimiento_CpMovimiento");
                }

                ICpMovimientoLogic logicCpMovimiento1 = new CpMovimientoLogic();
                CpMovimiento cpMovimientoClass = logicCpMovimiento1.getCpMovimiento(idMovimiento_CpMovimiento);

                if (cpMovimientoClass == null) {
                    throw new ZMessManager().new ForeignException("cpMovimiento");
                }

               

                if (entity != null) {
                    throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
                }

                entity = new CpDetalleMovimiento();
                entity.setAnno(anno);
                entity.setFehcaRegistro(fehcaRegistro);
                entity.setMes(mes);
                entity.setObservaciones(observaciones);
                entity.setPendiente(pendiente);
                entity.setValorMovimiento(valorMovimiento);
                entity.setValorPago(valorPago);
                entity.setCpMovimiento(cpMovimientoClass);
                EntityManagerHelper.beginTransaction();
                JPADaoFactory.getInstance().getCpDetalleMovimientoDAO().save(entity);
                EntityManagerHelper.commit();
            } catch (Exception e) {
                EntityManagerHelper.rollback();
                throw e;
            } finally {
                EntityManagerHelper.closeEntityManager();
            }
        }

    public void deleteCpDetalleMovimiento(Long idDetalleMovimiento)
        throws Exception {
        CpDetalleMovimiento entity = null;

        if (idDetalleMovimiento == null) {
            throw new ZMessManager().new EmptyFieldException(
                "idDetalleMovimiento");
        }

        entity = getCpDetalleMovimiento(idDetalleMovimiento);

        if (entity == null) {
            throw new ZMessManager().new EmptyFieldException(
                "CpDetalleMovimiento");
        }

        try {
            EntityManagerHelper.beginTransaction();
            JPADaoFactory.getInstance().getCpDetalleMovimientoDAO()
                         .delete(entity);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public void updateCpDetalleMovimiento(Long anno, Date fehcaRegistro,
        Long idDetalleMovimiento, Long mes, String observaciones,
        String pendiente, Long valorMovimiento, Long valorPago,
        Long idMovimiento_CpMovimiento) throws Exception {
        CpDetalleMovimiento entity = null;

        try {
            if ((anno != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        anno, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("anno");
            }

            if (idDetalleMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idDetalleMovimiento");
            }

            if ((idDetalleMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idDetalleMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idDetalleMovimiento");
            }

            if ((mes != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        mes, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException("mes");
            }

            if ((observaciones != null) &&
                    (Utilities.checkWordAndCheckWithlength(observaciones, 100) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "observaciones");
            }

            if ((pendiente != null) &&
                    (Utilities.checkWordAndCheckWithlength(pendiente, 1) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "pendiente");
            }

            if ((valorMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        valorMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorMovimiento");
            }

            if ((valorPago != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        valorPago, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "valorPago");
            }

            if (idMovimiento_CpMovimiento == null) {
                throw new ZMessManager().new EmptyFieldException(
                    "idMovimiento_CpMovimiento");
            }

            if ((idMovimiento_CpMovimiento != null) &&
                    (Utilities.checkNumberAndCheckWithPrecisionAndScale("" +
                        idMovimiento_CpMovimiento, 22, 0) == false)) {
                throw new ZMessManager().new NotValidFormatException(
                    "idMovimiento_CpMovimiento");
            }

            ICpMovimientoLogic logicCpMovimiento1 = new CpMovimientoLogic();
            CpMovimiento cpMovimientoClass = logicCpMovimiento1.getCpMovimiento(idMovimiento_CpMovimiento);

            if (cpMovimientoClass == null) {
                throw new ZMessManager().new ForeignException("cpMovimiento");
            }

            entity = getCpDetalleMovimiento(idDetalleMovimiento);

            if (entity == null) {
                throw new ZMessManager(ZMessManager.ENTITY_NOENTITYTOUPDATE);
            }

            entity.setAnno(anno);
            entity.setFehcaRegistro(fehcaRegistro);
            entity.setIdDetalleMovimiento(idDetalleMovimiento);
            entity.setMes(mes);
            entity.setObservaciones(observaciones);
            entity.setPendiente(pendiente);
            entity.setValorMovimiento(valorMovimiento);
            entity.setValorPago(valorPago);
            entity.setCpMovimiento(cpMovimientoClass);
            EntityManagerHelper.beginTransaction();
            JPADaoFactory.getInstance().getCpDetalleMovimientoDAO()
                         .update(entity);
            EntityManagerHelper.commit();
        } catch (Exception e) {
            EntityManagerHelper.rollback();
            throw e;
        } finally {
            EntityManagerHelper.closeEntityManager();
        }
    }

    public CpDetalleMovimiento getCpDetalleMovimiento(Long idDetalleMovimiento)
        throws Exception {
        CpDetalleMovimiento entity = null;

        try {
            entity = JPADaoFactory.getInstance().getCpDetalleMovimientoDAO()
                                  .findById(idDetalleMovimiento);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("CpDetalleMovimiento");
        } finally {
        }

        return entity;
    }

    public List<CpDetalleMovimientoDTO> getDataCpDetalleMovimiento()
        throws Exception {
        try {
            List<CpDetalleMovimiento> cpDetalleMovimiento = JPADaoFactory.getInstance()
                                                                         .getCpDetalleMovimientoDAO()
                                                                         .findAll(0);

            List<CpDetalleMovimientoDTO> cpDetalleMovimientoDTO = new ArrayList<CpDetalleMovimientoDTO>();

            for (CpDetalleMovimiento cpDetalleMovimientoTmp : cpDetalleMovimiento) {
                CpDetalleMovimientoDTO cpDetalleMovimientoDTO2 = new CpDetalleMovimientoDTO();

                cpDetalleMovimientoDTO2.setIdDetalleMovimiento(cpDetalleMovimientoTmp.getIdDetalleMovimiento());
                cpDetalleMovimientoDTO2.setAnno((cpDetalleMovimientoTmp.getAnno() != null)
                    ? cpDetalleMovimientoTmp.getAnno() : null);
                cpDetalleMovimientoDTO2.setFehcaRegistro(cpDetalleMovimientoTmp.getFehcaRegistro());
                cpDetalleMovimientoDTO2.setMes((cpDetalleMovimientoTmp.getMes() != null)
                    ? cpDetalleMovimientoTmp.getMes() : null);
                cpDetalleMovimientoDTO2.setObservaciones((cpDetalleMovimientoTmp.getObservaciones() != null)
                    ? cpDetalleMovimientoTmp.getObservaciones() : null);
                cpDetalleMovimientoDTO2.setPendiente((cpDetalleMovimientoTmp.getPendiente() != null)
                    ? cpDetalleMovimientoTmp.getPendiente() : null);
                cpDetalleMovimientoDTO2.setValorMovimiento((cpDetalleMovimientoTmp.getValorMovimiento() != null)
                    ? cpDetalleMovimientoTmp.getValorMovimiento() : null);
                cpDetalleMovimientoDTO2.setValorPago((cpDetalleMovimientoTmp.getValorPago() != null)
                    ? cpDetalleMovimientoTmp.getValorPago() : null);
                cpDetalleMovimientoDTO2.setIdMovimiento_CpMovimiento((cpDetalleMovimientoTmp.getCpMovimiento()
                                                                                            .getIdMovimiento() != null)
                    ? cpDetalleMovimientoTmp.getCpMovimiento().getIdMovimiento()
                    : null);
                cpDetalleMovimientoDTO.add(cpDetalleMovimientoDTO2);
            }

            return cpDetalleMovimientoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<CpDetalleMovimiento> findPageCpDetalleMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) throws Exception {
        List<CpDetalleMovimiento> entity = null;

        try {
            entity = JPADaoFactory.getInstance().getCpDetalleMovimientoDAO()
                                  .findPageCpDetalleMovimiento(sortColumnName,
                    sortAscending, startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("CpDetalleMovimiento");
        }

        return entity;
    }

    public Long findTotalNumberCpDetalleMovimiento() throws Exception {
        Long entity = null;

        try {
            entity = JPADaoFactory.getInstance().getCpDetalleMovimientoDAO()
                                  .findTotalNumberCpDetalleMovimiento();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException(
                "CpDetalleMovimiento Count");
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
    public List<CpDetalleMovimiento> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<CpDetalleMovimiento> list = new ArrayList<CpDetalleMovimiento>();
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
            list = JPADaoFactory.getInstance().getCpDetalleMovimientoDAO()
                                .findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
