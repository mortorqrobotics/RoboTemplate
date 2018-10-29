package org.usfirst.frc.team1515.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ActionCommand extends Command {
	
	Runnable runnable;
	
	public ActionCommand(Runnable runnable, Subsystem... required) {
		this.runnable = runnable;
		for(Subsystem subsystem : required) {
			requires(subsystem);
		}
	}

	@Override
	protected void initialize() {
		runnable.run();
	}

	@Override
	protected void execute() {
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
