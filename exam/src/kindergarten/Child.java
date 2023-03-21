package kindergarten;

import java.util.Comparator;

public class Child implements Comparable<Child> {
    private String firstName;
    private String lastName;
    private int age;
    private String parentName;
    private String contactNumber;

    public Child(String firstName, String lastName, int age, String parentName, String contactNumber) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAge(age);
        this.setParentName(parentName);
        this.setContactNumber(contactNumber);
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

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    @Override
    public String toString() {
        return String.format("Child: %s %s, Age: %d, Contact info: %s - %s",
                this.getFirstName(),
                this.getLastName(),
                this.getAge(),
                this.getParentName(),
                this.getContactNumber()
        );
    }

    @Override
    public int compareTo(Child o) {
        int result = this.getAge() - o.getAge();

        if(result == 0) {
            result = this.getFirstName().compareTo(o.getFirstName());

        }

        if(result == 0) {
            result = this.getLastName().compareTo(o.getLastName());
        }

        return result;
    }
}
