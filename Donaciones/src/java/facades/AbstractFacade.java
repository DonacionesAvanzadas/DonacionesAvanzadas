package facades;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import entities.*;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;
    protected final EntityManager em;

     /**
     * Constructor para asignar un objeto al objeto entityClass y 7
     * declarar un objeto tipo EntityMangerFactory
     * @param entityClass 
     */
    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DonacionesPU");
        
        em = emf.createEntityManager();
    }
    /**
     * Función para agregar un nuevo elemento al contexto de persistencia,
     * utilizando una transacción de JTA
     * 
     * @param entity La entidad que se va a persistir
     */
    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }
    /**
     * Función para editar un nuevo elemento al contexto de persistencia,
     * utilizando una transacción de JTA
     * 
     * @param entity La entidad que se va a persistir
     */
    public void edit(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
    /**
     * Función para eliminar un nuevo elemento al contexto de persistencia,
     * utilizando una transacción de JTA
     * 
     * @param entity La entidad que se va a persistir
     */
    public void remove(T entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }
    /**
     * busca un determinado objeto
     * @param id del objeto
     * @return el objeto encontrado
     */
    public T find(Object id) {
        return em.find(entityClass, id);
    }
    /**
     * retorna una lista de todos los objetos
     * @return lista de objetos
     */
    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

}
