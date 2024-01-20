package src.week13;

public class TestMyArrayList {
    public static void main(String[] args) {
        Integer[] values = {10,2,4,12,6};

        MyArrayList<Integer> MyList = new MyArrayList(values);

        Integer get = MyList.getAt(1);

        System.out.println(get);
    }
}
