package controller;

import lejos.hardware.Button;
import lejos.hardware.ev3.LocalEV3;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.remote.ev3.RemoteEV3;

import java.rmi.RemoteException;

/**
 * Inspiration: http://www.robogalaxy.com/post/remote-control-of-ev3-robot-using-java
 */
public class MotorController {
//    RemoteEV3 robot;
    LocalEV3 robot;
    boolean driving, direction;
//    RMIRegulatedMotor rightwheel, leftwheel;
    EV3LargeRegulatedMotor rightwheel, leftwheel;

    public MotorController() {
//        this.robot = robot;
        this.driving = false;
        this.direction = false; //true = forwards, false = backwards

//        this.rightwheel = robot.createRegulatedMotor("A", 'L');
//        this.leftwheel = robot.createRegulatedMotor("D", 'L');

        this.rightwheel = new EV3LargeRegulatedMotor(MotorPort.A);
        this.leftwheel = new EV3LargeRegulatedMotor(MotorPort.D);

    }

    public void wiggleTest(int wiggleness) {
        while(Button.ESCAPE.isUp() && driving) {
            wiggleness = directionHandling(wiggleness);
//            try {
                rightwheel.rotate(wiggleness);
                leftwheel.rotate(wiggleness);
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }
    }

    public void driveTest(int fastness) {
        while(Button.ESCAPE.isUp() && driving) {
            fastness = directionHandling(fastness);
//            try {
                rightwheel.setSpeed(fastness);
                leftwheel.setSpeed(fastness);

                rightwheel.forward();
                leftwheel.forward();
//            } catch (RemoteException e) {
//                e.printStackTrace();
//            }
        }
    }

    /**
     * Handles the motor going the right direction, giving the coder an advantage of writing positive numbers for forward and negative for backwards
     * @param speed speed of wheels
     */
    private int directionHandling(int speed) {
        return direction ? speed : -speed;
    }

    /**
     * Toggle driving on/off
     * @param isDriving if robot is driving
     */
    public void setDriving(boolean isDriving) {
        driving = isDriving;
    }
}
