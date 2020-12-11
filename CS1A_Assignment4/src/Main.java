/*

 By Omer Katz

 Class :CS1A

 Date: 02/03/19

 Professor: Harden

 File name: Main.java

 This program prints uses a loop to process purchases of frozen yogurt.
 Each time the user buys a yogurt they earn a credit. For every 7 credits that the user earns
 they are elgibile for a free yogurt. Before purchasing a yogurt the client program will
 ask if the user would like to make a purchase or shut down. If the the user decides to purchase
 then he will get the option to get a free yogurt(if eligible) or buy a yogurt and earn more credit.
 The program cycles until the user shuts it down.
  */

import java.util.Scanner;

public class Main {

    static final int CREEDIT_NEEDED = 7;


    public static void main(String[] args) {

        Scanner inputStream = new Scanner(System.in);
        String purchase;
        String freeYogurtAnswer;
        String stringYogurts;
        String userInputString;
        int numberOfYogurts;
        char firstCharacter;

        int creditTracker = 0;

        while(true)
        {

            System.out.print("\nMenu: \n" +
                    "  P (process Purchase)\n" +
                    "  S (Shut down) \n\n" +
                    "  Your Choice: " );
            purchase = inputStream.nextLine();
            firstCharacter = purchase.charAt(0);

            if(firstCharacter == 's' || firstCharacter == 'S')
            {
                break;
            }
            else if(firstCharacter != 'p' && firstCharacter != 'P')
            {
                System.out.println("\n*** Use P or S, please. ***");
                continue;
            }

            if(creditTracker >= CREEDIT_NEEDED)
            {
                System.out.print("\nYou qualify for a free yogurt. Would you like to use your credits? (Y or N) \n");
                freeYogurtAnswer = inputStream.nextLine();
                firstCharacter = freeYogurtAnswer.charAt(0);
                if(firstCharacter == 'y' || firstCharacter == 'Y'  )
                {
                   creditTracker -= 7;
                    System.out.println("\nYou have just used " + CREEDIT_NEEDED +
                            " credits and have " + creditTracker+ " left.\n" +
                            "Enjoy your free yogurt.");
                    continue;
                }
                else if(firstCharacter != 'n' && firstCharacter != 'N')
                {
                    System.out.println("\n*** Invalid response ***");
                    continue;
                }


            }

            System.out.print("\nHow many yogurts would you like to buy? ");

            stringYogurts = inputStream.nextLine();
            numberOfYogurts = Integer.parseInt(stringYogurts);

            if(numberOfYogurts >= 0) {



                creditTracker += numberOfYogurts;

                System.out.println("\nYou just earned " + numberOfYogurts
                        + " stamps and have a total of " + creditTracker + " to use.");
            }
            else{
                System.out.println("\nPlease enter a positive number");
            }


        }

    }

}


/*

run 1:

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

How many yogurts would you like to buy? -1

Please enter a positive number

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: P

How many yogurts would you like to buy? 2

You just earned 2 stamps and have a total of 2 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: Phaiah

How many yogurts would you like to buy? 5

You just earned 5 stamps and have a total of 7 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: k

*** Use P or S, please. ***

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: padnid

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
j

*** Invalid response ***

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
n

How many yogurts would you like to buy? 3

You just earned 3 stamps and have a total of 10 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: pabs

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
y

You have just used 7 credits and have 3 left.
Enjoy your free yogurt.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: P

How many yogurts would you like to buy? 20

You just earned 20 stamps and have a total of 23 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
y

You have just used 7 credits and have 16 left.
Enjoy your free yogurt.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: yodijd

*** Use P or S, please. ***

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
yedbjdb

You have just used 7 credits and have 9 left.
Enjoy your free yogurt.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: s


Run 2:

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: k

*** Use P or S, please. ***

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

How many yogurts would you like to buy? 2

You just earned 2 stamps and have a total of 2 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: P

How many yogurts would you like to buy? 7

You just earned 7 stamps and have a total of 9 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: phdihd

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
yea

You have just used 7 credits and have 2 left.
Enjoy your free yogurt.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: P

How many yogurts would you like to buy? 10

You just earned 10 stamps and have a total of 12 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
nojodjdj

How many yogurts would you like to buy? 0

You just earned 0 stamps and have a total of 12 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
y

You have just used 7 credits and have 5 left.
Enjoy your free yogurt.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

How many yogurts would you like to buy? 100

You just earned 100 stamps and have a total of 105 to use.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: pdn

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
Y

You have just used 7 credits and have 98 left.
Enjoy your free yogurt.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
N

How many yogurts would you like to buy? -1

Please enter a positive number

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: p

You qualify for a free yogurt. Would you like to use your credits? (Y or N)
Yejeh

You have just used 7 credits and have 91 left.
Enjoy your free yogurt.

Menu:
  P (process Purchase)
  S (Shut down)

  Your Choice: S
 */
