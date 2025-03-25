import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        int numStudents = 5;
        int numSeats = 3;

        System.out.println(
                "$$$$$$\\  $$\\                                                         $$\\      $$\\                     $$\\   $$\\                         \r\n"
                        + //
                        "$$  __$$\\ $$ |                                                        $$$\\    $$$ |                    \\__|  $$ |                        \r\n"
                        + //
                        "$$ /  \\__|$$ | $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$\\   $$$$$$\\        $$$$\\  $$$$ | $$$$$$\\  $$$$$$$\\  $$\\ $$$$$$\\    $$$$$$\\   $$$$$$\\  \r\n"
                        + //
                        "\\$$$$$$\\  $$ |$$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\ $$  __$$\\       $$\\$$\\$$ $$ |$$  __$$\\ $$  __$$\\ $$ |\\_$$  _|  $$  __$$\\ $$  __$$\\ \r\n"
                        + //
                        " \\____$$\\ $$ |$$$$$$$$ |$$$$$$$$ |$$ /  $$ |$$$$$$$$ |$$ |  \\__|      $$ \\$$$  $$ |$$ /  $$ |$$ |  $$ |$$ |  $$ |    $$ /  $$ |$$ |  \\__|\r\n"
                        + //
                        "$$\\   $$ |$$ |$$   ____|$$   ____|$$ |  $$ |$$   ____|$$ |            $$ |\\$  /$$ |$$ |  $$ |$$ |  $$ |$$ |  $$ |$$\\ $$ |  $$ |$$ |      \r\n"
                        + //
                        "\\$$$$$$  |$$ |\\$$$$$$$\\ \\$$$$$$$\\ $$$$$$$  |\\$$$$$$$\\ $$ |            $$ | \\_/ $$ |\\$$$$$$  |$$ |  $$ |$$ |  \\$$$$  |\\$$$$$$  |$$ |      \r\n"
                        + //
                        " \\______/ \\__| \\_______| \\_______|$$  ____/  \\_______|\\__|            \\__|     \\__| \\______/ \\__|  \\__|\\__|   \\____/  \\______/ \\__|      \r\n"
                        + //
                        "                                  $$ |                                                                                                   \r\n"
                        + //
                        "                                  $$ |                                                                                                   \r\n"
                        + //
                        "                                  \\__|                                                                                                   ");

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
