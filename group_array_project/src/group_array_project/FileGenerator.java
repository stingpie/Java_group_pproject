package group_array_project;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class FileGenerator{
    public static void makeTextFile(int width, int height){
          File file = new File("matrix.txt");  
        try{
            FileWriter writeto = new FileWriter("matrix.txt",false);
            int[][]arr = RandomizeArray(width,height);
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    writeto.write(arr[i][j]+" ");
                }
                if(i<arr.length-1){
                    writeto.write("\n");
                }
               
            }
        writeto.close();
        }
        catch(IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public static int[][] RandomizeArray(int width, int height){
        int[][] arr = new int[width][height];
        Random r = new Random();
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = r.nextInt(100);
            }
        }
        return arr;
    }
}
