package src.week12;

import java.io.*;

public class ObjectStream {
    public static void main(String[] args) {
        Cat myCat = new Cat("bob", 12, 140.0f, true);

        writeObject("files/objectStream.obj", myCat);

        Cat readCat = readObject("files/objectStream.obj");

        System.out.println(readCat.name);
        System.out.println(readCat.age);
        System.out.println(readCat.cost);
        System.out.println(readCat.isMale);

    }

    private static void writeObject(String filename, Cat obj) {
        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(filename))) {

            output.writeObject(obj);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Cat readObject(String filename) {
        Cat returnCat = null;

        try(ObjectInputStream input = new ObjectInputStream(new FileInputStream(filename))) {

            Object obj = input.readObject();

            returnCat = (Cat) obj;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return returnCat;

    }
}
