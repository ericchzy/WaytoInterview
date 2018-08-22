package com.company.DesignPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象标准的模式就是太啰嗦了，每新增一个筛选标准都要新增一个类，为此我们可以使用匿名类
 */

public class CriteriaPatternDemo {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();

        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("John","Male", "Married"));
        persons.add(new Person("Laura","Female", "Married"));
        persons.add(new Person("Diana","Female", "Single"));
        persons.add(new Person("Mike","Male", "Single"));
        persons.add(new Person("Bobby","Male", "Single"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();
        Criteria single = new CriteriaSingle();
        Criteria singleMale = new AndCriteria(single, male);

        System.out.println("Males: ");
        printPersons(male.meetCriteria(persons));

        System.out.println("\nFemales: ");
        printPersons(female.meetCriteria(persons));

        System.out.println("\nSingle Males: ");
        printPersons(singleMale.meetCriteria(persons));

        System.out.println("\nSingle Females: ");
        printPersons(new Criteria() {
            List<Person> result = new ArrayList<>();
            @Override
            public List<Person> meetCriteria(List<Person> persons) {
                for (Person person : persons) {
                    if (person.getGender().equalsIgnoreCase("Female") && person.getMaritalStatus().equalsIgnoreCase("Single")) {
                        result.add(person);
                    }
                }
                return result;
            }
        }.meetCriteria(persons));

//        printPersons(filterPersonByCriteria(persons, (List<Person> personList) -> ));
    }

    public static void printPersons(List<Person> persons){
        for (Person person : persons) {
            System.out.println("Person : [ Name : " + person.getName()
                    +", Gender : " + person.getGender()
                    +", Marital Status : " + person.getMaritalStatus()
                    +" ]");
        }
    }

/*    public static List<Person> filterPersonByCriteria(List<Person> persons, Criteria criteria) {
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (criteria.meetCriteria(person));
            result.add(person);
        }
        return result;
    }*/
}
