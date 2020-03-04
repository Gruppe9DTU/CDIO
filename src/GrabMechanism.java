import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;

public class GrabMechanism {

    public GrabMechanism() {

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
        Motor.A.setSpeed(1000);
        Motor.A.forward();
        LCD.drawString("FORWARD", 0, 0);
        Button.waitForAnyPress();
        LCD.drawString("BACKWARD", 0, 0);
        Motor.A.setSpeed(1000);
        Motor.A.backward();
        Button.waitForAnyPress();
        Motor.A.stop();
    }

}
