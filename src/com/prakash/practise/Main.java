class Shape {
    private int centerX;
    private int centerY;

    Shape(int centerX, int centerY) {
        setCenter(centerX, centerY);

    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public void setCenter(int centerX, int centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }

    public void draw() {
        System.out.println("Drawing a shape with center (" + centerX + ", " + centerY + ")");
    }
}


class Rectangle extends Shape {
    int length;
    int width;

    Rectangle(int centerX, int centerY, int length, int width) {
        super(centerX, centerY);
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public  int getWidth() {
        return width;
    }

    @Override
    public void draw() {
        System.out.println("Drawing a rectangle with length: " + length + " and width: " + width);
    }
}


public class Main {
    public static Shape moveRight(Shape s) {
        int newCenterX = s.getCenterX() + 1;
        s.setCenter(newCenterX, s.getCenterY());
        return s;
    }

    public static void main(String[] args) {
        Shape s = new Shape(1, 2);
        s = moveRight(s);
        Rectangle r = (Rectangle) s;
        System.out.println(r.getLength() + ", " + r.getWidth());
    }
}