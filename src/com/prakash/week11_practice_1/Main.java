package com.prakash.week11_practice_1;
abstract class Rectangle {
    abstract public double getWidth();
    abstract public double getHeight();

    //static member class
    static class DoubleRectangle extends Rectangle {
        private double width, height;

        DoubleRectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getHeight() {
            return height;
        }
    }

    //static member class
    static class FloatRectangle extends Rectangle {
        private float width, height;

        FloatRectangle(float width, float height) {
            this.width = width;
            this.height = height;
        }

        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getHeight() {
            return height;
        }
    }

    private Rectangle() {}

    double getArea() {
        return getHeight() * getWidth();
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle.DoubleRectangle(10.0, 20.0);
        Rectangle r2 = new Rectangle.FloatRectangle(5.0f, 8.0f);
        System.out.println("Area of first rectangle: " + r1.getArea());
        System.out.println("Area of second rectangle: " + r2.getArea());
    }
}
