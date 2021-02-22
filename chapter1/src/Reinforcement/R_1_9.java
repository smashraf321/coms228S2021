package Reinforcement;

public class R_1_9 {

    // Constant string to hold potential punctuations.
    private static final String punctuations = "!\"#$%&'’()*+,-./:;<=>?@[]^_`{|}~";

    public static void main(String[] args)
    {
        StringBuilder textToBeModified = new StringBuilder();
        textToBeModified.append("Let’s try, Mike!");

        System.out.println("Input string is:");
        System.out.println(textToBeModified.toString());

        punctuationRemover(textToBeModified);

        System.out.println("Output string sans punctuation is:");
        System.out.println(textToBeModified.toString());
    }

    private static void punctuationRemover(StringBuilder inputString)
    {
        // Explanation:
        //
        // 1. The goal is to identify the punctuations in the input string and delete them.
        //
        // 2. Since there are a specific number of punctuations, we hold them in a constant
        //    string "punctuations".
        //
        // 3. For every character in the input string, we compare it against all the
        //    characters in the punctuations string. If we find a match, we delete the
        //    character from the input string and stop comparing against other punctuations.
        //
        // 4. Now removing the character causes the input string to decrease in size.
        //    Also, the character that was previously at index [i+1] which could also very
        //    well be another punctuation will now be at index [i]. We therefore do not
        //    want to advance our index counter to [i+1] as we still need to verify the
        //    character at [i].

        for(int i = 0; i < inputString.length(); i++)
        {
            for(int j = 0; j < punctuations.length(); j++)
            {
                if(inputString.charAt(i) == punctuations.charAt(j))
                {
                    inputString.deleteCharAt(i);
                    i--;
                    break;
                }
            }
        }
    }

    // Alternate Logic - inaccurate
    //
    //    for(int i = 0; i < inputString.length(); i++)
    //    {
    //        for(int j = 0; j < punctuations.length(); j++)
    //        {
    //            if(inputString.charAt(i) == punctuations.charAt(j))
    //            {
    //                inputString.deleteCharAt(i);
    //            }
    //        }
    //        i--;
    //    }
    //
    // Explanation:
    //
    // 1. We should only decrement the index counter when we encounter a punctuation character
    //    resulting in character deletion.
    //
    // 2. Otherwise, we keep checking the same valid character over and over again
    //    when a character does not match a punctuation due to immediate index increment
    //    and decrement.
}
