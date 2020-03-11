package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.*;

public class OI {
    public Joystick controller = new Joystick(RobotMap.joystickId);
    public JoystickButton rightButton = new JoystickButton(controller, RobotMap.rightButtonId);
    public JoystickButton leftButton = new JoystickButton(controller, RobotMap.leftButtonId);
    public JoystickButton aButton = new JoystickButton(controller, RobotMap.aButtonId);
    public JoystickButton xButton = new JoystickButton(controller, RobotMap.xButtonId);
    public JoystickButton yButton = new JoystickButton(controller, RobotMap.yButtonId);
    public JoystickButton leftArrowButton = new JoystickButton(controller, RobotMap.leftArrowButtonId);

    public OI() {
        SmartDashboard.putNumber("Kp", 0.5);
        SmartDashboard.putNumber("Ki", 0.0);
        SmartDashboard.putNumber("Kd", 0.0);
        rightButton.whileHeld(new IntakeOut());
        leftButton.whileHeld(new IntakeIn());
        aButton.whileHeld(new WinchPull());
        xButton.whileHeld(new Shoot());
        yButton.whileHeld(new UnShoot());
        leftArrowButton.whenPressed(new ResetEncoders());
    }
}