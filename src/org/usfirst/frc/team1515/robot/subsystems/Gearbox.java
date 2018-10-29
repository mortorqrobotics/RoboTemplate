package org.usfirst.frc.team1515.robot.subsystems;

import org.usfirst.frc.team1515.robot.Robot;
import org.usfirst.frc.team1515.robot.RobotMap;
import org.usfirst.frc.team1515.robot.util.MotorModule;
import org.usfirst.frc.team1515.robot.util.PIDController;
import org.usfirst.frc.team1515.robot.util.Pair;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Gearbox extends Subsystem {
	
	private MotorModule motorModule;
	private Encoder encoder;
	
	private PIDController pidController;

	final double K_P = 1.0;
	final double K_I = 0.001;
	final double K_D = 0.0;
	
	final int MAX_ENCODER_RATE = 15000;
	
	public Gearbox(int[] talonPorts, Pair<Integer> encoderPorts) {
		motorModule = new MotorModule(talonPorts);
		encoder = new Encoder(encoderPorts.first, encoderPorts.last);

		encoder.setMaxPeriod(.05);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(RobotMap.WHEEL_CIRCUMFERENCE / RobotMap.TICKS_PER_REV);
		encoder.setSamplesToAverage(10);
//		encoder.setReverseDirection(true);
		encoder.reset();
		
		pidController = new PIDController(K_P, K_I, K_D, 0.9);
	}

	public void setSpeedPID(double target) {
		double measuredSpeed = getEncoderRate() / MAX_ENCODER_RATE;
		double output = pidController.getOutput(target, measuredSpeed);
		setSpeed(output);
	}
	
	public void printToSmartDashboard(String identifier) {
		pidController.printToSmartDashboard(identifier);
	}
	
	public void setSpeed(double speed) {
		motorModule.setSpeed(speed);
	}
	
	public double getEncoderRate() {
		return encoder.getRate();
	}
	
	public int getEncoderTicks() {
		return encoder.get();
	}
	
	public double getDistance() {
		return Math.abs(encoder.getDistance());
	}
	
	public void resetEncoder() {
		encoder.reset();
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
