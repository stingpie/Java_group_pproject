package group_array_project;

public class Main {

	int[][] mat;
	public static void main(String[] args) throws Exception {

		String[] testArgs = {"solve", "testmat.txt"};
		args = testArgs;

		if (hasArg(args, "gen")) {

			int width = 5, height = 5;

			if (args.length == 4) {
				width = Integer.parseInt(args[2]);
				height = Integer.parseInt(args[3]);
			}

			System.out.printf("Generating new random %dx%d matrix into %s\n", width, height, args[1]);
			
			FileGenerator.makeTextFile(width, height, args[1]);
		} else if (hasArg(args, "solve")) {

			StringToArray matrixParser = new StringToArray();

			int[][] mat = matrixParser.convert(TxtLoader.getTextFromFile(args[1]), "\n", " ");
			// solve a matrix

			TileWalkerRecursive.findCheapestPath(mat);

		} else {
			System.out.println("usage: app_name [gen|solve] file [?width] [?height]");
		}
	}

	public static boolean hasArg(String[] args, String arg) {
		for (String uarg : args) { if (uarg.equalsIgnoreCase(arg)) return true; }
		return false;
	}
}