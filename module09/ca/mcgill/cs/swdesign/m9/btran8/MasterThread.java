package ca.mcgill.cs.swdesign.m9.btran8;

final class MasterThread {
    public static void main(String[] args) throws InterruptedException {
        joiningThreadsExample();
    }

    static void threadWaitingExample() throws InterruptedException {
        Thread threadA = new Thread(() -> System.out.println("Running thread A"));
        Thread threadB = new Thread(() -> System.out.println("Running thread B"));
        threadA.start();
        threadA.join();
        System.out.println("Main thread waiting for thread A");
        threadB.start();
    }

    static void joiningThreadsExample() throws InterruptedException{
        Thread primeThread = new PrimeThread(1000000);
        Thread aThread = new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                    System.out.println(this.getName() + " completed normally.");
                } catch (InterruptedException e) {
                    System.out.println(this.getName() + " get interrupted!");
                }
            }
        };
        primeThread.start();
        aThread.start();
    }
}

class PrimeThread extends Thread {
    long minPrime;

    PrimeThread(long minPrime) {
        this.minPrime = minPrime;
    }

    @Override
    public void run() {
        final int MAXIMUM_TRIALS = 1000000;
        // compute the next prime larger than minPrime
        int trails = 0;
        long nextPrime = minPrime + 1;
        while (!PrimeHelper.isPrime(nextPrime) && trails < MAXIMUM_TRIALS) {
            nextPrime++;
            trails++;
        }
        System.out.println("Next prime after " + minPrime + " is: " + nextPrime);
        System.out.println("All primes up to " + minPrime +  ":");
        PrimeHelper.printPrimes(minPrime);
    }

}

final class PrimeHelper {

    static boolean isPrime(long number) {
        if (number < 2) { return false; }
        for (long i = 2; i <= Math.sqrt(number); i ++) {
            if (number % i == 0) { return false; }
        }
        return true;
    }

    /**
     * Prints to console all primes
     * @param upto the upper boundary
     */
    static void printPrimes(long upto) {
        if (upto < 2) { return; }
        for (int i = 2; i <= upto; i++) {
            if (isPrime(i)) { System.out.print(i + " "); }
        }
        System.out.println();
    }
}
