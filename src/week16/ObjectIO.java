package src.week16;

import java.io.*;

public class ObjectIO {
    public static void main(String[] args) {

        WriteFile("files/ExampleObjIO.obj");
        ReadFile("files/ExampleObjIO.obj");

    }

    public static void WriteFile(String fileName) {
        try (ObjectOutputStream obOut = new ObjectOutputStream(new FileOutputStream(fileName))) {

            Cat myCat = new Cat("Cat", 12, 200.5f, true);

            obOut.writeObject(myCat);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ReadFile(String fileName) {
        try (ObjectInputStream obIn = new ObjectInputStream(new FileInputStream(fileName))) {

            Cat myCat = (Cat) obIn.readObject();

            System.out.println(myCat.name);
            System.out.println(myCat.age);
            System.out.println(myCat.cost);
            System.out.println(myCat.isMale);

        } catch (IOException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);

        }
    }
}
