package ru.week3.day3;

public class Temperature {

    private double celsius;
    double fahrenheit;
    double kelvin;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    // Сеттер геттер цельсий

    public void setCelsius(double celsius) {
        if (celsius < 100) {
            this.celsius = celsius;
        } else {
            System.out.println("Некорректное значение!");
        }
    }
    public double getCelsius() {
        return celsius;
    }

    //Сеттер геттер фаренгейт

    public void setFahrenheit(double fahrenheit) {
        if (fahrenheit < 100) {
            this.fahrenheit = fahrenheit;
        } else {
            System.out.println("Некорректное значение!");
        }
    }

    public double getFahrenheit() {
        fahrenheit = celsius * 9/5 + 32;
        return fahrenheit;
    }

    // Сеттер геттер кельвины

    public void setKelvin(double kelvin) {
        if (kelvin < 100) {
            this.kelvin = kelvin;
        } else {
            System.out.println("Некорректное значение!");
        }
    }

    public double getKelvin() {
        kelvin = celsius + 273.15;
        return kelvin;
    }

    public static void main(String[] args) {
        Temperature temp = new Temperature(0);
        System.out.println(temp.getFahrenheit());
        System.out.println(temp.getKelvin());
    }
}
