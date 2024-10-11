import java.util.List;

public class ShapeCalculator {
	public double calculateTotalArea(List<Shape> shapes) {
		double totalArea = 0;
        for (Shape shape : shapes) {
            if (shape != null) {
                totalArea += shape.calculateArea();
            }
        }
        System.out.println(totalArea);
        return totalArea;
	}
}

