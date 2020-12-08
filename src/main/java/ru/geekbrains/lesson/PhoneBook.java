package ru.geekbrains.lesson;

import java.util.*;

public class PhoneBook implements checkPhoneNumber {

    private Person person;
    private List<Person> listPersons;
    private Map<String, List> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    void addNewContact(String surname, String email, String phoneNumber) {

        if (phoneBook.containsKey(surname)) {

            int count = phoneBook.get(surname).size();
            phoneBook.get(surname).add(new Person(++count, email, phoneNumber));

        } else {
            int id = 1;
            listPersons = new LinkedList<>();
            listPersons.add(new Person(id, email, phoneNumber));
            phoneBook.put(surname, listPersons);
        }
    }

    void getEmails(String surname) {
        if (phoneBook.containsKey(surname)) {

            Iterator<Person> iterator = readList(surname, "Список контактов и их email's по фамилии ");

            while (iterator.hasNext()) {
                person = iterator.next();
                System.out.println(person.getId() + ". " + person.getEmails());
            }
        } else
            System.out.println("Контактов по фамилии " + surname + " не существует");
    }

    void getPhoneNumbers(String surname) {
        if (phoneBook.containsKey(surname)) {

            Iterator<Person> iterator = readList(surname, "Список контактов и их телефоны по фамилии ");

            while (iterator.hasNext()) {
                person = iterator.next();
                System.out.println(person.getId() + ". " + person.getPhoneNumbers());
            }
        } else
            System.out.println("Контактов по фамилии " + surname + " не существует");
    }

    private Iterator<Person> readList(String surname, String consoleText) {
        listPersons = phoneBook.get(surname);
        Iterator<Person> iterator = listPersons.iterator();
        System.out.println(consoleText + surname);
        return iterator;
    }
}
