package random;

public class RandomUser {

    public RandomUser() {

        randomEmail();

    }

    public static String randomEmail() {

        return new String("Test_user-" + (int) (Math.random() * 100_000_000) + randomDomaine());

    }

    private static String randomDomaine() {

        int rand = (int) (Math.random() * 4);

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
