/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.Robot;
import frc.robot.RobotMap;


/**
 * Add your docs here.
 */


public class Auto extends Subsystem {
  /**
   * Add your docs here.
   */

  private PIDController controller;
  // private static AnalogInput sensor = new AnalogInput(RobotMap.UltrasonicPort);
  private double Kp;
  private double Ki;
  private double Kd;

  public Auto() {
    Kp = RobotMap.KpValue;
    Ki = RobotMap.KiValue;
    Kd = RobotMap.KdValue;
    controller = new PIDController(Kp, Ki, Kd);
  }

  @Override
  protected void initDefaultCommand() {
    
  }

  public void execute(double measurement) {
    double leftError = getSetpoint() - Robot.driveTrain.getLeftEncoderDistance();
    double rightError = getSetpoint() - Robot.driveTrain.getRightEncoderDistance();
    Robot.driveTrain.setLeftMotors(leftError * Kp);
    Robot.driveTrain.setRightMotors(rightError * Kp);
    // Robot.driveTrain.curvatureDrive(controller.calculate(measurement) * 0.8, 0.0);
  }

  // public PIDController getController() {
  //   return controller;
  // }

  public void setSetpoint(double setpoint) {
    controller.setSetpoint(setpoint);
  }

  public double getSetpoint() {
    return controller.getSetpoint();
  }

  public boolean done() {
    return controller.atSetpoint();
  }

  // public double getUltraSonic() {
  //   return (sensor.getAverageBits() * 5) / 305; 
  // }

}
