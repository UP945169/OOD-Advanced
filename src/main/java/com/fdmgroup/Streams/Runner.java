package com.fdmgroup.Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Runner {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Smith", 17);
        Person person2 = new Person("Jane", "Jones", 25);
        Person person3 = new Person("Tom", "Williams", 35);

        List<Person> people = new ArrayList<>(Arrays.asList(person1, person2, person3));

        Person[] personArray = {person1,person2,person3};


        people.stream();
        //Arrays.stream(personArray);

        Predicate<Person> ageOver30 = person -> person.getAge() > 30;
        people.stream().filter(ageOver30);

        Function<Person, Integer> ageOfPerson = person -> person.getAge();
        people.stream().map(ageOfPerson);

        people.stream().filter(ageOver30).map(ageOfPerson);

    }
}
