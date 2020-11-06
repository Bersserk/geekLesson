package ru.geekbrains.lesson;

public class Main {

    public static void main(String[] args) {

        Dog sharik = new Dog("Шарик", 500, 0.5f, 50);
        sharik.run(55);
        sharik.jump(30);
        sharik.swim(55);

        Dog tuzik = new Dog("Тузик", 300, 0.5f, 50);
        tuzik.run(55);
        tuzik.jump(0.7f);
        tuzik.swim(45);

        Cat murzik = new Cat("Мурзик", 200, 2);
        murzik.swim(20);
        murzik.run(30);
        murzik.jump(45);

        Cat vaska = new Cat("Васька", 20, 15);
        vaska.swim(20);
        vaska.run(30);
        vaska.jump(45);

        Horse poni = new Horse("Пони", 1500, 3, 100);
        poni.swim(80);
        poni.run(1200);
        poni.jump(10);

        Bird kesha = new Bird("Кеша", 5, 0.2f);
        kesha.swim(20);
        kesha.jump(0.5f);
        kesha.run(3);
    }
}

class Dog extends Animals {

    public Dog(String setName, float setLimitRun, float setLimitJump, float setLimitSwim) {
        super(setName, setLimitRun, setLimitJump, setLimitSwim);
    }
}

class Horse extends Animals {
    public Horse(String setName, float setLimitRun, float setLimitJump, float setLimitSwim) {
        super(setName, setLimitRun, setLimitJump, setLimitSwim);
    }
}

class Bird extends Animals {
    public Bird(String setName, float setLimitRun, float setLimitJump) {
            super(setName, setLimitRun, setLimitJump);
    }

    protected void swim(float swim) {
        System.out.println("Птицы плавать не умеют");
    }
}

class Cat extends Animals {
    public Cat(String setName, float setLimitRun, float setLimitJump) {
        super(setName, setLimitRun, setLimitJump);
    }

    protected void swim(float swim) {
        System.out.println("Коты плавать не умеют");
    }
}


