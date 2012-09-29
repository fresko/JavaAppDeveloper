package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.dataaccess.entityManager.EntityManagerHelper;
import org.zathura.cuentas.personales.CpDetalleMovimiento;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
* A data access object (DAO) providing persistence and search support for
* CpDetalleMovimiento entities. Transaction control of the save(), update() and delete()
* operations must be handled externally by senders of these methods or must be
* manually added to each of these methods for data to be persisted to the JPA
* datastore.
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* @see lidis.CpDetalleMovimiento
*
*/
public class CpDetalleMovimientoDAO implements ICpDetalleMovimientoDAO {
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

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
    * CpDetalleMovimientoDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpDetalleMovimiento entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpDetalleMovimiento entity) {
        EntityManagerHelper.log("saving CpDetalleMovimiento instance",
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
    * Delete a persistent CpDetalleMovimiento entity. This operation must be performed
    * within the a database transaction context for the entity's data to be
    * permanently deleted from the persistence store, i.e., database. This
    * method uses the
    * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * CpDetalleMovimientoDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpDetalleMovimiento entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpDetalleMovimiento entity) {
        EntityManagerHelper.log("deleting CpDetalleMovimiento instance",
            Level.INFO, null);

        try {
            entity = getEntityManager()
                         .getReference(CpDetalleMovimiento.class,
                    entity.getIdDetalleMovimiento());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

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
    * entity = CpDetalleMovimientoDAO.update(entity);
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
    public CpDetalleMovimiento update(CpDetalleMovimiento entity) {
        EntityManagerHelper.log("updating CpDetalleMovimiento instance",
            Level.INFO, null);

        try {
            CpDetalleMovimiento result = getEntityManager()
                                             .merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);

            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public CpDetalleMovimiento findById(Long id) {
        EntityManagerHelper.log(
            "finding CpDetalleMovimiento instance with id: " + id, Level.INFO,
            null);

        try {
            CpDetalleMovimiento instance = getEntityManager()
                                               .find(CpDetalleMovimiento.class,
                    id);

            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
    * Find all  CpDetalleMovimiento entities with a specific property value.
    *
    * @param propertyName
    *            the metaData.name of the  CpDetalleMovimiento property to query
    * @param value
    *            the property value to match
    * @return List< CpDetalleMovimiento> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpDetalleMovimiento> findByProperty(String propertyName,
        final Object value) {
        EntityManagerHelper.log(
            "finding  CpDetalleMovimiento instance with property: " +
            propertyName + ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from  CpDetalleMovimiento model where model." +
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
    *            number of results to return.
    * @return List<CpDetalleMovimiento> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpDetalleMovimiento> findByProperty(String propertyName,
        final Object value, final int... rowStartIdxAndCount) {
        EntityManagerHelper.log(
            "finding CpDetalleMovimiento instance with property: " +
            propertyName + ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from CpDetalleMovimiento model where model." +
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

    public List<CpDetalleMovimiento> findByAnno(Object anno,
        int... rowStartIdxAndCount) {
        return findByProperty(ANNO, anno, rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByAnno(Object anno) {
        return findByProperty(ANNO, anno);
    }

    public List<CpDetalleMovimiento> findByFehcaRegistro(Object fehcaRegistro,
        int... rowStartIdxAndCount) {
        return findByProperty(FEHCAREGISTRO, fehcaRegistro, rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByFehcaRegistro(Object fehcaRegistro) {
        return findByProperty(FEHCAREGISTRO, fehcaRegistro);
    }

    public List<CpDetalleMovimiento> findByIdDetalleMovimiento(
        Object idDetalleMovimiento, int... rowStartIdxAndCount) {
        return findByProperty(IDDETALLEMOVIMIENTO, idDetalleMovimiento,
            rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByIdDetalleMovimiento(
        Object idDetalleMovimiento) {
        return findByProperty(IDDETALLEMOVIMIENTO, idDetalleMovimiento);
    }

    public List<CpDetalleMovimiento> findByMes(Object mes,
        int... rowStartIdxAndCount) {
        return findByProperty(MES, mes, rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByMes(Object mes) {
        return findByProperty(MES, mes);
    }

    public List<CpDetalleMovimiento> findByObservaciones(Object observaciones,
        int... rowStartIdxAndCount) {
        return findByProperty(OBSERVACIONES, observaciones, rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByObservaciones(Object observaciones) {
        return findByProperty(OBSERVACIONES, observaciones);
    }

    public List<CpDetalleMovimiento> findByPendiente(Object pendiente,
        int... rowStartIdxAndCount) {
        return findByProperty(PENDIENTE, pendiente, rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByPendiente(Object pendiente) {
        return findByProperty(PENDIENTE, pendiente);
    }

    public List<CpDetalleMovimiento> findByValorMovimiento(
        Object valorMovimiento, int... rowStartIdxAndCount) {
        return findByProperty(VALORMOVIMIENTO, valorMovimiento,
            rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByValorMovimiento(
        Object valorMovimiento) {
        return findByProperty(VALORMOVIMIENTO, valorMovimiento);
    }

    public List<CpDetalleMovimiento> findByValorPago(Object valorPago,
        int... rowStartIdxAndCount) {
        return findByProperty(VALORPAGO, valorPago, rowStartIdxAndCount);
    }

    public List<CpDetalleMovimiento> findByValorPago(Object valorPago) {
        return findByProperty(VALORPAGO, valorPago);
    }

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
    @SuppressWarnings("unchecked")
    public List<CpDetalleMovimiento> findAll(final int... rowStartIdxAndCount) {
        EntityManagerHelper.log("finding all CpDetalleMovimiento instances",
            Level.INFO, null);

        try {
            final String queryString = "select model from CpDetalleMovimiento model";
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

    public List<CpDetalleMovimiento> findByCriteria(String whereCondition) {
        EntityManagerHelper.log("finding CpDetalleMovimiento " +
            whereCondition, Level.INFO, null);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from CpDetalleMovimiento model " +
                where;
            Query query = getEntityManager().createQuery(queryString);
            List<CpDetalleMovimiento> entitiesList = query.getResultList();

            return entitiesList;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find By Criteria in CpDetalleMovimiento failed",
                Level.SEVERE, re);
            throw re;
        }
    }

    public List<CpDetalleMovimiento> findPageCpDetalleMovimiento(
        String sortColumnName, boolean sortAscending, int startRow,
        int maxResults) {
        EntityManagerHelper.log("finding CpDetalleMovimiento findPageCpDetalleMovimiento",
            Level.INFO, null);

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from CpDetalleMovimiento model order by model." +
                    sortColumnName + " " + (sortAscending ? "asc" : "desc");

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        } else {
            try {
                String queryString = "select model from CpDetalleMovimiento model";

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Long findTotalNumberCpDetalleMovimiento() {
        EntityManagerHelper.log("finding CpDetalleMovimiento count",
            Level.INFO, null);

        try {
            String queryString = "select count(*) from CpDetalleMovimiento model";

            return (Long) getEntityManager().createQuery(queryString)
                              .getSingleResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
