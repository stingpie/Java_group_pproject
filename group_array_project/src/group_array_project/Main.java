package group_array_project;

public class Main {
	public static void main(String[] args) throws Exception {

		if (args[0].equalsIgnoreCase("gen")) { // if the command-line arguments contain the "generate" parameter

			int width = 5, height = 5; // define the width and height as five

			System.out.printf("Generating new random %dx%d matrix into %s\n", width, height, args[1]); // print what the program is doing
			
			FileGenerator.makeTextFile(width, height, args[1]); // generate a new 5x5 matrix into the path passed to the program

		} else if (args[0].equalsIgnoreCase("silve")) { // if the command-line arguments contain the "solve" parameter

			StringToArray matrixParser = new StringToArray(); // instantiate the matrix parser

			int[][] mat = matrixParser.convert(TxtLoader.getTextFromFile(args[1]), "\n", " "); // load the file from the path passed to the program as an array

			TileWalkerRecursive.findCheapestPath(mat); // find the cheapest path and print it to the command line

		} else {
			System.out.println("usage: app_name [gen|solve] file_path"); // if neither argument is present, print the help
		}
	}
}