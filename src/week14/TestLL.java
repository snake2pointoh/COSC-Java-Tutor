package src.week14;

public class TestLL {
    public static void main(String[] args) {
        LinkedListRec<Integer> myLL = new LinkedListRec<Integer>();

        myLL.add(10); // 0
        myLL.add(11); // 1
        myLL.add(12); // 2
        myLL.add(13); // 3

        System.out.println(myLL.count);

        myLL.remove(12);

        System.out.println(myLL.count);

        myLL.insert(12, 2);

        System.out.println(myLL.count);

        System.out.println(myLL.find(12)); // should return 2
        System.out.println(myLL.get(3)); // should return 13
    }
}
