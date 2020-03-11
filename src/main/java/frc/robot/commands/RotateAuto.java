/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.PID;

public class RotateAuto extends Command {

  private PID controller;

  public RotateAuto(double angle) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.driveTrain);

    // positve angles are counter clockwise and negative angles are clockwise
    controller = new PID(0.92 * (-angle));
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double leftOutput = controller.getLeftOutput();
    double rightOutput = controller.getRightOutput();
    Robot.driveTrain.setLeftMotors(leftOutput);
    Robot.driveTrain.setLeftMotors(rightOutput);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return controller.isDone();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.driveTrain.stopMotors();
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
