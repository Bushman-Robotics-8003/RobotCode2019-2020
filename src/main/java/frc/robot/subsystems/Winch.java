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
public class Winch extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  private VictorSP winchMotor1;
  private VictorSP winchMotor2;
  private VictorSP liftMotor;

  // TODO determine motor speeds
  // TODO liftMotorSpeed needs to be negative????
  private int winchMotorSpeed = -1;
  private int liftMotorSpeed = -1;

  public Winch() {
    winchMotor1 = new VictorSP(RobotMap.winchMotor1Id);
    winchMotor2 = new VictorSP(RobotMap.winchMotor2Id);
    liftMotor = new VictorSP(RobotMap.liftMotorId);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void pull() {
    // TODO which needs to be negative????
    winchMotor1.set(winchMotorSpeed);
    winchMotor2.set(winchMotorSpeed);
  }

  public void lift() {
    liftMotor.set(liftMotorSpeed);
  }

  public void stopWinch() {
    winchMotor1.set(0.0);
    winchMotor2.set(0.0);
  }

  public void stopLift() {
    liftMotor.set(0.0);
  }
}
