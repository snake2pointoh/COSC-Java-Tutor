package src.week8;

public class HauntedHouse {
    public static String[][] aMonsters = {
            {"Ghost", "2"},
            {"Vampire", "8"},
            {"WereWolf", "5"},
            {"Gremlin", "2"},
            {"Goblin", "3"},
            {"Mummy", "2"},
            {"Walker", "6"},
            {"Lobster", "1"},
            {"TaxMan", "10"},
            {"Dragon", "8"},
            {"Zombie", "6"},
            {"Racoon", "0"},
            {"Ghoul", "1"}
    };

    public static final int MONSTER_NAME_POS = 0;
    public static final int SCARE_FACTOR_POS = 1;
    public static final int BOUNDS = 8;

    /**
     * This method will generate an BOUNDS * BOUNDS matrix which is supposed to represent a Haunted house
     * Each "location" in the house will contain a randomly generated Monster whose name comes from the aMonsters array.
     *
     * @return
     */
    public static String[][] genHauntedHouse() {

        String[][] aHouse = new String[BOUNDS][BOUNDS];

        int nSlots = BOUNDS * BOUNDS;

        for (int i = 0; i < nSlots; i++) {
            placeMonster(aHouse);
        }

        return aHouse;
    }

    private static void placeMonster(String[][] aHome) {

        int nIdMonster = (int) (Math.random() * aMonsters.length);
        String sMonster = aMonsters[nIdMonster][MONSTER_NAME_POS];

        while (true) {
            int nRow = (int) (Math.random() * BOUNDS);
            int nCol = (int) (Math.random() * BOUNDS);

            if (aHome[nRow][nCol] == null) {
                //This is an empty Slot - fill it with the monster
                aHome[nRow][nCol] = sMonster;
                return;
            }
        }
    }
}
