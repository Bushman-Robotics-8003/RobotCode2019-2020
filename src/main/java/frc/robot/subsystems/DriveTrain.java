/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.*;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.RobotMap;
import frc.robot.commands.Drive;


/**
 * Add your docs here.
 */
public class DriveTrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static WPI_VictorSPX masterMotorLeft;
  private static WPI_VictorSPX slaveMotorLeft;

  private static WPI_VictorSPX masterMotorRight;
  private static WPI_VictorSPX slaveMotorRight;

  private static DifferentialDrive drive;

  private static double speedLimiter = 0.5;

  public DriveTrain() {
    masterMotorLeft = new WPI_VictorSPX(RobotMap.masterMotorLeftId);
    slaveMotorLeft = new WPI_VictorSPX(RobotMap.slaveMotorLeftId);

    masterMotorRight = new WPI_VictorSPX(RobotMap.masterMotorRightId);
    slaveMotorRight = new WPI_VictorSPX(RobotMap.slaveMotorRightId);

    SpeedControllerGroup driveTrainLeft = new SpeedControllerGroup(masterMotorLeft, slaveMotorLeft);
    SpeedControllerGroup driveTrainRight = new SpeedControllerGroup(masterMotorRight, slaveMotorRight);

    drive = new DifferentialDrive(driveTrainLeft, driveTrainRight);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new Drive());
  }

  public void drive(double speed, double turn) {
    drive.arcadeDrive(speed * speedLimiter, turn * speedLimiter);
  }

  public void curvatureDrive(double speed, double turn) {
    drive.curvatureDrive(speed, turn, true);
  }
}
