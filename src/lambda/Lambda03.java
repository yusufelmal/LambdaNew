package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BinaryOperator;

public class Lambda03 {
    public static void main(String[] args) {
        List<Integer> a=new ArrayList<>(Arrays.asList(7,12,14,4,9,2,4,12,16));
        ilkDortEleman(a);
        System.out.println();
        ilkDortAtla(a);
        System.out.println();
        yazdir(a);
        System.out.println();
        maxDeger(a);
    }




    //1. kucukten büyüğe, sonra ilk 4 ü yazdır.
    public static void ilkDortEleman(List<Integer> a) {
        a.stream().sorted().limit(4).forEach(Lambda02_Method::bosluklaYazdir);
    }


    //2. kucukten buyuğe ilk 4 ü atla
    public static void ilkDortAtla(List<Integer> a) {
        a.stream().sorted().skip(4).forEach(Lambda02_Method::bosluklaYazdir);
    }

  //  küçükten büyüğe sıralı, 4. 5. 6. elemanı yazdır

    public static void yazdir(List <Integer> a){
        System.out.println("aşağı bak");
        a.stream().sorted().limit(6).skip(3).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        a.stream().sorted().skip(3).limit(3).forEach(Lambda02_Method::bosluklaYazdir);
    }

   // List teki en büyük elemanı bul.(Use Method Reference)
   public static void maxDeger(List<Integer> a) {
       Integer b= a.stream().reduce(Integer.MIN_VALUE, Math::max);
       System.out.println(b);
       Integer k= a.stream().reduce(Integer.MAX_VALUE, Math::min);
       System.out.println(k);
       a.stream().sorted(Comparator.reverseOrder()).limit(1).forEach(Lambda02_Method::bosluklaYazdir);
       System.out.println();
       a.stream().sorted().limit(1).forEach(Lambda02_Method::bosluklaYazdir);
       System.out.println();
       a.stream().skip(a.size()-1).limit(a.size()).forEach(Lambda02_Method::bosluklaYazdir);

   }

}
