package tests;

import random.RandomUserDataProviders;
import utils.PropertyLoader;

import java.util.Random;

/**
 * Created by alexander on 18.02.16.
 */
public class Test {

    private static String email = PropertyLoader.loadProperty("user.new.EMAIL");
    private static String number = email + new Random().nextInt();
    private static final String EMAIL = number;

    private static String test = RandomUserDataProviders.randomEmail();

    public static void main(String[] args) {

        System.out.println(EMAIL);
        System.out.println(test);

    }

}
