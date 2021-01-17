package ru.geekbrains.lesson.task_3;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList arrayList;
    private float boxWeight;

    public Box(T fruit, int count) {
        this.boxWeight = 0.0f;
        this.arrayList = new ArrayList();

        if (fruit != null && count > 0)
            putInBox(fruit, count);
    }

    public void putInBox(T fruit, int count) {
        for (int i = 0; i < count; i++) {
            arrayList.add(fruit);
            boxWeight += fruit.weigth;
        }
    }

    public Float getWeight() {
        return boxWeight;
    }

    private void setBoxWeight(float boxWeight) {
        this.boxWeight = boxWeight;
    }

    private ArrayList getArrayList() {
        return arrayList;
    }

    public String compare(Box box) {
        if (Math.abs(boxWeight - box.getWeight()) < 0.0001)
            return "Коробки по весу равны";
        else
            return "Коробки по весу не равны";
    }

    public Box pourAllFruits(Box tmpBox) {
        tmpBox.getArrayList().addAll(0, this.arrayList);
        tmpBox.setBoxWeight(this.boxWeight);
        this.arrayList.clear();
        this.boxWeight = 0.0f;
        return tmpBox;
    }
}
