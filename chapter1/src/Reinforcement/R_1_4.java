package Reinforcement;

public class R_1_4 {

    public static void main(String[] args)
    {
        int positiveInteger = 100;
        if(isEven(positiveInteger))
        {
            System.out.println(String.valueOf(positiveInteger) + " is even");
        }
        else
        {
            System.out.println(String.valueOf(positiveInteger) + " is odd");
        }
    }

    private static boolean isEven(int i)
    {
        // Explanation:
        //
        // 1. An even number in its binary representation has the right most bit as a 0.
        //    Ex: 2 is [1 0]; 6 is [1 1 0]; 3 is [1 1]; and so on.
        //
        // 2. Bitwise & on a bit with 1 always yields the original bit.
        //    X = original bit, Y = 1
        //    X & Y => [ X & 1 = X ]
        //              -----------
        //               0 & 1 = 0
        //               1 & 1 = 1
        //
        // 3. Bitwise & on a bit with 0 always masks the original bit, i.e. returns 0.
        //    X = original bit, Y = 0
        //    X & Y => [ X & 0 = 0 ]
        //              -----------
        //               0 & 0 = 0
        //               1 & 0 = 0
        //
        // 4. The idea then is to only check the right most bit to determine whether a number is even or odd.
        //    Ex: 2 & 1 =>  1 0    |     3 & 1 =>  1 1     |
        //                & 0 1    |             & 0 1     |
        //    ---------------------------------------------|
        //    Answer:       0 0    |               0 1     |

        return ((i & 1) == 0);
    }
}
