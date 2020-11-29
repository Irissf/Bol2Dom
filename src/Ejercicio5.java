import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Ejercicio5 {
    public void ejer5(Document doc, int n){
        Node raiz, pelicula,titulo,nombreApellido;
        NodeList filmoteca, tituloDirector,direcor;

        int cont=0;
        String peliculaTitulo="";

        raiz = doc.getFirstChild();
        filmoteca = raiz.getChildNodes();
        for (int i = 0; i < filmoteca.getLength(); i++) {
            pelicula = filmoteca.item(i);
            if (pelicula.getNodeType() == Node.ELEMENT_NODE){
                tituloDirector = pelicula.getChildNodes();
                for (int j = 0; j < tituloDirector.getLength(); j++) {
                    titulo = tituloDirector.item(j);
                    if (titulo.getNodeName().equals("titulo")) {
                        peliculaTitulo = titulo.getFirstChild().getNodeValue();
                    }
                    if (titulo.getNodeType()==Node.ELEMENT_NODE) {
                        direcor = titulo.getChildNodes();
                        for (int j2 = 0; j2 < direcor.getLength(); j2++) {
                            nombreApellido = direcor.item(j2);
                            if (nombreApellido.getNodeType() == Node.ELEMENT_NODE) {
                                if (nombreApellido.getNodeName().equals("apellido")) { 
                                    cont++;
                                }
                            }
                        }
                    }
                }
            }
            if (n == cont) {
                System.out.println(peliculaTitulo+" tiene "+n+" directores");
            }
            cont = 0;
        }
    }
}
