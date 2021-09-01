package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class Lambda04 {
    public static void main(String[] args) {

        List<String> l = new ArrayList<>(Arrays.asList("Ali", "Ali", "Aysima", "Abdurrahman", "Mehmet", "Mustafa", "Bedirhan", "Yüksel", "Süleyman"));

        yazdirBuyuk(l);
        System.out.println();
        sirala(l);
        System.out.println();
        farkliSonHarfSirala(l);
        System.out.println();
        uzunlukIlkEleman(l);
        System.out.println();
        yazdirAIleBaslayan(l);
        System.out.println();
        ABasIBit(l);
        System.out.println();
        BuyukMetod(l);
        System.out.println();
        uzunlukSirala(l);
        System.out.println();
        kareTekrarCart(l);
        System.out.println();
        cartCurt(l);
        System.out.println();
        carto(l);
        System.out.println();
        corto(l);
        System.out.println();
        ekSoru(l);
    }


    //1. listin elemenalarını büyük harfle yazdir.
    private static void yazdirBuyuk(List<String> l) {
        l.stream().map(t -> t.toUpperCase()).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        l.stream().map(String::toUpperCase).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //2. elemnları uzunluklarına göre sırala ve yazdır.
    private static void sirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        l.stream().sorted(Comparator.comparing(t -> t.length())).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();//yukarısı tam tersine yazdirma

    }

    //3. farklı elemanlarını son harflerine göre sıralayıp yazdır.
    private static void farkliSonHarfSirala(List<String> l) {
        l.stream().distinct().sorted(Comparator.comparing(t -> t.substring(t.length() - 1))).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //4. elemanları uzunluklarına ve ardından aynı uzunlukta olanları ilk karakterlerine göre sıralamak için bir yöntem oluşturun
    private static void uzunlukIlkEleman(List<String> l) {
        l.add("Ata");
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.charAt(0))).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        l.stream().sorted(Comparator.comparing(String::length).thenComparing(t -> t.substring(0, 1))).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //5)Büyük harflerle, "A" ile başlayan liste öğelerini yazdırmak için bir yöntem oluşturun    */

    private static void yazdirAIleBaslayan(List<String> l) {
        l.stream().filter(t -> t.startsWith("A")).map(String::toUpperCase).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //6)  Küçük harflerle, "A" ile başlayan veya "i" ile biten liste öğelerini yazdırmak için bir yöntem oluşturun

    private static void ABasIBit(List<String> l) {
        l.stream().filter(t -> t.startsWith("A") && t.endsWith("i")).map(String::toLowerCase).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //7) Öğeleri uzunluklarına göre sıraladıktan sonra büyük harflerle yazdırmak için bir yöntem oluşturun
    private static void BuyukMetod(List<String> l) {
        l.stream().map(String::toUpperCase).sorted(Comparator.comparing(String::length)).forEach(Lambda02_Method::bosluklaYazdir);
    }

    ////8) Elemanları uzunluklarına göre sıralayın önce elemanı sonra uzunluğunu yazdırın
    private static void uzunlukSirala(List<String> l) {
        l.stream().sorted(Comparator.comparing(String::length)).map(t -> t + ":" + t.length()).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //9) Her elemanın uzunluğunun karesini alıp tekrarlıları sil, bunların 20'den büyük olanlarını ters sırada  yazdırın
    public static void kareTekrarCart(List<String> l) {
        l.stream().distinct().map(t -> t.length() * t.length()).filter(t -> t > 20).sorted(Comparator.reverseOrder()).forEach(Lambda02_Method::bosluklaYazdir);
    }

    //10) Tüm elemanların uzunluklarının 12'den az olup olmadığını kontrol etmek için bir metod oluşturun
//bütün elemanların "x" ile başlamadığını kontrol etmek için bir yöntem oluşturun
//en az 1 tane "R" ile biten eleman olup olmadığını kontrol etmek için bir metod oluşturun.
    public static void cartCurt(List<String> l) {
        boolean a = l.stream().allMatch(t -> t.length() < 12);
        System.out.print(a);
        boolean b = l.stream().noneMatch(t -> t.startsWith("x"));
        System.out.println();
        System.out.print(b);
        boolean c = l.stream().anyMatch(t -> t.endsWith("R"));
        System.out.println();
        System.out.println(c);

    }

    //   elemanları sondan 2. elemanlarına göre sıralayıp ilk elemanı yazdır
    public static void carto(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(t -> t.charAt(t.length() - 2))).findFirst());
    }

    //12)elemanlari uzunluklarina gore tersten siralayip ilk elemani yazdir
    public static void corto(List<String> l) {
        System.out.println(l.stream().sorted(Comparator.comparing(String::length).reversed()).findFirst());
    }
//x Eleman 'A', 'a' ile başlıyor veya 'N', 'n' ile bitiyorsa o elemanı silin
        public static void ekSoru (List <String> l) {
            l.removeIf(t -> t.startsWith("a") || t.startsWith("A") || t.endsWith("N") || t.endsWith("n"));
            System.out.println(l);

    }
}
