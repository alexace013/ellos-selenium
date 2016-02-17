package random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviders {

    public static Iterator<Object[]> loadUsersFromFile() throws IOException {

        BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("src/test/resources/user.data")));

        List<Object[]> usersData = new ArrayList<Object[]>();
        String str = bufReader.readLine();
        while (str != null) {
            usersData.add(str.split(";"));
            str = bufReader.readLine();
        }

        if (bufReader != null) {
            bufReader.close();
        }

        return usersData.iterator();

    }

}
