package dinalg2015;
/**
 * Clase Query, de los elementos a guardar en QueryDepot.
 * 
 * @author (Alonso Luján Torres Taño) 
 * @version (V.1 09/04/2015)
 */
public class Query {

    protected static String queryText;
    protected static int queryFreq;
    
    /** Construye una nueva query con el texto pasado como parámetro */
    public Query (String text) {
        this.setQueryText(text);
        this.setQueryFreq(1);
    }
    
    /** Modifica la frecuencia de la query */
    public void setFreq(int freq) {
        this.setQueryFreq(freq);
    }
    
    /** Devuelve el texto de una query */
    public String getText() {
	return getQueryText();
        
    }
    
    /** Devuelve la frecuencia de una query */
    public int getFreq() {
	return getQueryFreq();
        
    }

    /**
     * @return the queryText
     */
    public String getQueryText() {
	return queryText;
    }

    /**
     * @param queryText the queryText to set
     */
    public void setQueryText(String queryText) {
	this.queryText = queryText;
    }

    /**
     * @return the queryFreq
     */
    public int getQueryFreq() {
	return queryFreq;
    }

    /**
     * @param queryFreq the queryFreq to set
     */
    public void setQueryFreq(int queryFreq) {
	this.queryFreq = queryFreq;
    }
}