package calc;

import java.util.ArrayList;

public class Driver 
{
	public static void main(String args[])
	{
		ArrayList listOfEnteredValues = new ArrayList();
		CalcGui calc = new CalcGui();
		
		
	}
	
    /*
     * Check to see if the string is an integer.
     * @param s The String to check
     * @returns True if integer, false if not.
     * 
     */
    public static boolean isInteger(String s) {
        try { 
            Integer.parseInt(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }

        return true;
    }
    
    /*
     * Check to see if the string is a double.
     * @param s The String to check
     * @returns True if integer, false if not.
     * 
     */
    public static boolean isDouble(String s) {
        try { 
            Double.parseDouble(s); 
        } catch(NumberFormatException e) { 
            return false; 
        }

        return true;
    }
	
}
