package frc.robot;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.*;
import java.lang.Math;

public class RobotMap {
  static WPI_VictorSPX masterMotorLeft = new WPI_VictorSPX(0);
  static WPI_VictorSPX slaveMotorLeft = new WPI_VictorSPX(1);

  static WPI_VictorSPX masterMotorRight = new WPI_VictorSPX(2);
  static WPI_VictorSPX slaveMotorRight = new WPI_VictorSPX(3);

  //DifferentialDrive leftSide = new DifferentialDrive(masterMotorLeft, slaveMotorLeft);
  //DifferentialDrive rightSide = new DifferentialDrive(masterMotorRight, slaveMotorRight);
  DifferentialDrive drive = new DifferentialDrive(masterMotorLeft,masterMotorRight);

  public RobotMap() {
    //slaveMotorLeft.follow(masterMotorLeft);
    //slaveMotorRight.follow(masterMotorRight);
  }

  public static void move(double speed, double turn) {
    double actualRightTurn = 1;
    double actualLeftTurn = 1;
    if (Math.signum(turn) == 1.0) {
      actualRightTurn = 1.5 - turn;
    } else if (Math.signum(turn) == -1.0) {
      actualLeftTurn = 1.5 - (turn * -1);
    }
    masterMotorLeft.set(speed * actualLeftTurn);
    masterMotorRight.set(-speed * actualRightTurn);

    slaveMotorLeft.follow(masterMotorLeft);
    slaveMotorRight.follow(masterMotorRight);
    // drive.arcadeDrive(speed, 0.0);
    // .arcadeDrive(speed, 0.0);
    // rightSide.arcadeDrive(-speed, 0.0);
  }

  public static void rotate(double speed) {
    masterMotorLeft.set(speed);
    masterMotorRight.set(speed);

    slaveMotorLeft.follow(masterMotorLeft);
    slaveMotorRight.follow(masterMotorRight);
  }

}