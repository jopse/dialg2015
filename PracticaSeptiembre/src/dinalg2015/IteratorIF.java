package dinalg2015;
/**
 * Interfaz Iterator.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */

public interface IteratorIF<T> {
    /**
     * Devuelve el siguiente elemento de la iteracion.
     * @return el siguiente elemento de la iteracion.
     */
    public T getNext ();
    
    /**
     * Indica si hay más elemento en la iteración.
     * @return true si hay más elemento en la iteración
     */
    public boolean hasNext ();
    
    /**
     * Restablece el iterador para volver al inicio.
     */
    public void reset ();
}