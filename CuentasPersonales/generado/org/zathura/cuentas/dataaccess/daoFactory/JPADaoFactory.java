package  org.zathura.cuentas.dataaccess.daoFactory;
import org.zathura.cuentas.dataaccess.dao.*;
/**
 * Factory for Data Access Objects Strategy The DAO pattern can be made highly flexible 
 * by adopting the Abstract Factory [GoF] and the Factory Method [GoF] patterns.
 * When the underlying storage is not subject to change from one implementation to another, 
 * this strategy can be implemented using the Factory Method pattern to produce a number of DAOs needed by the application. 
 * This class is a Factory Method pattern
 *
 * @author Zathura Code Generator http://code.google.com/p/zathura/
 */
public class JPADaoFactory {
private static JPADaoFactory instance = null;
/**
* 
* @return JPADaoFactory
*/
public static JPADaoFactory getInstance(){
if(instance == null){
instance = new JPADaoFactory();
}
return instance;
}	
private JPADaoFactory(){
}
    /**
    * This method instantiates the ICpDetalleMovimientoDAO class for JPA 
    * that is used in this applications deployment environment to access the data. 
    * @return ICpDetalleMovimientoDAO implementation
    */
    public ICpDetalleMovimientoDAO getCpDetalleMovimientoDAO() {
    return new CpDetalleMovimientoDAO();
    }
    /**
    * This method instantiates the ICpGrupoMovimientoDAO class for JPA 
    * that is used in this applications deployment environment to access the data. 
    * @return ICpGrupoMovimientoDAO implementation
    */
    public ICpGrupoMovimientoDAO getCpGrupoMovimientoDAO() {
    return new CpGrupoMovimientoDAO();
    }
    /**
    * This method instantiates the ICpMovimientoDAO class for JPA 
    * that is used in this applications deployment environment to access the data. 
    * @return ICpMovimientoDAO implementation
    */
    public ICpMovimientoDAO getCpMovimientoDAO() {
    return new CpMovimientoDAO();
    }
    /**
    * This method instantiates the ICpTipoMovimientoDAO class for JPA 
    * that is used in this applications deployment environment to access the data. 
    * @return ICpTipoMovimientoDAO implementation
    */
    public ICpTipoMovimientoDAO getCpTipoMovimientoDAO() {
    return new CpTipoMovimientoDAO();
    }
    /**
    * This method instantiates the ICpUsuariosDAO class for JPA 
    * that is used in this applications deployment environment to access the data. 
    * @return ICpUsuariosDAO implementation
    */
    public ICpUsuariosDAO getCpUsuariosDAO() {
    return new CpUsuariosDAO();
    }
}
