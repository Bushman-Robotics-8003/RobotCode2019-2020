/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.DriveAuto;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.controller.PIDController;
// import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.*;




/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	private static final String kDefaultAuto = "Default";
	private static final String kCustomAuto = "My Auto";
	private String m_autoSelected;
	private final SendableChooser<String> m_chooser = new SendableChooser<>();

	public static DriveTrain driveTrain;
	public static PIDController controller;
	public static Auto auto;
	public static Intake intake;
	public static Shooter shooter;
	public static OI oi;
	private Command autonomousCommand;
	private double kp;
	private double kd;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
		m_chooser.addOption("My Auto", kCustomAuto);
		SmartDashboard.putData("Auto choices", m_chooser);
		CameraServer.getInstance().startAutomaticCapture();

		driveTrain = new DriveTrain();
		controller = new PIDController(0.5, 0, 0, 0.2);
		intake = new Intake();
		shooter = new Shooter();
		oi = new OI();
		kp = 0.5;
		kd = 0.01;
		// autonomousCommand = new DriveAuto(1.0, 0.5, 0.5, 0.1, 20);

		driveTrain.resetEncoders();

	}

	/**
	 * This function is called every robot packet, no matter the mode. Use
	 * this for items like diagnostics that you want ran during disabled,
	 * autonomous, teleoperated and test.
	 *
	 * <p>This runs after the mode specific periodic functions, but before
	 * LiveWindow and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {

	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {
		m_autoSelected = m_chooser.getSelected();
		// m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
		System.out.println("Auto selected: " + m_autoSelected);

		driveTrain.resetEncoders();
		controller.setSetpoint(10.0);
		auto = new Auto(controller);
		auto.enable();
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		// switch (m_autoSelected) {
		//   case kCustomAuto:
		//     // Put custom auto code here
		//     break;
		//   case kDefaultAuto:
		//   default:
		//     // Put default auto code here
		//     break;
		// }
		//Timer clock = new Timer(); 
		//clock.reset();
		//clock.start();

		// remember to add scheduler line when this starts
		// Scheduler.getInstance().run();
		// auto.periodic();
		double thing = (10.0 - Robot.driveTrain.getEncoderAvg()) * kp + (10.0 - (Robot.driveTrain.getEncoderAvg() / 0.02)) * kd;
		Robot.driveTrain.curvatureDrive(thing * 0.4, 0.0);
		SmartDashboard.putString("Left Motor Speed", Double.toString(driveTrain.getMasterMotorLeft().get()));
		SmartDashboard.putString("Right Motor Speed", Double.toString(driveTrain.getMasterMotorRight().get()));
		SmartDashboard.putString("Right Encoder", Double.toString(driveTrain.getRightEncoderDistance()));
		SmartDashboard.putString("Left Encoder", Double.toString(driveTrain.getLeftEncoderDistance()));

	}

	@Override
	public void teleopInit() {
		driveTrain.resetEncoders();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putString("Left Motor Speed", Double.toString(driveTrain.getMasterMotorLeft().get()));
		SmartDashboard.putString("Right Motor Speed", Double.toString(driveTrain.getMasterMotorRight().get()));
		SmartDashboard.putString("Right Encoder", Double.toString(driveTrain.getRightEncoderDistance()));
		SmartDashboard.putString("Left Encoder", Double.toString(driveTrain.getLeftEncoderDistance()));
		SmartDashboard.putString("stuff", Double.toString(Robot.driveTrain.getEncoderAvg()));
		// SmartDashboard.putData("PID Controller", auto.getController()); 
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
