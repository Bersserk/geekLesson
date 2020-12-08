package ru.geekbrains.lesson;

import java.util.ArrayList;

public class Person {
    private int id;

    private ArrayList emails = new ArrayList();
    private ArrayList phoneNumbers = new ArrayList();

    Person(int id, String email, String phoneNumber) {
        this.id = id;
        this.emails.add(email);
        this.phoneNumbers.add(phoneNumber);
    }

    int getId() {
        return id;
    }

    ArrayList getEmails() {
        return emails;
    }

    ArrayList getPhoneNumbers() {
        return phoneNumbers;
    }
}
