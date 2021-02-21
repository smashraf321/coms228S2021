package Reinforcement;

public class R_1_8 {
    public static void main(String[] args)
    {
        String text = "Hello World!!";
        System.out.println("There are " + String.valueOf(numVowels(text)) + " vowels in " + text);
    }

    public static int numVowels(String text)
    {
        return numVowels2(text);
    }
    
    public static int numVowels1(String text)
    {
        int count = 0;
        for(int i = 0; i < text.length(); i++)
        {
            // A naive approach considering all possibilities individually
            if(text.charAt(i) == 'a' || text.charAt(i) == 'A'
            || text.charAt(i) == 'e' || text.charAt(i) == 'E'
            || text.charAt(i) == 'i' || text.charAt(i) == 'I'
            || text.charAt(i) == 'o' || text.charAt(i) == 'O'
            || text.charAt(i) == 'u' || text.charAt(i) == 'U')
            {
                count++;
            }
        }
        return count;
    }

    public static int numVowels2(String text)
    {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for(int i = 0; i < text.length(); i++)
        {
            for(int j = 0; j < vowels.length(); j++)
            {
                if(text.charAt(i) == vowels.charAt(j))
                {
                    count++;
                }
            }
        }
        return count;
    }
}
