import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio11 {
    /**
     * Crea un método que permita borrar películas por su título
     */
    public void ejer11(Document doc, String titulo) {
        String ruta = "resources/peliculas.xml";
        
        NodeList titulos = doc.getElementsByTagName("titulo");
        Element padre=null;
        
        for (int i = 0; i < titulos.getLength(); i++) {
            if (titulos.item(i).getFirstChild().getNodeValue().equals(titulo)) {
                padre = (Element) titulos.item(i).getParentNode();
                padre.getParentNode().removeChild(padre);
                GrabarDomm gb = new GrabarDomm();
                try {
                    gb.grabarDOM(doc, ruta);
                } catch (Exception e) {
                    e.getMessage();
                }
                break;
            }
        }
        //ni idea de nada de esta basura ¬¬
        //https://examples.javacodegeeks.com/core-java/xml/dom/remove-node-from-dom-document/#:~:text=Remove%20this%20element%20from%20the,to%20normalize%20the%20DOM%20tree.

       
    }

   
}

/**
 *  <pelicula año="1987" genero="acción" idioma="original">
        <titulo>Depredador</titulo>
        <director>
            <nombre>John</nombre>
            <apellido>Tiernan</apellido>
        </director>
    </pelicula>
 */