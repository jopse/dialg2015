/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: Lista.java,v 1.18 2008/09/30 16:07:00 alf-mora Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Framework: Cupi2Collections
 * Autor: Jorge Villalobos - Abr 13, 2006
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package dinalg2015EstherJose;

import java.io.Serializable;

/**
 * Representa una lista modelada con un arreglo din�mico
 * @param <T> Tipo de datos a almacenar en la lista. Los objetos de tipo T deben tener bien definidos el m�todo <b>equals</b>
 */
public class Lista<T> implements Serializable 
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
	
    /**
	 * Constante para la serializaci�n
	 */
	private static final long serialVersionUID = 1L;	
	
    /**
     * Tama�o inicial del arreglo
     */
    private final static int INIT = 20;

    /**
     * N�mero de posiciones a agregar al crecer el arreglo
     */
    private final static int DELTA = 20;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Elementos de la lista
     */
    protected T[] elems;

    /**
     * N�mero de elementos actualmente en la lista
     */
    protected int numElems;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor por defecto de la lista. El tama�o inicial es de 20<br>
     * <b>post: </b> Se construy� una lista vac�a con tama�o inicial 20.<br>
     */
    public Lista( )
    {
        this( INIT );
    }

    /**
     * Constructor de la lista con la capacidad inicial dada. <br>
     * <b>pre: </b> capacidad!=null, capacidad>0. <br>
     * <b>post: </b> Se construy� la lista con la capacidad inicial especificada.<br>
     * @param capacidad Capacidad inicial para la lista. Entero positivo mayor a cero.<br>
     */
    @SuppressWarnings("unchecked")
    public Lista( int capacidad )
    {
        elems = ( T[] )new Object[capacidad];
        numElems = 0;
    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Devuelve el elemento en la posici�n especificada. <br>
     * <b>post</b>: Se retorn� el elemento en la posici�n especificada.<br>
     * @param pos Posici�n del elemento.<br>
     * @return Elemento en la posici�n especificada. Puede ser null en caso que no exista un elemento en la posici�n dada.<br>
     * @throws IndiceFueraDeRangoException Lanzada cuando la posici�n es menor a cero o mayor al tama�o de la lista menos uno.<br>
     */
    public T darElemento( int pos )
    {
        if( pos < 0 || pos > numElems )
            throw new IndiceFueraDeRangoException( pos );
        return elems[ pos ];
    }

    /**
     * Agrega el elemento al final lista. <br>
     * <b>post: </b> Se agreg� el elemento especificado al final de la lista.<br>
     * Si con la adici�n se excede la capacidad de la lista, la nueva capacidad de la lista es elem.length+DELTA. <br>
     * @param elem Elemento a agregar. Diferente de null.<br>
     */
    @SuppressWarnings("unchecked")
    public void agregar( T elem )
    {
        // Verifica si hay que aumentar el tama�o de la representaci�n
        if( numElems == elems.length )
        {
            T viejo[] = elems;
            elems = ( T[] )new Object[elems.length + DELTA];
            System.arraycopy( viejo, 0, elems, 0, viejo.length );
        }
        elems[ numElems++ ] = elem;
    }

    /**
     * Inserta el elemento en la posici�n especificada. <br>
     * <b>post: </b> Se insert� el elemento en la posici�n especificada desplazando los elementos que se encuentran desde pos una posici�n adelante.<br>
     * Si con la adici�n se excede la capacidad de la lista, la nueva capacidad de la lista es elem.length+DELTA. <br>
     * @param elem Elemento a insertar<br>
     * @param pos Posici�n en la que se va a insertar el elemento<br>
     * @throws IndiceFueraDeRangoException Lanzada cuando la posici�n donde se quiere insertar el elemento es negativa o m�s grande que el tama�o de la lista menos uno.<br>
     */
    @SuppressWarnings("unchecked")
    public void insertar( T elem, int pos )
    {
        if( pos < 0 || pos > numElems )
        {
            throw new IndiceFueraDeRangoException( pos );
        }
        // Verifica si hay que aumentar el tama�o de la representaci�n
        if( numElems == elems.length )
        {
            T viejo[] = elems;
            elems = ( T[] )new Object[elems.length + DELTA];
            System.arraycopy( viejo, 0, elems, 0, viejo.length );
        }
        // Abre espacio para el nuevo elemento
        for( int i = numElems - 1; i >= pos; i-- )
        {
            elems[ i + 1 ] = elems[ i ];
        }
        // Incrementa el n�mero de elementos
        numElems++;
        // Inserta el nuevo elemento
        elems[ pos ] = elem;
    }

    /**
     * Elimina el elemento en la posici�n especificada. <br>
     * <b>post: </b> Se elimin� el elemento en la posici�n especificada desplazando todos los elementos que se encuentran desde pos+1 una posici�n hacia atr�s. <br>
     * @param pos Posici�n del elemento a eliminar.
     * @return Elemento eliminado. En el caso de que no se elimine ning�n elemento se retorna null.
     * @throws IndiceFueraDeRangoException Lanzada cuando la posici�n donde se quiere eliminar el elemento es negativa o m�s grande que el tama�o de la lista menos uno.<br>
     */
    public T eliminar( int pos )
    {
        if( pos < 0 || pos >= numElems )
        {
            throw new IndiceFueraDeRangoException( pos );
        }
        // Saca el elemento a eliminar para ser retornado.
        T resp = elems[ pos ];
        // Desplaza los elementos
        for( int i = pos; i < numElems - 1; i++ )
        {
            elems[ i ] = elems[ i + 1 ];
        }
        // Se vuelve null el �ltimo elemento
        elems[ numElems - 1 ] = null;
        // Se reduce la cantidad de elementos
        numElems--;
        // Se retorna el elemento eliminado
        return resp;
    }

    /**
     * Elimina el elemento especificado de la lista. <br>
     * <b>post: </b> Se elimin� el elemento especificado desplazando todos los elementos que se encuentran despu�s de este elemento una posici�n hacia adelante.<br>
     * Si el elemento no existe se retorna null.<br>
     * @param elem Elemento a eliminar. Diferente de null<br>
     * @return Elemento eliminado o null si el elemento no existe.<br>
     */
    public T eliminar( T elem )
    {
        int pos = 0;
        // Se busca la posici�n del elemento a eliminar
        for( ; pos < numElems && !elem.equals( elems[ pos ] ); pos++ )
            ;

        T eliminado = null;
        // Si se encuentra la posici�n y es menor que la cantidad de elementos se llama el m�todo eliminar por posici�n
        if( pos < numElems )
            eliminado = eliminar( pos );
        // Se retorna el elemento eliminado o null en caso que no exista
        return eliminado;
    }

    /**
     * Busca el elemento especificado. <br>
     * <b>post:</b> Se retorn� la posici�n del elemento buscado dentro de la lista o -1 si no existe. <br>
     * @param elem Elemento a buscar. Diferente de null.<br>
     * @return Posici�n del elemento buscado dentro de la lista o -1 si no existe.<br>
     */
    public int buscar( T elem )
    {
        int pos = 0;
        for( ; pos < numElems && !elem.equals( elems[ pos ] ); pos++ )
            ;
        return pos == numElems ? -1 : pos;
    }

    /**
     * Devuelve la longitud de la lista. <br>
     * <b>post:</b> Se retorn� la longitud de la lista (n�mero de elementos).
     * @return Longitud de la lista. Entero mayor a cero o cero.
     */
    public int darLongitud( )
    {
        return numElems;
    }

    /**
     * Asigna a la posici�n especificada al elemento dado, reemplazando el elemento que se encuentra en esa posici�n <br>
     * <b>post:</b> El nuevo elemento en la posici�n pos es elem.<br>
     * @param elem Elemento a asignar<br>
     * @param pos Posici�n en la que se va a realizar la asignaci�n<br>
     * @throws IndiceFueraDeRangoException Lanzada cuando la posici�n donde se quiere asignar el elemento es menor a cero o igual a la cantidad de elementos de la lista.
     *         Tambi�n es lanzada cuando la lista no tiene posiciones.<br>
     */
    public void asignar( T elem, int pos )
    {
        if( pos < 0 || pos > numElems || numElems == 0 )
            throw new IndiceFueraDeRangoException( pos );
        elems[ pos ] = elem;
    }

    /**
     * Devuelve un iterador con los elementos de la lista. <br>
     * <b>post:</b> Se retorn� iterador con los elementos de la lista.<br>
     * @return Iterador con los elementos de la lista, puede ser vac�o pero no null.<br>
     */
    public Iterador<T> darIterador( )
    {
        IteradorSimple<T> respuesta = new IteradorSimple<T>( numElems );
        for( int i = 0; i < numElems; i++ )
        {
            try
            {
                respuesta.agregar( elems[ i ] );
            }
            catch( IteradorException e )
            {
                // Nunca deber�a ocurrir esta excepci�n
            }
        }
        return respuesta;
    }

    /**
     * Vac�a la lista.<br>
     * <b>post:</b> La lista se encuentra vac�a y la cantidad de elementos es cero.<br>
     */
    public void vaciar( )
    {
        // Se borran las referencias a los objetos presentes en la lista, para permitir el adecuado
        // trabajo del recolector de basura
        for( int i = 0; i < numElems; i++ )
            elems[ i ] = null;
        numElems = 0;
    }

    /**
     * Eval�a si el elemento dado se encuentra o no en la lista<br>
     * <b>post:</b> Se retorn� true en caso que el elemento buscado se encuentre en la lista, false de lo contrario. <br>
     * @param elem Elemento a buscar. Diferente de null.<br>
     * @return True en caso que el elemento buscado se encuentre en la lista, false de lo contrario.<br>
     */
    public boolean contiene( T elem )
    {
        return buscar( elem ) != -1;
    }

    /**
     * Eval�a si la lista es vac�a.
     * @return True en caso que la lista no tenga elementos, false de lo contrario.
     */
    public boolean esVacio( )
    {
        return darLongitud( ) == 0;
    }

    /**
     * Convierte la lista a un String. <br>
     * <b>post: </b> Se retorn� la representaci�n en String de la lista.<br>
     * El String tiene el formato "[numeroElementos]: e1-e2-e3..-en", donde e1, e2, ..., en son los elementos que contiene la lista y numeroElementos su longitud.<br>
     * @return La representaci�n en String de la lista
     */
    @Override
    public String toString( )
    {
        String resp = "[" + numElems + "]:";
        for( int i = 0; i < numElems; i++ )
        {
            resp += elems[ i ] + "-";
        }
        return resp;
    }
}