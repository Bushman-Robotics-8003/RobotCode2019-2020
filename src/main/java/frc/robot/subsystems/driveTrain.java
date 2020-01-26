package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import java.lang.Math;

public class driveTrain {

    // perhaps try this
    // left side motors
    static WPI_VictorSPX masterMotorLeft = new WPI_VictorSPX(0);
    static WPI_VictorSPX slaveMotorLeft = new WPI_VictorSPX(1);

    // right side motors
    static WPI_VictorSPX masterMotorRight = new WPI_VictorSPX(2);
    static WPI_VictorSPX slaveMotorRight = new WPI_VictorSPX(3);

    static SpeedControllerGroup driveTrainLeft = new SpeedControllerGroup(masterMotorLeft, slaveMotorLeft);
    static SpeedControllerGroup driveTrainRight = new SpeedControllerGroup(masterMotorRight, slaveMotorRight);

    static DifferentialDrive drive = new DifferentialDrive(driveTrainLeft, driveTrainRight);

    // original working code //
    // left side motors
    // static WPI_VictorSPX masterMotorLeft = new WPI_VictorSPX(0);
    // static WPI_VictorSPX slaveMotorLeft = new WPI_VictorSPX(1);


    // right side motors
    // static WPI_VictorSPX masterMotorRight = new WPI_VictorSPX(2);
    // static WPI_VictorSPX slaveMotorRight = new WPI_VictorSPX(3);
    // original working code //
    
    
    public driveTrain() {
        
    }

    public static void move(double speed, double turn) {

        // perhaps try this
        // not sure if turn will actually turn the robot
        // and supposedly aracdeDrive will negate the right side motors
        drive.arcadeDrive(speed, turn);

        // original working code //
		// default values for right/left turn
		// double actualRightTurn = 1;
		// double actualLeftTurn = 1;

		// // assign the turn multiplier
		// if (Math.signum(turn) == 1.0) {
		// 	actualRightTurn = 1.5 - turn;
		// } else if (Math.signum(turn) == -1.0) {
		// 	actualLeftTurn = 1.5 - (turn * -1);
		// }

		// // set speed
		// masterMotorLeft.set(speed * actualLeftTurn);
		// masterMotorRight.set(-speed * actualRightTurn);

		// // slave motors follow
		// slaveMotorLeft.follow(masterMotorLeft);
        // slaveMotorRight.follow(masterMotorRight);
        // original working code //
	}

	/**
	 * this method allows the robot to rotate without moving from its current position
	 * @param speed represents the speed that the motor will be set to
	 */
	public static void rotate(double speed) {
		masterMotorLeft.set(speed);
		masterMotorRight.set(speed);

		slaveMotorLeft.follow(masterMotorLeft);
		slaveMotorRight.follow(masterMotorRight);
	}
}