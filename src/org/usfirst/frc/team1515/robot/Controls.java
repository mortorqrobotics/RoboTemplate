package org.usfirst.frc.team1515.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;

public class Controls {
	
	public static final int DRIVE_STICK = 0;
	public static final int MANIPULATOR_STICK = 3;
	
	public static final int X_AXIS = 0;
	public static final int Y_AXIS = 1;
	
//	make sure THROTTLE value is correct
	public static final int THROTTLE = 5;
	
//	work on new drift code 
	public static final int DRIFT = 3

//	twisting/turning now set to seperate thumbstick (change it here)
	public static final int TWIST = 4;
	public static final int TURN_SPEED = 6;

	public static final Button SHIFT_TO_HIGH_GEAR = new JoystickButton(Robot.driveStick, 3);
	public static final Button SHIFT_TO_LOW_GEAR = new JoystickButton(Robot.driveStick, 4);
	public static final Button TOGGLE_PID = new JoystickButton(Robot.driveStick, 1);
	public static final Button REVERSE_DRIVETRAIN = new JoystickButton(Robot.manipStick, 7);
}
