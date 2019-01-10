package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.IntegrationTestRoutine;
import org.usfirst.frc.team1515.robot.commands.movement.DriveForwardMP;
import org.usfirst.frc.team1515.robot.subsystems.DriveTrain;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.CameraServer;
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
			RobotMap.LEFT_ENCODER_PORTS, RobotMap.RIGHT_ENCODER_PORTS);
		
		driveStick = new Joystick(Controls.DRIVE_STICK);
		manipStick = new Joystick(Controls.MANIPULATOR_STICK);
		gyro = new ADXRS450_Gyro();
		
		UsbCamera cam0 = CameraServer.getInstance().startAutomaticCapture(0);
		UsbCamera cam1 = CameraServer.getInstance().startAutomaticCapture(1);

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
// 		useless: autonomousCommand = new DriveForwardMP(1.5, 10);
// 		useless: autonomousCommand.start();
//	work-in-progress code to monitor autonomous speeds
//   	SmartDashboard.putNumber("L Speed: ", Robot.driveTrain.leftGearbox.getEncoderRate());
//    	SmartDashboard.putNumber("R Speed: ", Robot.driveTrain.rightGearbox.getEncoderRate());
	}

	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
		driveTrain.setSpeedPID(0.8);
//		currently a work-in-progress
//		used to be setSpeedPID
	}

	@Override
	public void teleopInit() {
		Robot.driveTrain.resetEncoders();
	}

	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
//		removed Robot.driveTrain.setSpeedPID(0.2);
		
//		use this code to test how straight robot goes
//		Robot.driveTrain.setSpeed(0.3);
		
//    	SmartDashboard.putNumber("L Speed (Ticks): ", Robot.driveTrain.leftGearbox.getEncoderTicks());
//    	SmartDashboard.putNumber("R Speed (Ticks): ", Robot.driveTrain.rightGearbox.getEncoderTicks());
//    	
//    	SmartDashboard.putNumber("L Speed (Rate): ", Robot.driveTrain.leftGearbox.getEncoderRate());
//    	SmartDashboard.putNumber("R Speed (Rate): ", Robot.driveTrain.rightGearbox.getEncoderRate());
		
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
