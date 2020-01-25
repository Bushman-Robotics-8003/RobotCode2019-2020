package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

public class logitechControlller{
	static Joystick controller = new Joystick(0);
	static double fullSpeed = 1.0;

	// handles the driving of the robot
	public static void controlDrive() {
	    // the different input method on the controller
		// joysticks, triggers, etc.
		double leftStickY = controller.getRawAxis(1);
		double rightStickX = controller.getRawAxis(4);
		double leftTrigger = controller.getRawAxis(2);
		double rightTrigger = controller.getRawAxis(3);

		// only let robot rotate in one direction at a time
		// start region
		if (leftTrigger > 0 && rightTrigger == 0) {
			RobotMap.rotate(-leftTrigger * 0.5);
		}

		if (rightTrigger > 0 && leftTrigger == 0) {
			RobotMap.rotate(rightTrigger * 0.5);
		}
		// end region

		// if triggers aren't down and joystick isn't zero, drive
		if (rightTrigger == 0 && leftTrigger == 0 && (leftStickY > 0 || leftStickY < 0)) {
			RobotMap.move(-leftStickY * 0.5, rightStickX);
		}
	}
}
