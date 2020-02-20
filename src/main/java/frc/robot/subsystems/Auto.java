/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import frc.robot.Robot;


/**
 * Add your docs here.
 */
public class Auto extends PIDSubsystem {

  /**
   * Add your docs here.
   */


  public Auto(PIDController controller) {
    // Intert a subsystem name and PID values here
    super(controller);

    // Use these to get going:
    // setSetpoint() - Sets where the PID controller should move the system
    // to
    // enable() - Enables the PID controller.
    setSetpoint(10.0);
  }

  @Override
  public void periodic() {
    useOutput(getMeasurement(), 10.0);
  }

  @Override
  public double getMeasurement() {
    return Robot.driveTrain.getEncoderAvg();
  }

  @Override
  protected void useOutput(double output, double setpoint) {
    Robot.driveTrain.curvatureDrive(output, 0.0);
  }

  public boolean atSetpoint() {
    return getController().atSetpoint();
  }

  public void stop() {
    Robot.driveTrain.curvatureDrive(0.0, 0.0);
  }

}
