package libreria.servicios;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Autor;
import libreria.entidades.Editorial;
import libreria.entidades.Libro;

/**
 *
 * @author Pablo
 */
public class LibroServicio {

    public void crearLibro (Integer isbn, String titulo, Integer año, Integer ejemplares, Integer prestados, Autor autor, Editorial editorial) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = new Libro(isbn, titulo, año, ejemplares, prestados, autor, editorial);
        em.persist(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, crearLibro");
        }
    }
    
    public void eliminarLibro (Integer isbn) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn);
        em.remove(libro);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, eliminarLibro");
        }
    }
    
    public void imprimirLibros ()  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        List <Libro> libros = em.createQuery("SELECT a FROM Libro a").getResultList();
        for (Libro a : libros) {
            System.out.println(a.toString());
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, imprimirLibros");
        }
    }
    
    public void cambiarTitulo (Integer isbn, String titulo) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn); 
        libro.setTitulo(titulo);
        em.merge(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, cambiarTitulo");
        }
    }
    
    public void cambiarAño (Integer isbn, Integer año) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn); 
        libro.setAño(año);
        em.merge(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, cambiarAño");
        }
    }
    
    public void cambiarAutor (Integer isbn, Autor autor) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn); 
        libro.setAutor(autor);
        em.merge(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, cambiarAutor");
        }
    }
    
    public void cambiarEditorial (Integer isbn, Editorial editorial) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn); 
        libro.setEditorial(editorial);
        em.merge(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, cambiarEditorial");
        }
    }
    
    public void cambiarEjemplares (Integer isbn, Integer ejemplares) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn); 
        libro.setEjemplares(ejemplares);
        em.merge(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, cambiarEjemplares");
        }
    }
    
    public void cambiarPrestados (Integer isbn, Integer prestados) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn); 
        libro.setPrestados(prestados);
        em.merge(libro);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, cambiarPrestados");
        }
    }
    
    public List <Libro> buscarLibrosTitulo (String titulo)  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        List <Libro> libros = em.createQuery("SELECT a FROM Libro a WHERE a.titulo LIKE :titulo") //"query" pero en "jpql". Usar siempre un alias (a).
                .setParameter("titulo", "%"+titulo+"%").getResultList(); // de esta manera le digo que el "nombre" de la jpql corresponde al parametro nombre.
        return libros;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, buscarLibroNombre");
        }
    }
    
    public void imprimirLibrosTitulo (String titulo)  throws Exception {
        try {
        List <Libro> libros = buscarLibrosTitulo(titulo);
        for (Libro a : libros) {
            System.out.println(a.toString());
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, imprimirLibrosTitulo");
        }
    }
    
    public void imprimirIsbn (Integer isbn) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn);
        System.out.println(libro.toString());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, buscarIsbn");
        }
    }
    
    public Libro buscarIsbn (Integer isbn) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Libro libro = em.find(Libro.class, isbn);
        return libro;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, buscarIsbn");
        }
    }
}
