package org.opencart.managers;

import com.github.javafaker.Faker;

public class FakeDataManager {

    private static Faker faker = new Faker();
    public static String generateFakeEmail(){
        return faker.internet().emailAddress();
    }
    public static String generateFakeName(){
        return faker.funnyName().name();
    }
    public static String generateFakePassword(int min, int max){
        return faker.internet().password(min, max);
    }

    public static String generateFakeEmail(String prefix, String sufix){
        String randomMidPartString = String.valueOf(faker.random().nextInt(1,999999999));
        return prefix + randomMidPartString + sufix;
    }
}
