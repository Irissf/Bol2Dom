import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio3 {
    public void ejer3(Document doc){
        Node raiz, pelicula,titulo,nombreApellido,atributo;
        NodeList filmoteca, tituloDirector,direcor;
        NamedNodeMap atributos;

        raiz = doc.getFirstChild();
        filmoteca = raiz.getChildNodes();
        for (int i = 0; i < filmoteca.getLength(); i++) {
            pelicula = filmoteca.item(i);
            if (pelicula.getNodeType() == Node.ELEMENT_NODE){
                System.out.println("===============================================");
                tituloDirector = pelicula.getChildNodes();
                for (int j = 0; j < tituloDirector.getLength(); j++) {
                    titulo = tituloDirector.item(j);
                    if (titulo.getNodeName().equals("titulo")) {
                        System.out.println(titulo.getNodeName()+":"+titulo.getFirstChild().getNodeValue());
                    }
                    if (titulo.getNodeType()==Node.ELEMENT_NODE) {
                        direcor = titulo.getChildNodes();
                        for (int j2 = 0; j2 < direcor.getLength(); j2++) {
                            nombreApellido = direcor.item(j2);
                            if (nombreApellido.getNodeType() == Node.ELEMENT_NODE) {
                                if (nombreApellido.getNodeName().equals("apellido")) { 
                                    System.out.println(nombreApellido.getNodeName()+":"+nombreApellido.getFirstChild().getNodeValue());
                                }
                            }
                        }
                    }
                }
            }
        
            if (pelicula.hasAttributes()) {//si tenemos atributos
                atributos = pelicula.getAttributes();
                for (int j = 0; j < atributos.getLength(); j++) {
                    if (atributos.item(j).getNodeName().equals("genero")) {
                        atributo = atributos.item(j);
                        System.out.printf("El %s de la película es: %s\n",atributo.getNodeName(),atributo.getNodeValue());
                    }
                } 
            }
        }
    }
}
