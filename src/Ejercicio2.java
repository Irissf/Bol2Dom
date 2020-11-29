import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Ejercicio2 {
    public void ejer2(Document doc){
        NodeList titulos = doc.getElementsByTagName("titulo");
        for (int i = 0; i < titulos.getLength();i++) {
            System.out.println(titulos.item(i).getFirstChild().getNodeValue());
        }
    }
}
