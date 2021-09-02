package lambda;

import java.util.Comparator;
import java.util.stream.IntStream;

public class Lambda05 {
    public static void main(String[] args) {
        //1den 20 ye kadar olan sayıları yazdır
        IntStream.rangeClosed(1,20).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        IntStream.rangeClosed(1,20).filter(t->t%2==0).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        IntStream.rangeClosed(1,20).sorted().filter(t->t%2==1).forEach(Lambda02_Method::bosluklaYazdir);
        System.out.println();
        //2) functional programlamayı kullanarak 3 den ile 98 e kadar olan çift tam sayıların toplamını bulun
        System.out.println(IntStream.rangeClosed(3, 98).filter(t -> t % 2 == 0).reduce(0, (t, u) -> t + u));
        //diğer çözüm
        System.out.println(IntStream.rangeClosed(3, 98).filter(t -> t % 2 == 0).sum());
        //3) functional programming kullanarak 9! i bul (9!=1*2*3...*9)
        System.out.println(IntStream.rangeClosed(1, 9).reduce(1, Math::multiplyExact));
        // 4) İlk 7 çift sayma sayısının çarpımını bulun (2,4,6,8,10,12,14)
        System.out.println(IntStream.rangeClosed(1,15).filter(t -> t % 2 == 0).reduce(1, Math::multiplyExact));

        //5)  6'dan büyük ilk 150 tek sayma sayısının toplamını bulun ==> 7, 9, 11, 13, 15, 17, 19
        System.out.println(IntStream.iterate(7, t -> t + 2).limit(150).sum());

        //7) İlk 23 çift sayma sayısının toplamını bulun
        System.out.println(IntStream.iterate(2, t -> t + 2).limit(23).sum());

        //5)  (11,33) arasındaki her tam sayının rakamlarının toplamını hesaplamak için bir metod oluşturun
       IntStream.rangeClosed(11, 33).map(Lambda02_Method::rakamlarToplami).forEach(Lambda02_Method::bosluklaYazdir);




    }


}
