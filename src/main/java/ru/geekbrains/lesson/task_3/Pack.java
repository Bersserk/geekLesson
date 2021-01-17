package ru.geekbrains.lesson.task_3;

public class Pack {

    public static void main(String[] args) {

        // создаем фрукты и коробки
        Box <Apple> boxOne = new Box<>(new Apple(1.0f), 10);
        Box <Orange> boxTwo = new Box<>(new Orange(1.5f), 10);

//        boxOne.putInBox(new Orange(2.5f), 2);   // ошибка компиляции. проверочное выполнение

        // Снимаем контрольный вес коробок
        System.out.println("Вес коробки boxOne = " + boxOne.getWeight());
        System.out.println("Вес коробки boxTwo = " + boxTwo.getWeight());

        // Сравниваем коробки по весу
        System.out.println(boxOne.compare(boxTwo));

        //  меняем содержимое коробок местами
        pourAllFruits(boxOne, boxTwo);
        System.out.println("Вес коробки boxOne = " + boxOne.getWeight());
        System.out.println("Вес коробки boxTwo = " + boxTwo.getWeight());
    }

    private static void pourAllFruits (Box boxFrom, Box boxTo){
        Box tmpBox = new Box(null, 0);

        boxFrom.pourAllFruits(tmpBox);
        boxTo.pourAllFruits(boxFrom);
        tmpBox.pourAllFruits(boxTo);
    }
}
