
package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.IntegrationTestRoutine;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForwardMP;
import org.usfirst.frc.team1515.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain driveTrain;
	public static Joystick driveStick;
	public static Joystick manipStick;
	public static Gyro gyro;

	public static Command autonomousCommand;
	public static Command testCommand;
	
	@Override
	public void robotInit() {		
		driveTrain = new DriveTrain(RobotMap.LEFT_MOTOR_PORTS, RobotMap.RIGHT_MOTOR_PORTS,
			RobotMap.LEFT_ENCODER_PORTS, RobotMap.RIGHT_ENCODER_PORTS
		);
		
		driveStick = new Joystick(Controls.DRIVE_STICK);
		manipStick = new Joystick(Controls.MANIPULATOR_STICK);
		gyro = new ADXRS450_Gyro();

		oi = new OI();
	}

	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void autonomousInit() {
		autonomousCommand = new DriveForwardMP(1.5, 10);
		autonomousCommand.start();
	}


	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		//driveTrain.setSpeed(0.5);
	}

	@Override
	public void teleopInit() {
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void testInit() {
		testCommand = new IntegrationTestRoutine();
		testCommand.start();		
	}
	
	@Override
	public void testPeriodic() {
		Scheduler.getInstance().run();
	}
}
