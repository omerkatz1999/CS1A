import java.util.*;
import java.util.Scanner;
import java.lang.Math;

/*


 By Omer Katz

 Class :CS1A

 Date: 02/26/19

 Professor: Harden

 File name: Main.java


This program simulates a slot machine. The method get bet, gets a bet from the user
while checking that it is within 0-50. It then calls the method pull, which calls
the method randString which generates a "bar", "space", "7" or "cherries".
the getPayMultiplier method checks the result and determines how much the
bet will be multiplied by: 0, 5, 15, 30, 50, or 100.
the method display displays the results.

This program uses the previously made class called triple String.

 */


public class Main {
    //percentages
    static final int BAR_PERCENT = 38;
    static final int CHERRIES_PERCENT = 40;
    static final int SPACE_PERCENT = 7;
    static final int SEVEN_PERCENT = 15;

    static final int MAX_BET = 50;
    static final int MIN_BET = 0;

    // winning multiplers
    static final int CHERRY_SLOT_1 = 5;
    static final int CHERRY_SLOT_1_AND_2 = 15;
    static final int ALL_CHERRIES = 30;
    static final int ALL_BARS = 50;
    static final int ALL_SEVENS = 100;

    // Items name
    static final String CHERRY = "cherries";
    static final String BAR = "BAR";
    static final String SEVEN = "7";
    static final String SPACE = "space";


    public static void main(String [] args)
    {

        while(true)
        {
            int bet = getBet();
            if(bet == 0)
            {
                break;
            }

            TripleString pullResult = pull();
            int mult = getPayMultiplier(pullResult);
            int winnings = mult * bet;
            display(pullResult, winnings);
            System.out.println();
        }


        System.out.println("Thanks for coming to Casino KATZ");



    }






    //Gets valid bet amount from user
    public static int getBet()
    {
        Scanner betInput = new Scanner(System.in);

        System.out.println("How much would you like to bet (1 - 50) or 0 to quit?");
        String betString = betInput.nextLine();

        int bet = Integer.parseInt(betString);

        while(bet < MIN_BET || bet > MAX_BET)
        {
            System.out.println("How much would you like to bet (1 - 50) or 0 to quit?");
            betString = betInput.nextLine();
            bet = Integer.parseInt(betString);
        }

        return bet;
    }






    //generates a random string
    public static String randString()
    {
        double rand = Math.random();
        int rand1 = (int)(rand * 100);

        if (rand1 < SPACE_PERCENT)
            return SPACE;
        else if ( rand1 < SPACE_PERCENT + SEVEN_PERCENT)
            return SEVEN;
        else if ( rand1 < SPACE_PERCENT + SEVEN_PERCENT + CHERRIES_PERCENT)
            return CHERRY;
        else
            return BAR;


    }






    //creates an object with 3 random string using randString
    public static TripleString pull()
    {
        TripleString ts1 = new TripleString();
        ts1.setString1(randString());
        ts1.setString2(randString());
        ts1.setString3(randString());
        return ts1;
    }






    //determines the multipier based off the result from pull
    public static int getPayMultiplier (TripleString thePull)
    {
        if (thePull.getString1().equals(CHERRY))
            if (!thePull.getString2().equals(CHERRY))
                return CHERRY_SLOT_1;
            else
                if (!thePull.getString3().equals(CHERRY))
                    return CHERRY_SLOT_1_AND_2;
                else
                    return ALL_CHERRIES;

        if (thePull.getString1().equals(BAR) && thePull.getString2().equals(BAR)
            && thePull.getString3().equals(BAR))
            return ALL_BARS;
        if (thePull.getString1().equals(SEVEN) && thePull.getString2().equals(SEVEN)
                && thePull.getString3().equals(SEVEN))
            return ALL_SEVENS;

        return 0;

    }






    //displays the result
    public static void display (TripleString thePull, int winnings )
    {
        System.out.print("whirrrrrr .... and your pull is ... \n\n");
        System.out.println(thePull.toString());
        if(winnings == 0)
            System.out.println("  sorry - you lost ");
        else
            System.out.println("congrats, you won $" + winnings + ".");

    }

}


class TripleString {

    public static final int MIN_LEN = 1;
    public static final int MAX_LEN = 50;
    public static final String DEFAULT_STRING = " (undefined) ";

    private String String1;
    private String String2;
    private String String3;





    //default constructor
    TripleString()
    {
        String1 = DEFAULT_STRING;
        String2 = DEFAULT_STRING;
        String3 = DEFAULT_STRING;

    }






    //constructor with parameters
    TripleString(String str1, String str2, String str3)
    {
        if(!setString1(str1))
        {
            String1 = DEFAULT_STRING;
        }

        if(!setString2(str2))
        {
            String2 = DEFAULT_STRING;
        }

        if(!setString3(str3))
        {
            String3 = DEFAULT_STRING;
        }

    }







    //sets string 1
    public boolean setString1( String str )
    {
        if(validString(str))
        {
            String1 = str;
            return true;
        }

        return false;

    }





    //sets string 2
    public boolean setString2( String str )
    {
        if(validString(str))
        {
            String2 = str;
            return true;
        }

        return false;

    }





    //sets string 3
    public boolean setString3( String str )
    {
        if(validString(str))
        {
            String3 = str;
            return true;
        }

        return false;

    }





    //gets string1
    public String getString1()
    {
        return String1;
    }




    //gets string2
    public String getString2()
    {
        return String2;
    }




    //gets string3
    public String getString3()
    {
        return String3;
    }





    //helper method, checks string validity
    public boolean validString( String str )
    {
        return str.length() >= MIN_LEN && str.length() <= MAX_LEN;
    }





    //returns to string
    public String toString()
    {
        return String1 +", " + String2 +", " + String3;
    }

}

/*
I got all bars in pull 22, 34, and 42.

I got all cherries in pulls 8, 21, 37.

output:

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, 7, 7
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, BAR, cherries
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, cherries, space
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, cherries, cherries
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, BAR, 7
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, cherries, cherries
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

space, cherries, BAR
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

cherries, cherries, cherries
congrats, you won $30.

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

7, BAR, BAR
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

cherries, space, BAR
congrats, you won $5.

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, cherries, BAR
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

cherries, BAR, cherries
congrats, you won $5.

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, BAR, cherries
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

cherries, 7, space
congrats, you won $5.

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, cherries, space
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

cherries, 7, cherries
congrats, you won $5.

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, cherries, space
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
2
whirrrrrr .... and your pull is ...

cherries, BAR, BAR
congrats, you won $10.

How much would you like to bet (1 - 50) or 0 to quit?
3
whirrrrrr .... and your pull is ...

7, BAR, BAR
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, cherries, BAR
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

cherries, cherries, cherries
congrats, you won $30.

How much would you like to bet (1 - 50) or 0 to quit?
1
whirrrrrr .... and your pull is ...

BAR, BAR, BAR
congrats, you won $50.

How much would you like to bet (1 - 50) or 0 to quit?
23
whirrrrrr .... and your pull is ...

BAR, cherries, BAR
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
24
whirrrrrr .... and your pull is ...

BAR, 7, BAR
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
25
whirrrrrr .... and your pull is ...

cherries, cherries, 7
congrats, you won $375.

How much would you like to bet (1 - 50) or 0 to quit?
26
whirrrrrr .... and your pull is ...

cherries, BAR, 7
congrats, you won $130.

How much would you like to bet (1 - 50) or 0 to quit?
27
whirrrrrr .... and your pull is ...

BAR, space, 7
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
28
whirrrrrr .... and your pull is ...

cherries, cherries, BAR
congrats, you won $420.

How much would you like to bet (1 - 50) or 0 to quit?
29
whirrrrrr .... and your pull is ...

cherries, cherries, BAR
congrats, you won $435.

How much would you like to bet (1 - 50) or 0 to quit?
30
whirrrrrr .... and your pull is ...

cherries, 7, BAR
congrats, you won $150.

How much would you like to bet (1 - 50) or 0 to quit?
31
whirrrrrr .... and your pull is ...

BAR, cherries, cherries
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
32
whirrrrrr .... and your pull is ...

BAR, cherries, cherries
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
33
whirrrrrr .... and your pull is ...

cherries, 7, BAR
congrats, you won $165.

How much would you like to bet (1 - 50) or 0 to quit?
34
whirrrrrr .... and your pull is ...

BAR, BAR, BAR
congrats, you won $1700.

How much would you like to bet (1 - 50) or 0 to quit?
35
whirrrrrr .... and your pull is ...

cherries, BAR, cherries
congrats, you won $175.

How much would you like to bet (1 - 50) or 0 to quit?
36
whirrrrrr .... and your pull is ...

cherries, cherries, BAR
congrats, you won $540.

How much would you like to bet (1 - 50) or 0 to quit?
37
whirrrrrr .... and your pull is ...

cherries, cherries, cherries
congrats, you won $1110.

How much would you like to bet (1 - 50) or 0 to quit?
38
whirrrrrr .... and your pull is ...

BAR, BAR, space
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
39
whirrrrrr .... and your pull is ...

7, BAR, 7
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
40
whirrrrrr .... and your pull is ...

cherries, BAR, 7
congrats, you won $200.

How much would you like to bet (1 - 50) or 0 to quit?
41
whirrrrrr .... and your pull is ...

BAR, cherries, 7
  sorry - you lost

How much would you like to bet (1 - 50) or 0 to quit?
-1
How much would you like to bet (1 - 50) or 0 to quit?
51
How much would you like to bet (1 - 50) or 0 to quit?
42
whirrrrrr .... and your pull is ...

BAR, BAR, BAR
congrats, you won $2100.

How much would you like to bet (1 - 50) or 0 to quit?
0
Thanks for coming to Casino KATZ

Process finished with exit code 0



 */