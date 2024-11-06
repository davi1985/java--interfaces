package application;

import model.entities.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main6 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        String path = "employees.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String employeeCsv = reader.readLine();

            while (employeeCsv != null) {
                String[] fields = employeeCsv.split(",");
                list.add(new Employee(fields[0], Double.parseDouble(fields[1])));
                employeeCsv = reader.readLine();
            }

            Collections.sort(list);

            for (Employee employee : list) {
                System.out.println(employee.getName() + ", " + employee.getSalary());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
