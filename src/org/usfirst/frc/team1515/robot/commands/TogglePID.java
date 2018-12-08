package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TogglePID extends Command {

//  focus on PID related issues later
    
    public TogglePID() {
        requires(Robot.driveTrain);
    }

    protected void initialize() {
    	Robot.driveTrain.togglePID();
    }

    protected boolean isFinished() {
        return true;
    }

}
