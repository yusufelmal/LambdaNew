package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static lambda.Lambda02_Method.bosluklaYazdir;
import static lambda.Lambda02_Method.kareAl;

public class Lambda02 {
    public static void main(String[] args) {
        // Method Reference'da bizim oluşturduğumuz metodları  veya Java metodlarını kullanırız.
        //Method Reference Syntax ı ==> ClassName::MethodName  System.out.println();  ==  System.out::println;

        List<Integer> l = new ArrayList<Integer>(Arrays.asList(15, 14, 9, 13, 4, 9, 2, 4, 14));
        elemanYazdir(l);
        System.out.println();
        bosluklaYazdir(l);//diğer taraftan getirebildik import ile
        System.out.println();
        ciftSayiYazdir(l);
        System.out.println();
        kareleriYazdir(l);
        System.out.println();
        tekrarliSil(l);
        System.out.println();
        farkliCiftSayiKareToplam(l);
        System.out.println();
        farkliCiftSayiKüpCarpim(l);
        System.out.println();
        System.out.println(garip(l));




    }

    //1)List in elemanlarını aralarında boşluk bırakarak yanyana yazdır.(Method Reference- kendi metodumuz)
    public static void elemanYazdir(List<Integer> l){
        l.stream().forEach(Lambda02_Method::bosluklaYazdir);
    }
    //2)List in elemanlarından çift olanları aralarında boşluk bırakarak yanyana yazdır..(Method Reference)
    public static void ciftSayiYazdir(List<Integer> l){
        l.stream().filter(Lambda02_Method::ciftMi).forEach(Lambda02_Method::bosluklaYazdir);
    }
    //3)List teki tek sayıların karelerini alıp aralarında boşluk bırakarak yanyana yazdır
    public static void kareleriYazdir(List<Integer> l){
        l.stream().filter(Lambda02_Method::tekMi).map(Lambda02_Method::kareAl).forEach(Lambda02_Method::bosluklaYazdir);

    }
    //4)List teki tekrarlı olanları silip tek sayıların küplerini alıp aralarında boşluk bırakarak yanyana yazdır.

    private static void tekrarliSil(List<Integer> l) {
        l.stream().distinct().filter(Lambda02_Method::tekMi).map(Lambda02_Method::kupAl).forEach(Lambda02_Method::bosluklaYazdir);
    }
    //5)Farklı çift sayıların karelerinin toplamını yazdır (Use Method Reference)
    public static void farkliCiftSayiKareToplam(List<Integer> l) {
        int num=  l.stream().distinct().filter(Lambda02_Method::ciftMi).map(Lambda02_Method::kareAl).reduce(0,Math::addExact);
        System.out.println(num); //216
    }
    //6)Farklı çift sayıların küplerinin çarpımını yazdır .(Use Method Reference)
    public static void farkliCiftSayiKüpCarpim(List<Integer> l){
        int a= l.stream().distinct().filter(Lambda02_Method::ciftMi).map(Lambda02_Method::kupAl).reduce(1, Math::multiplyExact);//carpar hepsini
        int b= l.stream().distinct().filter(Lambda02_Method::ciftMi).map(Lambda02_Method::kupAl).reduce(1, Math::addExact);//toplar hepsini
        System.out.print(a);
        System.out.println();
        System.out.print(b);
    }
    //7)List teki farklı ve 5 ten büyük ve çift elemanlarının yarısını alıp ters sıralayarak list olarak yazdır.
    public static List garip(List<Integer> l){
        System.out.println("burdan aşağısı");
        return l.stream().distinct().filter(t->t>5&&t%2==0).map(t->t/2).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}
