package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.dataaccess.entityManager.EntityManagerHelper;
import org.zathura.cuentas.personales.CpGrupoMovimiento;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
* A data access object (DAO) providing persistence and search support for
* CpGrupoMovimiento entities. Transaction control of the save(), update() and delete()
* operations must be handled externally by senders of these methods or must be
* manually added to each of these methods for data to be persisted to the JPA
* datastore.
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* @see lidis.CpGrupoMovimiento
*
*/
public class CpGrupoMovimientoDAO implements ICpGrupoMovimientoDAO {
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

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
    * CpGrupoMovimientoDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpGrupoMovimiento entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpGrupoMovimiento entity) {
        EntityManagerHelper.log("saving CpGrupoMovimiento instance",
            Level.INFO, null);

        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

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
    * CpGrupoMovimientoDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpGrupoMovimiento entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpGrupoMovimiento entity) {
        EntityManagerHelper.log("deleting CpGrupoMovimiento instance",
            Level.INFO, null);

        try {
            entity = getEntityManager()
                         .getReference(CpGrupoMovimiento.class,
                    entity.getIdGrupoMovimiento());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

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
    * entity = CpGrupoMovimientoDAO.update(entity);
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
    public CpGrupoMovimiento update(CpGrupoMovimiento entity) {
        EntityManagerHelper.log("updating CpGrupoMovimiento instance",
            Level.INFO, null);

        try {
            CpGrupoMovimiento result = getEntityManager()
                                           .merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);

            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public CpGrupoMovimiento findById(Long id) {
        EntityManagerHelper.log("finding CpGrupoMovimiento instance with id: " +
            id, Level.INFO, null);

        try {
            CpGrupoMovimiento instance = getEntityManager()
                                             .find(CpGrupoMovimiento.class, id);

            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
    * Find all  CpGrupoMovimiento entities with a specific property value.
    *
    * @param propertyName
    *            the metaData.name of the  CpGrupoMovimiento property to query
    * @param value
    *            the property value to match
    * @return List< CpGrupoMovimiento> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpGrupoMovimiento> findByProperty(String propertyName,
        final Object value) {
        EntityManagerHelper.log(
            "finding  CpGrupoMovimiento instance with property: " +
            propertyName + ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from  CpGrupoMovimiento model where model." +
                propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);

            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property metaData.name failed",
                Level.SEVERE, re);
            throw re;
        }
    }

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
    *            number of results to return.
    * @return List<CpGrupoMovimiento> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpGrupoMovimiento> findByProperty(String propertyName,
        final Object value, final int... rowStartIdxAndCount) {
        EntityManagerHelper.log(
            "finding CpGrupoMovimiento instance with property: " +
            propertyName + ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from CpGrupoMovimiento model where model." +
                propertyName + "= :propertyValue";
            Query query = getEntityManager().createQuery(queryString);
            query.setParameter("propertyValue", value);

            if ((rowStartIdxAndCount != null) &&
                    (rowStartIdxAndCount.length > 0)) {
                int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);

                if (rowStartIdx > 0) {
                    query.setFirstResult(rowStartIdx);
                }

                if (rowStartIdxAndCount.length > 1) {
                    int rowCount = Math.max(0, rowStartIdxAndCount[1]);

                    if (rowCount > 0) {
                        query.setMaxResults(rowCount);
                    }
                }
            }

            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find by property name failed",
                Level.SEVERE, re);
            throw re;
        }
    }

    public List<CpGrupoMovimiento> findByDescripcion(Object descripcion,
        int... rowStartIdxAndCount) {
        return findByProperty(DESCRIPCION, descripcion, rowStartIdxAndCount);
    }

    public List<CpGrupoMovimiento> findByDescripcion(Object descripcion) {
        return findByProperty(DESCRIPCION, descripcion);
    }

    public List<CpGrupoMovimiento> findByIdGrupoMovimiento(
        Object idGrupoMovimiento, int... rowStartIdxAndCount) {
        return findByProperty(IDGRUPOMOVIMIENTO, idGrupoMovimiento,
            rowStartIdxAndCount);
    }

    public List<CpGrupoMovimiento> findByIdGrupoMovimiento(
        Object idGrupoMovimiento) {
        return findByProperty(IDGRUPOMOVIMIENTO, idGrupoMovimiento);
    }

    public List<CpGrupoMovimiento> findByObservacion(Object observacion,
        int... rowStartIdxAndCount) {
        return findByProperty(OBSERVACION, observacion, rowStartIdxAndCount);
    }

    public List<CpGrupoMovimiento> findByObservacion(Object observacion) {
        return findByProperty(OBSERVACION, observacion);
    }

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
    @SuppressWarnings("unchecked")
    public List<CpGrupoMovimiento> findAll(final int... rowStartIdxAndCount) {
        EntityManagerHelper.log("finding all CpGrupoMovimiento instances",
            Level.INFO, null);

        try {
            final String queryString = "select model from CpGrupoMovimiento model";
            Query query = getEntityManager().createQuery(queryString);

            if ((rowStartIdxAndCount != null) &&
                    (rowStartIdxAndCount.length > 0)) {
                int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);

                if (rowStartIdx > 0) {
                    query.setFirstResult(rowStartIdx);
                }

                if (rowStartIdxAndCount.length > 1) {
                    int rowCount = Math.max(0, rowStartIdxAndCount[1]);

                    if (rowCount > 0) {
                        query.setMaxResults(rowCount);
                    }
                }
            }

            return query.getResultList();
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find all failed", Level.SEVERE, re);
            throw re;
        }
    }

    public List<CpGrupoMovimiento> findByCriteria(String whereCondition) {
        EntityManagerHelper.log("finding CpGrupoMovimiento " + whereCondition,
            Level.INFO, null);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from CpGrupoMovimiento model " +
                where;
            Query query = getEntityManager().createQuery(queryString);
            List<CpGrupoMovimiento> entitiesList = query.getResultList();

            return entitiesList;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find By Criteria in CpGrupoMovimiento failed",
                Level.SEVERE, re);
            throw re;
        }
    }

    public List<CpGrupoMovimiento> findPageCpGrupoMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) {
        EntityManagerHelper.log("finding CpGrupoMovimiento findPageCpGrupoMovimiento",
            Level.INFO, null);

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from CpGrupoMovimiento model order by model." +
                    sortColumnName + " " + (sortAscending ? "asc" : "desc");

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        } else {
            try {
                String queryString = "select model from CpGrupoMovimiento model";

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Long findTotalNumberCpGrupoMovimiento() {
        EntityManagerHelper.log("finding CpGrupoMovimiento count", Level.INFO,
            null);

        try {
            String queryString = "select count(*) from CpGrupoMovimiento model";

            return (Long) getEntityManager().createQuery(queryString)
                              .getSingleResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
