
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.*;
import lejos.hardware.sensor.EV3ColorSensor;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("Drive Regulated\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();

        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);

        colorSensor.setFloodlight(false);

                int i = 0;
                int whiteColourStreak = 0;
                int colour;

                while(Button.ESCAPE.isUp()) {
                    i++;
                    colour = colorSensor.getColorID();
                    System.out.println(i + " round, LL: " + colour);
                    if (colour == 6 && whiteColourStreak == 2){
                        Sound.beep();
                    } else if (colour == 6){
                        whiteColourStreak++;
                    } else {
                        whiteColourStreak = 0; //reset colour streak if other colour is found
                    }

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }



    }
}
