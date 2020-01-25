package frc.robot;

import com.ctre.phoenix.motorcontrol.can.*;
import java.lang.Math;

public class RobotMap {
	// left side motors
	static WPI_VictorSPX masterMotorLeft = new WPI_VictorSPX(0);
	static WPI_VictorSPX slaveMotorLeft = new WPI_VictorSPX(1);

	// right side motors
	static WPI_VictorSPX masterMotorRight = new WPI_VictorSPX(2);
	static WPI_VictorSPX slaveMotorRight = new WPI_VictorSPX(3);

	public RobotMap() {
		
	}

	/**
	 * this method moves the robot as well as handles steering
	 * @param speed represents the speed that the motor will be set to
	 * @param turn is the amount one of the side's motors are decreased by to create a turning effect
	 */
	public static void move(double speed, double turn) {
		// default values for right/left turn
		double actualRightTurn = 1;
		double actualLeftTurn = 1;

		// assign the turn multiplier
		if (Math.signum(turn) == 1.0) {
			actualRightTurn = 1.5 - turn;
		} else if (Math.signum(turn) == -1.0) {
			actualLeftTurn = 1.5 - (turn * -1);
		}

		// set speed
		masterMotorLeft.set(speed * actualLeftTurn);
		masterMotorRight.set(-speed * actualRightTurn);

		// slave motors follow
		slaveMotorLeft.follow(masterMotorLeft);
		slaveMotorRight.follow(masterMotorRight);
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