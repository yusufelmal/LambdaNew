package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LambdaFile07 {
    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("/Users/yusuf/IdeaProjects/Projects/LambdaNew/src/lambda/ahmet")).forEach(t-> System.out.println(t));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
