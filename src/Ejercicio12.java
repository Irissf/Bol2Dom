
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Ejercicio12 {
    String ruta = "resources/empresa.xml";
    Document doc = null;
    public Document ejer12(String nombre, String apellidos, String apodo, double salario, int id)
    {   
  
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            doc = builder.newDocument();
            
            Element compania = doc.createElement("compañía");
            doc.appendChild(compania);

            Element empleado = doc.createElement("empleado");
            empleado.setAttribute("id", Integer.toString(id));
            empleado.appendChild(doc.createTextNode("\n"));

            Element nombreEtiqueta = crearElemento("nombre", nombre);
            empleado.appendChild(nombreEtiqueta);
            empleado.appendChild(doc.createTextNode("\n"));
            
            Element apellidoEtiqueta = crearElemento("apellido", apellidos);
            empleado.appendChild(apellidoEtiqueta);
            empleado.appendChild(doc.createTextNode("\n"));
            
            Element apodoEtiqueta = crearElemento("apodo", apodo);
            empleado.appendChild(apodoEtiqueta);    
            empleado.appendChild(doc.createTextNode("\n"));

            Element salarioEtiqueta = crearElemento("salario", salario);
            empleado.appendChild(salarioEtiqueta);
            
            compania.appendChild(empleado);

        }catch(DOMException e){
            e.getMessage();
        }catch (Exception e) {
            System.out.println("Error generando el árbol DOM: " + e.getMessage());
        }
        return doc;

    }

    public Element crearElemento(String etiqueta, double contenido){
        Element ele = doc.createElement(etiqueta);
        Text textEle = doc.createTextNode(Double.toString(contenido));
        ele.appendChild(textEle);
        return ele;
    }
    public Element crearElemento(String etiqueta, String contenido){
        Element ele = doc.createElement(etiqueta);
        Text textEle = doc.createTextNode(contenido);
        ele.appendChild(textEle);
        return ele;
    }

}

