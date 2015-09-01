/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: IndiceFueraDeRangoException.java,v 1.2 2008/10/11 22:07:20 alf-mora Exp $
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

/**
 * Excepci�n que indica que el �ndice pasado como par�metro est� fuera de rango
 */
public class IndiceFueraDeRangoException extends RuntimeException
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Constante para serializaci�n
	 */
	private static final long serialVersionUID = 1L;
	
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

	/**
     * Constructor de la excepci�n
     * @param valor Valor fuera de rango
     */
    public IndiceFueraDeRangoException( int valor )
    {
        super( "�ndice: " + valor );
    }
}
