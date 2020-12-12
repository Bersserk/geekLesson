package ru.geekbrains.lesson;

public class Main {

    private final static int SIZE = 10_000_000;

    private static float[] filledArray;
    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {

        filledArray();

        float timeWork = calculateTimeWork();
        float timeWorkInThreads = calculateTimeWorkInThreads();

        System.out.println("Время выполнения метода без потоков: " + timeWork + " миллисекунд");
        System.out.println("Время выполнения метода на потоках: " + timeWorkInThreads + " миллисекунд");
        System.out.println("Потоки работают на: " + (int) ((timeWork - timeWorkInThreads) / timeWork * 100) + " % быстрее");
    }

    private static long calculateTimeWork() {
        startTime = System.currentTimeMillis();

        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = (float) (filledArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private static long calculateTimeWorkInThreads() {
        startTime = System.currentTimeMillis();

        int halfSizeArray = filledArray.length / 2;

        float[] tmp1 = new float[halfSizeArray];
        System.arraycopy(filledArray, 0, tmp1, 0, halfSizeArray);
        float[] tmp2 = new float[halfSizeArray];
        System.arraycopy(filledArray, halfSizeArray, tmp2, 0, halfSizeArray);

        calculateInThread(tmp1);
        calculateInThread(tmp2);

        System.arraycopy(tmp1, 0, filledArray, 0, tmp1.length);
        System.arraycopy(tmp2, 0, filledArray, halfSizeArray, tmp2.length);

        endTime = System.currentTimeMillis();

        return endTime - startTime;

    }

    private static void calculateInThread(float[] tmpArray) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < tmpArray.length; i++) {
                    tmpArray[i] = (float) (tmpArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
                }
            }
        }).start();
        Thread.interrupted();
    }

    private static void filledArray() {
        filledArray = new float[SIZE];
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = 1;
        }
    }


}
