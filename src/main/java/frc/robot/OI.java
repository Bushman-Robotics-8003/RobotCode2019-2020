package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.RobotMap;
import frc.robot.commands.CurveDrive;

public class OI {
    public Joystick controller = new Joystick(RobotMap.joystickId);
    public JoystickButton xButton = new JoystickButton(controller, RobotMap.xButtonId);

    public OI() {
        xButton.toggleWhenPressed(new CurveDrive());
    }

}