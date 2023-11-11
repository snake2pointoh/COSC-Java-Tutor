package src.week8;

public class Stack {
    private String[] stackArr;
    private int posInStack;

    public Stack(int stackSize) {
        this.stackArr = new String[stackSize];
        this.posInStack = -1;
    }

    //push
    public boolean Push(String value) {
        if(posInStack >= stackArr.length-1)
        {
            return false;
        }

        stackArr[posInStack + 1] = value;
        posInStack++;

        return true;
    }

    //pop
    public String Pop() {
        if(posInStack < 0) {
            return null;
        }

        String returnValue = stackArr[posInStack];
        stackArr[posInStack] = null;
        posInStack--;

        return returnValue;
    }

    //peek
    public String Peek() {
        return stackArr[posInStack];
    }

    public int Count() {
        return posInStack + 1;
    }


}
