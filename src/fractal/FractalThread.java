package fractal;

import static fractal.Settings.*;
import static fractal.SettingsTree.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FractalThread extends Thread {

    private Fractal fractal;

    public FractalThread(Fractal fractal) {
        this.fractal = fractal;
    }

    @Override
    public void run() {
        while (!fractal.isDone()) {
            try {
                Thread.sleep(FRAME_LENGTH);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            fractal.nextStep();
        }
        System.out.println("done");
    }

}
