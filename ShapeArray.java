
public class ShapeArray {

	public static void main(String[] args) {
			
		//instantiates test variables
		double testRadius = 2.5;
		double testHeight = 6.3;
		final int NUM_SHAPES = 3;
		int i = 0;
			
		//instantiates test array
		Shape[] shapeArray = new Shape[NUM_SHAPES];
			
		//constructs and stores test sphere
		Sphere testSphere = new Sphere(testRadius);
		shapeArray[0] = (testSphere);
			
		//constructs and stores test cylinder
		Cylinder testCylinder = new Cylinder(testRadius, testHeight);
		shapeArray[1] = (testCylinder);
			
		//constructs and stores test cone
		Cone testCone = new Cone(testRadius, testHeight);
		shapeArray[2] = (testCone);
			
		for(i = 0; i < NUM_SHAPES; ++i) {
			System.out.println(shapeArray[i].toString());
		}			
	}
}
