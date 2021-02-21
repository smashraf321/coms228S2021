package Reinforcement;

public class R_1_9 {

    // Constant string to hold potential punctuations.
    private static final String punctuations = "!\"#$%&'()*+,-./:;<=>?@[]^_`{|}~";

    public static void main(String[] args)
    {
        StringBuilder textToBeModified = new StringBuilder();
        textToBeModified.append("He!!**");

        System.out.println("Input string is:");
        System.out.println(textToBeModified.toString());

        punctuationRemover(textToBeModified);

        System.out.println("Output string sans punctuation is:");
        System.out.println(textToBeModified.toString());
    }

    // Logic 1
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
        //    characters in the

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

    // Logic 2 - inaccurate
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
}
