package pac;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by macbookair on 14.09.16.
 */
public class main {

    private static List<Integer> A = new LinkedList<Integer>();
    private static List<Integer> C = new LinkedList<Integer>();
    private static List<Integer> B = new LinkedList<Integer>();
    private static List<Integer> R = new LinkedList<Integer>();
    private static List<Integer> T = new LinkedList<Integer>();
    private static List<List<Integer>> MA = new LinkedList<List<Integer>>();
    private static List<List<Integer>> ME = new LinkedList<List<Integer>>();
    private static List<List<Integer>> MH = new LinkedList<List<Integer>>();
    private static List<List<Integer>> MK = new LinkedList<List<Integer>>();
    private static List<List<Integer>> ML = new LinkedList<List<Integer>>();
    private static List<List<Integer>> MO = new LinkedList<List<Integer>>();
    private static List<List<Integer>> MP = new LinkedList<List<Integer>>();
    private final static int N = 15;
//    private final static int from = 1

    public static void main(String[] args) {

//        Random random = new Random(10);
//        List<Integer> listMA;
        Functions functions = new Functions();
        for (int i = 0; i < N; i++) {
            A.add(getRandomInt(0,10));
            C.add(getRandomInt(0,10));
            B.add(getRandomInt(0,10));
            R.add(getRandomInt(0,10));
            T.add(getRandomInt(0,10));
//            list = new LinkedList<>();
            MA.add(new LinkedList<Integer>());
            ME.add(new LinkedList<>());
            MH.add(new LinkedList<>());
            MK.add(new LinkedList<>());
            ML.add(new LinkedList<>());
            MO.add(new LinkedList<>());
            MP.add(new LinkedList<>());
            for (int j = 0; j < N; j++) {
                MA.get(i).add(getRandomInt(0,10));
                ME.get(i).add(getRandomInt(0,10));
                MH.get(i).add(getRandomInt(0,10));
                MK.get(i).add(getRandomInt(0,10));
                ML.get(i).add(getRandomInt(0,10));
                MO.get(i).add(getRandomInt(0,10));
                MP.get(i).add(getRandomInt(0,10));
            }

        }

        System.out.println(System.currentTimeMillis());

        Thread t1 = new Thread(()->{
            System.out.println();
            long d1 = System.currentTimeMillis();
            System.out.println("Время начала обработки Функции 1: "+d1);
            List<Integer> E = new LinkedList<>();
            E.addAll(functions.function1(A, B, C, MA, ME));
            for (int i = 0; i < E.size(); i++) {
                System.out.println("Ответ функции 1: елемент " + i + " : " + E.get(i) + " ; ");
            }
            long d = System.currentTimeMillis();
            System.out.println("Время окончания F1 : "+d+" Длительность потока : "+(d-d1));

            System.out.println();
        });

        Thread t2 = new Thread(()->{
            System.out.println();
            long d1 = System.currentTimeMillis();
            System.out.println("Время начала обработки Функции 2: "+d1);
            Integer q;
            q = functions.function2(MH,MK,ML);
            long d = System.currentTimeMillis();
            System.out.println("Ответ функции 2 : макимальное значение матрицы : "+q+" ; время окончания F2 : "+d+" Длительность потока : "+(d-d1));
        });

        Thread t3 = new Thread(()->{
            System.out.println();
            long d1 = System.currentTimeMillis();
            System.out.println("Время начала обработки Функции 3: "+d1);
            Integer s;
            s = functions.function3(MO,MP,R,T);
            long d = System.currentTimeMillis();
            System.out.println("Ответ функции 3 : макимальное значение матрицы : "+s+" ; время окончания F3 : "+d+" Длительность потока : "+(d-d1));

        });

        t1.start();
        t2.start();
        t3.start();


    }

    private static Integer getRandomInt(Integer min, Integer max) {
        Random rn = new Random();
        int n = max - min + 1;
        int i = rn.nextInt() % n;
        return min + i;
    }


}
