package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.personales.CpTipoMovimiento;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Interface for CpTipoMovimientoDAO.
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 */
public interface ICpTipoMovimientoDAO {
    // property constants
    //public static final String  DESCRIPCION = "descripcion";
    public static final String DESCRIPCION = "descripcion";

    //public static final Long  IDTIPOMOVIMIENTO = "idTipoMovimiento";
    public static final String IDTIPOMOVIMIENTO = "idTipoMovimiento";

    //public static final String  OBSERVACION = "observacion";
    public static final String OBSERVACION = "observacion";

    /**
    * Perform an initial save of a previously unsaved CpTipoMovimiento entity. All
    * subsequent persist actions of this entity should use the #update()
    * method. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpTipoMovimientoDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpTipoMovimiento entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpTipoMovimiento entity);

    /**
    * Delete a persistent CpTipoMovimiento entity. This operation must be performed
    * within the a database transaction context for the entity's data to be
    * permanently deleted from the persistence store, i.e., database. This
    * method uses the
    * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpTipoMovimientoDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpTipoMovimiento entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpTipoMovimiento entity);

    /**
    * Persist a previously saved CpTipoMovimiento entity and return it or a copy of it
    * to the sender. A copy of the CpTipoMovimiento entity parameter is returned when
    * the JPA persistence mechanism has not previously been tracking the
    * updated entity. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * entity = ICpTipoMovimientoDAO.update(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpTipoMovimiento entity to update
    * @return CpTipoMovimiento the persisted CpTipoMovimiento entity instance, may not be the
    *         same
    * @throws RuntimeException
    *             if the operation fails
    */
    public CpTipoMovimiento update(CpTipoMovimiento entity);

    public CpTipoMovimiento findById(Long id);

    /**
    * Find all CpTipoMovimiento entities with a specific property value.
    *
    * @param propertyName
    *            the name of the CpTipoMovimiento property to query
    * @param value
    *            the property value to match
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpTipoMovimiento> found by query
        */
    public List<CpTipoMovimiento> findByProperty(String propertyName,
        Object value, int... rowStartIdxAndCount);

    public List<CpTipoMovimiento> findByCriteria(String whereCondition);

    public List<CpTipoMovimiento> findByDescripcion(Object descripcion);

    public List<CpTipoMovimiento> findByDescripcion(Object descripcion,
        int... rowStartIdxAndCount);

    public List<CpTipoMovimiento> findByIdTipoMovimiento(
        Object idTipoMovimiento);

    public List<CpTipoMovimiento> findByIdTipoMovimiento(
        Object idTipoMovimiento, int... rowStartIdxAndCount);

    public List<CpTipoMovimiento> findByObservacion(Object observacion);

    public List<CpTipoMovimiento> findByObservacion(Object observacion,
        int... rowStartIdxAndCount);

    /**
    * Find all CpTipoMovimiento entities.
    *
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpTipoMovimiento> all CpTipoMovimiento entities
    */
    public List<CpTipoMovimiento> findAll(int... rowStartIdxAndCount);

    public List<CpTipoMovimiento> findPageCpTipoMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults);

    public Long findTotalNumberCpTipoMovimiento();
}
