import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.utility.Delay;

public class Main {



    public static void main(String[] args) {

        GrabMechanism grabMechanism = new GrabMechanism();

        grabMechanism.grabBall();


    }
}
