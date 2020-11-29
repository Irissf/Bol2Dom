
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio6 {
    public void ejer6(Document doc) {
        Node raiz, pelicula, atributo;
        NodeList filmoteca;
        NamedNodeMap atributos;

        ArrayList<String> generos = new ArrayList<>();
        boolean yaEstoy = false;

        raiz = doc.getFirstChild();
        filmoteca = raiz.getChildNodes();
        for (int i = 0; i < filmoteca.getLength(); i++) {
            pelicula = filmoteca.item(i);
            if (pelicula.hasAttributes()) {//si tenemos atributos
                atributos = pelicula.getAttributes();
                for (int j = 0; j < atributos.getLength(); j++) {
                    if (atributos.item(j).getNodeName().equals("genero")) {
                        atributo = atributos.item(j);
                        for (int j2 = 0; j2 < generos.size(); j2++) {
                            if (generos.get(j2).equals(atributo.getNodeValue())) {
                                yaEstoy = true;
                            }
                        }
                        if (yaEstoy == false) {
                            generos.add(atributo.getNodeValue());
                        }
                        yaEstoy= false;
                    }
                } 
            }
            
        }  

        for (String genero : generos) {
            System.out.println("Género: "+genero);
        }

    }
}
