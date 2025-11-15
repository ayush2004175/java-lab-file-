class EvenThread extends Thread {
    public void run() {
        for (int i = 2; i <= 100; i += 2) {
            System.out.println("Even: " + i);
        }
    }
}

class OddThread extends Thread {
    public void run() {
        for (int i = 1; i <= 100; i += 2) {
            System.out.println("Odd: " + i);
        }
    }
}

public class EvenOddThreads {
    public static void main(String[] args) {
        EvenThread e = new EvenThread();
        OddThread o = new OddThread();

        e.start();
        o.start();
    }
}


