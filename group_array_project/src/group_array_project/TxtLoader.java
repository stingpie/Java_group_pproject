package group_array_project;

import java.io.File;
import java.util.Scanner;

class TxtLoader {
    public static String loadTxt(String path) throws Exception {
        StringBuilder build = new StringBuilder();
        File read = new File(path);
        Scanner reader = new Scanner(read);
        while (reader.hasNextLine()) {
            build.append(reader.nextLine() + "\n");
        }
        reader.close();
        return build.toString();
    }
}