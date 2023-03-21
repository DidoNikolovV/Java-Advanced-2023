package _00_Review;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class __00_ReviewMain {

    enum Color {
        RED,
        GREEN,
        BLUE,
        YELLOW
    }

    static class UnknownEnumValueException extends RuntimeException {
        public UnknownEnumValueException(Enum enumValue) {
            super("Unknown value " + enumValue + " for enum " + enumValue.getClass().getSimpleName());
        }

    }

    public static void main(String[] args) {
        Class<Person> personClass = Person.class;
        Person dido = new Person("Dido", 21);
        String ageFieldName = "age";

        try {
            Field ageField = personClass.getDeclaredField(ageFieldName);
            System.out.println(ageField.getName());

            ageField.setAccessible(true);
            System.out.println(ageField.getInt(dido));
            ageField.setInt(dido, -5);
            System.out.println(ageField.getInt(dido));

        } catch(NoSuchFieldException e) {
            System.out.println("Couldn't find field " + ageFieldName);
        } catch (IllegalAccessException e) {
            System.out.println("Couldn't access field " + ageFieldName);
        }

        System.out.println(dido.getAge());

    }
}
