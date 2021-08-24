package libreria.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Editorial;

/**
 *
 * @author Pablo
 */
public class EditorialServicio {

    public void crearEditorial (Integer id, String nombre) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Editorial editorial = new Editorial(id, nombre);
        em.persist(editorial);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en EditorialServicio, crearEditorial");
        }
    }
    
    public Editorial buscarEditorial (Integer id) throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Editorial editorial = em.find(Editorial.class, id);
        return editorial;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en EditorialServicio, buscarEditorial");
        }
    }
    
    public void eliminarEditorial (Integer id) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Editorial editorial = em.find(Editorial.class, id);
        em.remove(editorial);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en EditorialServicio, eliminarEditorial");
        }
    }
    
    public void cambiarNombre (Integer id, String nombre) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Editorial editorial = em.find(Editorial.class, id); 
        editorial.setNombre(nombre);
        em.merge(editorial);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en EditorialServicio, cambiarNombre");
        }
    }
    
    public void imprimirEditoriales ()  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        List <Editorial> editoriales = em.createQuery("SELECT a FROM Editorial a").getResultList();
        for (Editorial a : editoriales) {
            System.out.println(a.toString());
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en EditorialServicio, imprimirEditoriales");
        }
    }
}
