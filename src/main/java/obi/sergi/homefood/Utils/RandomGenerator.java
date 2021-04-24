package obi.sergi.homefood.Utils;

import java.util.Random;

public class RandomGenerator {

    public static int minUidNumber = 100000, maxUidNumber = 900000;

    public static String generateRandomUid(){
        Random random = new Random();
        return String.valueOf(minUidNumber + random.nextInt(maxUidNumber));
    }
}
