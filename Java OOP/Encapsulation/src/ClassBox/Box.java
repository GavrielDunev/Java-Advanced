package ClassBox;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    public void setLength(double length) {
        validateSide(length, "Length");
        this.length = length;
    }

    public void setWidth(double width) {
        validateSide(width, "Width");
        this.width = width;
    }

    public void setHeight(double height) {
        validateSide(height, "Height");
        this.height = height;
    }

    public void validateSide(double value, String prefix){
        if (value <= 0) {
            throw new IllegalArgumentException(prefix + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea () {
        return 2 * this.length * this.width + calculateLateralSurfaceArea();
    }

    public double calculateLateralSurfaceArea () {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume () {
        return this.length * this.height * this.width;
    }

    @Override
    public String toString() {
        return String.format("Surface Area - %.2f%n" +
                "Lateral Surface Area - %.2f%n" +
                "Volume – %.2f%n", calculateSurfaceArea(), calculateLateralSurfaceArea(), calculateVolume());
    }
}
