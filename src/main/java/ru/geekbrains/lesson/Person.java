package ru.geekbrains.lesson;

import java.util.ArrayList;

public class Person {
    private int id;
    private String surname;

    private ArrayList emails = new ArrayList();
    private ArrayList phoneNumbers = new ArrayList();

    Person(int id, String surname, String email, String phoneNumber) {
        this.id = id;
        this.surname = surname;
        this.emails.add(email);
        this.phoneNumbers.add(phoneNumber);
    }

    public int getId() {
        return id;
    }

    ArrayList getEmails() {
        return emails;
    }

    ArrayList getPhoneNumbers() {
        return phoneNumbers;
    }

    void setAnotherEmail(String anotherEmail) {
        emails.add(anotherEmail);
    }

    void setAnotherPhoneNumber(String anotherPhoneNumber) {
        phoneNumbers.add(anotherPhoneNumber);
    }
}
