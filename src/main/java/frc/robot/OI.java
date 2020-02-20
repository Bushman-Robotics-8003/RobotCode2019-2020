package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.commands.*;
import frc.robot.Robot;

public class OI {
    public Joystick controller = new Joystick(RobotMap.joystickId);
    public JoystickButton rightButton = new JoystickButton(controller, RobotMap.rightButtonId);
    public JoystickButton leftButton = new JoystickButton(controller, RobotMap.leftButtonId);
    public JoystickButton xButton = new JoystickButton(controller, RobotMap.xButtonId);
    public JoystickButton yButton = new JoystickButton(controller, RobotMap.yButtonId);
    public JoystickButton leftArrowButton = new JoystickButton(controller, RobotMap.leftArrowButtonId);

    public OI() {
        rightButton.whileHeld(new IntakeIn());
        leftButton.whileHeld(new IntakeOut());
        xButton.whileHeld(new Shoot());
        yButton.whileHeld(new UnShoot());
        leftArrowButton.whenPressed(new ResetEncoders());
    }
}