
public class Cone extends Shape {

	//instantiates radius and height variables
	private double radius;
	private double height;
	
	//parameterized constructor for cone object
	public Cone (double radius, double height) {
		this.radius = radius;
		this.height = height;
	}
	
	//method for cone surface area
	@Override
	public double surfaceArea() {
		return (Math.PI * this.radius) * (this.radius + Math.sqrt(Math.pow(this.radius, 2) + Math.pow(this.height, 2)));
	}
	
	//method for cone volume
	@Override
	public double volume() {
		return  Math.PI * Math.pow(this.radius, 2) * (this.height / 3);
	}
	
	//returns string to print
	@Override
	public String toString() {
		return "For a cone with a radius of " + this.radius 
				+ " and a height of " + this.height + ":\n" + super.toString();
	}
}
