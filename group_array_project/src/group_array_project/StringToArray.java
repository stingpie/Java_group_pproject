package group_array_project;

public interface StringToArray {
	public int[] dimensions = {5,5};
	public char collumnSeperator=' ';
	public char rowSeperator='|';
	
	public abstract int[][] convertStringToArray(String InputString);
	
}
