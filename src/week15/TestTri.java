package src.week15;

public class TestTri {
    public static void main(String[] args) {
        TriFunction<Integer,Integer,Integer,Integer> myTri = (a, b, c) -> a * b * c;

//        System.out.println(myTri.apply(2,2,2));

        doTri(2,2,2, myTri);
        doTri(2,2,2, (a,b,c) -> a + b + c);
        doTri(2,2,2, TestTri::thingToDo);
    }

    public static void doTri(int a, int b, int c, TriFunction<Integer, Integer, Integer, Integer> func) {
        System.out.println(func.apply(a,b,c));
    }

    public static Integer thingToDo(Integer a, Integer b, Integer c) {
        return a - b - c;
    }
}
