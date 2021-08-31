package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Lambda01 {
    public static void main(String[] args) {
//1. soru: Listin elemanlarini yan yana yazzdir.(java structured)
        List<Integer> l = new ArrayList<>(Arrays.asList(14, 9, 13, 4, 9, 2, 4, 14, 15));

        yazdirJava(l);
        System.out.println();
        yazdirLambda(l);
        System.out.println();
        ciftSayiJava(l);
        System.out.println();
        ciftSayiLambda(l);
        System.out.println();
        tekSayiKareLambda(l);
        System.out.println();
        farkliTekKüp(l);
        System.out.println();
        ciftSayiKareToplam(l);
        System.out.println();
        tekrarsizCiftKupCarpimi(l);
        System.out.println();
        siraliYazdir(l);


    }




    public static void yazdirJava(List<Integer> list) {
        for (Integer w : list
        ) {
            System.out.print(w + " ");

        }
    }
    //şimdi lambda!

    public static void yazdirLambda(List<Integer> list) {
        list.stream().forEach(t -> System.out.print(t + " "));

    }

    //Listin elemanlarından çift olanları aralarında boşluk bırakarak yazın.

    public static void ciftSayiJava(List<Integer> l) {
        for (Integer w : l) {
            if (w % 2 == 0) {
                System.out.print(w + " ");
            }

        }
    }

    private static void ciftSayiLambda(List<Integer> l) {
        //t oklu yazılar lambda expressions -> ok ile yazmaya da arrow funktion deniyor
        l.stream().filter(t -> t % 2 == 0).forEach(t -> System.out.print(t + " "));


    }// list tedeki tek sayiların karelerini yazdiran.

    private static void tekSayiKareLambda(List<Integer> l) {
        l.stream().filter(t -> t % 2 == 1).map(t -> t * t).forEach(t -> System.out.print(t + " "));
    }

    //tekrarlıları sil, tek sayı olanların küplerini yazdir.
    private static void farkliTekKüp(List<Integer> l) {
        l.stream().distinct().filter(t -> t % 2 == 1).map(t -> t * t * t).forEach(t -> System.out.print(t + " "));
    }
//tekrarlıları sil, çiftlerin karelerinin toplamı.
private static void ciftSayiKareToplam(List<Integer> l) {
    System.out.println("buraya bir bosluk");
    System.out.println(l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y));
//yazdirmanın iki yolu: sona .koy sout yaz içine al soutun.
    //diğer yol.
    int sayi= l.stream().distinct().filter(t -> t % 2 == 0).map(t -> t * t).reduce(0, (x, y) -> x + y);
    System.out.println(sayi);
    //diğer üçüncü yol
   // komple return type ı voidden Integer<> yaparak return type yaparsın. yukarda da metodu sout içine alırsın. çaat.

}
//listedeki tekrarlı elemanları silip çift sayı olanların küplerinin çarpımı
public static void tekrarsizCiftKupCarpimi(List<Integer> l){
    Integer a=  l.stream().distinct().filter(t->t%2==0).map(t->t*t*t).reduce(1, (t,u)->t*u);
    System.out.print(a);
}
//7)Listedeki elemanları sıralayarak ve ters sıralayarak yazdır

    public static void siraliYazdir(List<Integer> l){
        l.stream().sorted().forEach(t-> System.out.print(t+" "));
        System.out.println();
        l.stream().sorted(Comparator.reverseOrder()).forEach(a-> System.out.print(a+" "));

    }
}
