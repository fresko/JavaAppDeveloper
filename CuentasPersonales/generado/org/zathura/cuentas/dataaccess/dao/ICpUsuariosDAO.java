package org.zathura.cuentas.dataaccess.dao;

import org.zathura.cuentas.personales.CpUsuarios;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Interface for CpUsuariosDAO.
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura
 */
public interface ICpUsuariosDAO {
    // property constants
    //public static final String  ACTIVO = "activo";
    public static final String ACTIVO = "activo";

    //public static final String  APELLIDO = "apellido";
    public static final String APELLIDO = "apellido";

    //public static final String  CONTRASENA = "contrasena";
    public static final String CONTRASENA = "contrasena";

    //public static final String  CORREO = "correo";
    public static final String CORREO = "correo";

    //public static final Long  IDUSUARIO = "idUsuario";
    public static final String IDUSUARIO = "idUsuario";

    //public static final Long  MOVIL = "movil";
    public static final String MOVIL = "movil";

    //public static final String  NOMBRE = "nombre";
    public static final String NOMBRE = "nombre";

    //public static final String  OBSERVACIONES = "observaciones";
    public static final String OBSERVACIONES = "observaciones";

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
    * ICpUsuariosDAO.save(entity);
    * EntityManagerHelper.commit();
    * </pre>
    *
    * @param entity
    *            CpUsuarios entity to persist
    * @throws RuntimeException
    *             when the operation fails
    */
    public void save(CpUsuarios entity);

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
    * ICpUsuariosDAO.delete(entity);
    * EntityManagerHelper.commit();
    * entity = null;
    * </pre>
    *
    * @param entity
    *            CpUsuarios entity to delete
    * @throws RuntimeException
    *             when the operation fails
    */
    public void delete(CpUsuarios entity);

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
    * entity = ICpUsuariosDAO.update(entity);
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
    public CpUsuarios update(CpUsuarios entity);

    public CpUsuarios findById(Long id);

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
    *            count of results to return.
    * @return List<CpUsuarios> found by query
        */
    public List<CpUsuarios> findByProperty(String propertyName, Object value,
        int... rowStartIdxAndCount);

    public List<CpUsuarios> findByCriteria(String whereCondition);

    public List<CpUsuarios> findByActivo(Object activo);

    public List<CpUsuarios> findByActivo(Object activo,
        int... rowStartIdxAndCount);

    public List<CpUsuarios> findByApellido(Object apellido);

    public List<CpUsuarios> findByApellido(Object apellido,
        int... rowStartIdxAndCount);

    public List<CpUsuarios> findByContrasena(Object contrasena);

    public List<CpUsuarios> findByContrasena(Object contrasena,
        int... rowStartIdxAndCount);

    public List<CpUsuarios> findByCorreo(Object correo);

    public List<CpUsuarios> findByCorreo(Object correo,
        int... rowStartIdxAndCount);

    public List<CpUsuarios> findByIdUsuario(Object idUsuario);

    public List<CpUsuarios> findByIdUsuario(Object idUsuario,
        int... rowStartIdxAndCount);

    public List<CpUsuarios> findByMovil(Object movil);

    public List<CpUsuarios> findByMovil(Object movil, int... rowStartIdxAndCount);

    public List<CpUsuarios> findByNombre(Object nombre);

    public List<CpUsuarios> findByNombre(Object nombre,
        int... rowStartIdxAndCount);

    public List<CpUsuarios> findByObservaciones(Object observaciones);

    public List<CpUsuarios> findByObservaciones(Object observaciones,
        int... rowStartIdxAndCount);

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
    public List<CpUsuarios> findAll(int... rowStartIdxAndCount);

    public List<CpUsuarios> findPageCpUsuarios(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults);

    public Long findTotalNumberCpUsuarios();
}
