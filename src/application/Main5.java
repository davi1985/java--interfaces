package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main5 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        String path = "in.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String name = reader.readLine();

            while (name != null) {
                list.add(name);
                name = reader.readLine();
            }

            Collections.sort(list);

            for (String item : list) {
                System.out.println(item);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
