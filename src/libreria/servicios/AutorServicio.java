package libreria.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;

/**
 *
 * @author Pablo
 */
public class AutorServicio {

    public void crearAutor (Integer id, String nombre) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Autor autor = new Autor();
        autor.setId(id);
        autor.setNombre(nombre);
        em.persist(autor);
        em.getTransaction().commit();  
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en AutorServicio, crearAutor");
        }
    }
    
    public Autor buscarAutor(Integer id) throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            em.getTransaction().begin();
            Autor autor = em.find(Autor.class, id);
            return autor;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en AutorServicio, buscarAutor");
        }
    }
    
    public void eliminarAutor (Integer id)  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Autor autor = em.find(Autor.class, id);
        em.remove(autor);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en AutorServicio, eliminarAutor");
        }
    }
    
    public void cambiarNombre (Integer id, String nombre)  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Autor autor = em.find(Autor.class, id);
        autor.setNombre(nombre);
        em.merge(autor);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en AutorServicio, cambiarNombre");
        }
    }
    
    public List <Autor> buscarAutoresNombre (String nombre)  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        List <Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre") //"query" pero en "jpql". Usar siempre un alias (a).
                .setParameter("nombre", "%"+nombre+"%").getResultList(); // de esta manera le digo que el "nombre" de la jpql corresponde al parametro nombre.
        return autores;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en AutorServicio, buscarAutoresNombre");
        }
    }
    
    public void imprimirAutoresNombre (String nombre)  throws Exception {
        try {
        List <Autor> autores = buscarAutoresNombre(nombre);
        for (Autor a : autores) {
            System.out.println(a.toString());
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en AutorServicio, imprimirAutoresNombre");
        }
    }
    
    public void imprimirAutores ()  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        List <Autor> autores = em.createQuery("SELECT a FROM Autor a").getResultList();
        for (Autor a : autores) {
            System.out.println(a.toString());
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en AutorServicio, imprimirAutores");
        }
    }
}
