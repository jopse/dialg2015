package dinalg2015EstherJose;
import java.io.*;
/**
 * Clase Execute. Lanza la aplicación, seleccionando el tipo de implementación.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
public class Execute
{
    public static QueryDepot qDepotInitial;
    public static final int rep = 1;
    
    public static void main(String[] args) throws ExcepArgs
    {
        if (args.length != 3) {
            throw new ExcepArgs ("Los argumentos deben ser 3: estructura consultas operaciones");
        }
        else {
                if (args[0].equals("L")) {
                    qDepotInitial = new QueryDepotList();
                }
                else if (args[0].equals("T")) {
                    qDepotInitial = new QueryDepotTree();
                }
                else {
                    throw new ExcepArgs("El argumento de estructura debe ser L (lista) o T (Arbol)");
                }
                readQueries(args[1]);
                readActions(args[2]);
        }
    }
    
    public static void readQueries(String queriesFile) {
        File archivo = null;
        FileReader entrada = null;
        BufferedReader br = null;
        
        try {
            archivo = new File (queriesFile);
            entrada = new FileReader (archivo);
            br = new BufferedReader(entrada);
            String linea;
            
            while((linea=br.readLine())!=null) {
                qDepotInitial.incFreqQuery(linea);
            }
            int num = qDepotInitial.numQueries();
            System.out.println("Consultas almacenadas: "+num+".");
        }
        catch (Exception e) {
            System.out.println("Archivo de entrada erróneo o no se puede encontrar: "+archivo);
            e.printStackTrace();
        }
        finally {
            try {
                if( entrada != null ){
                    entrada.close();
                }
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
    
    public static void readActions(String actionsFile) {
        File archivo = null;
        FileReader entrada = null;
        BufferedReader br = null;
        
        try {
            archivo = new File (actionsFile);
            entrada = new FileReader (archivo);
            br = new BufferedReader(entrada);
            String linea;
            
            while((linea=br.readLine())!=null) {
                String [] aa0 = linea.split (" ",2);
                int freqQuery = 0;
                if (aa0[0].equals("F")) {
                    long tInicial = System.currentTimeMillis(); // almacena el tiempo inicial
                    for ( int cont = 0 ; cont < rep ; cont++ ) {
                        freqQuery = qDepotInitial.getFreqQuery(aa0[1]);
                    }
                    long tFinal = System.currentTimeMillis(); // almacena el tiempo final
                    double duracion = ((double)tFinal - (double)tInicial) / (double)rep; // duración
                    System.out.println("La frecuencia de "+'"'+aa0[1]+'"'+" es "+freqQuery+'.');
                    System.out.println("-Tiempo: "+duracion);
                }
                else if (aa0[0].equals("S")) {
                    String qqS = "";
                    System.out.print("La lista de sugerencias para "+'"'+aa0[1]+'"'+" es:");
                    long tInicial = System.currentTimeMillis(); // almacena el tiempo inicial
                    for ( int cont = 0 ; cont < rep ; cont++ ) {
                        Lista<Query> qD = qDepotInitial.listOfQueries(aa0[1]);
                        Iterador<Query> it = qD.darIterador();
                        qqS="";
                        while (it.haySiguiente()) {
                            Query qq = it.darSiguiente();
                            String qqSS = "\n  "+'"'+qq.getText()+'"'+" con frecuencia "+
                              qq.getFreq()+".";
                            qqS = qqS.concat(qqSS);
                        }
                    }
                    long tFinal = System.currentTimeMillis(); // almacena el tiempo final
                    double duracion = ((double)tFinal - (double)tInicial) / (double)rep; // duración
                    System.out.println(qqS);
                    System.out.println("-Tiempo: "+duracion);
                }
                else {
                    System.out.println("error");
                }
            }
        }
        catch (Exception e) {
            System.out.println("Archivo de entrada erróneo o no se puede encontrar: "+archivo);
            e.printStackTrace();
        }
        finally {
            try {
                if( entrada != null ){
                    entrada.close();
                }
            }
            catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
