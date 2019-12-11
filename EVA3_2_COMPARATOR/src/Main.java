
import java.util.Comparator;
import java.util.LinkedList;

/**
 *
 * @author Luis Santillanes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList<Integer> miLista = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            miLista.add((int)(Math.random()*10));
        }
        System.out.println("miLista = " + miLista);
        Comparator comp = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                int resu;
                Integer val1, val2;
                val1 = (Integer)o1;
                val2 = (Integer)o2;
                //CERO --> Igual
                //POSITIVO --> Mayor
                //NEGATIVO --> Menor
                resu = val1-val2;
                return resu;
            }
            
        };
        miLista.sort(comp);
        System.out.println("miLista = " + miLista);
    
        //ORDENAMOS UNA LISTA DE STRING
        LinkedList<String> listaStr = new LinkedList<>();
        listaStr.add("HOLA");
        listaStr.add(" ");
        listaStr.add("MUNDO");
        listaStr.add(" ");
        listaStr.add("CRUEL");
        listaStr.add("!!!");
        Comparator cmpStr = new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                String cade1 = (String)o1;
                String cade2 = (String)o2;
                char c1 = cade1.charAt(0);
                char c2 = cade2.charAt(0);
                return c1-c2;
            }
        };
        System.out.println(listaStr);
        listaStr.sort(cmpStr);
        System.out.println(listaStr);
        
        
    }
    
}
