/*

 By Omer Katz

 Class :CS1A

 Date: 02/11/19

 Professor: Harden

 File name: Main.java

 This program contains a total of 5 methods. The first two methods getKey and getString, take in the user input
 and store the designated key and string, while making sure that they are given as specified. The next two methods,
 maskCharacter and removeCharacter make a copy of the string with the character key masked or removed.
 Finaly the method countKey, counts the number of times the Key appears in the string.

 */



import java.util.Scanner;

public class Main {

    static final int MIN_STRING_LENGTH = 4;

    static final int MAX_STRING_LENGTH = 500;

    static final char maskCharacter = '$';


    //main
    public static void main(String[] args)
    {
        Scanner inputStream = new Scanner(System.in);

        String input, maskedString, removedString;

        int count;

        char key;

        key = getKeyCharacter();

        input = getString();

        System.out.println("String with '" + key + "' masked: ");

        System.out.println(maskCharacter(input, key));

        System.out.println("String with '" + key + "' removed: ");

        System.out.println(removeCharacter(input, key));

        System.out.print("# " + key + "s: " );

        System.out.print(countKey(input, key));

    }







    //gets the key and makes sure it is only 1 character long
    public static char getKeyCharacter()
    {
        String key = "";
        char keyChar;
        Scanner inputStream = new Scanner(System.in);

        while(key.length() != 1)
        {
            System.out.print("Please enter a SINGLE character to act as key:");

            key = inputStream.nextLine();

        }

        keyChar = key.charAt(0);

        return keyChar;
    }






    //gets the string and ensures it is between 4 and 500 long
    public static String getString()
    {
        String input = "";

        Scanner inputStream = new Scanner(System.in);

        while(input.length() < MIN_STRING_LENGTH || input.length() > MAX_STRING_LENGTH )
        {
            System.out.print( "Please enter a phrase or sentence >= 4 and <= 500 characters:");

            input = inputStream.nextLine();

        }

        return input;


    }






    //replaces the key with a $
    public static String maskCharacter(String theString, char keyCharacter)
    {

        String copy = "";

        for(int i = 0; i < theString.length(); i++)
        {
            if( theString.charAt(i) == keyCharacter)
            {
                copy += maskCharacter;
            }
            else
            {
                copy += theString.charAt(i);
            }
        }

        return copy;

    }






    //removed all instances of the key
    public static String removeCharacter(String theString, char keyCharacter)
    {
        String copy = "";

        for(int i = 0; i < theString.length(); i++)
        {
            if( theString.charAt(i) != keyCharacter)
            {
                copy += theString.charAt(i);
            }
        }

        return copy;

    }






    //counts the number of times that the key appears
    public static int countKey(String theString, char keyCharacter)
    {
        int count = 0;

        for(int i = 0; i < theString.length(); i++)
        {
            if( theString.charAt(i) == keyCharacter)
            {
                count++;
            }
        }

        return count;
    }
}


/*

run 1:
Please enter a SINGLE character to act as key:a
Please enter a phrase or sentence >= 4 and <= 500 characters:A man walked away
String with 'a' masked:
A m$n w$lked $w$y
String with 'a' removed:
A mn wlked wy
# as: 4

run 2:
Please enter a SINGLE character to act as key:duhasosh
Please enter a SINGLE character to act as key:$2Andi
Please enter a SINGLE character to act as key:p
Please enter a phrase or sentence >= 4 and <= 500 characters:ppo
Please enter a phrase or sentence >= 4 and <= 500 characters:Pinapple pizza is my personal favorite
String with 'p' masked:
Pina$$le $izza is my $ersonal favorite
String with 'p' removed:
Pinale izza is my ersonal favorite
# ps: 4

run 3:

Please enter a SINGLE character to act as key:/
Please enter a phrase or sentence >= 4 and <= 500 characters:ji
Please enter a phrase or sentence >= 4 and <= 500 characters:?nieci////osjdjijd
String with '/' masked:
?nieci$$$$osjdjijd
String with '/' removed:
?nieciosjdjijd
# /s: 4


run 4:
Please enter a SINGLE character to act as key:bacxbswc38720dm@$%(@
Please enter a SINGLE character to act as key:error
Please enter a SINGLE character to act as key:t
Please enter a phrase or sentence >= 4 and <= 500 characters:this is my 4th test run
String with 't' masked:
$his is my 4$h $es$ run
String with 't' removed:
his is my 4h es run
# ts: 4

run 5:
Please enter a SINGLE character to act as key:t
Please enter a phrase or sentence >= 4 and <= 500 characters:tttt
String with 't' masked:
$$$$
String with 't' removed:

# ts: 4
 */