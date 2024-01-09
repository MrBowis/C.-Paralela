package Hilos;

import java.util.concurrent.Semaphore;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author Allan Panchi, GiftSoft Team, DCCO-ESPE
 */
public class Sprints extends Thread {

    private final Semaphore semaforo;
    private final int timeSprint;
    private final String number;
    private final javax.swing.JLabel lblPercentage;
    private final javax.swing.JProgressBar progressBar;
    private final javax.swing.JLabel lblPercentageT;
    private final javax.swing.JProgressBar progressBarT;

    public Semaphore getSemaforo() {
        return semaforo;
    }

    public int getTimeSprint() {
        return timeSprint;
    }

    public JLabel getLblPercentage() {
        return lblPercentage;
    }

    public JProgressBar getProgressBar() {
        return progressBar;
    }

    public JLabel getLblPercentageT() {
        return lblPercentageT;
    }

    public JProgressBar getProgressBarT() {
        return progressBarT;
    }

    public String getNumber() {
        return number;
    }

    public Sprints(int timeSprint, Semaphore semaforo, String name, javax.swing.JLabel lblPercentage, javax.swing.JProgressBar progressBar, javax.swing.JLabel lblPercentageT, javax.swing.JProgressBar progressBarT) {
        this.timeSprint = timeSprint;
        this.semaforo = semaforo;
        this.number = name;
        this.lblPercentage = lblPercentage;
        this.progressBar = progressBar;
        this.lblPercentageT = lblPercentageT;
        this.progressBarT = progressBarT;
    }

    @Override
    public void run() {
        try
        {
            int current, new_value = 0, cT = 0;

            long t_o = System.currentTimeMillis();
            System.out.println("El Sprint #" + number + " ha sido definido");
            semaforo.acquire();
            cT = progressBarT.getValue();

            for (int i = 1; i <= 100; i++)
            {
                Thread.sleep((timeSprint * 7000) / (101));
                current = progressBar.getValue();
                new_value = current + 1;

                progressBar.setValue(new_value);
                lblPercentage.setText(progressBar.getValue() + "%");

                if (number == "1")
                {
                    progressBarT.setValue((int) (cT + new_value * 0.1));
                    lblPercentageT.setText(progressBarT.getValue() + "%");
                } else if (number == "2" || number == "3")
                {
                    progressBarT.setValue((int) (cT + new_value * 0.25));
                    lblPercentageT.setText(progressBarT.getValue() + "%");
                } else if (number == "4" || number == "5")
                {
                    progressBarT.setValue((int) (cT + new_value * 0.20));
                    lblPercentageT.setText(progressBarT.getValue() + "%");
                }
            }

            semaforo.release();

            long t_f = System.currentTimeMillis();
            System.out.println("\n" + (t_f - t_o) + " milisegundos" + "\n" + "Sprint #" + number + " finalizado.");

        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}
