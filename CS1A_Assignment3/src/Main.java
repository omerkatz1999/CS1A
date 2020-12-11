
/*

 By Omer Katz

 Class :CS1A

 Date: 01/27/19

 Professor: Harden

 File name: Main.java

 This program prints out 5 different ingredients and prompts the
 user to create a recipe. The program intakes the user input
 for the recipe name, amount of servings, and the amount from each ingredient.
 It then calculates the nutrition value for 1 serving and prints it out.
 Additionally the program performs error testing to ensure that the serving's
 number is between 1 and 15 and that the amount selected for each ingredient
 is between 0 and 1500 grams, if it does not then the programs exists with an error message.
  */

import java.util.Scanner;

public class Main {

    // food #1 constants
    static final String FOOD_1_NAME = "milk";
    static final double FOOD_1_CALORIES_P100G = 48;  // in calories
    static final double FOOD_1_FAT_P100G = 1.2;  // in grams
    static final double FOOD_1_PROTEIN_P100G = 16.8;  //in calories
    static final double FOOD_1_SODIUM_P100G = 58.0;  // in milligrams

    // food #2 constants
    static final String FOOD_2_NAME = "sugar";
    static final double FOOD_2_CALORIES_P100G = 387;  // in calories
    static final double FOOD_2_FAT_P100G = 0.0;  // in grams
    static final double FOOD_2_PROTEIN_P100G = 0.0;  // in calories
    static final double FOOD_2_SODIUM_P100G = 0.0;  // in milligrams

    // food #3 constants
    static final String FOOD_3_NAME = "vanilla extract";
    static final double FOOD_3_CALORIES_P100G = 288;  // in calories
    static final double FOOD_3_FAT_P100G = 0.1;  // in grams
    static final double FOOD_3_PROTEIN_P100G = 0.1;  // in calories
    static final double FOOD_3_SODIUM_P100G = 9.0;  // in milligrams

    // food #4 constants
    static final String FOOD_4_NAME = "whipping cream";
    static final double FOOD_4_CALORIES_P100G = 345.0;  // in calories
    static final double FOOD_4_FAT_P100G = 37.0; // in grams
    static final double FOOD_4_PROTEIN_P100G = 2.1; // in calories
    static final double FOOD_4_SODIUM_P100G = 38.0; // in milligrams

    // food #5 constants
    static final String FOOD_5_NAME = "strawberry";
    static final double FOOD_5_CALORIES_P100G = 69.0;  // in calories
    static final double FOOD_5_FAT_P100G = 0.6; // in grams
    static final double FOOD_5_PROTEIN_P100G = 0.6; // in calories
    static final double FOOD_5_SODIUM_P100G = 37.0; // in milligrams

    static final String INDENT = "   ";
    static final String SEPARATOR = "\n";

    // error testing constants
    static final double MIN_SERVINGS = 1;
    static final double MAX_SERVINGS = 15;
    static final double MIN_GRAMS = 0;
    static final double MAX_GRAMS = 1500;

    public static void main(String[] args) {


        String recipeName, userInputStr;
        int userInputInt;
        double numberServings;
        double totalSodium, totalCals, totalFat, totalProtein;
        Scanner inputStream = new Scanner(System.in);

        // initialize accumulator variables
        totalFat = 0;
        totalCals = 0;
        totalProtein = 0;
        totalSodium = 0;


        // print menu
        System.out.println("---------- List of Possible Ingredients ---------");
        System.out.println(INDENT + "Food #1: " + FOOD_1_NAME);
        System.out.println(INDENT + "Food #2: " + FOOD_2_NAME);
        System.out.println(INDENT + "Food #3: " + FOOD_3_NAME);
        System.out.println(INDENT + "Food #4: " + FOOD_4_NAME);
        System.out.println(INDENT + "Food #5: " + FOOD_5_NAME + SEPARATOR);

        // name of recipe
        System.out.print("What are you calling this recipe ? ");
        recipeName = inputStream.nextLine();

        //ask for servings
        System.out.print("How many servings ?");
        userInputStr = inputStream.nextLine();
        numberServings = Integer.parseInt(userInputStr);


        if ((numberServings < MIN_SERVINGS) || (numberServings > MAX_SERVINGS) )
        {
            System.out.print("number of servings is invalid");
            System.exit(0);
        }


        // food #1 ---------------------------------------------------------
        System.out.print("How many grams of " + FOOD_1_NAME + "? ");
        userInputStr = inputStream.nextLine();
        userInputInt = Integer.parseInt(userInputStr);

        if ((userInputInt < MIN_GRAMS) || (userInputInt > MAX_GRAMS))
        {
            System.out.print("number of grams is invalid");
            System.exit(0);
        }


        // update accumulators
        totalCals += userInputInt * (FOOD_1_CALORIES_P100G / 100.);
        totalFat += userInputInt * (FOOD_1_FAT_P100G / 100.);
        totalProtein += userInputInt * (FOOD_1_PROTEIN_P100G / 100.);
        totalSodium += userInputInt * (FOOD_1_SODIUM_P100G / 100.);



        // food #2 ---------------------------------------------------------
        System.out.print("How many grams of " + FOOD_2_NAME + "? ");
        userInputStr = inputStream.nextLine();
        userInputInt = Integer.parseInt(userInputStr);

        if ((userInputInt < MIN_GRAMS) || (userInputInt > MAX_GRAMS))
        {
            System.out.print("number of grams is invalid");
            System.exit(0);
        }

        // update accumulators
        totalCals += userInputInt * (FOOD_2_CALORIES_P100G / 100.);
        totalFat += userInputInt * (FOOD_2_FAT_P100G / 100.);
        totalProtein += userInputInt * (FOOD_2_PROTEIN_P100G / 100.);
        totalSodium += userInputInt * (FOOD_2_SODIUM_P100G / 100.);

        // food #3 ---------------------------------------------------------
        System.out.print("How many grams of " + FOOD_3_NAME + "? ");
        userInputStr = inputStream.nextLine();
        userInputInt = Integer.parseInt(userInputStr);

        if ((userInputInt < MIN_GRAMS) || (userInputInt > MAX_GRAMS))
        {
            System.out.print("number of grams is invalid");
            System.exit(0);
        }

        // update accumulators
        totalCals += userInputInt * (FOOD_3_CALORIES_P100G / 100.);
        totalFat += userInputInt * (FOOD_3_FAT_P100G / 100.);
        totalProtein += userInputInt * (FOOD_3_PROTEIN_P100G / 100.);
        totalSodium += userInputInt * (FOOD_3_SODIUM_P100G / 100.);



        // food #4 ---------------------------------------------------------
        System.out.print("How many grams of " + FOOD_4_NAME + "? ");
        userInputStr = inputStream.nextLine();
        userInputInt = Integer.parseInt(userInputStr);

        if ((userInputInt < MIN_GRAMS) || (userInputInt > MAX_GRAMS))
        {
            System.out.print("number of grams is invalid");
            System.exit(0);
        }

        // update accumulators
        totalCals += userInputInt * (FOOD_4_CALORIES_P100G / 100.);
        totalFat += userInputInt * (FOOD_4_FAT_P100G / 100.);
        totalProtein += userInputInt * (FOOD_4_PROTEIN_P100G / 100.);
        totalSodium += userInputInt * (FOOD_4_SODIUM_P100G / 100.);


        // food #5 ---------------------------------------------------------
        System.out.print("How many grams of " + FOOD_5_NAME + "? ");
        userInputStr = inputStream.nextLine();
        userInputInt = Integer.parseInt(userInputStr);

        if ((userInputInt < MIN_GRAMS) || (userInputInt > MAX_GRAMS))
        {
            System.out.print("number of grams is invalid");
            System.exit(0);
        }

        // update accumulators
        totalCals += userInputInt * (FOOD_5_CALORIES_P100G / 100.);
        totalFat += userInputInt * (FOOD_5_FAT_P100G / 100.);
        totalProtein += userInputInt * (FOOD_5_PROTEIN_P100G / 100.);
        totalSodium += userInputInt * (FOOD_5_SODIUM_P100G / 100.);


        inputStream.close();

        //divide the total by # of servings
        totalCals /= numberServings;
        totalFat /= numberServings;
        totalSodium /= numberServings;
        totalProtein /= numberServings;


        // report results --------------------------------------------------
        System.out.println("\nNutrition for " + recipeName + " Per 1 Serving------------");
        System.out.println(INDENT + "Calories: " + totalCals);
        System.out.println(INDENT + "Fat: " + totalFat + " grams");
        System.out.println(INDENT + "Protein: " + totalProtein + " grams");
        System.out.println(INDENT + "Sodium: " + totalSodium + " grams");
    }

}


/*
Run 1:

---------- List of Possible Ingredients ---------
   Food #1: milk
   Food #2: sugar
   Food #3: vanilla extract
   Food #4: whipping cream
   Food #5: strawberry

What are you calling this recipe ? Omer's Strawberry Ice Cream
How many servings ?1
How many grams of milk? 1000
How many grams of sugar? 50
How many grams of vanilla extract? 20
How many grams of whipping cream? 100
How many grams of strawberry? 100

Nutrition for Omer's Strawberry Ice Cream Per 1 Serving------------
   Calories: 1145.1
   Fat: 49.62 grams
   Protein: 170.72 grams
   Sodium: 656.8 grams

Run 2:
---------- List of Possible Ingredients ---------
   Food #1: milk
   Food #2: sugar
   Food #3: vanilla extract
   Food #4: whipping cream
   Food #5: strawberry

What are you calling this recipe ? Omer's Vanilla Ice Cream For Two
How many servings ?2
How many grams of milk? 1000
How many grams of sugar? 100
How many grams of vanilla extract? 40
How many grams of whipping cream? 100
How many grams of strawberry? 0

Nutrition for Omer's Vanilla Ice Cream For Two Per 1 Serving------------
   Calories: 663.6
   Fat: 24.52 grams
   Protein: 85.07 grams
   Sodium: 310.8 grams


Run 3:

---------- List of Possible Ingredients ---------
   Food #1: milk
   Food #2: sugar
   Food #3: vanilla extract
   Food #4: whipping cream
   Food #5: strawberry

What are you calling this recipe ? Wild Strawberry
How many servings ?4
How many grams of milk? 1500
How many grams of sugar? 200
How many grams of vanilla extract? 0
How many grams of whipping cream? 100
How many grams of strawberry? 1000

Nutrition for Wild Strawberry Per 1 Serving------------
   Calories: 632.25
   Fat: 15.25 grams
   Protein: 65.025 grams
   Sodium: 319.5 grams

Run 4:

---------- List of Possible Ingredients ---------
   Food #1: milk
   Food #2: sugar
   Food #3: vanilla extract
   Food #4: whipping cream
   Food #5: strawberry

What are you calling this recipe ? Super Berry Ice Cream
How many servings ?15
How many grams of milk? 1500
How many grams of sugar? 200
How many grams of vanilla extract? 0
How many grams of whipping cream? 100
How many grams of strawberry? 1000

Nutrition for Super Berry Ice Cream Per 1 Serving------------
   Calories: 168.6
   Fat: 4.066666666666666 grams
   Protein: 17.34 grams
   Sodium: 85.2 grams


Run 5:

---------- List of Possible Ingredients ---------
   Food #1: milk
   Food #2: sugar
   Food #3: vanilla extract
   Food #4: whipping cream
   Food #5: strawberry

What are you calling this recipe ? Omer's best
How many servings ?0
number of servings is invalid

Run 6:

---------- List of Possible Ingredients ---------
   Food #1: milk
   Food #2: sugar
   Food #3: vanilla extract
   Food #4: whipping cream
   Food #5: strawberry

What are you calling this recipe ? Berry world
How many servings ?16
number of servings is invalid

Run 7:
---------- List of Possible Ingredients ---------
   Food #1: milk
   Food #2: sugar
   Food #3: vanilla extract
   Food #4: whipping cream
   Food #5: strawberry

What are you calling this recipe ? I scream for Ice Cream
How many servings ?10
How many grams of milk? 1501
number of grams is invalid

 */
