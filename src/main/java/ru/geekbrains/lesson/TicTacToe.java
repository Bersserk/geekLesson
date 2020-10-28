package ru.geekbrains.lesson;

import java.util.Scanner;

public class TicTacToe {

    public static final char TURN_X = 'X';
    public static final char TURN_O = 'O';
    public static final char EMPTY_CELL = '_';

    public static int cellX, cellY;

    static int boardSize = 3;


    static char [][] board;
    static int [] arrTurn_X = new int [3];
    static int [] arrTurn_Y = new int [3];

    public static void main(String[] args) {

        dialogText("");
        startGame();
        messageText();
    }


    private static void dialogText(String s) {
        System.out.println(s);
    }

    private static void text(String s) {
        System.out.println(s);
    }

    private static void startGame() {

        int countTurn = 0;
        initGameBoard(boardSize);


        do {
            turn(board, TURN_X);
            //  вызываем метод условия победы для первого игрока
            if(isNotWinner(++countTurn) || isVictory())
                break;
            turn(board, TURN_O);
            //  вызываем метод условия победы для второго игрока
            if(isNotWinner(++countTurn) || isVictory())
                break;
        } while (true);

    }

    private static void printGameBoard(char[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int y = 0; y < boardSize; y++){
                System.out.print((board[i][y]) + "|");
            }
            System.out.println();
        }
    }

    private static void messageText() {

    }


    public static boolean isVictory (int [] arrTurn){   // метод условия победы игрока



        return true;
    }

    public static boolean isNotWinner (int countTurn){
        if (boardSize * boardSize == countTurn){
            text("Ничья");
            return true;
        } else
            return false;
    }

    public static void initGameBoard (int boardSize ){
        board = new char [boardSize][boardSize];

        for (int i = 0; i < board.length; i++){
            for (int y = 0; y < boardSize; y++){
                System.out.print((board[i][y] = EMPTY_CELL) + "|");
            }
            System.out.println();
        }
    }

    public static char [][] turn (char [][] board, char TURN){

            boolean flag = true;

            do {

                text("Введите номер выбранной строки от 1 до " + boardSize);
                cellX = new Scanner(System.in).nextInt();
                text("Введите номер выбранного столбца от 1 до " + boardSize);
                cellY = new Scanner(System.in).nextInt();

                if(cellX > 0 && cellY > 0 && cellX <= boardSize && cellY <= boardSize && (emptyCell(cellX-1, cellY-1))) {
                    board[cellX - 1][cellY - 1] = TURN;
                    printGameBoard(board);
                    flag = false;
                } else if (!(cellX > 0 && cellY > 0 && cellX <= boardSize && cellY <= boardSize)){
                    printGameBoard(board);
                    text("Вы ввели некорректное значение! Еще раз...");
                } else {
                    printGameBoard(board);
                    text("Ячейка занята! Выберите другую...");
                }
            } while (flag);

        return board;
    }



    public static boolean emptyCell (int cellX, int cellY){
        if (cellX >= 0 && cellX <= boardSize && cellY >= 0 && cellY <= boardSize)
            return board[cellX][cellY] == EMPTY_CELL;
        else
            return false;
    }

    public static boolean onBoard (int cellX, int cellY){
        int x = cellX - 1;
        int y = cellY - 1;

        return (x >= 0 && x <= boardSize && y >= 0 && y <= boardSize);
    }
}
