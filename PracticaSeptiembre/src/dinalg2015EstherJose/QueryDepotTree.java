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
    public HashMap<String,Trie<NodoTrie<Query>>> qDepot;
    public int num;
    
    /**
     * Constructor
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public QueryDepotTree() {
	qDepot = new HashMap<String,Trie<NodoTrie<Query>>>();
	String vocabulario = "abcdefghijklmnñopqrstuvwxyz";
	for (int i=0;i<vocabulario.length();i++){
	    qDepot.put(vocabulario.substring(i, i+1), new Trie(new NodoTrie<Query>(vocabulario.charAt(i),new Query(vocabulario.substring(i, i+1))),0));
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
	Trie<NodoTrie<Query>> trieAux = qDepot.get(letterAux);
	NodoTrie<Query> nAux = trieAux.buscar(q);
	Query qAux = nAux.buscar(q);
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
	Trie<NodoTrie<Query>> trieAux = qDepot.get(letterAux);
	Lista<NodoTrie<Query>> listOfNodes = trieAux.buscarPorPrefijo(prefix);
	Lista<Query> listOfQueries = new Lista<Query>();
	for (int i=0;i<listOfNodes.darLongitud();i++){
	    NodoTrie<Query> nAux = listOfNodes.darElemento(i);
	    Query qAux = nAux.darElemento();
	    listOfQueries.agregar(qAux);
	}
	 
	return listOfQueries;
    }

    /** Incrementa en uno la frecuencia de una consulta en el depósito
     * Si la consulta no existía en la estructura, la deberá añadir
     * @param el texto de la consulta
     */
    public void incFreqQuery (String q) {
	String letterAux = q.substring(0,1);
	Trie<NodoTrie<Query>> trieAux = qDepot.get(letterAux);
	NodoTrie<Query> nAux = trieAux.buscar(q);
	//Query qAux = trieAux.buscar(q);
	if (nAux==null){
	    try {
		trieAux.insertar(new NodoTrie<Query>(q.charAt(0),new Query(q)));
	    } catch (ElementoExisteException e) {
		System.out.println("El elemento ya existe");
		e.printStackTrace();
	    } catch (PalabraInvalidaException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}else{
	    trieAux.buscar(q).darElemento().setQueryFreq(nAux.darElemento().getQueryFreq()+1);
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
	Trie<NodoTrie<Query>> trieAux = qDepot.get(letterAux);
	NodoTrie<Query> nAux = trieAux.buscar(q);
	nAux.darElemento().setQueryFreq(nAux.darElemento().getQueryFreq()-1);
	if (nAux.darElemento().getQueryFreq()==0){
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
