package com.kodiatech.learn.java;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35),
                new Person("Diana", 20)
        );
        try {
            people.add(new Person("George", 22));
        }catch (Exception e){

        }
        // Affichage initial de la liste
        System.out.println("Liste initiale : " + people);

        // Tri par âge, puis par nom
        people.sort(
                Comparator.comparingInt(Person::age)
                        .thenComparing(Person::name)
        );
        /** Stream*/
        List<Person> sortedPeople = people.stream()
                .sorted(
                        Comparator.comparingInt(Person::age)
                                .thenComparing(Person::name)
                )
                .toList();

        System.out.println("Triée avec streams : " + sortedPeople);

        // Affichage du résultat
        System.out.println("Tri par âge et par nom : " + people);




        // Tri par âge croissant
        List<Person> sortedByAge = people.stream()
                .sorted(Comparator.comparingInt(Person::age))
                .toList();

        System.out.println("Triée par âge croissant : " + sortedByAge);

        people.sort(Comparator.comparingInt(Person::age));
        System.out.println("Liste originale après tri : " + people);

        //filter
        List<Person> filtered = people.stream()
                .filter(person -> person.age() > 25)
                .toList();

        System.out.println("Filtrer les personnes > 25 ans : " + filtered);



    }
}