package ca.mcgill.cs.swdesign.m9.assignment;

/**
 * Main class for assigment 09.
 * @author Bach Tran
 */
public class AssignmentNineMainClass {
    public static void main(String[] args) {
        System.out.println("Program run.");
        NumberBox box = new NumberBox();
        Thread incrementer = new NumberIncrementer(box);
        Thread printer = new NumberPrinter(box);
        incrementer.start();
        printer.start();
    }
}
