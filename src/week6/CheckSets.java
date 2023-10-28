package src.week6;

public class CheckSets {
    public static void main(String[] args) {
        String set = "1112222333"; // can be any string
        int setSize = 3; // number of sequential similar characters

        int numOfSets = countSets(set,setSize);

        System.out.println(numOfSets);
    }

    public static int countSets(String set, int setSize) {
        int numOfSets = 0;

        // if there are less than SETSIZE-1 characters left then end
        // for each character check the SETSIZE-1 characters after it
        for (int i = 0; i < set.length() - (setSize-1); i++) {
            char currentChar = set.charAt(i);
            boolean foundSet = true;

            for (int j = 1; j < setSize; j++) {
                char nextChar = set.charAt(i+j);

                if(currentChar != nextChar) {
                    foundSet = false;
                }
            }

            // if the are the same then add one to the set count
            if(foundSet) {
                numOfSets++;
            }
        }
        return numOfSets;
    }
}
