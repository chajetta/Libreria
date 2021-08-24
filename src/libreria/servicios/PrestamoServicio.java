package libreria.servicios;

import java.sql.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Libro;
import libreria.entidades.Prestamo;

/**
 *
 * @author Pablo
 */
public class PrestamoServicio {

    public void crearPrestamo (Integer id, String fecha, String devolucion, Libro libro) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Prestamo prestamo = new Prestamo(id, fecha, devolucion, libro);
        em.persist(prestamo);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en PrestamoServicio, crearPrestamo");
        }
    }
    
    public void eliminarPrestamo (Integer id) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Prestamo prestamo = em.find(Prestamo.class, id);
        em.remove(prestamo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en PrestamoServicio, eliminarPrestamo");
        }
    }
    
    public void imprimirPrestamo ()  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        List <Prestamo> prestamos = em.createQuery("SELECT a FROM Prestamo a").getResultList();
        for (Prestamo a : prestamos) {
            System.out.println(a.toString());
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en LibroServicio, imprimirLibros");
        }
    }
    
    public Prestamo buscarPrestamoId (Integer id) throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            em.getTransaction().begin();
            Prestamo prestamo = em.find(Prestamo.class, id);
            return prestamo;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en PrestamoServicio, buscarPrestamo");
        }
    }
}
