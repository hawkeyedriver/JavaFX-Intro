package schenk.teach.bindings05;

public class Utility {

public static String encryptCaesar(int key, String plainText){
		
		char[] cipherHold = new char[plainText.length()];
		
		
		//Outer loop over the string of plaintext
	    for (int i=0, j=plainText.length(); i<j; i++)
	    {
	        //Check for alphanumerics to determine immediate print passthrough for non-alpha chars
	        if (Character.isLetter(plainText.charAt(i)))
	        {
	            //define integer to hold offset correction based on ascii table placement of upper and lower chars
	            int asciiOffset = 0;
	            
	            //Set offset correction to shift ascii placement for modulus math in caesar cipher based on upper or lowercase
	            if (Character.isUpperCase(plainText.charAt(i)))
	            {
	                asciiOffset = 65;
	            }
	            else
	            {
	                asciiOffset = 97;
	            }
	            
	            //Calculate offset value then perform caesar shift
	            int temp = plainText.charAt(i) - asciiOffset;
	            int cipher = (temp + key) % 26;
	            
	            //Reset ascii value based on upper or lowercase, then print cipher value
	            cipher = cipher + asciiOffset;
	            cipherHold[i] = (char)cipher;
	        }
	        else
	        {   //Passthrough print for all non-alpha chars
	            cipherHold[i] = plainText.charAt(i);
	        }
	    }
	    
	    return String.valueOf(cipherHold);
		
	}

public static String decryptCaesar(int key, String plainText){
		
		char[] cipherHold = new char[plainText.length()];
		
		
		//Outer loop over the string of plaintext
	    for (int i=0, j=plainText.length(); i<j; i++)
	    {
	        //Check for alphanumerics to determine immediate print passthrough for non-alpha chars
	        if (Character.isLetter(plainText.charAt(i)))
	        {
	            //define integer to hold offset correction based on ascii table placement of upper and lower chars
	            int asciiOffset = 0;
	            
	            //Set offset correction to shift ascii placement for modulus math in caesar cipher based on upper or lowercase
	            if (Character.isUpperCase(plainText.charAt(i)))
	            {
	                asciiOffset = 65;
	            }
	            else
	            {
	                asciiOffset = 97;
	            }
	            
	            //Calculate offset value then perform caesar shift
	            int temp = plainText.charAt(i) - asciiOffset;
	            int cipher = (temp - key+26) % 26;
	            
	            //Reset ascii value based on upper or lowercase, then print cipher value
	            cipher = cipher + asciiOffset;
	            cipherHold[i] = (char)cipher;
	        }
	        else
	        {   //Passthrough print for all non-alpha chars
	            cipherHold[i] = plainText.charAt(i);
	        }
	    }
	    
	    return String.valueOf(cipherHold);
		
	}
	
public static String encryptVigenere(String key, String plainText){
		
		char[] cipherHold = new char[plainText.length()];
		
		int keyLength=key.length();  //used in a couple places
	    
	    //validating all alphabetical status in keyword
	    for (int i=0; i<keyLength; i++)
	    {
	        if (!(Character.isAlphabetic(key.charAt(i))))
	        {
	            System.out.println("Illegal KeyWord");	            
	            return "Bad Keyword. Please use all characters.";
	        }
	    }
	
	    //integer to track position in keyword since we must only "burn" a letter if needed
	    int keyPosIndex = 0;
	    
	    //Outer loop over the string of plaintext
	    for (int i=0, j=plainText.length(); i<j; i++)
	    {
	        //Check for alphanumerics to determine immediate print passthrough for non-alpha chars
	        if (Character.isAlphabetic(plainText.charAt(i)))
	        {
	            //define integer to hold offset correction based on ascii table placement of upper and lower chars
	            int asciiOffset = 0;
	            
	            //Set offset correction to shift ascii placement for modulus math in vignere cipher based on upper or lowercase
	            if (Character.isUpperCase(plainText.charAt(i)))
	            {
	                asciiOffset = 65;
	            }
	            else
	            {
	                asciiOffset = 97;
	            }
	            
	            //Calculate offset value then perform vignere shift
	            int temp = plainText.charAt(i) - asciiOffset;
	            
	            //Modulus calculation of position in the keyword
	            int keyPosition = keyPosIndex%keyLength;
	            
	            //Initialize shift value variable prior to calculation
	            int shiftValue = 0;
	            
	            //Test for case and correct for ascii table placement
	            if (Character.isUpperCase(key.charAt(keyPosition)))             
	            {
	                shiftValue = key.charAt(keyPosition) - 65;
	            }
	            else
	            {
	                shiftValue = key.charAt(keyPosition) - 97;
	            }
	            
	            //Increase index to move through keyword (Only done here, not for non-alpha passthroughs)
	            keyPosIndex++;
	            
	            //Calculate cypher value
	            int cipher = (temp + shiftValue) % 26;
	            
	            //Reset ascii value based on upper or lowercase, then print cipher value
	            cipher = cipher + asciiOffset;
	            cipherHold[i] = (char)cipher;
	        }
	        else
	        {   //Passthrough print for all non-alpha chars.  Note: We do NOT shift through the keyword here.
	        	cipherHold[i] = plainText.charAt(i);
	            
	        }
	    }
		
	    return String.valueOf(cipherHold);
		
	}

public static String decryptVigenere(String key, String plainText){
		
		char[] cipherHold = new char[plainText.length()];
		
		int keyLength=key.length();  //used in a couple places
	    
	    //validating all alphabetical status in keyword
	    for (int i=0; i<keyLength; i++)
	    {
	        if (!(Character.isAlphabetic(key.charAt(i))))
	        {
	            System.out.println("Illegal KeyWord");	            
	            return "Bad Keyword. Please use all characters.";
	        }
	    }
	
	    //integer to track position in keyword since we must only "burn" a letter if needed
	    int keyPosIndex = 0;
	    
	    //Outer loop over the string of plaintext
	    for (int i=0, j=plainText.length(); i<j; i++)
	    {
	        //Check for alphanumerics to determine immediate print passthrough for non-alpha chars
	        if (Character.isAlphabetic(plainText.charAt(i)))
	        {
	            //define integer to hold offset correction based on ascii table placement of upper and lower chars
	            int asciiOffset = 0;
	            
	            //Set offset correction to shift ascii placement for modulus math in vignere cipher based on upper or lowercase
	            if (Character.isUpperCase(plainText.charAt(i)))
	            {
	                asciiOffset = 65;
	            }
	            else
	            {
	                asciiOffset = 97;
	            }
	            
	            //Calculate offset value then perform vignere shift
	            int temp = plainText.charAt(i) - asciiOffset;
	            
	            //Modulus calculation of position in the keyword
	            int keyPosition = keyPosIndex%keyLength;
	            
	            //Initialize shift value variable prior to calculation
	            int shiftValue = 0;
	            
	            //Test for case and correct for ascii table placement
	            if (Character.isUpperCase(key.charAt(keyPosition)))             
	            {
	                shiftValue = key.charAt(keyPosition) - 65;
	            }
	            else
	            {
	                shiftValue = key.charAt(keyPosition) - 97;
	            }
	            
	            //Increase index to move through keyword (Only done here, not for non-alpha passthroughs)
	            keyPosIndex++;
	            
	            //Calculate cypher value
	            int cipher = (temp - shiftValue +26) % 26;
	            
	            //Reset ascii value based on upper or lowercase, then print cipher value
	            cipher = cipher + asciiOffset;
	            cipherHold[i] = (char)cipher;
	        }
	        else
	        {   //Passthrough print for all non-alpha chars.  Note: We do NOT shift through the keyword here.
	        	cipherHold[i] = plainText.charAt(i);
	            
	        }
	    }
		
	    return String.valueOf(cipherHold);
		
	}


}
