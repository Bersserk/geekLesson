package ru.geekbrains.lesson;

public class Main {

    private static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        // решения первого задания
        Words w = new Words("InputText");
        w.getListWords();
        System.out.println("stop program");
        w.getNumberWordsFromList();

        // решения второго задания

        phoneBook.addNewContact ("Jack", "jack@g.com", "066_123_45_66");
        phoneBook.addAnotherEmail("Jack", "jack@mail.ru");
        phoneBook.addAnotherPhoneNumber("Jack", "073_123_45_66");

        phoneBook.addNewContact("Fill", "fill@gmail.com", "056_151_32_85");
        phoneBook.addAnotherEmail("Fill", "fill@mail.ru");
        phoneBook.addAnotherPhoneNumber("Fill", "099_999_99_99");

        phoneBook.getEmails ("Jack");
        phoneBook.getPhoneNumbers ("Jack");
        phoneBook.getEmails ("Fill");
        phoneBook.getPhoneNumbers ("Fill");


    }
}
