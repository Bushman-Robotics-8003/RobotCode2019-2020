package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.subsystems.driveTrain;

public class logitechController{
	private static double speedLimiter = 1.0;
	private static Joystick controller = IO.controller;

	// handles the driving of the robot
	public static void controlDrive() {
	    // the different input method on the controller
		// joysticks, triggers, etc.
		double leftStickY = controller.getRawAxis(RobotMap.leftStickYAxisId);
		double rightStickX = controller.getRawAxis(RobotMap.rightStickXAxisId);
		double leftTrigger = controller.getRawAxis(RobotMap.leftTriggerId);
		double rightTrigger = controller.getRawAxis(RobotMap.rightTriggerId);

		
		if (leftTrigger > 0 && rightTrigger == 0) {
			driveTrain.rotate(-leftTrigger * speedLimiter);
		}

		if (rightTrigger > 0 && leftTrigger == 0) {
			driveTrain.rotate(rightTrigger * speedLimiter);
		}

		// if triggers aren't down and joystick isn't zero, drive
		if (rightTrigger == 0 && leftTrigger == 0) {
			driveTrain.move(-leftStickY * speedLimiter, rightStickX);
		}
	}
}
