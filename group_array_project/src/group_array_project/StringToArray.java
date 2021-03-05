package group_array_project;

public class StringToArray implements StringToArrayInterface {

	// converts a string into a 2d array, given delimiters
	public int[][] convert(String input, String rowSeparator, String columnSeparator) {
		String[] rows = input.split(rowSeparator); // split the array into row string using the row seperator
		int[][] ret = new int[rows.length][]; // allocate a 2d integer array with an undefined column size


		for (int r = 0; r < rows.length; r++) { // for each row in the array,
			String[] row = rows[r].split(columnSeparator); // split the row into strings containing each element
			ret[r] = new int[row.length]; // declare a new array to contain the parsed elements
			for (int c = 0; c < row.length; c++) { // for each item in the row,
				ret[r][c] = Integer.parseInt(row[c]); // copy over the value after parsing the element's string value
			}
		}

		return ret; // return the parsed array
	}
}
