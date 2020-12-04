package ru.geekbrains.lesson;

import java.util.ArrayList;

public class Person {
    private String surname;

    private ArrayList emails = new ArrayList();
    private ArrayList phoneNumbers = new ArrayList();

    Person(String surname, String email, String phoneNumber) {
        this.surname = surname;
        this.emails.add(email);
        this.phoneNumbers.add(phoneNumber);
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
