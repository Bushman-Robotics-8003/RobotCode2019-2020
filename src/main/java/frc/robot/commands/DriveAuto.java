/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Robot;
import frc.robot.subsystems.Auto;
import edu.wpi.first.wpilibj.command.Command;

public class DriveAuto extends Command {
  /**
   * Creates a new DriveAuto.
   */

  private Auto auto;
  double setpoint; 

  public DriveAuto(Auto auto, double setpoint) {
    this.auto = auto;
    this.setpoint = setpoint;
  }

  @Override
  protected void initialize() {
    auto.setSetpoint(this.setpoint);
  }

  @Override
  protected void execute() {
    auto.execute(Robot.driveTrain.getEncoderAvg());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return auto.done();
  }

  @Override
  protected void end() {
    Robot.driveTrain.stopMotors();
    this.cancel();
  }

  @Override
  protected void interrupted() {
    end();
  }
}
