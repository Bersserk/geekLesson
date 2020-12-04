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

        main.newContact("Иванов", "jack@g.com", "0111111111");
        main.newContact("Иванов", "jack2@g.com", "0222222222");
        main.newContact("Иванов", "jack3@g.com", "0333333333");

        main.searchPhoneNumber("Иванов");

//        main.addEmail("Jack", "jack@mail.ru");
//        main.addPhoneNumber("Jack", "07312345066");

//        main.addEmail("Fill", "fill@mail.ru");
//        main.addPhoneNumber("Fill", "0999999999");
//
//        main.searchEmail("Jack");
//        main.searchEmail("Fill");
//        main.searchPhoneNumber("Fill");
//
//        main.addEmail("Rocky", "rocky@mail.ru");
//        main.searchEmail("Rocky");
//        main.searchPhoneNumber("Rocky");


    }


    public void newContact(String surname, String email, String phoneNumber) {
        if (checkPhoneNumber(phoneNumber))
            phoneBook.addNewContact(surname, email, phoneNumber);
    }

//    public void addPhoneNumber(String surname, String phoneNumber) {
//        if (checkPhoneNumber(phoneNumber))
//            phoneBook.addAnotherPhoneNumber(surname, phoneNumber);
//    }
//
//    public void addEmail(String surname, String email) {
//        phoneBook.addAnotherEmail(surname, email);
//    }
//
    // Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов)
    public void searchPhoneNumber(String surname) {
        phoneBook.getPhoneNumbers(surname);
    }
//
//    // Отдельный метод для поиска e-mail по фамилии
//    public void searchEmail(String surname) {
//        phoneBook.getEmails(surname);
//    }


}
