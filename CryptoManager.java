package application;

public class CryptoManager {

    private static final char LOWER_BOUND = ' ';

    private static final char UPPER_BOUND = '_';

    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

    /**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */

    public static boolean stringInBounds(String plainText) {  // String in bound will return true if the string is in bounds

        boolean withInBound = false;     // Declare boolean withInBound and set it to false

        for (int i = 0; i < plainText.length(); i++) // reiterates through each character of string and checks if its within LowerBound and upper bound

        {

            if (plainText.charAt(i) >= LOWER_BOUND && plainText.charAt(i) <= UPPER_BOUND) // if the character at indext I is bewtween Lower_Bound and upper bound the code retriates through the plainText

                withInBound = true;  // WithinBound is set to True if plainText is within the boundary

        }

        return withInBound;  // returns whether withinBound is True or False

    }   //

    /**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */

    public static String encryptCaesar(String plainText, int key)

    {

        String encryptedCaesar = "";  // declare string variable 

        if (stringInBounds(plainText)) // if the stringIsInBound, loops through each character of the string

        {

            for (int i = 0; i < plainText.length(); i++) // loop that will reiterate till i is lesss than plainText

            {

                char currentChar = plainText.charAt(i);   // set thisChar to plainText indext of i

                int encryptedChar = ((int) currentChar + key);  // calculate an encrypted char using key as an integer and 

                while (encryptedChar > UPPER_BOUND) // incriment the value until it reaches upper_Bound

                {

                    encryptedChar -= RANGE;  // once the value reaches upper_bound subtract range the current value to 

                }

                encryptedCaesar += (char) encryptedChar; // appends the new value to the end of the encryptedCaesar and continues to loop through characters until all are done with their calculation

            } // The code will encrypt the String ABC with a key of 3, The output of the code above would be XBC

        }

        return encryptedCaesar;

    }

    /**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */

    public static String encryptBellaso(String plainText, String bellasoStr)

    {
    	//The code then loops through the string of text to encrypt it with the Bellaso algorithm

        String bellasoEncrypted = ""; // create an empty string called bellasoEncrypted.

        int encryptedLength = bellasoStr.length(); //loop through the length of both strings and store their respective lengths in encryptedLength for later use.

        for (int i = 0; i < plainText.length(); i++)

        {
        	// iterate over each character in plainText by using i as a counter variable and charAt() method to get its value from 0-255 (inclusive).
            char currentChar = plainText.charAt(i);

            int charEncrypted = ((int) currentChar + (int) bellasoStr.charAt(i % encryptedLength));
            //calculate what our currentChar would be if it was at position i%encryptedLength which will be equal to RANGE - 1 because there are no more 
            //characters left after this one when you reach UPPER_BOUND.
            //
            while (charEncrypted > (int) UPPER_BOUND)

            {

                charEncrypted -= RANGE;

            }

            bellasoEncrypted += (char) charEncrypted;
            //currentChar will have a value between 0-RANGE - 1 inclusive so we can add them together with + operator before adding them into bellasoEncrypted
           // The code encrypts the string bellasoStr with a key of UPPER_BOUND.
        }

        return bellasoEncrypted; //returns the encrypted string bellasoEncrypted

    }

    /**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */

    public static String decryptCaesar(String encryptedText, int key)

    {


        String decryptedCaesar = "";
        //
        for (int i = 0; i < encryptedText.length(); i++)

        {
        	//The code then iterates through the text, decrypting each character with the corresponding integer from the key

            char current = encryptedText.charAt(i); //uses charAt() on encryptedText to get current character at i .
            //
            int caesarInt = ((int) current - key);

            // The function then iterates through each character of the string and calculates the Caesar Cipher encryption for it.
           // sets up a while loop that will go until caesarInt is less than or equal to LOWER_BOUND .
            while (caesarInt < LOWER_BOUND)

            {
            	//RANGE which will store all integers between 0 and LOWER_BOUND-1 (inclusive).
                caesarInt += RANGE;

            }
            //In each iteration of this loop, it increments caesarInt by 1 , subtracts its value from key , and adds 1 to lower bound .

            decryptedCaesar += (char) caesarInt;

        }

        return decryptedCaesar; // return the decrypted string

    }

    /**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */

    public static String decryptBellaso(String encryptedText, String bellasoStr)

    {

        String bellasoDecrepted = "";     //

        int inputLength = bellasoStr.length(); // inputLength which is used to keep track of how many characters are in the string that will be decrypted.

        //declares an integer variable called inputLength and assigns it with the length of bellasoStr.
        
        for (int i = 0; i < encryptedText.length(); i++)//
        //The loop then begins by storing each character in encryptedText into current, and then subtracting that value from bellasoStr at i % inputLength.

        {

            char current = encryptedText.charAt(i); //used to store the character currently being processed.

            int charDecrepted = ((int) current - (int) bellasoStr.charAt(i % inputLength)); //the code loops through each character in the string until it 
            //finds one that has not been previously seen before (i.e., it's not equal to LOWER_BOUND).
            //
            while (charDecrepted < (int) LOWER_BOUND)
            //increments decryptedCharint by RANGE and stores this value into bellasoDecrepted as well as storing its corresponding character into current.
            {

                charDecrepted += RANGE;

            }

            bellasoDecrepted += (char) charDecrepted;

        }

        return bellasoDecrepted;

    }

}