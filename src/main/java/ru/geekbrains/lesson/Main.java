package ru.geekbrains.lesson;

public class Main {

    private final static int SIZE = 10_000_000;

    private static long startTime;
    private static long endTime;

    public static void main(String[] args) {

        float timeWork = calculateTimeWork();
        float timeWorkInThreads = calculateTimeWorkInThreads();

        System.out.println("Время выполнения метода без потоков: " + timeWork + " миллисекунд");
        System.out.println("Время выполнения метода на потоках: " + (timeWorkInThreads) + " миллисекунд");
        System.out.println("Потоки работают на: " + (int) ((timeWork - timeWorkInThreads) / timeWork * 100) + " % быстрее");
    }


    private static long calculateTimeWork() {
        float[] filledArray = filledArray();
        startTime = System.currentTimeMillis();

        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = (float) (filledArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    private static long calculateTimeWorkInThreads() {
        float[] filledArray = filledArray();
        startTime = System.currentTimeMillis();

        int halfSizeArray = filledArray.length / 2;

        float[] tmpArray1 = new float[halfSizeArray];
        System.arraycopy(filledArray, 0, tmpArray1, 0, halfSizeArray);
        float[] tmpArray2 = new float[halfSizeArray];
        System.arraycopy(filledArray, halfSizeArray, tmpArray2, 0, halfSizeArray);

        Thread thread1 = new Thread(new MyThread(tmpArray1));
        Thread thread2 = new Thread(new MyThread(tmpArray2));
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(tmpArray1, 0, filledArray, 0, tmpArray1.length);
        System.arraycopy(tmpArray2, 0, filledArray, halfSizeArray, tmpArray2.length);

        endTime = System.currentTimeMillis();

        return endTime - startTime;
    }

    private static float[] filledArray() {
        float[] filledArray = new float[SIZE];
        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = 1;
        }

        return filledArray;
    }
}


class MyThread implements Runnable {
    float[] tmp;

    public MyThread(float[] tmp) {
        this.tmp = tmp;
    }

    @Override
    public void run() {
        calculateInThread(tmp);
    }

    private void calculateInThread(float[] tmpArray) {
        for (int i = 0; i < tmpArray.length; i++) {
            this.tmp[i] = (float) (tmpArray[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}


