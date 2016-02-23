package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.PropertyLoader;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestClass {

    @Parameters({"email", "password"})
    @Test(dataProvider = "randomEmailAndPassword")
    public void test1(String email, String password) {
        System.out.println("email: " + email + "\n" + "password: " + password);
    }

    @DataProvider
    public Iterator<Object[]> randomEmailAndPassword() {
        List<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < 10; i++) {
            data.add(new Object[]{
                    generateRandomEmail(), generateRandomPassword()
            });
        }
        return data.iterator();
    }

//    @DataProvider
//    public Object[][] randomEmail() {
//        Object[][] data = new Object[2][2];
//        data[0][0] = generateRandomEmail();
//        data[0][1] = generateRandomPassword();
//        data[1][0] = generateRandomEmail();
//        data[1][1] = generateRandomPassword();
//        return data;
//    }


    private Object generateRandomPassword() {
        return PropertyLoader.loadProperty("user.new.PASS") + randomValue();
    }

    private Object generateRandomEmail() {
        return PropertyLoader.loadProperty("user.new.EMAIL") + randomValue() + PropertyLoader.loadProperty("user.new.EMAIL.domain");
    }

    private int randomValue() {
        int value = new Random().nextInt(10_000);
        if (value < 0) {
            value *= -1;
        }
        return value;
    }

}
