package dinalg2015;

/**
 * Interfaz QueueIF.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */

public interface QueueIF <T> {
    
    /**
     * Devuelve la cabeza de la cola.
     * @return la cabeza de la cola.
     */
    public T getFirst ();
    
    /**
     * Inserta un nuevo elemento a la cola.
     * @param element El elemento a añadir.
     * @return la cola incluyendo el elemento.
     */
    public QueueIF<T> add (T element);
    
    /**
     * Borra la cabeza de la cola.
     * @return la cola excluyendo la cabeza.
     */
    public QueueIF<T> remove();
    
    /**
     * Devuelve cierto si la cola esta vacia.
     * @return cierto si la cola esta vacia.
     */
    public boolean isEmpty ();
    
    /**
     * Devuelve cierto si la cola esta llena.
     * @return cierto si la cola esta llena.
     */
    public boolean isFull ();
    
    /** Devuelve el numero de elementos de la cola.
     * @return el numero de elementos de la cola.
     */
    public int getLength ();
    
    /**
     * Devuelve cierto si la cola contiene el elemento.
     * @param element El elemento buscado.
     * @return cierto si la cola contiene el elemento.
     */
    public boolean contains (T element);
    
    /**
     * Devuelve un iterador para la cola.
     * @return un iterador para la cola.
     */
    public IteratorIF<T> getIterator ();
}