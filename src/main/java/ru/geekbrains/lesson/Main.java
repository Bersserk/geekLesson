package ru.geekbrains.lesson;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static int randomNumber;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int answer;
        int n = 3;

        do {
            System.out.println("Компьютер загадал для вас число от 0 до 9 включительно. У вас " + n + " попытки");
            randomNumber = new Random().nextInt(10);
            startGame(sc, n);
            System.out.println("Повторить игру еще раз? 1 – да / 0 – нет");

            while (true) {

                answer = sc.nextInt();
                if(answer == 1 || answer == 0)
                    break;
                System.out.println("Введите 1 – да / 0 – нет");
            }

        } while (answer == 1);

        System.out.println("Good By :)");

    }

    private static void startGame(Scanner sc, int n) {

        int answer;

        while (n > 0) {
            System.out.println("Введите ваш ответ?!");
            answer = sc.nextInt();
            n--;
            if (answer == randomNumber) {
                System.out.println("Поздравляем! Вы угадали :)");
                n = 0;
            }
            else if (n == 0)
                System.out.println("Вы не угадали!");
            else if (answer < randomNumber)
                System.out.println("Загаданное число больше! \nУ вас осталось " + n + " попытки");
            else if (answer > randomNumber)
                System.out.println("Загаданное число меньше!\nУ вас осталось " + n + " попытки");
        }
    }
}
