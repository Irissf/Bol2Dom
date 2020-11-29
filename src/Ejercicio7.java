
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;


/**
 * Ejercicio7
 */
public class Ejercicio7 {

    //String ruta = "resources/peliculas.xml";
    String ruta = "Bol2Dom/resources/peliculas.xml";

    String peliculaTitulo = "Fargo";
    Element padrePelicula;
    NamedNodeMap atributos;
    boolean noestaAtributo = true;
    GrabarDomm gb = new GrabarDomm();

    public void ejer7(Document doc, String atributoName, String parametroAtributo) {
        // voy a suponer que puede haber varias pelis con el mismo nombre
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            if (titulos.item(i).getFirstChild().getNodeValue().equals(peliculaTitulo))

            {
                padrePelicula = (Element) titulos.item(i).getParentNode();
                if (padrePelicula.hasAttributes()) {
                    atributos = padrePelicula.getAttributes();
                    for (int j = 0; j < atributos.getLength(); j++) {
                        if (atributos.item(j).getNodeName().equals(atributoName)) {
                            System.err.println("entro aqui");
                            noestaAtributo = false;
                        }
                    }

                }
                if (noestaAtributo) {
                    System.err.printf("%s:%s", atributoName, parametroAtributo);
                    padrePelicula.setAttribute(atributoName, parametroAtributo);
                }
            }
        }
        try {
            gb.grabarDOM(doc, ruta);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void ejer7b(Document doc, String atributo) {
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength(); i++) {
            if (titulos.item(i).getFirstChild().getNodeValue().equals(peliculaTitulo))
                ;
            {
                padrePelicula = (Element) titulos.item(i).getParentNode();
                if (padrePelicula.hasAttributes()) {
                    atributos = padrePelicula.getAttributes();
                    for (int j = 0; j < atributos.getLength(); j++) {
                        if (atributos.item(j).getNodeName().equals(atributo)) {
                            padrePelicula.removeAttribute(atributo);
                        }
                    }

                }
            }
        }
        try {
            gb.grabarDOM(doc, ruta);
        } catch (Exception e) {
            e.getMessage();
        }
    }

  
}