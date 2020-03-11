package frc.robot;

import edu.wpi.first.wpilibj.Timer;

public class PID {

    private double setpoint; 
    private static double Kp = RobotMap.KpValue;
    private static double Ki = RobotMap.KiValue;
    private static double Kd = RobotMap.KdValue;

    private double iLimit = 1;
    private double errorSum = 0;
    private double lastTimeStamp = 0;
    private double lastError = 0;

    public PID(double setpoint) {
        this.setpoint = setpoint;
    }

    public double getLeftOutput() {

        // calculations
        double error = setpoint - Robot.driveTrain.getLeftEncoderDistance();
        
        double dt = Timer.getFPGATimestamp() - lastTimeStamp;
        if (Math.abs(error) < iLimit) {
        errorSum += error * dt;
        }

        double errorRate = (error - lastError) / dt;
        double outputSpeed = Kp * error + Ki * errorSum + Kd + errorRate;

        // update "last" variables
        lastTimeStamp = Timer.getFPGATimestamp();
        lastError = error;

        return outputSpeed;
    }

    public double getRightOutput() {
        // calculations
        double error = setpoint - Robot.driveTrain.getRightEncoderDistance();
        
        double dt = Timer.getFPGATimestamp() - lastTimeStamp;
        if (Math.abs(error) < iLimit) {
        errorSum += error * dt;
        }

        double errorRate = (error - lastError) / dt;
        double outputSpeed = Kp * error + Ki * errorSum + Kd + errorRate;

        // update "last" variables
        lastTimeStamp = Timer.getFPGATimestamp();
        lastError = error;

        return outputSpeed;
    }

    public boolean isDone() {
        if (setpoint - Robot.driveTrain.getLeftEncoderDistance() < 0.5 && this.setpoint - Robot.driveTrain.getRightEncoderDistance() < 0.5) {
            return true;
        }
        return false;
    }
}