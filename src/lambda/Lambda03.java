package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda03 {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>(Arrays.asList(7,12,14,4,9,2,4,12,16));
        ilkDortEleman(a);
        System.out.println();
        ilkDortAtla(a);
    }


    //1. kucukten büyüğe, sonra ilk 4 ü yazdır.
    public static void ilkDortEleman(List<Integer> a) {
        a.stream().sorted().limit(4).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //2. kucukten buyuğe ilk 4 ü atla
    private static void ilkDortAtla(List<Integer> a) {
        a.stream().sorted().skip(4).forEach(Lambda02_Method::bosluklaYazdir);
    }

}
