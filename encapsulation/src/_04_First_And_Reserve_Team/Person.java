package _04_First_And_Reserve_Team;

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
        if(firstName.length() < 3)  {
            throw new IllegalArgumentException("First name cannot be less than 3 symbols");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() < 3)  {
            throw new IllegalArgumentException("Last name cannot be less than 3 symbols");
        }
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age <= 0) {
            throw new IllegalArgumentException("Age cannot be zero or negative");
        }
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 460) {
            throw new IllegalArgumentException("Salary can't be less than 460.0");
        }
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
