package OODCwk; 
import java.io.*;
/**
 * Enumeration class ForceState 
 * 
 * @author A.Marczyk
 * @version 02/11/2019
 */
public enum ForceState implements Serializable 
{
    DOCKED("Docked"), ACTIVE("Active"), DESTROYED("Destroyed");
    private String state;
    
    private ForceState(String st)
    {
        state = st;
    }
    
    public String toString()
    {
        return state;
    }
}
