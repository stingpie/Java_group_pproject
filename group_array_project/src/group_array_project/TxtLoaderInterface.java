package group_array_project;

public interface TxtLoaderInterface{
    public String fileAddress=""; // file path
    public String textFromFile=""; // file text contents
    
    public String getTextFromFile() throws Exception; // get the text contents of a file
}