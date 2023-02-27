package _02_Salary_Increase;

public class Person {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
        setSalary(salary);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double actualBonus = bonus / 100;
        if(age < 30) {
            actualBonus /= 2;
        }

        double newSalary = this.salary + this.salary * actualBonus;
        this.setSalary(newSalary);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " gets " + salary + " leva";
    }
}
