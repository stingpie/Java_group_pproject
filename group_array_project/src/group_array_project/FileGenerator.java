package group_array_project;

import java.io.FileWriter;
import java.util.Random;

public class FileGenerator {
    public static void makeTextFile(int width, int height, String path) throws Exception{
        FileWriter writeto = new FileWriter(path, false);
        int[][] arr = randomizeArray(width, height);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                writeto.write(arr[i][j] + " ");
            }
            if (i < arr.length - 1) {
                writeto.write("\n");
            }
        }
        writeto.close();
    }

    public static int[][] randomizeArray(int width, int height){
        int[][] arr = new int[height][width];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++){
                arr[i][j] = r.nextInt(100);
            }
        }
        return arr;
    }
}
