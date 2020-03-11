package logic;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3ColorSensor;
import lejos.hardware.sensor.EV3TouchSensor;

import static java.lang.Thread.sleep;

public class SensorLogic {

    public SensorLogic() {

    }

    public void checkSensor() {
        System.out.println("Drive Regulated\n");
        System.out.println("Press any key to start");

        Button.LEDPattern(4);    // flash green led and
        Sound.beepSequenceUp();    // make sound when ready.

        Button.waitForAnyPress();

        EV3ColorSensor colorSensor = new EV3ColorSensor(SensorPort.S1);
        EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S2);

        //colorSensor.setFloodlight(false);

        int i = 0;
        int whiteColourStreak = 0;
        int colour;

        while(Button.ESCAPE.isUp()) {

                    i++;
                    colour = colorSensor.getColorID();
                    System.out.println(i + " round, Cl: " + colour);
                    if (colour == 6 && whiteColourStreak == 1){
                        Sound.beep();
                    } else if (colour == 6){
                        whiteColourStreak++;
                    } else {
                        whiteColourStreak = 0; //reset colour streak if other colour is found
                    }

            try {
                sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("touch: ");

        }
    }
}