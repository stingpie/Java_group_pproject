package group_array_project;

import java.util.*;

public class TileWalkerRecursive {

	// paths are stored in one byte. if the bit is zero, move down. otherwise, move to the right.
	// by guaranteeing that 4 bits are on, the other 4 bits must be off, meaning that there's always going to be 4 moves right and 4 moves down.
	private static byte[] genPathCodes() {

		ArrayList<Byte> pathCodes = new ArrayList<>(); // declare arraylist of pathcodes, as bytes

		for (int i = 0; i < 256; i++) { if (Integer.bitCount(i) == 4) pathCodes.add((byte)i); } // if the pathcode has 4 set bits, add it to the list of test pathcodes

		byte[] ret = new byte[pathCodes.size()]; // declare a new array to hold all the pathcodes for returning

		for (int i = 0; i < pathCodes.size(); i++) { // for each item in the pathcode arraylist...
			ret[i] = pathCodes.get(i); // copy it over to the return array
		}

		return ret; // return an array containing all of the valid pathcodes
	}

	// gets the cost of a pathcode given a grid and a pathcode
	public static int getPathCost(int[][] grid, byte path) {
		int r = 0, c = 0; // declare row and column variables
		int cost = 0; // declare a running cost accumulator

		for (byte bitmask = 1; bitmask != 0; bitmask <<= 1) { // for each bit in the pathcode,

			cost += grid[r][c]; // add the grid value to the running cost

			if ((path & bitmask) == 0) r++; // if the bit is zero, move down
			else c++; // if the bit is one, move right
		}

		r = c = 4; // go to the destination tile

		cost += grid[r][c]; // add the final tile to the path cost

		return cost; // return the running cost
	}

	public static void printPath(int[][] grid, byte path) {
		int r = 0, c = 0; // declare row and column variables
		int cost = 0; // declare a running cost accumulator

		for (byte bitmask = 1; bitmask != 0; bitmask <<= 1) { // for each bit in the pathcode,

			cost += grid[r][c]; // add the grid value to the running cost

			System.out.printf("tile (%d, %d): cost=%d, total=%d\n", c, r, grid[r][c], cost); // print the (x, y) coordinates of the current tile, the grid value, and the running cost

			if ((path & bitmask) == 0) r++; // if the bit is zero, move down
			else c++; // if the bit is one, move right
		}

		r = c = 4; // go to the destination tile

		cost += grid[r][c]; // add the final tile to the path cost

		System.out.printf("tile (%d, %d): cost=%d, total=%d\n", c, r, grid[r][c], cost); // print the (x, y) coordinates of the final tile, the grid value, and the final cost
	}

	// finds the pathcode of the cheapest path in a 5x5 grid (row major), from the top-left tile to the the bottom-right tile
	public static byte findCheapestPath(int[][] grid) {
		byte[] pathCodes = genPathCodes(); // get an array of all the possible paths to traverse

		System.out.printf("found %d possible paths\n", pathCodes.length); // print the number of possible paths

		int cheapestPathCost = Integer.MAX_VALUE; // set the cheapest value to something insanely high, to guarantee that anything will test lower.
		byte cheapestPath = 0; // declare the cheapest pathcode

		for (int i = 0; i < pathCodes.length; i++) { // for each path in the possible pathcodes

			int cost = getPathCost(grid, pathCodes[i]); // calculate the path cost

			if (cost < cheapestPathCost) { // if the path cost is less than the cheapest found path cost
				cheapestPathCost = cost; // save the current path cost as the cheapest
				cheapestPath = pathCodes[i]; // save the current path code as the cheapest
			}
		}

		System.out.printf( // print the binary value, and cost of the cheapest path
			"path %s (costs %d):\n", 
			Integer.toBinaryString(cheapestPath).substring(24), 
			cheapestPathCost
		);

		printPath(grid, cheapestPath); // traverse the path and print it to the console output

		return cheapestPath; // return the cheapest path code
	}
}
