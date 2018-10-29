package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class JoystickDrive extends Command {
	
    public JoystickDrive() {
    	requires(Robot.driveTrain);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrain.drive();
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
