package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.personales.CpDetalleMovimiento;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Interface for CpDetalleMovimientoDAO.
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 */
public interface ICpDetalleMovimientoDAO {
    // property constants
    //public static final Long  ANNO = "anno";
    public static final String ANNO = "anno";

    //public static final Date  FEHCAREGISTRO = "fehcaRegistro";
    public static final String FEHCAREGISTRO = "fehcaRegistro";

    //public static final Long  IDDETALLEMOVIMIENTO = "idDetalleMovimiento";
    public static final String IDDETALLEMOVIMIENTO = "idDetalleMovimiento";

    //public static final Long  MES = "mes";
    public static final String MES = "mes";

    //public static final String  OBSERVACIONES = "observaciones";
    public static final String OBSERVACIONES = "observaciones";

    //public static final String  PENDIENTE = "pendiente";
    public static final String PENDIENTE = "pendiente";

    //public static final Long  VALORMOVIMIENTO = "valorMovimiento";
    public static final String VALORMOVIMIENTO = "valorMovimiento";

    //public static final Long  VALORPAGO = "valorPago";
    public static final String VALORPAGO = "valorPago";

    /**
    * Perform an initial save of a previously unsaved CpDetalleMovimiento entity. All
    * subsequent persist actions of this entity should use the #update()
    * method. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpDetalleMovimientoDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpDetalleMovimiento entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpDetalleMovimiento entity);

    /**
    * Delete a persistent CpDetalleMovimiento entity. This operation must be performed
    * within the a database transaction context for the entity's data to be
    * permanently deleted from the persistence store, i.e., database. This
    * method uses the
    * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpDetalleMovimientoDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpDetalleMovimiento entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpDetalleMovimiento entity);

    /**
    * Persist a previously saved CpDetalleMovimiento entity and return it or a copy of it
    * to the sender. A copy of the CpDetalleMovimiento entity parameter is returned when
    * the JPA persistence mechanism has not previously been tracking the
    * updated entity. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * entity = ICpDetalleMovimientoDAO.update(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpDetalleMovimiento entity to update
    * @return CpDetalleMovimiento the persisted CpDetalleMovimiento entity instance, may not be the
    *         same
    * @throws RuntimeException
    *             if the operation fails
    */
    public CpDetalleMovimiento update(CpDetalleMovimiento entity);

    public CpDetalleMovimiento findById(Long id);

    /**
    * Find all CpDetalleMovimiento entities with a specific property value.
    *
    * @param propertyName
    *            the name of the CpDetalleMovimiento property to query
    * @param value
    *            the property value to match
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpDetalleMovimiento> found by query
        */
    public List<CpDetalleMovimiento> findByProperty(String propertyName,
        Object value, int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByCriteria(String whereCondition);

    public List<CpDetalleMovimiento> findByAnno(Object anno);

    public List<CpDetalleMovimiento> findByAnno(Object anno,
        int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByFehcaRegistro(Object fehcaRegistro);

    public List<CpDetalleMovimiento> findByFehcaRegistro(Object fehcaRegistro,
        int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByIdDetalleMovimiento(
        Object idDetalleMovimiento);

    public List<CpDetalleMovimiento> findByIdDetalleMovimiento(
        Object idDetalleMovimiento, int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByMes(Object mes);

    public List<CpDetalleMovimiento> findByMes(Object mes,
        int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByObservaciones(Object observaciones);

    public List<CpDetalleMovimiento> findByObservaciones(Object observaciones,
        int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByPendiente(Object pendiente);

    public List<CpDetalleMovimiento> findByPendiente(Object pendiente,
        int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByValorMovimiento(
        Object valorMovimiento);

    public List<CpDetalleMovimiento> findByValorMovimiento(
        Object valorMovimiento, int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findByValorPago(Object valorPago);

    public List<CpDetalleMovimiento> findByValorPago(Object valorPago,
        int... rowStartIdxAndCount);

    /**
    * Find all CpDetalleMovimiento entities.
    *
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpDetalleMovimiento> all CpDetalleMovimiento entities
    */
    public List<CpDetalleMovimiento> findAll(int... rowStartIdxAndCount);

    public List<CpDetalleMovimiento> findPageCpDetalleMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults);

    public Long findTotalNumberCpDetalleMovimiento();
}
