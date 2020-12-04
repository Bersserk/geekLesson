package ru.geekbrains.lesson;

public class Main implements checkPhoneNumber {

    PhoneBook phoneBook;

    public Main(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public static void main(String[] args) {
        // решения первого задания
        Words w = new Words("InputText");
        w.getListWords();
        System.out.println("stop program");
        w.getNumberWordsFromList();

        // решения второго задания

        Main main = new Main(new PhoneBook());

        main.newContact("Jack", "jack@g.com", "99995658191");
        main.addEmail("Jack", "jack@mail.ru");
        main.addPhoneNumber( "Jack", "07312345066");

        main.newContact( "Fill", "fill@gmail.com", "0561513285");
        main.addEmail("Fill", "fill@mail.ru");
        main.addPhoneNumber("Fill", "0999999999");

        main.searchEmail("Jack");
        main.searchPhoneNumber("Jack");
        main.searchEmail("Fill");
        main.searchPhoneNumber("Fill");

        main.addEmail("Rocky", "rocky@mail.ru");
        main.searchEmail("Rocky");
        main.searchPhoneNumber("Rocky");


    }


    public void newContact(String surname, String email, String phoneNumber) {
        if (checkPhoneNumber(phoneNumber))
            phoneBook.addNewContact(surname, email, phoneNumber);
    }

    public void addPhoneNumber(String surname, String phoneNumber) {
        if (checkPhoneNumber(phoneNumber))
            phoneBook.addAnotherPhoneNumber(surname, phoneNumber);
    }

    public void addEmail(String surname, String email) {
        phoneBook.addAnotherEmail(surname, email);
    }

    public void searchPhoneNumber(String surname) {
        phoneBook.getPhoneNumbers(surname);
    }

    public void searchEmail(String surname) {
        phoneBook.getEmails(surname);
    }


}
