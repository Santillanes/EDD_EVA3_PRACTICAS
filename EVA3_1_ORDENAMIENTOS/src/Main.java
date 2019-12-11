
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Luis Santillanes
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        int[] arre = new int[20];
        
        long ini, fin;
        
        //SELECTION SORT
        llenar(arre);
        imprimir(arre);
        ini = System.nanoTime();
        selectionSort(arre);
        fin = System.nanoTime();
        imprimir(arre);
        System.out.println("Tiempo = "+(fin-ini));
        /*
        //insertionSort
        llenar(arre);
        imprimir(arre);
        ini = System.nanoTime();
        insertionSort(arre);
        fin = System.nanoTime();
        imprimir(arre);
        System.out.println("Tiempo = "+(fin-ini));
        
        //bubbleSort
        llenar(arre);
        imprimir(arre);
        ini = System.nanoTime();
        bubbleSort(arre);
        fin = System.nanoTime();
        imprimir(arre);
        System.out.println("Tiempo = "+(fin-ini));
        /*
        //quickSort
        llenar(arre);
        imprimir(arre);
        quickSort(arre);
        imprimir(arre);
        */
        //busquedaBinaria
        Scanner sc = new Scanner(System.in);
        System.out.println("Qué valor desea buscar?");
        int val = sc.nextInt();
        System.out.println("Posición: "+busqueda(arre, val));
        
    }
    
    
    public static void llenar(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            arreglo[i] = (int)(Math.random()*100);
        }
    }
    public static void imprimir(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print("["+arreglo[i]+"]");
        }
        System.out.println("");
    }
    
    public static void selectionSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = i+1; j < arreglo.length; j++) {
                if(arreglo[j]<arreglo[i]){
                    int a = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = a;
                }
            }
        }
    }
    
    public static void insertionSort (int[] arreglo){
        for (int i = 1; i < arreglo.length; i++) {
            int iTemp = arreglo[i];
            int insP;
            for (insP = i; insP > 0; insP--) {
                int iPrev = insP - 1;
                if (arreglo[iPrev] > iTemp) {
                    //SWAP
                    arreglo[insP] = arreglo[iPrev];
                }else{
                    break;
                }
            }
            arreglo[insP] = iTemp;
        }
    }
    
    
    public static void bubbleSort(int[] arreglo){
        for (int i = 0; i < arreglo.length; i++) {
            for (int j = 0; j < arreglo.length-1; j++) {
                if (arreglo[j] > arreglo[j+1]) {
                    int iTemp = arreglo[j];
                    arreglo[j] = arreglo[j+1];
                    arreglo[j+1] = iTemp;
                }
            }
        }
    }
    
    public static void quickSort(int[] arreglo){
        quickSortRec(arreglo, 0, arreglo.length-1);
    }
    private static void quickSortRec(int[] arreglo, int ini, int fin){
        if((ini < fin) && (ini >= 0) && (fin < arreglo.length)){//DETENERNOS
            int iPiv = ini;
            int too_big = ini+1;
            int too_small = fin;
            int iTemp;
            while(too_big < too_small){
                while((too_big < fin) && (arreglo[too_big] < arreglo[iPiv]))
                    too_big++;
                while((too_small > (ini+1)) && (arreglo[too_small] > arreglo[iPiv]))
                    too_small--;

                if(too_big < too_small){//NO SE HAN CRUZADO
                    iTemp = arreglo[too_big];
                    arreglo[too_big] = arreglo[too_small];
                    arreglo[too_small] = iTemp;
                }
            }
            //SWAP EL PIVOTE}
            System.out.println("too_big = " + too_big);
            System.out.println("too_small = " + too_small);
            iTemp = arreglo[iPiv];
            arreglo[iPiv] = arreglo[too_small];
            arreglo[too_small] = iTemp;

            quickSortRec(arreglo, ini, (too_small-1));//IZQ
            quickSortRec(arreglo, (too_small+1), fin);//DER
        }
    }
    public static int busqueda(int[] arreglo, int val){
        return busquedaBinRec(arreglo, val, 0, (arreglo.length-1));
    }
    private static int busquedaBinRec(int[] arreglo, int val, int ini, int fin){
        if(ini <= fin){
            int mid = ini + ((fin - ini)/2);
            if (val == arreglo[mid]) {
                return mid;
            }else if (val > arreglo[mid]) {//MAYOR
                return busquedaBinRec(arreglo, val, mid+1, fin);
            }else{//MENOR
                return busquedaBinRec(arreglo, val, ini, mid-1);
            }
        }else{
            return -1;
        }
    }
    
    
    
}
