package dinalg2015;

/**
 * Clase que crea una excepción nueva.
 * Esta excepción se lanza cuando el formato del archivo de entrada no es correcto.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
public class ExcepArgs extends Exception
{
    /**
     * Constructor.
     * Crea la excepción.
     * 
     * @Param   message: El mensaje a mostrar al capturar la ocurrencia de la excepción.
     */
    public ExcepArgs(String message)
    {
        super(message);
    }
}
