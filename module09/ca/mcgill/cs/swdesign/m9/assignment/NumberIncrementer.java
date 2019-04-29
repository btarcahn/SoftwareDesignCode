package ca.mcgill.cs.swdesign.m9.assignment;

class NumberIncrementer extends Thread {
    private NumberBox box;
    private Integer start;
    NumberIncrementer(NumberBox box) {
        super();
        this.start = 0;
        this.box = box;
    }
    NumberIncrementer(Integer start, NumberBox box) {
        super();
        this.start = start;
        this.box = box;
    }

    Integer current() {
        return new Integer(this.box.peek());
    }

    @Override
    public void run() {
        for (int i = 0; i < 5000; i++) {
            this.box.add(start++);
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class NumberPrinter extends Thread {
    private NumberBox box;
    NumberPrinter(NumberBox box) {
        this.box = box;
    }
    @Override
    public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println(box);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
