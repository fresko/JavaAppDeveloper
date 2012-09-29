package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.dataaccess.entityManager.EntityManagerHelper;
import org.zathura.cuentas.personales.CpUsuarios;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import javax.persistence.EntityManager;
import javax.persistence.Query;


/**
* A data access object (DAO) providing persistence and search support for
* CpUsuarios entities. Transaction control of the save(), update() and delete()
* operations must be handled externally by senders of these methods or must be
* manually added to each of these methods for data to be persisted to the JPA
* datastore.
*
* @author Zathura Code Generator http://code.google.com/p/zathura
* @see lidis.CpUsuarios
*
*/
public class CpUsuariosDAO implements ICpUsuariosDAO {
    private EntityManager getEntityManager() {
        return EntityManagerHelper.getEntityManager();
    }

    /**
    * Perform an initial save of a previously unsaved CpUsuarios entity. All
    * subsequent persist actions of this entity should use the #update()
    * method. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#persist(Object) EntityManager#persist}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * CpUsuariosDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpUsuarios entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpUsuarios entity) {
        EntityManagerHelper.log("saving CpUsuarios instance", Level.INFO, null);

        try {
            getEntityManager().persist(entity);
            EntityManagerHelper.log("save successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("save failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
    * Delete a persistent CpUsuarios entity. This operation must be performed
    * within the a database transaction context for the entity's data to be
    * permanently deleted from the persistence store, i.e., database. This
    * method uses the
    * {@link javax.persistence.EntityManager#remove(Object) EntityManager#delete}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * CpUsuariosDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpUsuarios entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpUsuarios entity) {
        EntityManagerHelper.log("deleting CpUsuarios instance", Level.INFO, null);

        try {
            entity = getEntityManager()
                         .getReference(CpUsuarios.class, entity.getIdUsuario());
            getEntityManager().remove(entity);
            EntityManagerHelper.log("delete successful", Level.INFO, null);
        } catch (RuntimeException re) {
            EntityManagerHelper.log("delete failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
    * Persist a previously saved CpUsuarios entity and return it or a copy of it
    * to the sender. A copy of the CpUsuarios entity parameter is returned when
    * the JPA persistence mechanism has not previously been tracking the
    * updated entity. This operation must be performed within the a database
    * transaction context for the entity's data to be permanently saved to the
    * persistence store, i.e., database. This method uses the
    * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
    * operation.
    *
    * <pre>
    * EntityManagerHelper.beginTransaction();
    * entity = CpUsuariosDAO.update(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpUsuarios entity to update
    * @return CpUsuarios the persisted CpUsuarios entity instance, may not be the
    *         same
    * @throws RuntimeException
    *             if the operation fails
    */
    public CpUsuarios update(CpUsuarios entity) {
        EntityManagerHelper.log("updating CpUsuarios instance", Level.INFO, null);

        try {
            CpUsuarios result = getEntityManager().merge(entity);
            EntityManagerHelper.log("update successful", Level.INFO, null);

            return result;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("update failed", Level.SEVERE, re);
            throw re;
        }
    }

    public CpUsuarios findById(Long id) {
        EntityManagerHelper.log("finding CpUsuarios instance with id: " + id,
            Level.INFO, null);

        try {
            CpUsuarios instance = getEntityManager().find(CpUsuarios.class, id);

            return instance;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find failed", Level.SEVERE, re);
            throw re;
        }
    }

    /**
    * Find all  CpUsuarios entities with a specific property value.
    *
    * @param propertyName
    *            the metaData.name of the  CpUsuarios property to query
    * @param value
    *            the property value to match
    * @return List< CpUsuarios> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpUsuarios> findByProperty(String propertyName,
        final Object value) {
        EntityManagerHelper.log("finding  CpUsuarios instance with property: " +
            propertyName + ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from  CpUsuarios model where model." +
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
    * Find all CpUsuarios entities with a specific property value.
    *
    * @param propertyName
    *            the name of the CpUsuarios property to query
    * @param value
    *            the property value to match
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            number of results to return.
    * @return List<CpUsuarios> found by query
        */
    @SuppressWarnings("unchecked")
    public List<CpUsuarios> findByProperty(String propertyName,
        final Object value, final int... rowStartIdxAndCount) {
        EntityManagerHelper.log("finding CpUsuarios instance with property: " +
            propertyName + ", value: " + value, Level.INFO, null);

        try {
            final String queryString = "select model from CpUsuarios model where model." +
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

    public List<CpUsuarios> findByActivo(Object activo,
        int... rowStartIdxAndCount) {
        return findByProperty(ACTIVO, activo, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByActivo(Object activo) {
        return findByProperty(ACTIVO, activo);
    }

    public List<CpUsuarios> findByApellido(Object apellido,
        int... rowStartIdxAndCount) {
        return findByProperty(APELLIDO, apellido, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByApellido(Object apellido) {
        return findByProperty(APELLIDO, apellido);
    }

    public List<CpUsuarios> findByContrasena(Object contrasena,
        int... rowStartIdxAndCount) {
        return findByProperty(CONTRASENA, contrasena, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByContrasena(Object contrasena) {
        return findByProperty(CONTRASENA, contrasena);
    }

    public List<CpUsuarios> findByCorreo(Object correo,
        int... rowStartIdxAndCount) {
        return findByProperty(CORREO, correo, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByCorreo(Object correo) {
        return findByProperty(CORREO, correo);
    }

    public List<CpUsuarios> findByIdUsuario(Object idUsuario,
        int... rowStartIdxAndCount) {
        return findByProperty(IDUSUARIO, idUsuario, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByIdUsuario(Object idUsuario) {
        return findByProperty(IDUSUARIO, idUsuario);
    }

    public List<CpUsuarios> findByMovil(Object movil, int... rowStartIdxAndCount) {
        return findByProperty(MOVIL, movil, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByMovil(Object movil) {
        return findByProperty(MOVIL, movil);
    }

    public List<CpUsuarios> findByNombre(Object nombre,
        int... rowStartIdxAndCount) {
        return findByProperty(NOMBRE, nombre, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByNombre(Object nombre) {
        return findByProperty(NOMBRE, nombre);
    }

    public List<CpUsuarios> findByObservaciones(Object observaciones,
        int... rowStartIdxAndCount) {
        return findByProperty(OBSERVACIONES, observaciones, rowStartIdxAndCount);
    }

    public List<CpUsuarios> findByObservaciones(Object observaciones) {
        return findByProperty(OBSERVACIONES, observaciones);
    }

    /**
    * Find all CpUsuarios entities.
    *
    * @param rowStartIdxAndCount
    *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
    *            row index in the query result-set to begin collecting the
    *            results. rowStartIdxAndCount[1] specifies the the maximum
    *            count of results to return.
    * @return List<CpUsuarios> all CpUsuarios entities
    */
    @SuppressWarnings("unchecked")
    public List<CpUsuarios> findAll(final int... rowStartIdxAndCount) {
        EntityManagerHelper.log("finding all CpUsuarios instances", Level.INFO,
            null);

        try {
            final String queryString = "select model from CpUsuarios model";
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

    public List<CpUsuarios> findByCriteria(String whereCondition) {
        EntityManagerHelper.log("finding CpUsuarios " + whereCondition,
            Level.INFO, null);

        try {
            String where = ((whereCondition == null) ||
                (whereCondition.length() == 0)) ? "" : ("where " +
                whereCondition);
            final String queryString = "select model from CpUsuarios model " +
                where;
            Query query = getEntityManager().createQuery(queryString);
            List<CpUsuarios> entitiesList = query.getResultList();

            return entitiesList;
        } catch (RuntimeException re) {
            EntityManagerHelper.log("find By Criteria in CpUsuarios failed",
                Level.SEVERE, re);
            throw re;
        }
    }

    public List<CpUsuarios> findPageCpUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults) {
        EntityManagerHelper.log("finding CpUsuarios findPageCpUsuarios",
            Level.INFO, null);

        if ((sortColumnName != null) && (sortColumnName.length() > 0)) {
            try {
                String queryString = "select model from CpUsuarios model order by model." +
                    sortColumnName + " " + (sortAscending ? "asc" : "desc");

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        } else {
            try {
                String queryString = "select model from CpUsuarios model";

                return getEntityManager().createQuery(queryString)
                           .setFirstResult(startRow).setMaxResults(maxResults)
                           .getResultList();
            } catch (RuntimeException re) {
                throw re;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Long findTotalNumberCpUsuarios() {
        EntityManagerHelper.log("finding CpUsuarios count", Level.INFO, null);

        try {
            String queryString = "select count(*) from CpUsuarios model";

            return (Long) getEntityManager().createQuery(queryString)
                              .getSingleResult();
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
