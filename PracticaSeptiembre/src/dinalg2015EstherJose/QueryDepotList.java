package dinalg2015EstherJose;

/**
 * Clase QueryDepotList. Implementa QueryDepot para la implementación por listas.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
public class QueryDepotList implements QueryDepot 
{
    public Lista<Query> qDepot;
    Iterador<Query> iter;
    /**
     * Constructor for objects of class QueryDepotList
     */
    public QueryDepotList()
    {
        qDepot = new Lista<Query>();
        iter = qDepot.darIterador();
    }

    /** Devuelve el número de consultas diferentes (sin contar repeticiones) 
     * que hay almacenadas en el depósito
     * @returns el número de consultas diferentes almacenadas */
    public int numQueries () {	
	return qDepot.darLongitud();
        
    }
    
    /** Consulta la frecuencia de una consulta en el depósito
     * @returns la frecuencia de la consulta. Si no está, devolverá 0
     * @param el texto de la consulta */
    public int getFreqQuery (String q) {
	iter = qDepot.darIterador();
	int auxFreq=0;
	while (iter.haySiguiente()){
	    Query aux = iter.darSiguiente();
	    if (aux.getText().compareTo(q) == 0){
		auxFreq = aux.getFreq();
		return auxFreq;
	    }
	}
	iter.reiniciar();
	return auxFreq;        
    }

    /** Dado un prefijo de consulta, devuelve una lista, ordenada por
     * frecuencias de mayor a menor, de todas las consultas almacenadas
     * en el depósito que comiencen por dicho prefijo
     * @returns la lista de consultas ordenada por frecuencias y orden
     * lexicográfico en caso de coincidencia de frecuencia
     * @param el prefijo */
    public Lista<Query> listOfQueries (String prefix) {
	iter = qDepot.darIterador();
	Lista<Query> listQuery = null;
	listQuery = new Lista<Query>();
	while (iter.haySiguiente()){
	    Query aux = iter.darSiguiente();
	    if (aux.getText().startsWith(prefix)){
		listQuery.agregar(aux);
	    }
	}
	iter.reiniciar();
	return listQuery;
    }

    /** Incrementa en uno la frecuencia de una consulta en el depósito
     * Si la consulta no existía en la estructura, la deberá añadir
     * @param el texto de la consulta */
    public void incFreqQuery (String q) {
	iter = qDepot.darIterador();
	if (qDepot.esVacio()){
	    qDepot.agregar(new Query(q));
	    return;
	}else{
	    while (iter.haySiguiente()){
		Query aux = iter.darSiguiente();
		if (aux.getText().compareTo(q)==0){
		    aux.setFreq(aux.getFreq()+1);
		    return;
		}else{
		    qDepot.agregar(new Query(q));
		    return;
		}
	    }
	}
        iter.reiniciar();
    }

    /** Decrementa en uno la frecuencia de una consulta en el depósito
     * Si la frecuencia decrementada resultase ser 0, deberá eliminar
     * la información referente a la consulta del depósito
     * @precondición la consulta debe estar ya en el depósito
     * @param el texto de la consulta */
    public void decFreqQuery (String q) {
	iter = qDepot.darIterador();
        while (iter.haySiguiente()){
            Query aux = iter.darSiguiente();
            if (aux.getText().compareTo(q)==0){
        	aux.setFreq(aux.getFreq()-1);
        	if (aux.getFreq()==0){
        	    qDepot.eliminar(aux);
        	}
            }
        }
        iter.reiniciar();
    }
}
