/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;


/**
 * Add your docs here.
 */


public class Auto extends Subsystem {
  /**
   * Add your docs here.
   */

  private PIDController controller;
  private double Kp;
  private double Ki;
  private double Kd;

  public Auto() {
    Kp = SmartDashboard.getNumber("Kp", 0.7);
    Ki = 0;
    Kd = 0;
    // table = NetworkTable.getPath();
    // table.beginTransaction();
    // table.putDouble("speed", 0.5);
    // table.endTransaction();
    // Kp = NetworkTable.getTable("SmartDashboard").getDouble("speed");
    // Ki = NetworkTable.getTable("SmartDashboard").getDouble("speed");
    // Kd = NetworkTable.getTable("SmartDashboard").getDouble("speed");
    controller = new PIDController(Kp, Ki, Kd);
  }

  @Override
  protected void initDefaultCommand() {
    
  }

  public void execute(double measurement) {
    Robot.driveTrain.curvatureDrive(controller.calculate(measurement) * 0.6, 0.0);
  }

  public PIDController getController() {
    return controller;
  }

  public void setSetpoint(double setpoint) {
    controller.setSetpoint(setpoint);
  }

  public boolean done() {
    return controller.atSetpoint();
  }
}
