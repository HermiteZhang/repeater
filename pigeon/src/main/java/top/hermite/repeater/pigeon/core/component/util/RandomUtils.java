package top.hermite.repeater.pigeon.core.component.util;


import java.util.Random;


public class RandomUtils
{
    // !@#$%^&*
    private final static char[] PASSWORD_CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
        'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
        'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '!', '@',
        '#', '$', '%', '^', '&', '*', '+', '-', '/', '_'};

    private static Random random = new Random();

    public static String numberCode(int size)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++ )
        {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    public static String passwordCode(int size)
    {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < size; i++ )
        {
            int idx = random.nextInt(PASSWORD_CHARS.length);
            sb.append(PASSWORD_CHARS[idx]);
        }
        return sb.toString();
    }
}
