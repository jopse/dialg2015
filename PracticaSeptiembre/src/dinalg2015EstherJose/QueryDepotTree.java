package dinalg2015EstherJose;

import java.util.HashMap;

/**
 * Clase QueryDepotTree. Implementa QueryDepot para la implementación por árboles.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
public class QueryDepotTree implements QueryDepot 
{
    public HashMap<String,Trie<Query>> qDepot;
    public int num;
    
    /**
     * Constructor
     */
    public QueryDepotTree() {
	String vocabulario = "abcdefghijklmnñopqrstuvwxyz";
	for (int i=0;i<vocabulario.length();i++){
	    qDepot.put(vocabulario.substring(i, i), new Trie<Query>(new NodoTrie<Query>(vocabulario.charAt(i),null),0));
	}
    }

    /** Devuelve el número de consultas diferentes (sin contar repeticiones) 
     * que hay almacenadas en el depósito
     * @returns el número de consultas diferentes almacenadas
     */
    public int numQueries() {
	return num;
    }
    
    /** Consulta la frecuencia de una consulta en el depósito
     * @returns la frecuencia de la consulta. Si no está, devolverá 0
     * @param el texto de la consulta
     */
    public int getFreqQuery (String q) {
	String letterAux = q.substring(0,0);
	Trie<Query> trieAux = qDepot.get(letterAux);
	Query qAux = trieAux.buscar(q);
	if (qAux == null){
		return 0;
	}
	return qAux.getFreq();
    }

    /** Dado un prefijo de consulta, devuelve una lista, ordenada por
     * frecuencias de mayor a menor, de todas las consultas almacenadas
     * en el depósito que comiencen por dicho prefijo
     * @returns la lista de consultas ordenada por frecuencias y orden
     * lexicográfico en caso de coincidencia de frecuencia
     * @param el prefijo
     */
    public Lista<Query> listOfQueries (String prefix) {
	String letterAux = prefix.substring(0,0);
	Trie<Query> trieAux = qDepot.get(letterAux);
	Lista<Query> listOfQueries = trieAux.buscarPorPrefijo(prefix);
	return listOfQueries;
    }

    /** Incrementa en uno la frecuencia de una consulta en el depósito
     * Si la consulta no existía en la estructura, la deberá añadir
     * @param el texto de la consulta
     */
    public void incFreqQuery (String q) {
	String letterAux = q.substring(0,0);
	Trie<Query> trieAux = qDepot.get(letterAux);
	Query qAux = trieAux.buscar(q);
	if (qAux==null){
	    try {
		trieAux.insertar(new Query(q));
	    } catch (ElementoExisteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (PalabraInvalidaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}else{
	    trieAux.buscar(q).setQueryFreq(qAux.getQueryFreq()+1);
	}
    }

    /** Decrementa en uno la frecuencia de una consulta en el depósito
     * Si la frecuencia decrementada resultase ser 0, deberá eliminar
     * la información referente a la consulta del depósito
     * @precondición la consulta debe estar ya en el depósito
     * @param el texto de la consulta
     */
    public void decFreqQuery (String q) {
	String letterAux = q.substring(0,0);
	Trie<Query> trieAux = qDepot.get(letterAux);
	Query qAux = trieAux.buscar(q);
	qAux.setQueryFreq(qAux.getQueryFreq()-1);
	trieAux.buscar(q).setQueryFreq(qAux.getQueryFreq());
	if (qAux.getQueryFreq()==0){
	    try {
		trieAux.eliminar(q);
	    } catch (ElementoNoExisteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    } catch (PalabraInvalidaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	
    }
}
