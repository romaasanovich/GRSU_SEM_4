package by.grsu.tweettrends.utills;

import java.io.*;
import java.util.Scanner;

public class FileWorker {

    public static String readFile (String path) throws FileNotFoundException {
        String str = "";
        FileReader fR = new FileReader(new File(path));
        Scanner scan = new Scanner(fR);
        while (scan.hasNextLine()){
            str+=scan.nextLine()+"\n";
        }
        return str;
    }
}
