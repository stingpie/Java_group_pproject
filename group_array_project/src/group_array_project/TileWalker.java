package group_array_project;

import java.util.Arrays;

public class TileWalker implements TileStepper{

	boolean debug=true;
	
	public int[] pos= {0,0};
	public int[][] confirmedSteps= new int[1][3];
	public int[] confirmedCosts = new int[1];
	public int[][] testSteps= new int[1][3];
	public int[] testCosts= new int[1];
	public int[][] grid = new int[5][5];
	
	public TileWalker(int[][] grid_map) {
		this.grid=grid_map;
		confirmedSteps[0][0]=0;
		confirmedSteps[0][1]=0;
		confirmedCosts[0]=grid[0][0];
		
		
	}
	
	byte[][] offset= {{0,1},{1,0}};// x y offsets
	
	public void findPossibleSteps() {
		for(int i=0;i<confirmedSteps.length; i++) { // look at all the steps that we have taken so far
			for(int j=0; j<offset.length;j++) { // look at the surrounding tiles
				boolean isItNew=true;
				
				int[] newTest= {confirmedSteps[i][0]+offset[j][0],confirmedSteps[i][1]+offset[j][1] };
				
				 for(int z=0; z<testSteps.length;z++) {
					if(testSteps[z].equals(newTest)) {
						isItNew=false;
						break;
					}
				 }
				 if(isItNew) {
					 for(int z=0; z<confirmedSteps.length;z++) {
						if( confirmedSteps[z].equals(newTest)) {
							isItNew=false;
							break;
						}
					 }
				 }
				 
				 if(isItNew) {
					testSteps=Arrays.copyOf(testSteps, testSteps.length+1);
					testSteps[testSteps.length-1]=newTest;
					
					testCosts=Arrays.copyOf(testCosts, testCosts.length+1);
					testCosts[testCosts.length-1]=confirmedCosts[i]+grid[testSteps[testSteps.length-1][0]][testSteps[testSteps.length-1][1]];
					
					System.out.print(newTest[0]); System.out.print(" "); System.out.println(newTest[1]);
				 }
				 
				 
				 
			}
		}
		System.out.println(testSteps.length);
	}
	
	public void testPossibleSteps() {
		for(int i=0; i<testSteps.length; i++) {
			
		}
	}
	
	public int[][] getPath(){
		return confirmedSteps;
	}
	
}
