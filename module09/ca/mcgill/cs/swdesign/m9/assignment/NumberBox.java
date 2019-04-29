package ca.mcgill.cs.swdesign.m9.assignment;

import java.util.Stack;

/**
 * Number box is a box contains integers.
 * @author Bach Tran
 */
class NumberBox {
    protected Stack<Integer> box = new Stack<>();
    /**
     * adds an integer to the box
     * @param element the integer to be added
     */
    synchronized void add(int element) {
        box.add(element);
    }

    synchronized Integer peek() { return box.peek(); }

    synchronized Stack<Integer> getBox() { return this.box; }

    @Override
    public synchronized String toString() {
        return this.box.toString();
    }
}
