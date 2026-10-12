
package com.demo;

public class App {
    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        App app = new App();
        System.out.println("Hello from automated Jenkins CI Pipeline!");
        System.out.println("Sum: " + app.add(10, 20));
    }
}
