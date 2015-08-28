package dinalg2015;

/**
 * Interfaz TreeIF.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */

public interface TreeIF <T> {

    public int PREORDER = 0;
    public int POSTORDER = 1;
    public int LRBREADTH = 2;
    public int RLBREADTH = 3;
    
    /**
     * Devuelve el elemento raiz del arbol.
     * @return el elemento raiz del arbol
     */
    public T getRoot ();
          
    /**
     * Establece el elemento raiz.
     * @param element El elemento a establecer.
     */
    public void setRoot (T element);
                
    /**
     * Devuelve los hijos de un arbol.
     * @return los hijos de un arbol.
     */
    public ListIF <TreeIF <T>> getChildren();

    /**
     * Inserta un subarbol como ultimo hijo.
     * @param child el hijo a insertar.
     */
    public void addChild (TreeIF<T> child);
    
    /**
     * Extrae un subarbol como hijo.
     * @param index el indice del subarbol con base en 0.
     */
    public void removeChild (int index);
    
    /**
     * Devuelve cierto si el arbol es un nodo hoja.
     * @return cierto si el arbol es un nodo hoja.
     */
    public boolean isLeaf ();
    
    /**
     * Devuelve cierto si el arbol es vacio.
     * @return cierto si el arbol es vacio.
     */
    public boolean isEmpty ();
    
    /**
     * Devuelve cierto si la lista contiene el elemento.
     * @param element El elemento buscado.
     * @return cierto si la lista contiene el elemento.
     */
    public boolean contains (T element);
    
    /**
     * Devuelve un iterador para la lista.
     * @param traversalType El tipo de recorrido.
     * @return un iterador para la lista.
     */
    public IteratorIF<T> getIterator (int traversalType);
    
    public int getLength();

    void insert(T element);

    void delete(T element);
}