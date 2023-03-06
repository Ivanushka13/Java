package davydoff;

import davydoff.models.Car;
import davydoff.models.Person;

public class Main {
    public static void main(String[] args) {

        Person person = new Person("Nickolay", "Chuikin", 24);

        //Car car = new Car("Mercedes", "AMG 6.3", "black", 2020);

        Application.run(person);
    }
}