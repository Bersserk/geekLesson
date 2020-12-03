package ru.geekbrains.lesson;

public class Main {

    static String stringCorrect = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";   // безошибочная входящая строка
    static String stringTest1 = "1 1 H 1\nL 1 1 1\n1 K 1 1\n1 1 1 'g'";  // строка имеющая нечисловые значения
    static String stringTest2 = "10 32 1 2\n2 3 22 2\n51 6 7 1\n300 3 1 0 5 78";  // строка имеющая длину не соответствующая матрицы 4х4

    public static void main(String[] args) {

        System.out.println("Результат корректного значения = " + mathResultFromArray(matrixToArray(stringCorrect)) + "\n");
        System.out.println("Результат с нечисловыми значениями = " + mathResultFromArray(matrixToArray(stringTest1)) + "\n");
        System.out.println("Результат строки не подходящей длины = " + mathResultFromArray(matrixToArray(stringTest2)));

    }

    public static String[][] matrixToArray(String matrix) {
        String[][] arrStr = new String[4][4];
        int i = 0;
        int j = 0;

        for (String s : matrix.replaceAll("\\r|\\n", " ").split(" ")) {
            if (j == 4) {
                j = 0;
                i++;
            }

            if (i == 4) {
                try {
                    throw new NoPlaceArrayException();   // кастомный exception
                } catch (NoPlaceArrayException e) {
                    e.setMessage(s);
                }
            } else {
                arrStr[i][j] = s;
                j++;
            }
        }
        return arrStr;
    }

    public static int mathResultFromArray(String[][] array) throws NumberFormatException {

        int result = 0;

        for (String[] a : array) {
            for (String i : a) {

                if (!(i.matches("-?\\d+(\\.\\d+)?"))) {
                    try {
                        throw new NumberFormatException();
                    } catch (NumberFormatException e) {
                        System.out.println("Ошибочное значение - " + i);
                    }
                } else
                    result += Integer.parseInt(i);
            }
        }

        return result / 2;
    }
}
