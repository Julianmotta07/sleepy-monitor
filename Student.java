import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

public class Student implements Runnable {

    private int id;
    private Semaphore seatsAvailable;
    private Semaphore wakeUpMonitor;

    public Student(int id, Semaphore seatsAvailable, Semaphore wakeUpMonitor) {
        this.id = id;
        this.seatsAvailable = seatsAvailable;
        this.wakeUpMonitor = wakeUpMonitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("\n[Estudiante " + id + "]\nSe encuentra programando...");
                Thread.sleep(ThreadLocalRandom.current().nextInt(2000, 5000));

                System.out.println("\n[Estudiante " + id + "]\nSe encuentra con un error y decide buscar ayuda del monitor.");

                if (seatsAvailable.tryAcquire()) { 
                    System.out.println("\n[Estudiante " + id + "]\nEncuentra un asiento libre en el corredor y se sienta a esperar su turno.");
                    wakeUpMonitor.release(); 
                    seatsAvailable.acquire(); 
                    System.out.println("\n[Estudiante " + id + "]\nSe encuentra recibiendo ayuda del monitor.");
                } else {
                    System.out.println("\n[Estudiante " + id + "]\nNo encuentra sillas disponibles en el corredor y se va a la sala de computo para volver más tarde.");
                }

            } catch (InterruptedException e) {
                System.out.println("\n[Estudiante " + id + "]\nAlgo interrumpió su búsqueda de ayuda.");
            }
        }
    }
}
