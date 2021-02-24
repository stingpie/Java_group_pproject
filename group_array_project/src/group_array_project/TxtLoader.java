package group_array_project;

public interface TxtLoader {
	//public String fileAddress=""; //IMPLEMENT THESE
	//public String textFromFile="";  
	
	public abstract void readTxt() ;
	
	public abstract void setFileAddress(String newFileAddress);
	String getFileAddress();
	
	String getTextFromFile();
}
