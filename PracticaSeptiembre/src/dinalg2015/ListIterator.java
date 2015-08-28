package dinalg2015;

/**
 * Clase ListIterator. Implmenenta IteratorIF para listas.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
class ListIterator<T> implements IteratorIF<T>  {
    
    private ListIF<T> handler;
    private ListIF<T> restart;
    
    /**
     * Constructor para ListIterator.
     * @param handler el manejador de listas.
     */
    public ListIterator (ListIF<T>handler) {
        this.handler = handler;
        this.restart = handler;
    }
    
    /** Devuelve el siguiente elemento de la iteracion.
     * @return el siguiente elemento de la iteracion.
     */
    @Override
    public T getNext () {
        T next = handler.getFirst ();
        handler = handler.getTail ();
        return next;
    }
    
    /**
     * Devuelve cierto si existen mas elementos a iterar.
     * @return cierto si existen mas elementos a iterar.
     */
    @Override
    public boolean hasNext () {
        return !handler.isEmpty ();
    }
    
    /**
     * Restablece el iterador para volver al inicio.
     */
    @Override
    public void reset () {
        handler = restart;
    }
    
    /*@Override
    public int hashCode() {
        return hashcode;
    }*/
    
    /*@Override
    public boolean equals (Object o) {
        ...
    }*/
    
    /*@Override
    public String toString () {
        ...
    }*/
}