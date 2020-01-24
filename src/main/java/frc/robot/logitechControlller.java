package frc.robot;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi
//PLUG CONTROLLER INTO COMPUTER
public class logitechControlller{
  static Joystick controller = new Joystick(0);
  static double fullSpeed = 1.0;
  // public static final int LeftStickY = 1;
      
  // public double GetRawAxis(int axis) {
  //   return controller.getRawAxis(1);
  // }
  public static void controlDrive() {
    double leftStickY = controller.getRawAxis(1);
    double rightStickX = controller.getRawAxis(4);
    double leftTrigger = controller.getRawAxis(2);
    double rightTrigger = controller.getRawAxis(3);
    if (leftTrigger > 0 && rightTrigger == 0) {
      RobotMap.rotate(-leftTrigger * 0.5);
    }
    if (rightTrigger > 0 && leftTrigger == 0) {
      RobotMap.rotate(rightTrigger * 0.5);
    }

    if (rightTrigger == 0 && leftTrigger == 0 && (leftStickY > 0 || leftStickY < 0)) {
      RobotMap.move(-leftStickY * 0.5, rightStickX);
    }
  }
}
