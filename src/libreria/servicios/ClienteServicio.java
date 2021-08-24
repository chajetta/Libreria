package libreria.servicios;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import libreria.entidades.Cliente;
import libreria.entidades.Prestamo;

/**
 *
 * @author Pablo
 */
public class ClienteServicio {

    public void crearCliente (Integer documento, String nombre, String apellido, String domicilio, String telefono, ArrayList<Prestamo> prestamo) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = new Cliente(documento, nombre, apellido, domicilio, telefono);
        em.persist(cliente);
        em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en ClienteServicio, crearCliente");
        }
    }
    
    public void eliminarCliente (Integer documento) throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, documento);
        em.remove(cliente);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en ClienteServicio, eliminarCliente");
        }
    }
    
    public void imprimirClientes ()  throws Exception {
        try {
        EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
        List <Cliente> clientes = em.createQuery("SELECT a FROM Cliente a").getResultList();
        for (Cliente c : clientes) {
            System.out.println(c.toString());
            c.mostrarPrestamos();
        }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en ClienteServicio, imprimirClientes");
        }
    }
    
    public void agregarPrestamo(Integer documento, Integer idPrestamo) throws Exception {
        try {
            PrestamoServicio ps = new PrestamoServicio();
            Cliente cliente = buscarCliente(documento);
            Prestamo pr = ps.buscarPrestamoId(idPrestamo);
            Boolean duplicado = false;
            for (Prestamo p : cliente.getPrestamo()) {
                if (p.getId().equals(idPrestamo)) {
                    duplicado = true;
                    break;
                }
            }
            if (!duplicado) {
                EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
                em.getTransaction().begin();
                System.out.println("en agregar prestamo, Nombre cliente: " + cliente.getNombre());
                System.out.println("en agregar prestamo, Prestamo: " + ps.buscarPrestamoId(idPrestamo).toString());
                cliente.setPrestamo(pr);
                em.merge(cliente);
                em.getTransaction().commit();
            } else {
                System.out.println("El prestamo ya ha sido asignado.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en ClienteServicio, agregarPrestamo");
        }
    }
    
    public Cliente buscarCliente (Integer documento) throws Exception {
        try {
            EntityManager em = Persistence.createEntityManagerFactory("LibreriaPU").createEntityManager();
            em.getTransaction().begin();
            Cliente cliente = em.find(Cliente.class, documento);
            return cliente;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("Error en ClienteServicio, buscarCliente");
        }
    }
}
