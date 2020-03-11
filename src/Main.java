import controller.MotorController;
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.remote.ev3.RemoteEV3;

public class Main {

    public static void main(String[] args) {


        //TODO All below is for testing purpose, delete when ready
        MotorController motor = new MotorController();
        motor.setDriving(true);
//        motor.wiggleTest(30);
        motor.driveTest(1000);

        Button.waitForAnyPress();
        motor.setDriving(false);
    }
}
