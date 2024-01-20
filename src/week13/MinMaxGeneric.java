package src.week13;

public class MinMaxGeneric {
    public static void main(String[] args) {

        Integer first = 10;
        Integer second = 14;

        Integer min = min(first,second);
//        Integer min = (Integer) minComp(first,second);
        Integer max = max(first,second);

        System.out.printf("Min is %d\nMax is %d",min, max);

    }

    public static <T extends Comparable<T>> T min(T first ,T second) {
        if(first.compareTo(second) < 0) {
            return first;
        } else {
            return second;
        }
    }

    public static Comparable minComp(Comparable first, Comparable second) {
        if(first.compareTo(second) < 0) {
            return first;
        } else {
            return second;
        }
    }

    public static <T extends Comparable<T>> T max(T first, T second) {
        if(first.compareTo(second) > 0) {
            return first;
        } else {
            return second;
        }
    }
}
