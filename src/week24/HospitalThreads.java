package src.week24;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HospitalThreads {

    public static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue(20);
    public static Integer OverflowCount = 0;
    public static Integer PatientsCount = 0;
    public static Long TotalTime = 0L;

    public static final int WALK_TIME = 20;
    public static final int MIN_NEW_PATIENT = 20;
    public static final int MAX_NEW_PATIENT = 50;
    public static final int MIN_PATIENT_TIME = 360;
    public static final int MAX_PATIENT_TIME = 600;
    public static final int SECONDS_SCALE = 1;

    public static final int MIN_DOCS = 3;
    public static final int MAX_DOCS = 10;

    public static boolean runSim = true;

    public static void main(String[] args) {
        for (int i = MIN_DOCS; i <= MAX_DOCS; i++) {
            runSim = true;
            OverflowCount = 0;
            PatientsCount = 0;
            TotalTime = 0L;

            ExecutorService executor = Executors.newFixedThreadPool(i + 1);

            executor.execute(HospitalThreads::CreatePatientsThread);

            for (int j = 0; j < i; j++) {
                executor.execute(HospitalThreads::DoctorThread);
            }

            try {
                Thread.sleep(8 * 60 * (60 * SECONDS_SCALE));

                runSim = false;
                executor.shutdown();
                while (!executor.isTerminated());

                System.out.printf("Run with docs: %d, patients treated: %d, patient time: %d, patients leaving: %d\n",
                        i, PatientsCount, TotalTime/PatientsCount.longValue(), OverflowCount);

            } catch (InterruptedException err) {
                err.printStackTrace();
            }

        }

    }

    // add patients
    public static void CreatePatientsThread () {
        Random random = new Random();

        while (runSim) {
            try {
                Thread.sleep(random.nextInt(MIN_NEW_PATIENT * SECONDS_SCALE, (MAX_NEW_PATIENT + 1) * SECONDS_SCALE));
                queue.add(random.nextInt(MIN_PATIENT_TIME * SECONDS_SCALE, (MAX_PATIENT_TIME + 1) * SECONDS_SCALE));

            } catch (IllegalStateException err) {
                OverflowCount += 1;
//                System.out.println("queue full");
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }

    // doctors consume patients
    public static void DoctorThread() {
        while (runSim) {
            Integer patientTime = queue.poll();

            if (patientTime == null) {
                continue;
            }

            Integer waitTime = (WALK_TIME * SECONDS_SCALE) + patientTime;

            synchronized (TotalTime) {
                TotalTime += waitTime.longValue();
            }

            synchronized (PatientsCount) {
                PatientsCount += 1;
            }

            try {
                Thread.sleep(waitTime);
            } catch (InterruptedException err) {
                err.printStackTrace();
            }
        }
    }

}
