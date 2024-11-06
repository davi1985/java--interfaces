package model.entities;

public class Employee implements Comparable<Employee> {

    private String name;
    private Double salary;

    public Employee(final String name, final Double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(final Double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(final Employee object) {
        return salary.compareTo(object.getSalary());
    }
}
