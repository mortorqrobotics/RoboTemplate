package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ReverseDrivetrain extends Command {

    public ReverseDrivetrain() {
    	requires(Robot.driveTrain);
    }

    @Override
	protected void initialize() {
		Robot.driveTrain.reverse();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
	
	@Override
	protected void interrupted() {
		end();
	}
}
