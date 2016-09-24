package pac;

import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by macbookair on 14.09.16.
 */
public class Functions {
//    static List<Integer> l = new LinkedList<Integer>(Arrays.asList(4, 7));
//    static List<Integer> l1 = new LinkedList<Integer>(Arrays.asList(4, 7));
//    static List<Integer> l2 = new LinkedList<Integer>(Arrays.asList(4, 7));
//    static List<List<Integer>> m1 = new LinkedList<List<Integer>>();
//    static List<List<Integer>> m2 = new LinkedList<List<Integer>>();
//    final int N;
//
//    public Functions(int n) {
//        N = n;
//    }

//    public static void main(String[] args) {
//        m1.add(l);
//        m1.add(l1);
//        m2.add(l);
//        m2.add(l1);
//        function1(l, l1, l2, m1, m2);
//        function2(m1, m2, m1);
//        function3(m1, m2, l,l1);
//    }

    /**
     * @param vectA
     * @param vectB
     * @param vectC
     * @param matrixMA
     * @param matrixME
     * @return vector E
     */
    public synchronized List<Integer> function1(List<Integer> vectA, List<Integer> vectB, List<Integer> vectC,
                                          List<List<Integer>> matrixMA, List<List<Integer>> matrixME) {
        List<List<Integer>> matr = new LinkedList<List<Integer>>();
        List<Integer> list;
        int n = vectA.size();
        if (n == vectB.size() && n == vectC.size() && n == matrixMA.size() && n == matrixME.size()) {
            //matrix * matrix
            for (int i = 0; i < n; i++) {
                list = new LinkedList<Integer>();

                for (int j = 0; j < n; j++) {
                    int a = 0;
                    for (int k = j; k < n; k++) {
                        a += matrixMA.get(i).get(k) * matrixME.get(k).get(j);
                    }
                    list.add(a);
                }
//                System.out.println(list.size());
                matr.add(list);

            }


            //vect * matrix
            list = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                int a = 0;
                for (int j = 0; j < n; j++) {
                    a += vectC.get(j) * matr.get(j).get(i);
                }
                a += vectA.get(i) + vectB.get(i);
                list.add(a);
            }


//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(matr.get(i).get(j) + "  ");
//                }
//                System.out.println();
//
//            }

//            list.forEach((e)->{
//                System.out.print(e+" ");
//            });

            return list;

        } else {
            throw new ArithmeticException("In function 1 parameters are invalid to execute");
        }
    }

    public synchronized Integer function2(List<List<Integer>> matr_H, List<List<Integer>> matr_K, List<List<Integer>> matr_L) {

        List<List<Integer>> matr = new LinkedList<List<Integer>>();
        List<Integer> list;
        int n = matr_H.size();
        if (n == matr_K.get(0).size() && n == matr_L.size()) {
            for (int i = 0; i < n; i++) {
                list = new LinkedList<Integer>();

                for (int j = 0; j < n; j++) {
                    int a = 0;
                    for (int k = j; k < n; k++) {
                        a += matr_H.get(i).get(k) * matr_K.get(k).get(j);
                    }
                    a -= matr_L.get(i).get(j);
                    list.add(a);
                }

                matr.add(list);
            }

            //sort matrix (max value will be (n,n))
            matr.sort((e1, e2) -> {
                e1.sort((p1, p2) -> {
                    if (p1 > p2) {
                        return 1;
                    } else if (p1 < p2) {
                        return -1;
                    } else return 0;
                });
                e2.sort((p1, p2) -> {
                    if (p1 > p2) {
                        return 1;
                    } else if (p1 < p2) {
                        return -1;
                    } else return 0;
                });

                int a1 = e1.get(0);
                int a2 = e2.get(0);
                if (a1 > a2) {
                    return 1;
                } else if (a1 < a2) {
                    return -1;
                } else return 0;

            });


            Integer max = matr.get(matr.size() - 1).get(matr.size() - 1);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(matr.get(i).get(j) + "  ");
//            }
//            System.out.println();
//
//        }

//        System.out.println("max: "+max+" ;   min:  "+min);
            return max;
        }else {
            throw new ArithmeticException("In function 2 parameters are invalid to execute");
        }

    }

    public synchronized Integer function3 (List<List<Integer>> matr_O, List<List<Integer>> matr_P,
                                     List<Integer> vectR, List<Integer> vectT){

        List<List<Integer>> matr = new LinkedList<List<Integer>>();
        List<Integer> list;
        List<Integer> listAddVect = new LinkedList<>();
        int n = matr_O.size();
        if (n == matr_O.get(0).size() && n == matr_P.size()) {
            for (int i = 0; i < n; i++) {
                list = new LinkedList<Integer>();

                for (int j = 0; j < n; j++) {
                    int a = 0;
                    for (int k = j; k < n; k++) {
                        a += matr_O.get(i).get(k) * matr_P.get(k).get(j);
                    }
//
                    list.add(a);
                }
//
                matr.add(list);

                listAddVect.add(vectR.get(i) + vectT.get(i)); //R+T
            }

            list = new LinkedList<Integer>();
            for (int i = 0; i < n; i++) {
                int a = 0;
                for (int j = 0; j < n; j++) {
                    a += listAddVect.get(j) * matr.get(j).get(i);
                }
                list.add(a);
            }
            //sort vect , max value will be get(n)
            list.sort((p1,p2)->{
                if (p1 > p2) {
                    return 1;
                } else if (p1 < p2) {
                    return -1;
                } else return 0;
            });


            Integer max = list.get(list.size()-1);

//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(matr.get(i).get(j) + "  ");
//            }
//            System.out.println();
//
//        }
//
//            for (int i = 0; i < n; i++) {
//                System.out.print(listAddVect.get(i) + " ");
//            }
//            System.out.println();
//            for (int i = 0; i < n; i++) {
//                System.out.print(list.get(i) + " ");
//            }
//            System.out.println(max);



//        System.out.println("max: "+max+" ;   min:  "+min);
            return max;
        }else {
            throw new ArithmeticException("In function 3 parameters are invalid to execute");
        }

    }
}

















