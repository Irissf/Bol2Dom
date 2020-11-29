import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class Ejercicio9 {
    /**
     * Larry Wachowski ha cambiado su nombre por Lana. Modifica el árbol y
     * almacénalo
     */
    public void ejer9(Document doc, String nombre, String newNombre) {

        String ruta = "resources/peliculas.xml";
        NodeList name = doc.getElementsByTagName("nombre");
        for (int i = 0; i < name.getLength(); i++) {
            if (name.item(i).getFirstChild().getNodeValue().equals(nombre)) {
                name.item(i).getFirstChild().setTextContent(newNombre);
                System.err.println("llego aqui");
                break;
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
