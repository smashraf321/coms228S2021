package Reinforcement;

public class R_1_4 {
    public static void main(String[] args)
    {
        int i = 100;
        if(isEven(i))
        {
            System.out.println(String.valueOf(i) + " is even");
        }
        else
        {
            System.out.println(String.valueOf(i) + " is odd");
        }
    }

    public static boolean isEven(int i)
    {
        return ((i & 1) == 0);
        // Explanation:
        // An even number in its binary representation has the right most bit as a 0.
        // Ex: 2 is 10; 6 is 110; 3 is 11; and so on.
        // bitwise & with 1 is a filter that always returns the original value.
        // Ex: 0 & 1 = 0; 1 & 1 = 1;
        // The idea then is to only check the right most bit to determine whether a number is even or odd.
        // Ex: 2 & 1 =>  1 0    |     3 & 1 =>  1 1     |
        //             & 0 1    |             & 0 1     |
        //----------------------------------------------|
        // Answer:       0 0    |               0 1     |
    }
}
