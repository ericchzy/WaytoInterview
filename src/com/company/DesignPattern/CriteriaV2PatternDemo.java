package com.company.DesignPattern;

import java.util.ArrayList;
import java.util.List;

public class CriteriaV2PatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        //过滤列表中为单身且为女性的人员
        List<Person> singlePersons = FilterByCriteriaV2.filter(persons, (Person person) -> "Single".equalsIgnoreCase(person.getMaritalStatus()) && "Female".equalsIgnoreCase(person.getGender()));
        CriteriaPatternDemo.printPersons(singlePersons);

        //过滤列表中大于等于2的整数
        List<Integer> resultIntegerList = FilterByCriteriaV2.filter(integers, (Integer integerObject) -> integerObject >= 2);
        printIntegerList(resultIntegerList);
    }

    public static void printIntegerList(List<Integer> objectList){
        System.out.println("List length: " + objectList.size());

        for (Integer object : objectList) {
            System.out.println(object);
        }
    }
}
