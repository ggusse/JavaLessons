
public class Cylinder extends Shape{
	
	//instantiates radius and height variables
	private double radius;
	private double height;
	
	//parameterized constructor for cylinder object
	public Cylinder (double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	//method for cylinder surface area
	@Override
	public double surfaceArea() {
		return 2 * Math.PI * (Math.pow(this.radius, 2) + (this.radius * this.height));
	}
	
	//method for cylinder volume
	@Override
	public double volume() {
		return Math.PI * Math.pow(this.radius, 2) * this.height;
	}
	
	//returns string to print
	@Override
	public String toString() {
		return "For a cylinder with a radius of " + this.radius 
				+ " and a height of " + this.height + ":\n" + super.toString();
	}
}
