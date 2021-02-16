import java.util.Random;

public class TheoryItem
{
    private String murderer;
    private String location;
    private String weapon;

    // Translate Methods
    public String murdererTranslate(int num)
    {
        return caseTranslate(num, "Ms. Scarlett", "Colonial Mustard", "Mrs. White", "Reverend Green", "Mrs. Peacock", "Professor Plum");
    }

    public String locationTranslate(int num)
    {
        return caseTranslate(num, "kitchen", "ballroom", "conservatory", "billiard", "library", "study", "hall", "lounge", "dining room", "cellar");
    }

    public String weaponTranslate(int num)
    {
        return caseTranslate(num, "rope", "wrench", "candlestick", "revolver", "knife", "pipe");
    }

    public String caseTranslate(int num, String case1, String case2, String case3, String case4, String case5, String case6)
    {
        switch(num)
        {
            case 1:
                return case1;
            case 2:
                return case2;
            case 3:
                return case3;
            case 4:
                return case4;
            case 5:
                return case5;
            case 6:
                return case6;
            default:
                return null;
        }
    }

    public String caseTranslate(int num, String case1, String case2, String case3, String case4, String case5, String case6, String case7, String case8, String case9, String case10)
    {
            switch (num)
            {
                case 1:
                    return case1;
                case 2:
                    return case2;
                case 3:
                    return case3;
                case 4:
                    return case4;
                case 5:
                    return case5;
                case 6:
                    return case6;
                case 7:
                    return case7;
                case 8:
                    return case8;
                case 9:
                    return case9;
                case 10:
                    return case10;
                default:
                    return null;
            }
    }

    public int numExclusion(int range, int numExcluded)
    {
        Random random = new Random();
        int num;
        do
        {
            num = random.nextInt(range) + 1;
        }while (num == numExcluded);
        return num;
    }
}
