package lambda;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class LambdaFile07 {
    public static void main(String[] args) {

        try {
            Files.lines(Paths.get("/Users/yusuf/IdeaProjects/Projects/LambdaNew/src/lambda/ahmet")).forEach(t-> System.out.println(t));
        } catch (IOException e) {
            e.printStackTrace();
        }
//Tüm karakterleri büyük harfe dönüştürün ve okuyun
        try {
            Files.lines(Paths.get("/Users/yusuf/IdeaProjects/Projects/LambdaNew/src/lambda/ahmet")).map(String::toUpperCase).forEach(t-> System.out.println(t));
        } catch (IOException e) {
            e.printStackTrace();
        }
//metindeki farklı kelimeleri yazdır

        try {
            Files.lines(Paths.get("/Users/yusuf/IdeaProjects/Projects/LambdaNew/src/lambda/ahmet"))
                            .map(t -> t.split(" ")).flatMap(Arrays::stream).map(t->t.replaceAll("\\W", "")).distinct().forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }

        // metinde "e" içeren tüm kelimeleri yazdırın. (sayısınıda yazdırabilirsin)

        try {
            Files.lines(Paths.get("/Users/yusuf/IdeaProjects/Projects/LambdaNew/src/lambda/ahmet")).map(t->t.split(" ")).flatMap(Arrays::stream).filter(t->t.contains("e")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
