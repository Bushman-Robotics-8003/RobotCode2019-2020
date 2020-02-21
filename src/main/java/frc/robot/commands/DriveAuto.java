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
import edu.wpi.first.wpilibj.controller.PIDController;

public class DriveAuto extends Command {
  /**
   * Creates a new DriveAuto.
   */

  Auto auto;


  public DriveAuto() {
    auto = new Auto(new PIDController(0.5, 0, 0));
  }

  @Override
  protected void initialize() {
    auto.setSetpoint(10.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return auto.atSetpoint();
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
