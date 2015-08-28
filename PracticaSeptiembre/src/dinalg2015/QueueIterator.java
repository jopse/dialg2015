package dinalg2015;

/**
 * Clase QueueIterator. Implementa IteratorIF para las colas.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
class QueueIterator<T> implements IteratorIF<T> {
    
    private QueueIF<T> handler;
    private QueueIF<T> restart;
    
    /**
     * Constructor para QueueIterator.
     * @param handler el manejador de colas.
     */
    public QueueIterator (QueueIF<T> handler) {
        this.handler = handler;
        this.restart = new QueueDynamic<T> (handler);
    }
    
    /**
     * Devuelve el siguiente elemento de la iteracion.
     * @return el siguiente elemento de la iteracion.
     */
    @Override
    public T getNext () {
        T element = handler.getFirst ();
        handler.remove ();
        return element;
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
     * Restablece el iterador para volver iterar.
     */
    @Override public void reset () {
        handler = new QueueDynamic<T> (restart);
    }
}