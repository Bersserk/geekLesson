package ru.geekbrains.lesson;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    Map <String, Person> phoneBook;

    Person person;

    public PhoneBook() {

        phoneBook = new HashMap<>();
    }

    public void addNewContact(String surname, String email, String phoneNumber) {
        Person person = new Person(surname, email, phoneNumber);
        phoneBook.put(surname, person);
    }

    public void addAnotherEmail(String surname, String emails) {
        // проверяем, есть ли уже контакт с такой фамилией, если нет, создаем
        // если контакт есть, добавляем email в его список
        phoneBook.get(surname).setAnotherEmail(emails);
    }

    public void addAnotherPhoneNumber(String surname, String phoneNumber) {
        // проверяем, есть ли уже контакт с такой фамилией, если нет, создаем
        // если контакт есть, добавляем phoneNumber в его список
        phoneBook.get(surname).setAnotherPhoneNumber(phoneNumber);
    }

    public void getEmails(String surname) {
        // если контакта с таким именем еще нет, вывести уведомление
        person = phoneBook.get(surname);
        System.out.println("emails контакта " + surname + ": " + person.getEmails());
    }

    public void getPhoneNumbers(String surname) {
        // если контакта с таким именем еще нет, вывести уведомление
        person = phoneBook.get(surname);
        System.out.println("номера контакта " + surname + ": " + person.getPhoneNumbers());
    }
}
