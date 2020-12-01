package ru.geekbrains.lesson;

public class Main {

    static String string = "10 3 1 2\n2 3 2 2\n5 6 7 1\n300 3 1 0";
    public static String [][] arrStr;
    static int i = 0;
    static int j = 0;
    static String tmp;

    public static void main(String[] args) {
        arrStr = new String[4][4];

        tmp = string.replaceAll("\\r|\\n", " ");
        String [] tmp2 = tmp.split(" ");

        //String [] str = string.split();

        //String s = str.toString();

        System.out.println(string.replaceAll("\\r|\\n", " ").split(" ").length);



        //System.out.println(tmp);

//        for (String s: str){
//            if(j == 4){
//                i++;
//                j=0;
//            }
//            arrStr[i][j] = s;
//            j++;
//        }


//
//        int k = 0;
//
//        for (int i = 0; i < arrStr.length; i++) {
//            for (int j = 0; j < arrStr.length; j++) {
//                if (string.substring(k) != " ")
//                arrStr[i][j] = string.substring(k);
//                k++;
//            }
//        }



    }

    public static int [][] matrixToArray (String matrix){



        return null;
    }
}
