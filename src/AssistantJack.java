import java.util.Random;
import java.util.Scanner;
public class AssistantJack
{
    public void guess(int murdererNum, int locationNum, int weaponNum)
    {
        TheoryItem item = new TheoryItem();
        Random random = new Random();
        Scanner key = new Scanner(System.in);
        int confirm;
        String murderMethod = "";
        int murdererGuess;
        int locationGuess;
        int weaponGuess;
        do
        {
            System.out.print("*Enter the number of the suspect you think committed the murder(suspects 1-6): ");
            murdererGuess = maxminGuess(1, 6);
            System.out.print("*Enter the number of the location you think the murder happened(locations 1-10): ");
            locationGuess = maxminGuess(1, 10);
            System.out.print("*Enter the number of the object you think was used to commit the murder(weapons 1-6): ");
            weaponGuess = maxminGuess(1, 6);

            switch(weaponGuess)
            {
                case 1:
                    murderMethod = "strangled";
                    break;
                case 2:
                    murderMethod = "attacked";
                    break;
                case 3:
                    murderMethod = "bashed";
                    break;
                case 4:
                    murderMethod = "shot";
                    break;
                case 5:
                    murderMethod = "stabbed";
                    break;
                case 6:
                    murderMethod = "struck";
                    break;
            }

            System.out.println("Jack: So your story is... " + item.murdererTranslate(murdererGuess) + " " + murderMethod + " Dr. Foo with a " + item.weaponTranslate(weaponGuess) + " in the " + item.locationTranslate(locationGuess) + "? Is that your final guess?");
            confirm = 0;
            System.out.print("*Enter 1 for yes, 0 for no: ");
            confirm = maxminGuess(0,1);
        }while(confirm == 0);

        if (murdererGuess == murdererNum && locationGuess == locationNum && weaponGuess == weaponNum)
        {
            System.out.println("Jack: Jill, you did it! You've solved the case, and the killer is behind bars!");
            System.exit(0);
        }
        else
        {
            int checked = 0;
            do
            {
                switch (random.nextInt(3) + 1)
                {
                    case 1: // Suspect
                        if (murdererGuess != murdererNum)
                        {
                            checked = murdererGuess;
                            System.out.println("\nJack: Detectives examined the house and could find no evidence of " + item.murdererTranslate(murdererGuess) + "'s (Suspect " + murdererGuess + ") involvement in the crime.");
                        }
                        break;
                    case 2: // Location
                        if (locationGuess != locationNum)
                        {
                            checked = locationGuess;
                            System.out.println("\nJack: No fingerprints or any evidence of a struggle were found in the " + item.locationTranslate(locationGuess) + " (location " + locationGuess + ").");
                        }
                        break;
                    case 3: // Weapon
                        if (weaponGuess != weaponNum)
                        {
                            checked = weaponGuess;
                            System.out.println("\nDetectives have found no evidence of the " + item.weaponTranslate(weaponGuess) + " (weapon " + weaponGuess + ") being used recently.");
                        }
                        break;
                }
            }while (checked == 0);
        }
    }



    public int maxminGuess(int min, int max)
    {
        Scanner key = new Scanner(System.in);
        int guess;
        do
        {
            guess = key.nextInt();
            if (guess < min || guess > max)
            {
                System.out.print("Please enter a value between " + min + " and " + max + ": ");
            }
        }while(guess < min || guess > max);
        return guess;
    }

    public void dailyJackQuoteGenerator(int day, int murdererNum, int locationNum, int weaponNum)
    {
        System.out.print("Jack: ");
        if (day == 1)
        {
            System.out.println("Okay, Jill, they said they would give us 20 days before handing the case off to someone else.\nI'm relying on you. Good luck, and don't forget to read the case files.");
        }
        else if (day == 10)
        {
            giveClue(murdererNum, locationNum, weaponNum, 1);
        }
        else if(day == 20)
        {
            giveClue(murdererNum, locationNum, weaponNum, 2);
            System.out.println("This is our last day! Can we make it count?");
        }
        else if (day <= 7)
        {
            printRandomQuote("We've got a lot of work ahead, but I think we can do this.", "What'cha got for me?", "Another day, another guess to make.", "Any sus?");
        }
        else if (day <= 14)
        {
            printRandomQuote("You know the drill, Jill.", "We've been at this for a while, maybe you can close it up now?", "Keep at it, Jill. Sooner we get this done, the sooner we can rest and maybe get some fried chicken.", "Any leads yet?");
        }
        else if (day <= 20)
        {
            printRandomQuote("We're running out of time, we might need to speed things up.", "I'm sure all this work we've done has amounted to something.", "We've done a lot, you think we have what we need to wrap this up?", "I know it looks bad, but keep your chin up. Mr. Foo's family is counting on us.");
        }
    }

    public String printRandomQuote(String quote1, String quote2, String quote3, String quote4)
    {
        Random random = new Random();
        switch(random.nextInt(3) + 1)
        {
            case 1:
                return quote1;
            case 2:
                return quote2;
            case 3:
                return quote3;
            case 4:
                return quote4;
        }
        return null;
    }

    public void giveClue(int murdererInt, int locationNum, int weaponNum, int clueMagnitude)
    {
        Random random = new Random();
        TheoryItem item = new TheoryItem();
        switch(random.nextInt(3) + 1)
        {
            case 1: // Suspect Clue
                /*
                1. Ms. Scarlett        Age: 24     Hair: Blond
                2. Colonial Mustard    Age: 62     Hair: Grey
                3. Mrs. White          Age: 57     Hair: White
                4. Reverend Green      Age: 42     Hair: Dark Brown
                5. Mrs. Peacock        Age: 38     Hair: Red
                6. Professor Plum      Age: 32     Hair: Light Brown
                */
                switch(clueMagnitude)
                {
                    case 1: // Suspect Magnitude 1
                        System.out.print("Listen, Jill! Investigators have found evidence that the killer was in their ");
                        if (murdererInt == 1 || murdererInt == 6)
                            System.out.println("mid 20s to early 30s.");
                        else if (murdererInt ==  4|| murdererInt == 5)
                            System.out.println("mid 30s to early 40s.");
                        else if (murdererInt == 2 || murdererInt == 3)
                            System.out.println("50s to early 60s.");
                        break;
                    case 2: // Suspect Magnitude 2
                        System.out.print("Listen, Jill! Investigators have found a string of ");
                        switch (murdererInt)
                        {
                            case 1:
                                System.out.print("blond");
                                break;
                            case 2:
                                System.out.print("gray");
                                break;
                            case 3:
                                System.out.print("white");
                                break;
                            case 4:
                                System.out.print("dark brown");
                                break;
                            case 5:
                                System.out.print("red");
                                break;
                            case 6:
                                System.out.print("light brown");
                                break;
                        }
                        System.out.println(" hair on the victim's body.");
                        break;
                }
            case 2: // Room Clue
                /*
                1. Kitchen
                2. Ballroom
                3. Conservatory
                4. Billiard
                5. Library
                6. Study
                7. Hall
                8. Lounge
                9. Dining Room
                10. Cellar
                */

                switch(clueMagnitude)
                {
                    case 1: // Room Magnitude 1
                        System.out.print("Listen, Jill! Investigators found evidence of much activity between the ");
                        switch(locationNum)
                        {
                            case 1: // Kitchen
                                System.out.print(item.locationTranslate(9) + ", " + item.locationTranslate(1) + ", and " + item.locationTranslate(2));
                                break;
                            case 2: // Ballroom
                                switch(random.nextInt(3)+1)
                                {
                                    case 1:
                                        System.out.print(item.locationTranslate(9) + ", " + item.locationTranslate(1) + ", and " + item.locationTranslate(2));
                                        break;
                                    case 2:
                                        System.out.print(item.locationTranslate(2) + " and " + item.locationTranslate(10));
                                        break;
                                    case 3:
                                        System.out.print(item.locationTranslate(2) + ", " + item.locationTranslate(3) + ", and " + item.locationTranslate(4));
                                        break;
                                }
                                break;
                            case 3: // Conservatory
                                System.out.print(item.locationTranslate(2) + ", " + item.locationTranslate(3) + ", and " + item.locationTranslate(4));
                                break;
                            case 4: // Billiard
                                switch(random.nextInt(2)+1)
                                {
                                    case 1:
                                        System.out.print(item.locationTranslate(2) + ", " + item.locationTranslate(3) + ", and " + item.locationTranslate(4));
                                        break;
                                    case 2:
                                        System.out.print(item.locationTranslate(4) + ", " + item.locationTranslate(5) + ", and " + item.locationTranslate(10));
                                        break;
                                }
                                break;
                            case 5: // Library
                                switch(random.nextInt(2)+1)
                                {
                                    case 1:
                                        System.out.print(item.locationTranslate(4) + ", " + item.locationTranslate(5) + ", and " + item.locationTranslate(10));
                                        break;
                                    case 2:
                                        System.out.print(item.locationTranslate(5) + ", " + item.locationTranslate(6) + ", and " + item.locationTranslate(7));
                                        break;
                                }
                                break;
                            case 6: // Study
                                System.out.print(item.locationTranslate(5) + ", " + item.locationTranslate(6) + ", and " + item.locationTranslate(7));
                                break;
                            case 7: // Hall
                                switch(random.nextInt(3)+1)
                                {
                                    case 1:
                                        System.out.print(item.locationTranslate(5) + ", " + item.locationTranslate(6) + ", and " + item.locationTranslate(7));
                                        break;
                                    case 2:
                                        System.out.print(item.locationTranslate(7) + " and " + item.locationTranslate(10));
                                        break;
                                    case 3:
                                        System.out.print(item.locationTranslate(7) + ", " + item.locationTranslate(8) + ", and " + item.locationTranslate(9));
                                        break;
                                }
                                break;
                            case 8: // Lounge
                                System.out.print(item.locationTranslate(7) + ", " + item.locationTranslate(8) + ", and " + item.locationTranslate(9));
                                break;
                            case 9: // Dining Room
                                switch(random.nextInt(3)+1)
                                {
                                    case 1:
                                        System.out.print(item.locationTranslate(7) + ", " + item.locationTranslate(8) + ", and " + item.locationTranslate(9));
                                        break;
                                    case 2:
                                        System.out.print(item.locationTranslate(9) + " and " + item.locationTranslate(10));
                                        break;
                                    case 3:
                                        System.out.print(item.locationTranslate(9) + ", " + item.locationTranslate(1) + ", and " + item.locationTranslate(2));
                                        break;
                                }
                                break;
                            case 10: // Cellar
                                switch(random.nextInt(4)+1)
                                {
                                    case 1:
                                        System.out.print(item.locationTranslate(2) + " and " + item.locationTranslate(10));
                                        break;
                                    case 2:
                                        System.out.print(item.locationTranslate(4) + ", " + item.locationTranslate(5) + ", and " + item.locationTranslate(10));
                                        break;
                                    case 3:
                                        System.out.print(item.locationTranslate(7) + " and " + item.locationTranslate(10));
                                        break;
                                    case 4:
                                        System.out.print(item.locationTranslate(9) + " and " + item.locationTranslate(10));
                                        break;
                                }
                                break;
                        }
                        System.out.println(".");
                        break;
                    case 2: // Room Magnitude 2
                        System.out.println("Listen, Jill! Traces of the victim's fingerprints were found all over the " + item.locationTranslate(locationNum) + "!");
                        break;
                }
                break;
            case 3: // Weapon Clue
                /*
                1. Rope
                2. Wrench
                3. Candlestick
                4. Revolver
                5. Knife
                6. Pipe
                */
                switch(clueMagnitude)
                {
                    case 1: // Weapon Magnitude 1
                        System.out.print("\nListen, Jill! The weapons were examined, and ");
                        switch (random.nextInt(2) + 1)
                        {
                            case 1:
                                System.out.print("the " + item.weaponTranslate(weaponNum) + " and the " + item.weaponTranslate(item.numExclusion(6, weaponNum)));
                                break;
                            case 2:
                                System.out.print("the " + item.weaponTranslate(item.numExclusion(6, weaponNum)) + " and the " + item.weaponTranslate(weaponNum));
                                break;
                        }
                        System.out.println(" look like they might have been used recently!");
                        break;
                    case 2: // Weapon Magnitude 2
                        System.out.println("Listen, Jill! An autopsy was just performed, and ");
                        switch (weaponNum)
                        {
                            case 1:
                                System.out.println("strangle marks were found on the victim's neck!");
                                break;
                            case 2:
                                System.out.println("fracture marks were found on the victim' skull!");
                                break;
                            case 3:
                                System.out.println("fracture marks were found on the victim' skull... along with small burn marks!");
                                break;
                            case 4:
                                String bulletLocation = "";
                                switch (random.nextInt(3) + 1)
                                {
                                    case 1:
                                        bulletLocation = "heart";
                                        break;
                                    case 2:
                                        bulletLocation = "lungs";
                                        break;
                                    case 3:
                                        bulletLocation = "stomach";
                                        break;
                                }
                                System.out.println("a bullet was found inside the victim's " + bulletLocation + "!");
                                break;
                            case 5:
                                System.out.println("several stab wounds were found on the victim's body!");
                                break;
                            case 6:
                                System.out.println("fracture marks were found on the victim' skull... along with water in the victim's hair!");
                                break;
                        }
                        break;
                }
                break;
        }

    }
}


