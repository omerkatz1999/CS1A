/*
Program by Omer Katz

Class: CS1A

Instructor: Professor Harden

Date: 03/10/19


Program: This program uses a student class and an array utilities
class to demonstrate the use of a sort key. The array is sorted depending on
the sort key, meaning it is sorted by either last name, first name, or number of points.
 */
import javax.swing.*;

public class Main
{
    public static void main (String[] args)
    {
        Student[] myStudents1 = { new Student("smith","fred", 95),
                new Student("bauer","jack",123),
                new Student("jacobs","carrie", 195),
                new Student("renquist","abe",148),
                new Student("3ackson","trevor", 108),
                new Student("perry","fred",225),
                new Student("loceff","fred", 44),
                new Student("stollings","pamela",452),
                new Student("charters","rodney", 295),
                new Student("cassar","john",321),
                new Student("Bernard", "Andy", 100),
                new Student("Schrute", "Dwite", 500),
                new Student("Scott", "Michael", 99),
                new Student("Bratton", "Creed", 173),
                new Student("Halpert", "Jim", 100),
                new Student("Beasly", "Pam", 121),
                new Student("the-devil", "Toby", 50)

        };


        Student[] myStudents2 = { new Student("smith","fred", 95),
                new Student("bauer","jack",123),
                new Student("jacobs","carrie", 195),
                new Student("renquist","abe",148),
                new Student("3ackson","trevor", 108),
                new Student("perry","fred",225),
                new Student("loceff","fred", 44),
                new Student("stollings","pamela",452),
                new Student("charters","rodney", 295),
                new Student("cassar","john",321),
                new Student("Bernard", "Andy", 100),
                new Student("Schrute", "Dwite", 500),
                new Student("Scott", "Michael", 99),
                new Student("Bratton", "Creed", 173),
                new Student("Halpert", "Jim", 100),
                new Student("Beasly", "Pam", 121),
                new Student("the-devil", "Toby", 50),
                new Student("Katz", "Omer", 50)

        };


        Student[] myStudents3 = {new Student("smith", "fred", 95)};

        Student[] myStudents4 = {};




        System.out.println(StudentArrayUtilities.toString("Before: ", myStudents2));
        StudentArrayUtilities.arraySort(myStudents2);
        System.out.println(StudentArrayUtilities.toString("Sorted by Last: ", myStudents2));

        Student.setSortKey(Student.SORT_BY_FIRST);
        StudentArrayUtilities.arraySort(myStudents2);
        System.out.println(StudentArrayUtilities.toString("Sorted by First: ", myStudents2));


        Student.setSortKey(Student.SORT_BY_POINTS);
        StudentArrayUtilities.arraySort(myStudents2);
        System.out.println(StudentArrayUtilities.toString("Sorted by Points: ", myStudents2));

        Student.setSortKey(Student.SORT_BY_FIRST);

        System.out.println("Median of Large Even array: ");
        System.out.println(StudentArrayUtilities.getMedianDestructive(myStudents2));

        System.out.println("Sort key should be 88:  " + Student.getSortKey());

        System.out.println("Median of Large Odd array: ");
        System.out.println(StudentArrayUtilities.getMedianDestructive(myStudents1));

        System.out.println("Median of array size 1: ");
        System.out.println(StudentArrayUtilities.getMedianDestructive(myStudents3));

        System.out.println("Median of empty array: ");
        System.out.println(StudentArrayUtilities.getMedianDestructive(myStudents4));




    }
}

class Student
{
    private String lastName;
    private String firstName;
    private int totalPoints;


    public static final int SORT_BY_FIRST = 88;
    public static final int SORT_BY_LAST = 98;
    public static final int SORT_BY_POINTS = 108;

    private static int sortKey = SORT_BY_LAST;

    public static final String DEFAULT_NAME = "zz-error";
    public static final int DEFAULT_POINTS = 0;
    public static final int MAX_POINTS = 1000;

    // constructor requires parameters - no default supplied
    public Student( String last, String first, int points)
    {
        if ( !setLastName(last) )
            lastName = DEFAULT_NAME;
        if ( !setFirstName(first) )
            firstName = DEFAULT_NAME;
        if ( !setPoints(points) )
            totalPoints = DEFAULT_POINTS;
    }

    public String getLastName() { return lastName; }
    public String getFirstName() { return firstName; }
    public int getTotalPoints() { return totalPoints; }
    public static int getSortKey(){return sortKey;}






    //setters
    public boolean setLastName(String last)
    {
        if ( !validString(last) )
            return false;
        lastName = last;
        return true;
    }







    public boolean setFirstName(String first)
    {
        if ( !validString(first) )
            return false;
        firstName = first;
        return true;
    }







    public boolean setPoints(int pts)
    {
        if ( !validPoints(pts) )
            return false;
        totalPoints = pts;
        return true;
    }







    public static boolean setSortKey( int key )
    {
        if(key == SORT_BY_LAST || key == SORT_BY_FIRST || key == SORT_BY_POINTS)
        {
            sortKey = key;
            return true;
        }

        return false;

    }







    // could be an instance method and, if so, would take one parameter
    public static int compareTwoStudents( Student firstStud, Student secondStud )
    {
        int result;

        switch( sortKey )
        {
            case SORT_BY_LAST:
                result = firstStud.lastName.compareToIgnoreCase(secondStud.lastName);
                return result;
            case SORT_BY_FIRST:
                result = firstStud.firstName.compareToIgnoreCase(secondStud.firstName);
                return result;
            case SORT_BY_POINTS:
                result = firstStud.totalPoints - secondStud.totalPoints;
                return result;
        }

        return 0;
    }






    //to string
    public String toString()
    {
        String resultString;

        resultString = " "+ lastName
                + ", " + firstName
                + " points: " + totalPoints
                + "\n";
        return resultString;
    }






    //checks string validity
    private static boolean validString( String testStr )
    {
        if (
                testStr != null && testStr.length() > 0
                        && Character.isLetter(testStr.charAt(0))
        )
            return true;
        return false;
    }






    //check points validity
    private static boolean validPoints( int testPoints )
    {
        if (testPoints >= 0 && testPoints <= MAX_POINTS)
            return true;
        return false;
    }
}

class StudentArrayUtilities
{
    // print the array with string as a title for the message box
    // this is somewhat controversial - we may or may not want an I/O
    // methods in this class.  we'll accept it today
    public static String toString(String title, Student[] data)
    {
        String output = title +"\n";

        // build the output string from the individual Students:
        for (int k = 0; k < data.length; k++)
            output += " " + data[k].toString();

        return output;
    }







    // returns true if a modification was made to the array
    private static boolean floatLargestToTop(Student[] data, int top)
    {
        boolean changed = false;
        Student temp;

        // compare with client call to see where the loop stops
        for (int k = 0; k < top; k++)
            if ( Student.compareTwoStudents(data[k], data[k + 1]) > 0 )
            {
                temp = data[k];
                data[k] = data[k + 1];
                data[k + 1] = temp;
                changed = true;
            }
        return changed;
    }







    // public callable arraySort() - assumes Student class has a compareTo()
    public static void arraySort(Student[] array)
    {
        for (int k = 0; k < array.length; k++)
            // compare with method def to see where inner loop stops
            if ( !floatLargestToTop(array, array.length - 1 - k) )
                return;
    }






    //gets the median when the array is sorted by points
    public static double getMedianDestructive(Student[] array)
    {
        if (array.length < 1)
        {
            return 0;
        }

        int tmpSortKey = Student.getSortKey();

        Student.setSortKey(Student.SORT_BY_POINTS);

        arraySort(array);

        double median = 0;

        if (array.length % 2 == 0)
        {
            median = (array[array.length/2 - 1].getTotalPoints()
                    + array[array.length/2].getTotalPoints())/2;
        }

      else
        median = array[array.length/2].getTotalPoints();

        Student.setSortKey(tmpSortKey);

        return median;





    }
}

/*

run:



Before:
  smith, fred points: 95
  bauer, jack points: 123
  jacobs, carrie points: 195
  renquist, abe points: 148
  zz-error, trevor points: 108
  perry, fred points: 225
  loceff, fred points: 44
  stollings, pamela points: 452
  charters, rodney points: 295
  cassar, john points: 321
  Bernard, Andy points: 100
  Schrute, Dwite points: 500
  Scott, Michael points: 99
  Bratton, Creed points: 173
  Halpert, Jim points: 100
  Beasly, Pam points: 121
  the-devil, Toby points: 50
  Katz, Omer points: 50

Sorted by Last:
  bauer, jack points: 123
  Beasly, Pam points: 121
  Bernard, Andy points: 100
  Bratton, Creed points: 173
  cassar, john points: 321
  charters, rodney points: 295
  Halpert, Jim points: 100
  jacobs, carrie points: 195
  Katz, Omer points: 50
  loceff, fred points: 44
  perry, fred points: 225
  renquist, abe points: 148
  Schrute, Dwite points: 500
  Scott, Michael points: 99
  smith, fred points: 95
  stollings, pamela points: 452
  the-devil, Toby points: 50
  zz-error, trevor points: 108

Sorted by First:
  renquist, abe points: 148
  Bernard, Andy points: 100
  jacobs, carrie points: 195
  Bratton, Creed points: 173
  Schrute, Dwite points: 500
  loceff, fred points: 44
  perry, fred points: 225
  smith, fred points: 95
  bauer, jack points: 123
  Halpert, Jim points: 100
  cassar, john points: 321
  Scott, Michael points: 99
  Katz, Omer points: 50
  Beasly, Pam points: 121
  stollings, pamela points: 452
  charters, rodney points: 295
  the-devil, Toby points: 50
  zz-error, trevor points: 108

Sorted by Points:
  loceff, fred points: 44
  Katz, Omer points: 50
  the-devil, Toby points: 50
  smith, fred points: 95
  Scott, Michael points: 99
  Bernard, Andy points: 100
  Halpert, Jim points: 100
  zz-error, trevor points: 108
  Beasly, Pam points: 121
  bauer, jack points: 123
  renquist, abe points: 148
  Bratton, Creed points: 173
  jacobs, carrie points: 195
  perry, fred points: 225
  charters, rodney points: 295
  cassar, john points: 321
  stollings, pamela points: 452
  Schrute, Dwite points: 500

Median of Large Even array:
122.0
Sort key should be 88:  88
Median of Large Odd array:
123.0
Median of array size 1:
95.0
Median of empty array:
0.0
 */