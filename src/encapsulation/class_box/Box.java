package encapsulation.class_box;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    // Surface Area = 2lw + 2lh + 2wh
    public double calculateSurfaceArea() {
        return 2 * this.length * this.width +
               2 * this.length * this.height +
               2 * this.width * this.height;
    }

    // Lateral Surface Area = 2lh + 2wh
    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height +
               2 * this.width * this.height;
    }

    // Volume = lwh
    public double calculateVolume() {
        return this.length * this.height * this.width;
    }

    private void setLength(double length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Length cannot be zero or negative.");
        }
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Height cannot be zero or negative.");
        }
        this.height = height;
    }
}
