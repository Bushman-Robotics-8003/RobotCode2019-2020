/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private static VictorSP intakeMotor;
  private double motorSpeed = 1.0;

  public Intake() {
    intakeMotor = new VictorSP(RobotMap.intakeMotorId);

  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void stopMotor() {
    intakeMotor.set(0.0);
  }

  public void intakeIn() {
    intakeMotor.set(-motorSpeed);
  }

  public void intakeOut() {
    intakeMotor.set(motorSpeed);
  }
}
