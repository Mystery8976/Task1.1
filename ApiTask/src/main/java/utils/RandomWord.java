package utils;

import java.util.Random;

public class RandomWord {
    public static String generateRandomWord(int wordLength) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder(wordLength);
        for (int count = 0; count < wordLength; count++) {
            char tmp = (char) ('a' + random.nextInt('z' - 'a'));
            stringBuilder.append(tmp);
        }
        return stringBuilder.toString();
    }
}
