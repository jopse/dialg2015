package dinalg2015;

/**
 * Clase QueryDepotList. Implementa QueryDepot para la implementación por listas.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
public class QueryDepotList implements QueryDepot 
{
    public ListIF<Query> qDepot;
    IteratorIF<Query> iter;
    /**
     * Constructor for objects of class QueryDepotList
     */
    public QueryDepotList()
    {
        qDepot = new ListDynamic<Query>();
        iter = qDepot.getIterator();
    }

    /** Devuelve el número de consultas diferentes (sin contar repeticiones) 
     * que hay almacenadas en el depósito
     * @returns el número de consultas diferentes almacenadas */
    public int numQueries () {	
	return qDepot.getLength();
        
    }
    
    /** Consulta la frecuencia de una consulta en el depósito
     * @returns la frecuencia de la consulta. Si no está, devolverá 0
     * @param el texto de la consulta */
    public int getFreqQuery (String q) {
	int auxFreq=0;
	while (iter.hasNext()){
	    Query aux = iter.getNext();
	    if (aux.getText().compareTo(q)==0){
		auxFreq = aux.getFreq();
		return auxFreq;
	    }
	}
	iter.reset();
	return auxFreq;        
    }

    /** Dado un prefijo de consulta, devuelve una lista, ordenada por
     * frecuencias de mayor a menor, de todas las consultas almacenadas
     * en el depósito que comiencen por dicho prefijo
     * @returns la lista de consultas ordenada por frecuencias y orden
     * lexicográfico en caso de coincidencia de frecuencia
     * @param el prefijo */
    public ListIF<Query> listOfQueries (String prefix) {
	ListIF<Query> listQuery = null;
	listQuery = new ListDynamic<Query>();
	while (iter.hasNext()){
	    Query aux = iter.getNext();
	    if (aux.getText().startsWith(prefix)){
		listQuery.insert(aux);
	    }
	}
	ComparatorIF<Query> comparator = new ComparatorQuery<Query>();
	listQuery.sort(comparator);
	iter.reset();
	return listQuery;
    }

    /** Incrementa en uno la frecuencia de una consulta en el depósito
     * Si la consulta no existía en la estructura, la deberá añadir
     * @param el texto de la consulta */
    public void incFreqQuery (String q) {
        while (iter.hasNext()){
            Query aux = iter.getNext();
            if (aux.getText().compareTo(q)==0){
        	aux.setFreq(aux.getFreq()+1);
            }else{
        	qDepot.insert(new Query(q));
            }
        }
        iter.reset();
    }

    /** Decrementa en uno la frecuencia de una consulta en el depósito
     * Si la frecuencia decrementada resultase ser 0, deberá eliminar
     * la información referente a la consulta del depósito
     * @precondición la consulta debe estar ya en el depósito
     * @param el texto de la consulta */
    public void decFreqQuery (String q) {
        while (iter.hasNext()){
            Query aux = iter.getNext();
            if (aux.getText().compareTo(q)==0){
        	aux.setFreq(aux.getFreq()-1);
        	if (aux.getFreq()==0){
        	    qDepot.delete(aux);
        	}
            }
        }
        iter.reset();
    }
}
