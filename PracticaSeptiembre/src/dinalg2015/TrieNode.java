package dinalg2015;

import java.util.LinkedList;

public class TrieNode extends Query
{ 
    private boolean isEnd; 
    private LinkedList<Query> childList; 
 
    /* Constructor */
    public TrieNode(String c)
    {
	super(queryText);
        childList = new LinkedList<Query>();
        isEnd = false;
    }  
    
    public Query subNode(String c)
    {
        if (childList != null)
            for (Query eachChild : childList)
                if (eachChild.getQueryText() == c)
                    return eachChild;
        return null;
    }
    
    public int getNumChild(){
	return childList.size();
    }
}