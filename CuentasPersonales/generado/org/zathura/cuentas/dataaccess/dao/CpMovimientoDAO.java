package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.dataaccess.entityManager.EntityManagerHelper;
import org.zathura.cuentas.personales.CpMovimiento;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
* A data access object (DAO) providing persistence and search support for
* CpMovimiento entities. Transaction control of the save(), update() and delete()
* operations must be handled externally by senders of these methods or must be
* manually added to each of these methods for data to be persisted to the JPA
* datastore.
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* @see lidis.CpMovimiento
*
*/
public class CpMovimientoDAO implements ICpMovimientoDAO {
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

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
    * CpMovimientoDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpMovimiento entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpMovimiento entity) {
        EntityManagerHelper.log("saving CpMovimiento instance", Level.INFO, null);

        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

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
    * CpMovimientoDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpMovimiento entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpMovimiento entity) {
        EntityManagerHelper.log("deleting CpMovimiento instance", Level.INFO,
            null);

        try {
            entity = getEntityManager()
                         .getReference(CpMovimiento.class,
                    entity.getIdMovimiento());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

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
    * entity = CpMovimientoDAO.update(entity);
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
    public CpMovimiento update(CpMovimiento entity) {
        EntityManagerHelper.log("updating CpMovimiento instance", Level.INFO,
            null);

        try {
            CpMovimiento result = getEntityManager()
                                      .merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);

            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public CpMovimiento findById(Long id) {
        EntityManagerHelper.log("finding CpMovimiento instance with id: " + id,
            Level.INFO, null);

        try {
            CpMovimiento instance = getEntityManager()
                                        .find(CpMovimiento.class, id);

            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
    * Find all  CpMovimiento entities with a specific property value.
    *
    * @param propertyName
    *            the metaData.name of the  CpMovimiento property to query
    * @param value
    *            the property value to match
    * @return List< CpMovimiento> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpMovimiento> findByProperty(String propertyName,
        final Object value) {
        EntityManagerHelper.log(
            "finding  CpMovimiento instance with property: " + propertyName +
            ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from  CpMovimiento model where model." +
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
    *            number of results to return.
    * @return List<CpMovimiento> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpMovimiento> findByProperty(String propertyName,
        final Object value, final int... rowStartIdxAndCount) {
        EntityManagerHelper.log("finding CpMovimiento instance with property: " +
            propertyName + ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from CpMovimiento model where model." +
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

    public List<CpMovimiento> findByDescripcionMovimiento(
        Object descripcionMovimiento, int... rowStartIdxAndCount) {
        return findByProperty(DESCRIPCIONMOVIMIENTO, descripcionMovimiento,
            rowStartIdxAndCount);
    }

    public List<CpMovimiento> findByDescripcionMovimiento(
        Object descripcionMovimiento) {
        return findByProperty(DESCRIPCIONMOVIMIENTO, descripcionMovimiento);
    }

    public List<CpMovimiento> findByIdMovimiento(Object idMovimiento,
        int... rowStartIdxAndCount) {
        return findByProperty(IDMOVIMIENTO, idMovimiento, rowStartIdxAndCount);
    }

    public List<CpMovimiento> findByIdMovimiento(Object idMovimiento) {
        return findByProperty(IDMOVIMIENTO, idMovimiento);
    }

    public List<CpMovimiento> findByObservaciones(Object observaciones,
        int... rowStartIdxAndCount) {
        return findByProperty(OBSERVACIONES, observaciones, rowStartIdxAndCount);
    }

    public List<CpMovimiento> findByObservaciones(Object observaciones) {
        return findByProperty(OBSERVACIONES, observaciones);
    }

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
    @SuppressWarnings("unchecked")
    public List<CpMovimiento> findAll(final int... rowStartIdxAndCount) {
        EntityManagerHelper.log("finding all CpMovimiento instances",
            Level.INFO, null);

        try {
            final String queryString = "select model from CpMovimiento model";
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

    public List<CpMovimiento> findByCriteria(String whereCondition) {
        EntityManagerHelper.log("finding CpMovimiento " + whereCondition,
            Level.INFO, null);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from CpMovimiento model " +
                where;
            Query query = getEntityManager().createQuery(queryString);
            List<CpMovimiento> entitiesList = query.getResultList();

            return entitiesList;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find By Criteria in CpMovimiento failed",
                Level.SEVERE, re);
            throw re;
        }
    }

    public List<CpMovimiento> findPageCpMovimiento(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        EntityManagerHelper.log("finding CpMovimiento findPageCpMovimiento",
            Level.INFO, null);

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from CpMovimiento model order by model." +
                    sortColumnName + " " + (sortAscending ? "asc" : "desc");

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        } else {
            try {
                String queryString = "select model from CpMovimiento model";

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Long findTotalNumberCpMovimiento() {
        EntityManagerHelper.log("finding CpMovimiento count", Level.INFO, null);

        try {
            String queryString = "select count(*) from CpMovimiento model";

            return (Long) getEntityManager().createQuery(queryString)
                              .getSingleResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
