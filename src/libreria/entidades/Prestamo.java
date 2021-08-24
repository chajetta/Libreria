package libreria.entidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Pablo
 */

@Entity
public class Prestamo {

    @Id
    private Integer id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Temporal(TemporalType.DATE)
    private Date devolucion;
    @OneToOne
    private Libro libro;

    public Prestamo() {
    }

    public Prestamo(Integer id, String fecha, String devolucion, Libro libro) throws ParseException {
        this.id = id;
        setFecha(fecha);
        setDevolucion(devolucion);
        this.libro = libro;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date Dfecha = sdf.parse(fecha);
        this.fecha = Dfecha;
    }

    public Date getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date Ddevolucion = sdf.parse(devolucion);
        this.devolucion = Ddevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    @Override
    public String toString() {
        return "Prestamo{" + "id=" + id + ", fecha=" + fecha + ", devolucion=" + devolucion + ", libro=" + libro + '}';
    }

    
    
}
