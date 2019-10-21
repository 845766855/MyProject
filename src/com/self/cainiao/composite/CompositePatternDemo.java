package com.self.cainiao.composite;

public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("John","CEO",30000);

        Employee headSales = new Employee("Rober","Head Sales",20000);

        Employee headmarketing = new Employee("Miche","Head Marketing",20000);

        Employee clerk1 = new Employee("Laura","Marketing",10000);
        Employee clerk2 = new Employee("Bob","Marketing",10000);

        Employee salesExcutive1 = new Employee("Richard","Sales",10000);
        Employee salesExcutive2 = new Employee("Rob","Sales",10000);

        CEO.add(headSales);
        CEO.add(headmarketing);

        headSales.add(salesExcutive1);
        headSales.add(salesExcutive2);

        headmarketing.add(clerk1);
        headmarketing.add(clerk2);

        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }
}
