/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.PID;
import edu.wpi.first.wpilibj.command.Command;

public class DriveAuto extends Command {
  /**
   * Creates a new DriveAuto.
   */

  
  private PID controller;

  public DriveAuto(double setpoint) {
    this.controller = new PID(setpoint);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    double leftOutputSpeed = controller.getLeftOutput();
    double rightOutputSpeed = controller.getRightOutput();

    Robot.driveTrain.setLeftMotors(leftOutputSpeed);
    Robot.driveTrain.setRightMotors(-rightOutputSpeed);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return controller.isDone();
  }

  @Override
  protected void end() {
    Robot.driveTrain.stopMotors();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
