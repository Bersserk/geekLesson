/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
2. Конструктор класса должен заполнять эти поля при создании объекта;
3. Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
4. Вывести при помощи методов из пункта 3 ФИО и должность.
5. Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
6. * Создать метод, повышающий зарплату всем сотрудникам старше 45 лет на 5000;
7. ** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.

 */

package ru.geekbrains.lesson;

public class Main {

    static boolean flag = false;

    public static void main(String[] args) {

        Employee[] employees = new Employee[]{
                new Employee("Овчинников Демьян Михаилович", "директор", "730 156 000", 42, 5000),
                new Employee("Носков Мечислав Даниилович", "секретарь", "730 156 111", 25, 5100),
                new Employee("Казаков Вадим Яковлевич", "бухгалтер", "730 156 222", 34, 5200),
                new Employee("Зиновьев Артем Игнатьевич", "менеджер", "730 156 333", 36, 5300),
                new Employee("Гусев Ипполит Глебович", "водитель", "730 156 444", 46, 5400)
        };

        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getEmployeeID() + " ФИО: " + employees[i].getName() + "; должность: " + employees[i].getPosition());
        }   // id + ФИО и должность всех имеющихся сотрудников

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 40) {
                if (!flag) {
                    System.out.println();
                    System.out.println("Информация о сотрудниках старше 40 лет:");
                    flag = true;
                }

                System.out.println("ФИО: " + employees[i].getName() + "; должность: " + employees[i].getPosition() + "; телефон: " +
                        employees[i].getPhone() + "; возраст: " + employees[i].getAge() + "; зарплата: " + employees[i].getSalary() + ";");
            }
        }   // полная инфа о сотрудниках старше 40

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getAge() > 45) {
                employees[i].setNewSalary(5000);
                System.out.println("Теперь сотрудник " + employees[i].getName() + " будет получать зп: " + employees[i].getSalary());
            }
        }  // повышение зп сотрудникам старше 45
    }
}

class Employee {

    private String name;
    private String position;
    private String phone;
    private int age;
    private int salary;
    private final int employeeID;
    private static int id = 0;

    public Employee(String name, String position, String phone, int age, int salary) {
        this.name = name;
        this.position = position;
        this.phone = phone;
        this.age = age;
        this.salary = salary;
        this.employeeID = ++id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setNewSalary(int salary) {
        this.salary += salary;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}



