package facades;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author Yael Arturo Chavoya Andalón 14300094
 */
public abstract class AbstractFacade<T> {

    private final Class<T> entityClass;
    protected final EntityManager em;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("DonacionesPU");
        
        em = emf.createEntityManager();
    }

    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public void edit(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void remove(T entity) {
        em.getTransaction().begin();
        em.remove(em.merge(entity));
        em.getTransaction().commit();
    }

    public T find(Object id) {
        return em.find(entityClass, id);
    }

    public List<T> findAll() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

}
