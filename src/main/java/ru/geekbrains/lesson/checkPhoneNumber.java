package ru.geekbrains.lesson;

public interface checkPhoneNumber {

    int MIN_SIZE_PHONE_NUM = 4;
    int MAX_SIZE_PHONE_NUM = 16;

    default boolean checkPhoneNumber(String s) {
        boolean result = false;

        try {
            if (s.length() > MIN_SIZE_PHONE_NUM && s.length() < MAX_SIZE_PHONE_NUM && Long.parseLong(s) > 0) {
                result = true;
            } else if (s.length() > MIN_SIZE_PHONE_NUM) {
                System.out.println("Номер \"" + s + "\" слишком длинный. Допустимо от 5 до 15 символов включительно");
            } else {
                System.out.println("Номер \"" + s + "\" слишком короткий. Допустимо от 5 до 15 символов включительно");

            }
        } catch (NumberFormatException e) {
            System.out.println(e.getLocalizedMessage() + " - некорректное значение. Допускаются только цифры");
        }
        return result;
    }
}
