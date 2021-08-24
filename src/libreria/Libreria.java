package libreria;
import java.util.Date;
import java.util.Scanner;
import libreria.servicios.AutorServicio;
import libreria.servicios.ClienteServicio;
import libreria.servicios.EditorialServicio;
import libreria.servicios.LibroServicio;
import libreria.servicios.PrestamoServicio;
/*
 * @author Pablo
 */
public class Libreria {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
        
        // RECORDAR METER TODOS LOS METODOS DENTRO DE TRY CATCH.
        
        AutorServicio as = new AutorServicio();
        ClienteServicio cs = new ClienteServicio();
        EditorialServicio es = new EditorialServicio();
        LibroServicio ls = new LibroServicio();
        PrestamoServicio ps = new PrestamoServicio();
        
        as.crearAutor(1, "Antoine de Saint-Exupéry");
        as.crearAutor(2, "J. R. R. Tolkien");
        as.imprimirAutores();

        es.crearEditorial(1, "Lexus Editores");
        es.crearEditorial(2, "HarperCollins Publishers");
        es.imprimirEditoriales();

        cs.crearCliente(36756387, "Pablo", "Capredoni", "Larrea 424", "2613364201", null);
        cs.crearCliente(36277421, "Flor", "Gomez", "Las Rosas 3350", "2616566357", null);
        cs.imprimirClientes();

        ls.crearLibro(123, "El principito", 1943, 10, 0, as.buscarAutor(1), es.buscarEditorial(1));
        ls.crearLibro(456, "Lord of the Rings", 1949, 5, 0, as.buscarAutor(2), es.buscarEditorial(2));
        ls.imprimirLibros();
        ls.buscarIsbn(456);
        ls.imprimirLibrosTitulo("principito");

        ps.crearPrestamo(1, "2021-08-13", "2021-09-13", ls.buscarIsbn(456));
        ps.crearPrestamo(2, "2021-08-09", "2021-08-11", ls.buscarIsbn(123));
        ps.imprimirPrestamo();

        cs.agregarPrestamo(36756387, 1);
        cs.agregarPrestamo(36277421, 2);
        cs.imprimirClientes();

//        es.cambiarNombre(1, "pepito");
//        es.imprimirEditoriales();
//        es.cambiarNombre(1, "Lexus Editores");
//        es.imprimirEditoriales();


    }

}
