package utilities;

import java.util.UUID;

public class RandomDataGenerator {

    public static String randomEmail() {

        return "user" + UUID.randomUUID().toString().substring(0,6) + "@gmail.com";

    }

}