/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Robot;

public class DriveAuto extends PIDCommand {
  /**
   * Creates a new DriveAuto.
   */

  private double margin;
  private double setPoint;

  public DriveAuto(double p, double i, double d, double margin, double setPoint) {
    super(p, i, d);
    requires(Robot.driveTrain);

    this.margin = margin;
    this.setPoint = setPoint;
  }

  @Override
  protected void initialize() {
    setSetpoint(this.setPoint);
  }

  @Override
  public double returnPIDInput() {
    double avgDist = (Robot.driveTrain.getRightEncoderDistance() + Robot.driveTrain.getLeftEncoderDistance()) / 2;
    return avgDist;
  }

  @Override
  public void usePIDOutput(double output) {
    Robot.driveTrain.curvatureDrive(output, 0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(getSetpoint() - getPosition()) < margin;
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
