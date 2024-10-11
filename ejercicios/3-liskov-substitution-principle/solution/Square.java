public class Square extends Shape {
    private int size;
    
    public Square(int size) {
        if (size <= 0) {
    		throw new IllegalArgumentException();
    	}
        this.size = size;
    }
    
    public int calculateArea() {
        return this.size * this.size;
    }
}
