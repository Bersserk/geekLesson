package ru.geekbrains.lesson;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static final char TURN_X = 'X';
    public static final char TURN_O = 'O';
    public static final char EMPTY_CELL = '_';
    static int lenWin = 0;  // условие длины выиграшной линии
    static int sizeBoard = 0;  // размер поля
    static int [] arrX = new int[1];
    static int [] arrO = new int[1];
    static int win, win10, win11;
    static int cellX, cellY;
    static String nameGamer1;
    static String nameGamer2;
    static char [][] board;
    static boolean secondPlayerPC;

    public static void main(String[] args) {

        setGameBoard ();
        setWinLine ();
        setSecondPlayer ();
        setNamePlayers ();

        arrX = new int[sum(sizeBoard)];
        arrO = new int[sum(sizeBoard)];

        game ();
    }

    private static void setSecondPlayer() {
        text("выберите '1' если желаете сразиться с компьютером, '2' если друг против друга");
        int chose = new Scanner(System.in).nextInt();

        boolean flag;
        do {
            flag = false;
            switch (chose) {
                case 1:
                    secondPlayerPC = true;
                    break;
                case 2:
                    secondPlayerPC = false;
                    break;
                default:
                    text("некорректный выбор!!! Выберите '1' если желаете сразиться с компьютером, '2' если друг против друга");
                    flag = true;
                    break;
            }
        }while (flag);
    }


    private static void game() {

        do {
            if (turnPlayers(turn(nameGamer1, TURN_X), arrX)) {
                text("player 1 win");
                break;
            } else if (isNobodyWon()){
                text("ничья");
                break;
            } else if (turnPlayers(turn(nameGamer2, TURN_O), arrO)) {
                text("player 2 win");
                break;
            } else if (isNobodyWon()){
                text("ничья");
                break;
            }
        }while (true);


    }

    private static boolean isNobodyWon (){

        boolean nobodyWon = true;

        for (char [] k :board){
            for(int i: k){
                if(i == '_')
                    nobodyWon = false;
            }
        }

        return nobodyWon;
    }


    private static int turn (String nameGamer, char c){

        boolean flag = true;

        do {

            if(nameGamer == "Компьютер"){
                cellX = (int) (Math.random() * (sizeBoard) + 1);
                cellY = (int) (Math.random() * (sizeBoard) + 1);
            }else {
                text(nameGamer + " введите номер выбранной строки от 1 до " + sizeBoard);
                cellX = new Scanner(System.in).nextInt();
                text(nameGamer + " введите номер выбранного столбца от 1 до " + sizeBoard);
                cellY = new Scanner(System.in).nextInt();
            }

            if(cellX > 0 && cellY > 0 && cellX <= sizeBoard && cellY <= sizeBoard && (emptyCell(cellX-1, cellY-1))) {
                board[cellX - 1][cellY - 1] = c;
                if (nameGamer == "Компьютер"){
                    text("Компьютер ход сделал!!!");
                }
                printGameBoard(board);
                flag = false;
            } else if (!(cellX > 0 && cellY > 0 && cellX <= sizeBoard && cellY <= sizeBoard)){
                if(nameGamer != "Компьютер") {
                    printGameBoard(board);
                    text("Вы ввели некорректное значение! Еще раз...");
                }
            } else {
                if(nameGamer != "Компьютер") {
                    printGameBoard(board);
                    text("Ячейка занята! Выберите другую...");
                }
            }

        } while (flag);

        return cellX*10+cellY;
    }



    public static boolean turnPlayers (int turn, int [] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {  // заполняет ближайшую не занятую ячейку массива
            if(arr[i] == 0){
                arr[i] = turn;
                break;
            }
        }

        return isWin(sortArr(arr));
    }

    public static int [] sortArr (int [] _arrTurn){
        int j;

        for(int i = _arrTurn.length-1 ; i > 0 ; i--){
            for(j = 0; j < i ; j++){
                if( _arrTurn[j] > _arrTurn[j+1] ){
                    int tmp = _arrTurn[j];
                    _arrTurn[j] = _arrTurn[j+1];
                    _arrTurn[j+1] = tmp;
                }
            }
        }
        return _arrTurn;
    }

    public static boolean isWin (int [] arr){

        boolean playerWin = false;
        win = 1;
        win10 = 1;
        win11 = 1;

        for (int i = arr.length-1; i > 0; i--){
            win = 1;
            win10 = 1;
            win11 = 1;

            for (int k = i-1; k >= 0; k--){

                if(arr[i] - arr[k] == 1){
                    win++;
                    i--;
                }else if (arr[i] - arr[k] == 10){
                    win10++;
                    i--;
                }else if(arr[i] - arr[k] == 11){
                    win11++;
                    i--;
                }
            }

            if(win == lenWin || win10 == lenWin || win11 == lenWin){
                playerWin = true;
                break;
            }
        }

        return playerWin;

    }

    private static int sum (int sizeBoard) {  // высчитывает максимально возможное кол-во ходов
        int t = 0;
        if (sizeBoard%2 != 0){
            t = (sizeBoard*sizeBoard+1)/2;
        } else {
            t = sizeBoard*sizeBoard/2;
        }
        return t;
    }

    private static void printGameBoard (char[][] board) {
        for (int i = 0; i < sizeBoard; i++){
            for (int y = 0; y < sizeBoard; y++){
                System.out.print((board[i][y]) + "|");
            }
            System.out.println();
        }
    }

   /* public static boolean onBoard (int cellX, int cellY){
        int x = cellX - 1;
        int y = cellY - 1;

        return (x >= 0 && x <= sizeBoard && y >= 0 && y <= sizeBoard);
    }

    */


    public static boolean emptyCell (int cellX, int cellY){
        if (cellX >= 0 && cellX <= sizeBoard && cellY >= 0 && cellY <= sizeBoard)
            return board[cellX][cellY] == EMPTY_CELL;
        else
            return false;
    }

    private static void text(String s) {
        System.out.println(s);
    }


    public static void setGameBoard(){
        do {
            if(sizeBoard != 0) {
                System.out.println("Вы ввели значение не соответствующие требованию...");
            }

            System.out.println("Задайте размер игрового поля!? (Число целое от 3 до 'сколько хотите')");
            sizeBoard = new Scanner(System.in).nextInt();
            board = new char[sizeBoard][sizeBoard];

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    board[i][j] = EMPTY_CELL;
                }
            }
        } while (sizeBoard < 3);
    }

    private static void setWinLine() {
        do {
            if(lenWin != 0) {
                System.out.println("Вы ввели значение не соответствующие требованию...");
            }

            if (sizeBoard > 3) {
                System.out.println("Задайте длину победной линии!? (Число целое от 3 до " + sizeBoard);
                lenWin = new Scanner(System.in).nextInt();
            } else {
                lenWin = 3;
            }
        }while (!(lenWin >= 3 && lenWin <= sizeBoard));
    }

    private static void setNamePlayers() {
        System.out.println("Как будут звать первого игрока?");
        nameGamer1 = new Scanner(System.in).nextLine();

        if(secondPlayerPC){
            nameGamer2 = "Компьютер";
        } else {
            System.out.println("Как будут звать второго игрока?");
            nameGamer2 = new Scanner(System.in).nextLine();
        }
    }
}



