package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.personales.CpGrupoMovimiento;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Interface for CpGrupoMovimientoDAO.
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 */
public interface ICpGrupoMovimientoDAO {
    // property constants
    //public static final String  DESCRIPCION = "descripcion";
    public static final String DESCRIPCION = "descripcion";

    //public static final Long  IDGRUPOMOVIMIENTO = "idGrupoMovimiento";
    public static final String IDGRUPOMOVIMIENTO = "idGrupoMovimiento";

    //public static final String  OBSERVACION = "observacion";
    public static final String OBSERVACION = "observacion";

    /**
    * Perform an initial save of a previously unsaved CpGrupoMovimiento entity. All
    * subsequent persist actions of this entity should use the #update()
    * method. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpGrupoMovimientoDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpGrupoMovimiento entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpGrupoMovimiento entity);

    /**
    * Delete a persistent CpGrupoMovimiento entity. This operation must be performed
    * within the a database transaction context for the entity's data to be
    * permanently deleted from the persistence store, i.e., database. This
    * method uses the
    * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * ICpGrupoMovimientoDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpGrupoMovimiento entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpGrupoMovimiento entity);

    /**
    * Persist a previously saved CpGrupoMovimiento entity and return it or a copy of it
    * to the sender. A copy of the CpGrupoMovimiento entity parameter is returned when
    * the JPA persistence mechanism has not previously been tracking the
    * updated entity. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * entity = ICpGrupoMovimientoDAO.update(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpGrupoMovimiento entity to update
    * @return CpGrupoMovimiento the persisted CpGrupoMovimiento entity instance, may not be the
    *         same
    * @throws RuntimeException
    *             if the operation fails
    */
    public CpGrupoMovimiento update(CpGrupoMovimiento entity);

    public CpGrupoMovimiento findById(Long id);

    /**
    * Find all CpGrupoMovimiento entities with a specific property value.
    *
    * @param propertyName
    *            the name of the CpGrupoMovimiento property to query
    * @param value
    *            the property value to match
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpGrupoMovimiento> found by query
        */
    public List<CpGrupoMovimiento> findByProperty(String propertyName,
        Object value, int... rowStartIdxAndCount);

    public List<CpGrupoMovimiento> findByCriteria(String whereCondition);

    public List<CpGrupoMovimiento> findByDescripcion(Object descripcion);

    public List<CpGrupoMovimiento> findByDescripcion(Object descripcion,
        int... rowStartIdxAndCount);

    public List<CpGrupoMovimiento> findByIdGrupoMovimiento(
        Object idGrupoMovimiento);

    public List<CpGrupoMovimiento> findByIdGrupoMovimiento(
        Object idGrupoMovimiento, int... rowStartIdxAndCount);

    public List<CpGrupoMovimiento> findByObservacion(Object observacion);

    public List<CpGrupoMovimiento> findByObservacion(Object observacion,
        int... rowStartIdxAndCount);

    /**
    * Find all CpGrupoMovimiento entities.
    *
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpGrupoMovimiento> all CpGrupoMovimiento entities
    */
    public List<CpGrupoMovimiento> findAll(int... rowStartIdxAndCount);

    public List<CpGrupoMovimiento> findPageCpGrupoMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults);

    public Long findTotalNumberCpGrupoMovimiento();
}
