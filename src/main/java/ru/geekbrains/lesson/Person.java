package ru.geekbrains.lesson;

import java.util.ArrayList;

public class Person {
    private String surname;

    private ArrayList emails = new ArrayList();
    private ArrayList phoneNumbers = new ArrayList();

    public Person(String surname, String email, String phoneNumber) {
        this.surname = surname;
        this.emails.add(email);
        this.phoneNumbers.add(phoneNumber);
    }


    public ArrayList getEmails() {
        return emails;
    }

    public ArrayList getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setAnotherEmail(String anotherEmail) {
        emails.add(anotherEmail);
    }

    public void setAnotherPhoneNumber(String anotherPhoneNumber) {
        phoneNumbers.add(anotherPhoneNumber);
    }
}
