package src.week8;

public class HouseStuff {
    public static void main(String[] args) {
        String[][] house = HauntedHouse.genHauntedHouse();

        printHouse(house);

//        removeMonstersWithName(house, "TaxMan");
//        removeRandomMonsters(house, 10);

        removeFromFloor(house, 1, 3);

        System.out.println();

        printHouse(house);
    }

    public static void removeMonstersWithName(String[][] house, String monsterName) {
        // double loop
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                // if current monster == monsterName
                if(house[i][j].equals(monsterName)) {
                    // set to null!
                    house[i][j] = null;
                }
            }
        }

    }

    public static boolean removeFromFloor(String[][] house, int floorIndex, int roomIndex) {
        if(floorIndex < 0 || floorIndex >= house.length) {
            return false;
        }
        if(roomIndex < 0 || roomIndex >= house[floorIndex].length) {
            return false;
        }

        // rebuild the floor without the item to remove (roomIndex)
        String[] newFloor = new String[ house[floorIndex].length - 1 ];

        int counter = 0;
        for (int i = 0; i < house[floorIndex].length; i++) {
            if(i == roomIndex) {
                continue;
            }
            newFloor[counter] = house[floorIndex][i];
            counter++;
        }
        house[floorIndex] = newFloor;

        return true;
    }

    public static void removeRandomMonsters(String[][] house, int removeCount) {
        while (removeCount > 0) {
            // generate 2 random numbers
            int xPos = (int)(Math.random() * house.length);
            int yPos = (int)(Math.random() * house[xPos].length);

            // check that position if null
            if(house[xPos][yPos] == null){
                // if it is null - try again
                continue;
            }

            // if not null - remove the monster
            house[xPos][yPos] = null;
            removeCount--;
        }
    }

    public static void printHouse(String[][] house) {
        for (int i = 0; i < house.length; i++) {
            for (int j = 0; j < house[i].length; j++) {
                System.out.printf("%s\t", house[i][j]);
            }
            System.out.println();
        }
    }

}
