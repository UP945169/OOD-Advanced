package com.fdmgroup.lambda;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

public class Runner {
    public static void main(String[] args) {
        Person person1 = new Person("Edgar","Afonso",27);
        Person person2 = new Person("John","Doe",35);
        Person person3 = new Person("Jane","Doe",50);
        List<Person> personList = new ArrayList<>(Arrays.asList(person1,person2,person3));
        System.out.println(getFullName(person1));

        Function<Person,String> getFullName = person -> person.getFirstName() + " " + person.getLastName();

        System.out.println(getFullName.apply(person1));

        BiFunction<Person,Integer,Integer> yearsToRetirement = (person, retirementAge) -> retirementAge - person.getAge();

        int person1years = yearsToRetirement.apply(person1, 65);

        System.out.println(person1years + " years to retire");

        Predicate<Person> oldEnoughToVote = person -> person.getAge() >= 18;
        boolean person1OldEnoughToVote = oldEnoughToVote.test(person1);

        System.out.println(person1OldEnoughToVote ? "Person 1 is old enough to vote" : "Person 1 is not old enough");

        Consumer<Person> printFirstName = person -> System.out.println(person.getFirstName());
        printFirstName.accept(person1);
        printFirstName.accept(person2);


        BinaryOperator<Person> getOldestAge = (PersonOne, PersonTwo) -> PersonOne.getAge() > PersonTwo.getAge()
                ? PersonOne : PersonTwo;
        Person oldestPerson = getOldestAge.apply(person1, person2);

        System.out.println("Oldest person is: " + oldestPerson.getAge());


        System.out.println("Testing java 8+ for each method");
        personList.forEach(printFirstName);
        System.out.println("Can also pass lambda expressions straight into the for each method");
        personList.forEach(person -> System.out.println(person.getFirstName()));
        System.out.println("=====Testing removeif======");
        personList.forEach(printFirstName);
        //personList.removeIf(oldEnoughToVote.negate());
        personList.forEach(printFirstName);

        System.out.println("=====Testing comparisons====");
        Comparator<Person> sortByFirstName = (PersonOne,PersonTwo) ->
                PersonOne.getFirstName().compareTo(PersonTwo.getFirstName());
        personList.sort(sortByFirstName);
        personList.forEach(printFirstName);


        /*System.out.println("=====combining predicates=====");
        Predicate<Person> over25 = person -> person.getAge() > 25;
        Predicate<Person> jName = person -> person.getFirstName().charAt(0) == 'J';
        Predicate<Person> over25AndNameStartsWithJ = over25.and(jName);
        personList.removeIf(over25AndNameStartsWithJ);*/

        personList.forEach(printFirstName);

        System.out.println("=====Combining comparators=====");
        Comparator<Person> sortByAge = (PersonOne, PersonTwo) -> PersonOne.getAge() - PersonTwo.getAge();

        Comparator<Person> sortByNameThenAge = sortByAge.thenComparing(sortByFirstName);

        personList.sort(sortByNameThenAge);
        personList.forEach(person -> System.out.println(person.getFirstName() + ": " + person.getAge()));
    }

    public static String getFullName(Person person){
        return person.getFirstName() + " " + person.getLastName();
    }
}
