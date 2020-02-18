/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.motorcontrol.can.*;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
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

  private static Encoder leftEncoder;
  private static Encoder rightEncoder;

  private static DifferentialDrive drive;

  private static double speedLimiter = 0.5;
  private static double turnLimiter = 0.3;

  public DriveTrain() {
    masterMotorLeft = new WPI_VictorSPX(RobotMap.masterMotorLeftId);
    slaveMotorLeft = new WPI_VictorSPX(RobotMap.slaveMotorLeftId);

    masterMotorRight = new WPI_VictorSPX(RobotMap.masterMotorRightId);
    slaveMotorRight = new WPI_VictorSPX(RobotMap.slaveMotorRightId);

    leftEncoder = new Encoder(2, 3, true, EncodingType.k4X);
    leftEncoder.setDistancePerPulse(1./256.);

    rightEncoder = new Encoder(0, 1, false, EncodingType.k4X);
    rightEncoder.setDistancePerPulse((2*Math.PI*0.25) / 360);



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

  public void curvatureDrive(double speed, double turn) {
    drive.curvatureDrive(speed * speedLimiter, turn * turnLimiter, true);
  }

  public void stopMotors() {
    drive.curvatureDrive(0, 0, true);
  }

  public WPI_VictorSPX getMasterMotorLeft() {
    return masterMotorLeft;
  }

  public WPI_VictorSPX getMasterMotorRight() {
    return masterMotorRight;
  }

  public double getRightEncoderDistance() {
    return rightEncoder.getDistance();
  }

  public double getLeftEncoderDistance() {
    return leftEncoder.getDistance();
  }

  public double getEncoderAvg() {
    return (getLeftEncoderDistance() + getRightEncoderDistance()) / 2;
  }

  public void resetEncoders() {
    rightEncoder.reset();
    leftEncoder.reset();
  }
}
