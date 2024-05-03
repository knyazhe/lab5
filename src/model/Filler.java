package model;

import java.util.Scanner;

public class Filler {
    public void Fill(Dragon dragon) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name: ");
        String name = sc.nextLine();
        dragon.setName(name);
        System.out.println("Enter the age: ");
        try {
            while (true) {
                int age = sc.nextInt();
                if (age > 0) {
                    dragon.setAge(age);
                    break;
                } else {
                    System.out.println("Invalid age");
                }
            }
        } catch (Throwable e) {
            System.out.println("Invalid input");
        }
    }
}
