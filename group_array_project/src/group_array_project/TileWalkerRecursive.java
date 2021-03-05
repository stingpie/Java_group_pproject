package group_array_project;

import java.util.*;

public class TileWalkerRecursive {

	// paths are stored in one byte. if the bit is zero, move down. otherwise, move to the right.
	// by guaranteeing that 4 bits are on, the other 4 bits must be off, meaning that there's always going to be 4 moves right and 4 moves down.
	private static byte[] genPathCodes() {

		ArrayList<Byte> pathCodes = new ArrayList<>();

		for (int i = 0; i < 256; i++) { if (Integer.bitCount(i) == 4) pathCodes.add((byte)i); }

		byte[] ret = new byte[pathCodes.size()];

		for (int i = 0; i < pathCodes.size(); i++) {
			ret[i] = pathCodes.get(i);
		}

		return ret;

	}

	public static int getPathCost(int[][] grid, byte path) {
		int r = 0, c = 0;
		int cost = 0;

		for (byte bitmask = 1; bitmask != 0; bitmask <<= 1) {

			cost += grid[r][c];

			if ((path & bitmask) == 0) r++;
			else c++;
		}

		r = c = 4;

		cost += grid[r][c];

		return cost;
	}

	public static void printPath(int[][] grid, byte path) {
		int r = 0, c = 0;
		int cost = 0;

		for (byte bitmask = 1; bitmask != 0; bitmask <<= 1) {

			cost += grid[r][c];

			System.out.printf("tile (%d, %d): cost=%d, total=%d\n", c, r, grid[r][c], cost);

			if ((path & bitmask) == 0) r++;
			else c++;
		}

		r = c = 4;

		cost += grid[r][c];

		System.out.printf("tile (%d, %d): cost=%d, total=%d\n", c, r, grid[r][c], cost);
	}

	public static byte findCheapestPath(int[][] grid) {
		byte[] pathCodes = genPathCodes();

		System.out.printf("found %d paths\n", pathCodes.length);

		int cheapestPathCost = Integer.MAX_VALUE;
		byte cheapestPath = 0;

		for (int i = 0; i < pathCodes.length; i++) {


			int cost = getPathCost(grid, pathCodes[i]);

			if (cost < cheapestPathCost) {
				cheapestPathCost = cost;
				cheapestPath = pathCodes[i];
			}
		}

		System.out.printf(
			"path %s (costs %d):\n", 
			Integer.toBinaryString(cheapestPath).substring(24), 
			cheapestPathCost
		);

		printPath(grid, cheapestPath);

		return cheapestPath;
	}
}
