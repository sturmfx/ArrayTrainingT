package sample;

import java.util.Random;

public class RES
{
    static Random random = new Random();
    static String[] female_names = new String[]
            {
                    "Gwendolyn",
                    "Melinda",
                    "Meryl",
                    "Alisha",
                    "Jammie",
                    "Peggy",
                    "Letty",
                    "Teena",
                    "Bethany",
                    "Kerstin",
                    "Cristie",
                    "Socorro",
                    "Kyra",
                    "Adena",
                    "Mary",
                    "Jennifer",
                    "Lisa",
                    "Ashley",
                    "Laura",
                    "Anna",
                    "Victoria",
                    "Ann",
                    "Alice",
                    "Gloria",
                    "Jane"
            };
    static String[] male_names = new String[]
            {
                    "James",
                    "John",
                    "Robert",
                    "Michael",
                    "William",
                    "David",
                    "Richard",
                    "Joseph",
                    "Thomas",
                    "Charles",
                    "Christopher",
                    "Daniel",
                    "Matthew",
                    "Anthony",
                    "Donald",
                    "Mark",
                    "Paul",
                    "Steven",
                    "Andrew",
                    "Kenneth",
                    "George",
                    "Joshua",
                    "Kevin",
                    "Brian",
                    "Edward"
            };
    static String[] second_names = new String[]
            {
                    "Smith",
                    "Johnson",
                    "Williams",
                    "Jones",
                    "Brown",
                    "Davis",
                    "Miller",
                    "Wilson",
                    "Moore",
                    "Taylor",
                    "Anderson",
                    "Thomas",
                    "Jackson",
                    "White",
                    "Harris",
                    "Martin",
                    "Thompson",
                    "Garcia",
                    "Martinez",
                    "Robinson",
                    "Clark",
                    "Rodriguez",
                    "Lewis",
                    "Lee",
                    "Walker"
            };
    public static String getFemaleName()
    {
        int index = random.nextInt(25);
        String return_string = female_names[index];
        return return_string;
    }
    public static String getMaleName()
    {
        int index = random.nextInt(25);
        String return_string = male_names[index];
        return return_string;
    }
    public static String getSecondName()
    {
        int index = random.nextInt(25);
        String return_string = second_names[index];
        return return_string;
    }
    public static Person getPerson(int age1, int age2, int points1, int points2)
    {
        return new Person(getFemaleName(), getSecondName(), age1 + random.nextInt(age2-age1), points1 + random.nextInt(points2-points1));
    }

}
