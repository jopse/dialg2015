/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PalabraInvalidaException.java,v 1.3 2008/09/30 16:06:59 alf-mora Exp $
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Framework: Cupi2Collections
 * Autor: Manuel Mu�oz - May 16, 2007
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package dinalg2015EstherJose;

/**
 * Excepci�n que informa que la palabra a eliminar o adicionar es inv�lida
 */
public class PalabraInvalidaException extends Exception
{
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
	 * Constante para la serializaci�n
	 */
	private static final long serialVersionUID = 1L;
	
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    /**
     * Constructor con mensaje
     * 
     * @param mensaje Mensaje de error
     */
    public PalabraInvalidaException( String mensaje )
    {
        super( mensaje );
    }
}
