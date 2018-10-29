package org.usfirst.frc.team1515.robot.commands.movement;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveForwardMP extends Command {

	private double distance, time, startTime, currentTime;
	private double acceleration, velocity, speed;
	
	public static final int MAX_SPEED = 1;
	public static final int MIN_SPEED = 0;

	
	// Distance in Feet
    public DriveForwardMP(double distanceInFeet, double timeInSeconds) {
        requires(Robot.driveTrain);
        this.distance = distanceInFeet;
        this.time = timeInSeconds;
        setTimeout(time);
    }
    
    protected void initialize() {
    	acceleration = (9 * distance) / (2 * time * time);
    	velocity = (3 * distance) / (2 * time);
    	startTime = currentTime = System.currentTimeMillis() / 1000;
    }

    protected void execute() {
    	currentTime = (double) (System.currentTimeMillis() / 100) / 10 - startTime;
    	
    	if (currentTime <= time / 3) {
    		speed = acceleration * currentTime;
    	} else if (currentTime >= time / 3 * 2) {
    		speed = (time - currentTime) * acceleration;
    	} else {
    		speed = velocity;
    	} 
    	
    	//speed = (speed < 0) ? 0 : speed;
    	//speed = (speed > 1) ? 1 : speed;

    	SmartDashboard.putNumber("Speed: ", speed);
    	Robot.driveTrain.setSpeed(speed);
    }

    protected boolean isFinished() {
    	return isTimedOut();
    }

}
