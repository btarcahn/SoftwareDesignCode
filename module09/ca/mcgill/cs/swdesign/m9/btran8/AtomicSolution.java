package ca.mcgill.cs.swdesign.m9.btran8;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * A thread-safe demonstration of how
 * concurrency should be properly done.
 * @author Bach Tran
 */
final class AtomicSolution {
    public static void main(String[] args) {
        atomicCounterExample();
        mutableNameExample();
    }

    private static void atomicCounterExample() {
        AtomicCounter atomicCounter = new AtomicCounter();
        Thread aThread = new Thread(() -> incrementAndPrint(atomicCounter));
        Thread bThread = new Thread(() -> incrementAndPrint(atomicCounter));

        aThread.start();
        bThread.start();
        System.out.println("Atomic Counter Example finished.");
    }

    private static void incrementAndPrint(AtomicCounter atomicCounter) {
        for (int i = 0; i < 100; i++) {
            System.out.print(atomicCounter.getNext() + " ");
        }
        System.out.println();
    }

    private static void mutableNameExample() {

    }
}

class AtomicCounter {
    private AtomicInteger aInteger = new AtomicInteger(0);
    int getNext() { return aInteger.incrementAndGet(); }
}

class AtomicName {
    private AtomicReference<String> aName;
    private AtomicInteger aCount;

    synchronized void setName(AtomicReference<String> pName) {
        aName = pName;
        aCount.incrementAndGet();
    }
}
