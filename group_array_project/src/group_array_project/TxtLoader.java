package group_array_project;

//import necessary java classes
import java.io.File;
import java.util.Scanner;

class TxtLoader implements TxtLoaderInterface{
    //constructor that sets file address
     public TxtLoader(String path){
        String fileAddress = path;
    }
    //method that extracts file text as an unformatted String
    public String getTextFromFile(){
        StringBuilder textFromFile = new StringBuilder(); //instantiates StringBuilder class (for String generation)
        File read = new File(fileAddress); //instantiates File class (for file accessing)
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