package logic;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class GrabLogic {

    public GrabLogic() {

    }


    public void grabBall() {
     /*

        LCD.drawString("Tutor 4", 0, 0);
        Button.waitForAnyPress();
        while (Button.readButtons() > 0) ;
        LCD.clear();
        Motor.A.rotateTo(360, true);
        while (Motor.A.isMoving()) {
            Delay.msDelay(200);
            LCD.drawInt(Motor.A.getTachoCount(), 0, 0);
            if (Button.readButtons() > 0) Motor.A.stop();
        }
        LCD.drawInt(Motor.A.getTachoCount(), 0, 1);

        Button.waitForAnyPress();


*/
        LCD.drawString("Program 1", 0, 0);
        Button.waitForAnyPress();
        LCD.clear();
        Motor.B.setSpeed(1000);
        Motor.B.backward();
        LCD.drawString("FORWARD", 0, 0);
        Button.waitForAnyPress();
        LCD.drawString("BACKWARD", 0, 0);
        Motor.B.setSpeed(1000);
        Motor.B.forward();
        Button.waitForAnyPress();
        Motor.B.stop();
    }

}
