package ru.geekbrains.lesson;

public class Animals {

    private String name;

    private float maxRun;
    private float maxJump;
    private float maxSwim;

    public Animals(String name, float limitRun, float limitJump, float limitSwim) {
        this.name = name;
        this.maxRun = limitRun;
        this.maxJump = limitJump;
        this.maxSwim = limitSwim;
    }

    public Animals(String name, float limitRun, float limitJump) {
        this.name = name;
        this.maxRun = limitRun;
        this.maxJump = limitJump;
    }


    protected void run (float run){
        ifAndAction("run", run, maxRun);
    }

    protected void jump (float jump){
        ifAndAction("jump", jump, maxJump);
    }

    protected void swim (float swim){
        ifAndAction("swim", swim, maxSwim);
    }

    //   сравнивает действие с допустимым и выдает результат
    private void ifAndAction (String act, float action, float maxAction){

        if (action > maxAction) {
            switch (act){
                case "swim":
                    System.out.println("На такое расстояние " + name + " плавать не могёт!");
                    break;
                case "jump":
                    System.out.println("На такую высоту " + name + " прыгнуть не могёт!");
                    break;
                case "run":
                    System.out.println("Столько " + name + " пробежать не могёт !");
                    break;
            }

        } else {
            switch (act){
                case "swim":
                    System.out.println(name + " проплыл!!!");
                    break;
                case "jump":
                    System.out.println(name + " прыгнул!!!");
                    break;
                case "run":
                    System.out.println(name + " пробежал !");
                    break;
            }
        }
    }
}
