public class Sphere extends Shape {
	
	//instantiates radius variable
	private double radius;
	
	//parameterized constructor for sphere object
	public Sphere (double radius) {
		this.radius = radius;
	}
	
	//method for sphere surface area
	@Override
	public double surfaceArea() {
		return 4 * Math.PI * Math.pow(this.radius, 2);
	}
	
	//method for sphere volume
	@Override
	public double volume() {
		return (4 * Math.PI * Math.pow(this.radius, 3)) / 3;
	}
	
	//returns string to print
	@Override
	public String toString() {
		return "For a sphere with a radius of " + this.radius 
				+ ":\n" + super.toString();
	}
}
