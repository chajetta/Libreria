package libreria.entidades;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Pablo
 */

@Entity
public class Cliente {
    
    @Id
    private Integer documento;
    private String nombre;
    private String apellido;
    private String domicilio;
    private String telefono;
    @OneToMany
    private List <Prestamo> prestamo;

    public Cliente() {
    }

    public Cliente(Integer documento, String nombre, String apellido, String domicilio, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.prestamo = new ArrayList<>();
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Prestamo> getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo.add(prestamo);
    }

    @Override
    public String toString() {
        return "Cliente{" + "documento=" + documento + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", telefono=" + telefono + ", prestamo=" + prestamo + '}';
    }
    
    public void mostrarPrestamos () {
        for (Prestamo p : prestamo) {
            System.out.println("Id: "+p.getId()+" Libro: "+p.getLibro()+", desde "+p.getFecha()+" - hasta "+p.getDevolucion()+".");
        }
    }

    
    
    

}
