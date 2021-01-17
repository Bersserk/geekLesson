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
        System.out.println(compare(boxOne, boxTwo));

        //  меняем содержимое коробок местами
        pourAllFruits(boxOne, boxTwo);
        System.out.println("Вес коробки boxOne = " + boxOne.getWeight());
        System.out.println("Вес коробки boxTwo = " + boxTwo.getWeight());
    }

    private static String compare(Box<Apple> boxOne, Box<Orange> boxTwo) {
        if (Math.abs(boxOne.getWeight() - boxTwo.getWeight()) < 0.0001)
            return "Коробки по весу равны";
        else
            return "Коробки по весу не равны";
    }

    private static void pourAllFruits (Box boxFrom, Box boxTo){
        Box <Fruit> tmpBox = new Box<>(null, 0);

        fromPourTo (boxFrom, tmpBox);
        fromPourTo(boxTo, boxFrom);
        fromPourTo(tmpBox, boxTo);
    }


    private static Box fromPourTo(Box boxFrom, Box boxTo) {
        boxTo.getArrayList().addAll(0, boxFrom.getArrayList());
        boxTo.setBoxWeight(boxFrom.getWeight());
        boxFrom.getArrayList().clear();
        boxFrom.setBoxWeight(0.0f);
        return boxTo;
    }
}
