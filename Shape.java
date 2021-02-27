
public abstract class Shape {
	
	//abstract method for surface area
	abstract double surfaceArea();
	
	//abstract method for volume
	abstract double volume();
	
	//returns string with volume and surface area for shapes
	@Override
	public String toString() {
		return "Surface Area = " + this.surfaceArea()
			+ "\nVolume = " + this.volume();
	}
	
}
