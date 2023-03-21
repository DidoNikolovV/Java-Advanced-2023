package _00_Review;

class Person {
    private String name;
    private int age;


    public Person(String name, int age) {
        validateAge(age);
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    private void validateAge(int age) {
        if(age < 0) {
            throw new IllegalArgumentException("Expected non-negative value for age");
        }
    }
}
