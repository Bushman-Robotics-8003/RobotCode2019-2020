package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RobotMap {
	// Victor motors
	public static final int masterMotorLeftId = 1;
	public static final int slaveMotorLeftId = 0;
	public static final int masterMotorRightId = 3;
	public static final int slaveMotorRightId = 2;
	public static final int intakeMotorId = 0;
	public static final int shooterMotorId = 1;

	// TODO give these motors an ID
	public static final int winchMotor1Id = -1;
	public static final int winchMotor2Id = -1;
	public static final int liftMotorId = -1;

	// Joystick
	public static final int joystickId = 0;
	public static final int leftStickYAxisId = 1;
	public static final int rightStickXAxisId = 4;
	
	// Controller triggers and buttons
	public static final int leftTriggerId = 2;
	public static final int rightTriggerId = 3;
	public static final int rightButtonId = 6;
	public static final int leftButtonId = 5;
	public static final int aButtonId = 1;
	public static final int xButtonId = 3;
	public static final int yButtonId = 4;
	public static final int leftArrowButtonId = 7;

	//Proximity Senor
	public static final int UltrasonicPort = 0; 

	// PID Values
	public static final double KpValue = SmartDashboard.getNumber("Kp", 0.5);
	public static final double KiValue = SmartDashboard.getNumber("Ki", 0);
	public static final double KdValue = SmartDashboard.getNumber("Kd", 0);
}
