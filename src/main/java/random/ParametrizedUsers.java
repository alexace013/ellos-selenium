package random;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ParametrizedUsers {

    @Test(dataProvider = "users")
    public void test0(String user, String password) throws InterruptedException {
        Thread.sleep(1000);
    }

    @DataProvider
    public Iterator<Object[]> users() {

        List<Object[]> data = new ArrayList<Object[]>();

        data.add(new Object[]{"admin", "admin"});
        data.add(new Object[]{"guest", "guest"});
        data.add(new Object[]{"root", "root123"});

        for (int i = 0; i < 10; i++) {
            data.add(new Object[]{
                    generateRandomName(), generateRandomPassword()
            });
        }

        return data.iterator();

    }

    private Object generateRandomName() {
        return "user" + new Random().nextInt();
    }

    private Object generateRandomPassword() {
        return "pass" + new Random().nextInt();
    }

}
