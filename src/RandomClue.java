import java.util.Random;
import java.util.Scanner;
public class RandomClue
{
    public static void main(String[] args)
    {
        RandomClue clue = new RandomClue();
        AssistantJack Jack = new AssistantJack();
        Random random = new Random();
        Scanner key = new Scanner(System.in);
        int murdererNum = random.nextInt(6) + 1;
        int locationNum = random.nextInt(10) + 1;
        int weaponNum = random.nextInt(6) + 1;

        for (int day = 1; day <= 20; day++)
        {
            System.out.println("\nDay " + day + "\n");
            Jack.dailyJackQuoteGenerator(day, murdererNum, locationNum, weaponNum);
            Jack.guess(murdererNum, locationNum, weaponNum);
        }
    }
}


