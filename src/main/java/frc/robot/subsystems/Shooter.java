/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * Add your docs here.
 */
public class Shooter extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private VictorSP shooterMotor;
  private double motorSpeed = 1.0;

  public Shooter() {
    shooterMotor = new VictorSP(RobotMap.shooterMotorId);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void stopMotor() {
    shooterMotor.set(0.0);
  }

  public void shoot() {
    shooterMotor.set(motorSpeed);
  }

  public void unShoot() {
    shooterMotor.set(-motorSpeed);
  }
}
