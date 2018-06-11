package by.grsu.detailshop.utills;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Reader {
    public String readFile(String path) throws IOException {
        String result = "";
        try (FileReader fileReader = new FileReader(path)) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                result += scan.nextLine();
            }
            return result;
        }
    }

    public File getFile(String filePath)throws IOException {
        File file = new File(filePath);
        if(!file.createNewFile()){
            return file;
        }
        else  return null;
    }
}
