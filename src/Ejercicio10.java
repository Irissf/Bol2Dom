import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

public class Ejercicio10 {
    /**
     * Nos hemos enterado que Alfredo Landa ayudo a David Lynch a dirigir Dune.
     * Añádelo como director y almacena esta modificación en nuevo árbol.
     */
    public void ejer10(Document doc, String titulo, String apellidoNuevo, String nombreNuevo) {
        NodeList titulos = doc.getElementsByTagName("titulo");
        String ruta = "resources/peliculas.xml";
        Element Pelicula;
        System.err.println("llego aqui");


        for (int i = 0; i < titulos.getLength(); i++) {
            if (titulos.item(i).getFirstChild().getNodeValue().equals(titulo)) {
                Pelicula = (Element) titulos.item(i).getParentNode();
                Element director = doc.createElement("director");
                Element nombre = doc.createElement("nombre");
                Text nombreTexto = doc.createTextNode(nombreNuevo);
                nombre.appendChild(nombreTexto);
                director.appendChild(nombre);

                Element apellido = doc.createElement("apellido");
                Text apellidoTexto = doc.createTextNode(apellidoNuevo);
                apellido.appendChild(apellidoTexto);
                director.appendChild(apellido);
                Pelicula.appendChild(director);
                System.err.println("llego aqui");
            }
        }
        GrabarDomm gb = new GrabarDomm();
        try {
            gb.grabarDOM(doc, ruta);
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
