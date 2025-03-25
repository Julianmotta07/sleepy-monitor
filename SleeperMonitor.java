import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SleeperMonitor implements Runnable {

    private Semaphore studentsWaiting;
    private Semaphore monitor;
    private boolean isBussy = false;

    public SleeperMonitor(Semaphore studentsWaiting, Semaphore monitor) {
        this.studentsWaiting = studentsWaiting;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!isBussy) {
                    System.out.println("\nEl monitor está durmiendo zzz \n" +
                            "......................................-*++=====:..\r\n" + //
                            "......................................+*#######-..\r\n" + //
                            "..........................#######:........+##*:...\r\n" + //
                            ".........................=++..##-.......=###:.....\r\n" + //
                            "............................=##.......+##*:.......\r\n" + //
                            ".................#####*....###......*###..........\r\n" + //
                            "...................:#=....##=.....*##+............\r\n" + //
                            "..................=#:...:##***##:.#########*......\r\n" + //
                            ".................+#:....%##%*-::..................\r\n" + //
                            "................=####+............................\r\n" + //
                            "..........=#*.....................................\r\n" + //
                            ".....+#-..........................................\r\n");
                    monitor.acquire();
                }

                isBussy = true;
                System.out.println("\nEl monitor está atendiendo a un estudiante");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                System.out.println("\nEl monitor ha terminado de atender al estudiante");

                if (studentsWaiting.availablePermits() == 3) {
                    System.out.println("\nComo ya no hay más estudiantes para atender, el monitor se va a dormir zzz");
                    isBussy = false;
                } else {
                    studentsWaiting.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}