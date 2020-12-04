package ru.geekbrains.lesson;

import java.util.*;

public class PhoneBook implements checkPhoneNumber {

    private Map <String, Map > phoneBook;
    private Person person;
    private Map <Integer, Person> arrayPersons;

    public PhoneBook() {
        phoneBook = new HashMap<>();
        arrayPersons = new HashMap<>();
    }

    void addNewContact(String surname, String email, String phoneNumber) {

        int id = arrayPersons.size() + 1;
        arrayPersons.put(id , new Person(id, surname, email, phoneNumber));
        phoneBook.put(surname, arrayPersons);
    }

//    void addAnotherEmail(String surname, String emails) {
//        if (phoneBook.containsKey(surname))
//            phoneBook.get(surname).setAnotherEmail(emails);
//        else {
//            System.out.print("Такого контакта не существует, желаете создать? (1-да): ");
//            if (new Scanner(System.in).nextInt() == 1) {
//                while (true) {
//                    System.out.println("Введите номер телефона (только числа от 5 до 10 знаков включительно ): ");
//                    String newPhoneNumber = new Scanner(System.in).nextLine();
//
//                    if (checkPhoneNumber(newPhoneNumber)) {
//                        addNewContact(surname, emails, newPhoneNumber);
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    void addAnotherPhoneNumber(String surname, String phoneNumber) {
//
//        if (phoneBook.containsKey(surname))
//            phoneBook.get(surname).setAnotherPhoneNumber(phoneNumber);
//        else {
//            System.out.print("Такого контакта не существует, желаете создать? (1-да): ");
//            if (new Scanner(System.in).nextInt() == 1) {
//                addNewContact(surname, "", phoneNumber);
//            }
//        }
//    }
//
//    void getEmails(String surname) {
//        // если контакта с таким именем еще нет, вывести уведомление
//        person = phoneBook.get(surname);
//        System.out.println("emails контакта " + surname + ": " + person.getEmails());
//    }
//
    void getPhoneNumbers(String surname) {
        // если контакта с таким именем еще нет, вывести уведомление

        //person = (Person) phoneBook.get(surname).get(2);

        //arrayPersons = phoneBook.get(surname);

        System.out.println("результат поиска по фамилии " + surname + ":");
        for (int i = 0; i < arrayPersons.size(); i++) {
            person = (Person) phoneBook.get(surname).get(i+1);
            System.out.println(person.getId() + "." + person.getPhoneNumbers() + "; " + person.getEmails());
        }

    }
}
