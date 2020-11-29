import org.w3c.dom.Document;

public class MainClass {
    public static void main(String[] args) throws Exception {
        String ruta = "resources/peliculas.xml";
        
        Ejercicio1 ejer1 = new Ejercicio1();
        Document doc = ejer1.creaArbol(ruta);

        // Ejercicio2 ejer2 = new Ejercicio2();
        // ejer2.ejer2(doc);

        //  Ejercicio3 ejer3 = new Ejercicio3();
        //  ejer3.ejer3(doc); 

        //Ejercicio5 ejer5 = new Ejercicio5();
        //ejer5.ejer5(doc, 2);

        // 'Ejercicio6 ejer6 = new Ejercicio6();
        // ejer6.ejer6(doc);

        // Ejercicio7 ejer7 = new Ejercicio7();
        // ejer7.ejer7(doc,"duracion","larga");

        // Ejercicio8 ejer8 = new Ejercicio8();
        // Boolean correcto = ejer8.ejer8(doc, "Depredador" , 1987 , "John", "Tiernan", "acción", "original");
        // if (correcto) {
        //     System.out.println("todo ok");
        // }

        // Ejercicio9 ejer9 = new Ejercicio9();
        // ejer9.ejer9(doc, "Larry", "Lana");

        // Ejercicio10 ejer10 = new Ejercicio10();
        // ejer10.ejer10(doc, "Dune", "Kalaska", "Moka");

        // Ejercicio11 ejer11 = new Ejercicio11();
        // ejer11.ejer11(doc, "Depredador");

        Ejercicio12 ejer12 = new Ejercicio12();
        doc = ejer12.ejer12("iris", "Seijo", "Lider", 2222.2, 1);
        GrabarDomm grabar = new GrabarDomm();
        try {
            grabar.grabarDOM(doc,"resources/Empresa.xml");
        } catch (Exception e) {
            e.getMessage();
        }
        
    }
}
