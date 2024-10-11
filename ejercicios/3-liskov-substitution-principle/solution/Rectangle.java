public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int width, int height) {
        if (width <= 0 || height <= 0) {
    		throw new IllegalArgumentException();
    	}
        this.width = width;
        this.height = height;
    }
    
    public int calculateArea() {
        return this.width * this.height;
    }
}
