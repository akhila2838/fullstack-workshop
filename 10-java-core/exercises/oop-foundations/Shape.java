public abstract class Shape {

    // Abstract methods
    public abstract double area();
    public abstract double perimeter();

    // Concrete method
    public void displayInfo() {
        System.out.println(this.getClass().getSimpleName() + " Info:");
        System.out.println("Area: " + area());
        System.out.println("Perimeter: " + perimeter());
    }
}
