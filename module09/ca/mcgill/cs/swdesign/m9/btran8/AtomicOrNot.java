package ca.mcgill.cs.swdesign.m9.btran8;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

final class AtomicOrNot {
    /**
     * Main method demonstrating the difference between atomic
     * and non-atomic.
     * @param args arguments input from console.
     */
    public static void main(String[] args) {
        exampleReadModifyWrite();
        exampleCheckThenAct();
    }

    /**
     * An example demonstrating the race condition of
     * <b>read-modify-write</b>.
     */
    static void exampleReadModifyWrite() {
        NonAtomicZeros nonAtomicZeros = new NonAtomicZeros();
        // create threads
        Thread aThread = new Thread(() -> nonAtomicZeros.add(10000));
        Thread bThread = new Thread(() -> nonAtomicZeros.add(20000));
        // play with them, expect an error
        aThread.start();
        try {
            aThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bThread.start();
        // we have to do this to achieve thread-safe.
        try {
            bThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(nonAtomicZeros);
        System.out.println("Read-Modify-Write demonstration done at " + LocalTime.now());
    }

    /**
     * An example demonstrating the race condition of
     * <b>check-then-act</b>.
     */
    static void exampleCheckThenAct() {
        final int REPEATS = 10000;
        NonAtomicIntegerSet nonAtomicIntegerSet = new NonAtomicIntegerSet();
        Thread aThread = new Thread(() -> {
            for (int i = 0; i < REPEATS; i++) {
                nonAtomicIntegerSet.add(i);
            }
        });
        Thread bThread = new Thread(() -> {
            for (int i = REPEATS - 1; i >=0; i--) {
                System.out.println("Set contains " + i + "? - " + nonAtomicIntegerSet.contains(i));
            }
        });
        aThread.start();
        try {
            aThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        bThread.start();
        System.out.println(nonAtomicIntegerSet);
        System.out.println("Check-Then-Act demonstration done at " + LocalTime.now());
    }
}

/**
 * A non atomic class demonstrating the non-atomic example.
 * This class is not atomic because of the ArrayList is one of its attributes.
 * Non-atomic category: read-modify-write.
 * @author Bach Tran
 */
class NonAtomicZeros {
    static final Integer ZERO = 0;
    ArrayList<Integer> zeros = new ArrayList<>();

    /**
     * Adds an extra zero to the object.
     * This indicates a read-modify-write procedure to the object,
     * making it <i><b>NOT</b> atomic</i>.
     */
    void add() {zeros.add(ZERO);}

    /**
     * Takes an integer signifies the number of zeros to be added,
     * then add those many zeros to the object.
     * This indicates a read-modify-write procedure to the object,
     * making it <i><b>NOT</b> atomic</i>.
     * @param quantity the number of zeros to be added.
     */
    void add(int quantity) {
        for (int i = 0; i < quantity; i++) { zeros.add(ZERO); }
    }
    Integer size() { return zeros.size(); }

    /**
     * Clears everything (all zeros) currently existing in the object.
     */
    void wipe() {
        zeros.clear();
        assert zeros.size() == 0;
    }
    @Override
    public String toString() {
        return this.size().toString() + this.zeros;
    }
}

/**
 * A non-atomic class falling in the category of
 * <i><b>check-then-act</b></i> operation.
 * @author Bach Tran
 * @author Jin Guo
 */
class NonAtomicIntegerSet {
    private Set aSet;
    NonAtomicIntegerSet() {
        aSet = new HashSet<>();
    }
    boolean contains(Integer element) { return aSet.contains(element); }

    /**
     * Add an integer to the Set.
     * It is actually a check-then-act operation provided in the
     * interface Set<T>. Therefore making the class to be non-atomic.
     * @param element the Integer to be added.
     * @return true if the operation was successful, false otherwise.
     */
    boolean add(Integer element) { return aSet.add(element); }

    /**
     * Removes the specified Integer from the Set.
     * It is actually a check-then-act operation provided in the
     * interface Set<T>. Therefore making the class to be non-atomic.
     * @param element the Integer to be removed.
     * @return true if the operation was successful, false otherwise.
     */
    boolean remove(Integer element) { return aSet.remove(element); }

    int size() { return aSet.size(); }
    @Override
    public String toString() {
        return aSet.toString();
    }
}