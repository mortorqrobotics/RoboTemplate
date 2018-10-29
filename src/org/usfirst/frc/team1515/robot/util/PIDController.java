package org.usfirst.frc.team1515.robot.util;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class PIDController {
	
	private final double K_P;
	private final double K_I;
	private final double K_D;
	private final double DIMINISHER;
	
	double p_term;
	double i_term;
	double d_term;
	
	double error;
	double lastError;
	double errorSum;
	
	double target;
	double actual;
	double output;
	
	long time;
	long lastTime;
	long timeDifference;
	
	public PIDController(double K_P, double K_I, double K_D) {
		this.K_P = K_P;
		this.K_I = K_I;
		this.K_D = K_D;
		DIMINISHER = 1;
		timeDifference = 20;
	}
	
	public PIDController(double K_P, double K_I, double K_D, double DIMINISHER) {
		this.K_P = K_P;
		this.K_I = K_I;
		this.K_D = K_D;
		this.DIMINISHER = DIMINISHER;
		timeDifference = 20;
	}
	
	public double getOutput(double target, double actual) {
		this.target = target;
		this.actual = actual;
		time = System.currentTimeMillis();

		error = target - actual;
		timeDifference = time - lastTime;
		
		p_term = error * K_P;
		
		errorSum += error /** timeDifference */ * DIMINISHER;
		i_term = errorSum * K_I;
		
		d_term = (error - lastError)/* / timeDifference */; 
		d_term *= K_D;
		
		lastError = error;
		lastTime = time;
		output = p_term + i_term + d_term;
		
		return output;
	}
	
	public void reset() {
		 p_term = 0;
		 i_term = 0;
		 d_term = 0;

		 error = 0;
		 lastError = 0;
		 errorSum = 0;
		 
		 time = System.currentTimeMillis();
		 lastTime = System.currentTimeMillis();
		 timeDifference = 20;
	}
	
	public void printToSmartDashboard(String identifier) {
		SmartDashboard.putNumber(identifier + " target", target);
		SmartDashboard.putNumber(identifier + " measured", actual);
		SmartDashboard.putNumber(identifier + " output", output);
		SmartDashboard.putNumber(identifier + " timeDifference", timeDifference);
	
		SmartDashboard.putNumber(identifier + " error", error);
		SmartDashboard.putNumber(identifier + " p_term", p_term);
		SmartDashboard.putNumber(identifier + " i_term", i_term);
		SmartDashboard.putNumber(identifier + " d_term", d_term);
	}

}
