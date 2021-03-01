package group_array_project;

//import necessary java classes
import java.io.FileWriter;
import java.util.Random;

public class FileGenerator{
    //method that generates a file containing an array of numbers with specified width, height, and path
    public static void makeTextFile(int width, int height, String path) throws Exception{
        FileWriter writeto = new FileWriter(path, false); //instantiate FileWriter class (for writing)
        int[][] arr = randomizeArray(width, height); //calls randomizeArray fuction and sets that value as a new array
        //write the array to a file with new lines for every row
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                writeto.write(arr[i][j] + " ");
            }
            if (i < arr.length - 1){
                writeto.write("\n");
            }
        }
        writeto.close(); //stop writing to the file
    }

    //method that returns an array of specified dimensions with random values in it
    public static int[][] randomizeArray(int width, int height){
        int[][] arr = new int[height][width]; //sets up new array of specified dimensions
        Random r = new Random(); //instantiates Random class (for random integer generation)
        //generates a random int for each index of the array
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = r.nextInt(100);
            }
        }
        return arr; //return the array of random integers
    }
}
