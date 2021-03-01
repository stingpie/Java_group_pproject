package group_array_project;

public class MatrixParser implements StringToArray {
	public int[][] convert(String input, String rowSeparator, String columnSeparator) {
		String[] rows = input.split(rowSeparator);
		int[][] ret = new int[rows.length][];


		for (int r = 0; r < rows.length; r++) {
			String[] row = rows[r].split(columnSeparator);
			ret[r] = new int[row.length];
			for (int c = 0; c < row.length; c++) {
				ret[r][c] = Integer.parseInt(row[c]);
			}
		}

		return ret;
	}
}
