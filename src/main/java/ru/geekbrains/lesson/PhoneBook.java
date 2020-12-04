package ru.geekbrains.lesson;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook implements checkPhoneNumber {

    Map<String, Person> phoneBook;
    Person person;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void addNewContact(String surname, String email, String phoneNumber) {

        person = new Person(surname, email, phoneNumber);
        phoneBook.put(surname, person);
    }

    public void addAnotherEmail(String surname, String emails) {
        if (phoneBook.containsKey(surname))
            phoneBook.get(surname).setAnotherEmail(emails);
        else {
            System.out.print("Такого контакта не существует, желаете создать? (1-да): ");
            if (new Scanner(System.in).nextInt() == 1) {
                while (true) {
                    System.out.println("Введите номер телефона (только числа от 5 до 10 знаков включительно ): ");
                    String newPhoneNumber = new Scanner(System.in).nextLine();

                    if (checkPhoneNumber(newPhoneNumber)) {
                        addNewContact(surname, emails, newPhoneNumber);
                        break;
                    }
                }
            }
        }
    }

    public void addAnotherPhoneNumber(String surname, String phoneNumber) {

        if (phoneBook.containsKey(surname))
            phoneBook.get(surname).setAnotherPhoneNumber(phoneNumber);
        else {
            System.out.print("Такого контакта не существует, желаете создать? (1-да): ");
            if (new Scanner(System.in).nextInt() == 1) {
                addNewContact(surname, "", phoneNumber);
            }
        }
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
