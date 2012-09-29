package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.personales.CpMovimiento;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Interface for CpMovimientoDAO.
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 */
public interface ICpMovimientoDAO {
    // property constants
    //public static final String  DESCRIPCIONMOVIMIENTO = "descripcionMovimiento";
    public static final String DESCRIPCIONMOVIMIENTO = "descripcionMovimiento";

    //public static final Long  IDMOVIMIENTO = "idMovimiento";
    public static final String IDMOVIMIENTO = "idMovimiento";

    //public static final String  OBSERVACIONES = "observaciones";
    public static final String OBSERVACIONES = "observaciones";

    /**
    * Perform an initial save of a previously unsaved CpMovimiento entity. All
    * subsequent persist actions of this entity should use the #update()
    * method. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpMovimientoDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpMovimiento entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpMovimiento entity);

    /**
    * Delete a persistent CpMovimiento entity. This operation must be performed
    * within the a database transaction context for the entity's data to be
    * permanently deleted from the persistence store, i.e., database. This
    * method uses the
    * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpMovimientoDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpMovimiento entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpMovimiento entity);

    /**
    * Persist a previously saved CpMovimiento entity and return it or a copy of it
    * to the sender. A copy of the CpMovimiento entity parameter is returned when
    * the JPA persistence mechanism has not previously been tracking the
    * updated entity. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * entity = ICpMovimientoDAO.update(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpMovimiento entity to update
    * @return CpMovimiento the persisted CpMovimiento entity instance, may not be the
    *         same
    * @throws RuntimeException
    *             if the operation fails
    */
    public CpMovimiento update(CpMovimiento entity);

    public CpMovimiento findById(Long id);

    /**
    * Find all CpMovimiento entities with a specific property value.
    *
    * @param propertyName
    *            the name of the CpMovimiento property to query
    * @param value
    *            the property value to match
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpMovimiento> found by query
        */
    public List<CpMovimiento> findByProperty(String propertyName, Object value,
        int... rowStartIdxAndCount);

    public List<CpMovimiento> findByCriteria(String whereCondition);

    public List<CpMovimiento> findByDescripcionMovimiento(
        Object descripcionMovimiento);

    public List<CpMovimiento> findByDescripcionMovimiento(
        Object descripcionMovimiento, int... rowStartIdxAndCount);

    public List<CpMovimiento> findByIdMovimiento(Object idMovimiento);

    public List<CpMovimiento> findByIdMovimiento(Object idMovimiento,
        int... rowStartIdxAndCount);

    public List<CpMovimiento> findByObservaciones(Object observaciones);

    public List<CpMovimiento> findByObservaciones(Object observaciones,
        int... rowStartIdxAndCount);

    /**
    * Find all CpMovimiento entities.
    *
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpMovimiento> all CpMovimiento entities
    */
    public List<CpMovimiento> findAll(int... rowStartIdxAndCount);

    public List<CpMovimiento> findPageCpMovimiento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberCpMovimiento();
}
