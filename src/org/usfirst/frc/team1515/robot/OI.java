package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.commands.ReverseDrivetrain;
import org.usfirst.frc.team1515.robot.commands.TogglePID;

public class OI {

	public OI() {
		Controls.TOGGLE_PID.whenPressed(new TogglePID());
		
		Controls.REVERSE_DRIVETRAIN.whenPressed(new ReverseDrivetrain());
	}
}
