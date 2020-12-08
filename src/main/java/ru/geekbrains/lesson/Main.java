package ru.geekbrains.lesson;

public class Main implements checkPhoneNumber {

    PhoneBook phoneBook;

    public Main(PhoneBook phoneBook) {
        this.phoneBook = phoneBook;
    }

    public static void main(String[] args) {
        // решения первого задания
        System.out.println("РЕЗУЛЬТАТ РАБОТЫ ПЕРВОГО ЗАДАНИЯ:");
        Words w = new Words("InputText");
        w.getListWords();
        w.getNumberWordsFromList();

        // решения второго задания
        System.out.println("\nРЕЗУЛЬТАТ РАБОТЫ ВТОРОГО ЗАДАНИЯ:");
        Main main = new Main(new PhoneBook());

        // методы добавления контактов
        main.newContact("Иванов", "ivanov1@gmail.com", "011");
        main.newContact("Иванов", "ivanov2@gmil.com", "0222222222");
        main.newContact("Иванов", "ivanov3@gmail.com", "0333333333");
        main.newContact("Петров", "petrov1@gmail.com", "0444444444");
        main.newContact("Иванов", "ivanov4@gmail.com", "055555555");
        main.newContact("Петров", "petrov2@gmail.com", "0666666666");
        main.newContact("Васильев", "petrov2@gmail.com", "0777777777р");

        // методы поиска
        main.searchPhoneNumber("Иванов");
        main.searchEmail("Иванов");

        main.searchPhoneNumber("Петров");

        main.searchPhoneNumber("Васильев");
    }


    public void newContact(String surname, String email, String phoneNumber) {
        if (checkPhoneNumber(phoneNumber))
            phoneBook.addNewContact(surname, email, phoneNumber);
    }

    // Отдельный метод для поиска номера телефона по фамилии (ввели фамилию, получили ArrayList телефонов)
    public void searchPhoneNumber(String surname) {
        phoneBook.getPhoneNumbers(surname);
    }

    // Отдельный метод для поиска e-mail по фамилии
    public void searchEmail(String surname) {
        phoneBook.getEmails(surname);
    }
}
