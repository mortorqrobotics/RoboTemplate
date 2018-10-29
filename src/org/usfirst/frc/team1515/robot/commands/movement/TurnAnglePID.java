package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.util.PIDController;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnAnglePID extends Command {

	PIDController pidController;

	static final double K_P = 0.007;
	static final double K_I = 0.0000000001;
	static final double K_D = 0.0;
	
	static final double THRESHOLD = 1;

	double startAngle;
	double target;
	
	public TurnAnglePID(double target, double timeout) {
		requires(Robot.driveTrain);
		this.target = target;
		setTimeout(timeout);
	}

	@Override
	protected void initialize() {
		System.out.println("turning: " + target);
		startAngle = Robot.gyro.getAngle();
		pidController = new PIDController(K_P, K_I, K_D);
	}

	@Override
	protected boolean isFinished() {
		double measuredAngle = Robot.gyro.getAngle() - startAngle;
		double output = pidController.getOutput(target, measuredAngle);
		Robot.driveTrain.setSpeeds(output, -output);
		
		return (Math.abs(measuredAngle) >= Math.abs(target - THRESHOLD)
    			&& Math.abs(measuredAngle) <= Math.abs(target + THRESHOLD))
				|| isTimedOut();
	}

	@Override
	protected void end() {
		Robot.driveTrain.stop();
	}

	@Override
	protected void interrupted() {
		end();
	}
	
}

