
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * Añade la siguiente película "Depredador" dirigida en 1987 por John Tiernan
 * dentro del género acción. Esta en versión original. Almacena este árbol en un
 * fichero XML.
 */

public class Ejercicio8 {
    public boolean ejer8(Document doc, String titulo, int fecha, String nombre, String apellido, String genero,
            String idioma) {
        GrabarDomm gb = new GrabarDomm();
        // String ruta = "resources/peliculas.xml";
        String ruta = "Bol2Dom/resources/peliculas.xml";
        try {

            Element nodoPelicula = doc.createElement("pelicula");

            // los atributos de película
            nodoPelicula.setAttribute("año", Integer.toString(fecha));
            nodoPelicula.setAttribute("genero", genero);
            nodoPelicula.setAttribute("idioma", idioma);

            nodoPelicula.appendChild(doc.createTextNode("\n"));// salto de linea

            // Nodos hijo de pelicula, director y titulo
            // titulo:
            Element nodoTitulo = doc.createElement("titulo");// el nombre del nodo
            Text textNodoTitulo = doc.createTextNode(titulo);// su contenido
            nodoTitulo.appendChild(textNodoTitulo);
            nodoPelicula.appendChild(nodoTitulo);

            nodoPelicula.appendChild(doc.createTextNode("\n"));// salto de linea

            // director:__nombre__apellido
            Element nodoDirector = doc.createElement("director");
            nodoPelicula.appendChild(nodoDirector);
            nodoDirector.appendChild(doc.createTextNode("\n"));

            //nombre
            Element nodoNombre = doc.createElement("nombre");
            Text textNodeNombre = doc.createTextNode(nombre);
            nodoNombre.appendChild(textNodeNombre);
            nodoDirector.appendChild(nodoNombre);

            nodoPelicula.appendChild(doc.createTextNode("\n"));
            
            //apellido
            Element nodoApellido = doc.createElement("apellido");
            Text textNodoApellido = doc.createTextNode(apellido);
            nodoApellido.appendChild(textNodoApellido);
            nodoDirector.appendChild(nodoApellido);

            nodoPelicula.appendChild(doc.createTextNode("\n"));

            Node raiz = doc.getFirstChild();
            raiz.appendChild(nodoPelicula);
            try {
                gb.grabarDOM(doc, ruta);
            } catch (Exception e) {
                e.getMessage();
            }
            return true;
        } catch (DOMException e) {
            return false;
        }
    }
}
