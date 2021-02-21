package Reinforcement;

public class R_1_8 {

    public static void main(String[] args)
    {
        String text = "Hello World!!";
        System.out.println("There are " + String.valueOf(numVowels(text)) + " vowels in:\n" + text);
    }

    private static int numVowels(String text)
    {
        return numVowels2(text);
    }

    // Logic 1
    private static int numVowels1(String text)
    {
        // Explanation:
        //
        // 1. A naive approach considering all possibilities individually.
        //    For every character in the input string, check if it's a vowel.

        int count = 0;
        for(int i = 0; i < text.length(); i++)
        {
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

    // // Logic 2
    private static int numVowels2(String text)
    {
        // Explanation:
        //
        // 1. The idea is to create a constant string that contains
        //    all the vowels in the alphabet (as they're fixed) and then
        //    for every character in the input string, compare it with all
        //    the vowels in the alphabet stored in the constant string "vowels".

        int count = 0;
        final String vowels = "aeiouAEIOU";

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
