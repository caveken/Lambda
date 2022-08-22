package lambda_functional_programming01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class sonElemanBul {
    public static void main(String[] args) {


        List<Integer> liste = new ArrayList<>();
        liste.add(8);
        liste.add(9);
        liste.add(131);
        liste.add(10);
        liste.add(9);
        liste.add(10);
        liste.add(2);
        liste.add(127);

        //Stream<Integer> liste= IntStream.range(0, 20).mapToObj(i -> "x");//"x" dizesinin 20 kopyasından oluşan bir stream elde etmek için
        //Collections.nCopies(5, "x").stream();//   bir koleksiyon oluşturmak ve ardından stream yapmaktır


        Integer sonEleman=liste.stream().reduce((a, b) -> b)
            .orElseThrow(() -> new IllegalStateException("no last element"));
        System.out.println(sonEleman);
    }
}