import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int numStudents = 5;
        int numSeats = 3;

        Semaphore studentWainting = new Semaphore(numSeats, true);
        Semaphore monitor = new Semaphore(0, true);
        Thread monitorThread = new Thread(new SleeperMonitor(studentWainting, monitor));
        monitorThread.start();

        for (int i = 0; i < numStudents; i++) {
            Thread studentThread = new Thread(new Student(i, studentWainting, monitor));
            studentThread.start();
        }
    }
}
