package org.usfirst.frc.team1515.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

public class Delay extends Command {

    public Delay(double time) {
    	setTimeout(time);
    }

    protected boolean isFinished() {
        return isTimedOut();
    }

}
