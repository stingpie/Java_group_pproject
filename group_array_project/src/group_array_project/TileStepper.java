package group_array_project;

public interface TileStepper {
	// IMPLEMENT THESE
	//public int[] currentPos= {0,0};
	//public int[][] confirmedSteps= new int[0][2]; // each confirmed step should be a pair of cooridnates on the grid
	//public int[][] testSteps= new int[0][2]; //The steps that should be tested in the next iteration
	//public int[][] grid = new int[5][5];
	
	public abstract void findPossibleSteps(); // look along the edges of the current path, and add them to test steps if they're new. 
	
	public abstract void testPossibleSteps(); // look through the testSteps, and pick the cheapest one. Then, add it to confirmedSteps.
	
	public abstract int[][] getPath(); // return the confirmed steps we have generated so far. 
	
	
}
