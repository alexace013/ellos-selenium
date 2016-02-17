package random;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class RandomUserDataProviders {

    private static List<String[]> data = new ArrayList<String[]>();

    private RandomUserDataProviders() {

    }

    @DataProvider
    public static String randomEmail() {

        data.add(new String[]{"test_user-" + generateRandomName() + generateDomaine()});

        String user = null;

        for (String str : data.iterator().next()) {

            user = str;

        }

        return user;

    }

    private static Integer generateRandomName() {

        return new Random().nextInt();

    }

    private static String generateDomaine() {

        int number = 4;

        int rand = (int) (Math.random() * number);

        switch (rand) {
            case 0:
                return "@gmail.com";
            case 1:
                return "@mail.ru";
            case 2:
                return "@ukr.net";
            default:
                return "@i.ua";
        }

    }

}
