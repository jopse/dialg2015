package dinalg2015EstherJose;

/**
 * Clase ComparatorFreq. Implementa ComparatorIF para comparar frecuencias.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
public class ComparatorFreq <T> implements ComparatorIF<Query>
{
    /**
     * Compara dos elementos para indicar si el primero es
     * menor, igual o mayor que el segundo elemento.
     * @param e1 el primer elemento.
     * @param e2 el segundo elemento.
     * @return el orden de los elementos.
     */
    @Override
    public int compare (Query e1, Query e2){
        if (e1.getFreq()<(e2.getFreq()))
            return LESS;
        else if (e1.getFreq() > (e2.getFreq()))
            return GREATER;
        else
            return EQUAL;
    }
    
    /**
     * Indica si un elemento es menor que otro.
     * @param e1 el primer elemento.
     * @param e2 el segundo elemento.
     * @return true si un elemento es menor que otro.
     */
    public boolean isLess (Query e1, Query e2) {
        if (e2.getFreq() < (e1.getFreq()))
            return true;
        else
            return false;
    }
    
    /**
     * Indica si un elemento es igual queotro.
     * @param e1 el primer elemento.
     * @param e2 el segundo elemento.
     * @return true si un elemento es igual que otro.
     */
    public boolean isEqual (Query e1, Query e2) {
        if (e1.getFreq() == (e2.getFreq()))
            return true;
        else
            return false;
    }
    
    /**
     * Indica si un elemento es mayor que otro.
     * @param e1 el primer elemento.
     * @param e2 el segundo elemento.
     * @return true si un elemento es mayor que otro.
     */
    public boolean isGreater (Query e1, Query e2) {
        if (e1.getFreq() > (e2.getFreq()))
            return true;
        else
            return false;
    }
}
