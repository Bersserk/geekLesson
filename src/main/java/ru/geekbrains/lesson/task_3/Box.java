package ru.geekbrains.lesson.task_3;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

    private List<T> arrayList;
    private float boxWeight;

    public Box(T fruit, int count) {
        this.boxWeight = 0.0f;
        this.arrayList = new ArrayList<>();

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

    protected void setBoxWeight(float boxWeight) {
        this.boxWeight = boxWeight;
    }

    protected List<T> getArrayList() {
        return arrayList;
    }

}
