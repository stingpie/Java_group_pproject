package group_array_project;

//import necessary java classes
import java.io.File;
import java.util.Scanner;

class TxtLoader {
    //method that extracts file text as an unformatted String
    public static String getTextFromFile(String path) throws Exception {

        StringBuilder textFromFile = new StringBuilder(); //instantiates StringBuilder class (for String generation)
        File read = new File(path); //instantiates File class (for file accessing)
        Scanner reader = new Scanner(read); //instantiates Scanner class (for reading)

        //adds each line from the file as a string
        while (reader.hasNextLine()) {
            textFromFile.append(reader.nextLine() + "\n");
        }
        //stop reading the file and return the file's data as a single String
        reader.close();
        return textFromFile.toString();
    }
}