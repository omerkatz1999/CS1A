
import java.util.*;
import java.util.Scanner;
import java.lang.Math;


/*


 By Omer Katz

 Class :CS1A

 Date: 03/01/19

 Professor: Harden

 File name: Main.java

This program is used for computer dating. The class DatingProfile, allows the creation of
dating profiles and the comparing of two different profiles to verify matches.
 */


public class Main {

    //static method that displays the match result between two profiles
    public static void displayTwoProfiles( DateProfile profile1, DateProfile profile2 )
    {
        String result = "Fit between " + profile1.getName() + " and " +
                profile2.getName() + ":    " + profile1.fitValue(profile2);
        System.out.println(result);
    }





    //main
    public static void main(String [] args)
    {
        DateProfile applicant1 = new DateProfile();

        DateProfile applicant2 = new  DateProfile('P', 'F', 9, 3, "Omer Katz");

        DateProfile applicant3 = new  DateProfile('F', 'M', 5, 4, "Sarah Somebody");

        DateProfile applicant4 = new  DateProfile('M', 'M', 1, 10, "Ron Swanson");

        DateProfile list[] = {applicant1, applicant2, applicant3, applicant4};

        for( int i = 0; i < 4; i++)
        {
            for( int j = 0; j < 4; j++)
            {
                displayTwoProfiles(list[i],list[j]);

            }
            System.out.println();
        }



    }
}

//class date profile
class DateProfile {

    //constants
    public static final int MIN_ROMANCE =1;
    public static final int MAX_ROMANCE =10;
    public static final int MIN_FINANCE =1;
    public static final int MAX_FINANCE =10;
    public static final int MIN_NAME_LEN =1;
    public static final int MAX_NAME_LEN =50;

    public static final char DEFAULT_GEND ='M';
    public static final char DEFAULT_SEARCH_GEND = 'F';
    public static final String DEFAULT_NAME ="Bob Builder";
    public static final int DEFAULT_ROMANCE =10;
    public static final int DEFAULT_FINANCE =10;

    public static final double AVERAGE_OF = 2.0;

    //private variables
    private char gender;
    private char searchGender;
    private int romance;
    private int finance;
    private String name;






    //default constructor
    DateProfile()
    {
        setDefaults();
    }






    //constructors with paremeters
    DateProfile(char gen, char search, int rom, int fin, String input)
    {
        setAll(gen, search, rom, fin, input);
    }






    //getters
    //get gender
    public char getGender()
    {
        return gender;
    }






    //get search gender
    public char getSearchGender()
    {
        return searchGender;
    }






    //get romance
    public int getRomance()
    {
        return romance;
    }






    //get finance
    public int getFinance()
    {
        return finance;
    }






    //get name
    public String getName()
    {
        return name;
    }






    //setters
    //sets gender
    public boolean setGender( char gen )
    {
        if(validGen(gen))
        {
            gender = gen;
            return true;
        }
        return false;

    }






    //sets search gender
    public boolean setSearchGender( char gen )
    {
        if(validGen(gen))
        {
            searchGender = gen;
            return true;
        }
        return false;

    }






    //sets romance
    public boolean setRomance( int rom )
    {
        if(validNum(rom))
        {
            romance = rom;
            return true;
        }
        return false;

    }






    //sets finance
    public boolean setFinance( int fin )
    {
        if(validNum(fin))
        {
            finance = fin;
            return true;
        }
        return false;

    }






    //sets name
    public boolean setName( String input )
    {
        if(validString(input))
        {
            name = input;
            return true;
        }
        return false;

    }






    //helper- checks string validity
    private boolean validString( String input)
    {
        return (input.length() >= MIN_NAME_LEN && input.length() <= MAX_NAME_LEN);

    }






    ///helper- checks number is in range
    private boolean validNum( int input)
    {
        return (input >= MIN_FINANCE && input <= MAX_FINANCE);

    }






    //helper- checks gender validity
    private boolean validGen( char gen)
    {

        return (gen == 'M' || gen == 'm' || gen == 'F' || gen == 'f');

    }






    //sets all paremeters at once
    public void setAll( char gen, char search, int rom, int fin, String input)
    {
        if(!setGender(gen))
        {
            gender = DEFAULT_GEND;
        }

        if(!setSearchGender(search))
        {
            searchGender = DEFAULT_SEARCH_GEND;
        }

        if(!setRomance(rom))
        {
            romance = DEFAULT_ROMANCE;
        }

        if(!setFinance(fin))
        {
            finance = DEFAULT_FINANCE;
        }

        if(!setName(input))
        {
            name = DEFAULT_NAME;
        }


    }






    //sets all members to default
    public void setDefaults()
    {
        gender = DEFAULT_GEND;

        searchGender = DEFAULT_SEARCH_GEND;

        romance = DEFAULT_ROMANCE;

        finance = DEFAULT_FINANCE;

        name = DEFAULT_NAME;
    }






    //checks gnder fit
    private double determineGenderFit(DateProfile partner)
    {
        if (searchGender == partner.gender && partner.searchGender == gender)
        {
            return 1.0;
        }
        return 0.0;
    }






    //checks romance fit
    private double determineRomanceFit(DateProfile partner)
    {
        return 1.0 - (Math.abs(romance - partner.romance) / (double)MAX_ROMANCE);
    }






    //checks finance fit
    private double determineFinanceFit(DateProfile partner)
    {
        return 1.0 - (Math.abs(romance - partner.romance) / (double)MAX_ROMANCE);
    }






    //checks overall fit
    public double fitValue(DateProfile partner)
    {
        if(determineGenderFit(partner) == 0)
        {
            /*System.out.println("gender: " + gender );
            System.out.println("SearchGender: " + searchGender );
            System.out.println("Partner gender: " + partner.gender );
            System.out.println("Partner SearchGender: " + partner.searchGender );
            */
            return 0.0;
        }

        double numerator = determineRomanceFit(partner) + determineFinanceFit(partner);

        return numerator/AVERAGE_OF;
    }

}


/*
---------run----------


Fit between Bob Builder and Bob Builder:    0.0
Fit between Bob Builder and Omer Katz:    0.0
Fit between Bob Builder and Sarah Somebody:    0.5
Fit between Bob Builder and Ron Swanson:    0.0

Fit between Omer Katz and Bob Builder:    0.0
Fit between Omer Katz and Omer Katz:    0.0
Fit between Omer Katz and Sarah Somebody:    0.6
Fit between Omer Katz and Ron Swanson:    0.0

Fit between Sarah Somebody and Bob Builder:    0.5
Fit between Sarah Somebody and Omer Katz:    0.6
Fit between Sarah Somebody and Sarah Somebody:    0.0
Fit between Sarah Somebody and Ron Swanson:    0.0

Fit between Ron Swanson and Bob Builder:    0.0
Fit between Ron Swanson and Omer Katz:    0.0
Fit between Ron Swanson and Sarah Somebody:    0.0
Fit between Ron Swanson and Ron Swanson:    1.0
 */