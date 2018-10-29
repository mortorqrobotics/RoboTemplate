package org.usfirst.frc.team1515.robot.util;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class CombinedButton {
	
	JoystickButton[] buttons;
	
	public CombinedButton(int[] ports, Joystick joystick) {
		buttons = new JoystickButton[ports.length];
		for (int i = 0; i < ports.length; i++) {
			buttons[i] = new JoystickButton(joystick, ports[i]);
		}
	}
}
