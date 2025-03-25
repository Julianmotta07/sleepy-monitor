import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class SleeperMonitor implements Runnable {

    private Semaphore studentWainting;
    private Semaphore monitor;
    private boolean isBussy = false;

    public SleeperMonitor(Semaphore studentWainting, Semaphore monitor) {
        this.studentWainting = studentWainting;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (!isBussy) {
                    System.out.println("El monitor está durmiendo zzz \n" +
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
                System.out.println("El monitor está atendiendo a un estudiante");
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
                System.out.println("El monitor ha terminado de atender al estudiante");

                if (studentWainting.availablePermits() == 3) {
                    System.out.println("Como ya no hay más estudiantes para atender, el monitor se va a dormir zzz");

                } else {
                    System.out.println("Cómo no hay sillas, el estudiante se va a programar a la biblio...");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}