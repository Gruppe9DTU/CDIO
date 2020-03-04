
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.utility.Delay;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Drive Regulated\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();

        final EV3ColorSensor sensorC = new EV3ColorSensor(SensorPort.S1);
        sensorC.setCurrentMode(1);

        Runnable ballReg = new Runnable() {
            @Override
            public void run() {
                boolean running = true;
                int i = 0;

                while(running) {
                    i++;
                    System.out.println(i + "round, LL: "+ sensorC.toString());

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (Button.readButtons() > 0){
                        running = false;
                    }
                }

            }
        };

        ballReg.run();

    }
}
