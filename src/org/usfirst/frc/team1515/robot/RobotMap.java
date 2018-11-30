package org.usfirst.frc.team1515.robot;

import org.usfirst.frc.team1515.robot.util.Pair;

public class RobotMap {
	
	public static final int[] LEFT_MOTOR_PORTS = {32, 34};
	public static final int[] RIGHT_MOTOR_PORTS = {31, 35};

	public static final Pair<Integer> LEFT_ENCODER_PORTS = new Pair<Integer>(0, 1);
	public static final Pair<Integer> RIGHT_ENCODER_PORTS = new Pair<Integer>(2, 3);

	public static final int TICKS_PER_REV = 2700;
//	in inches
	public static final double WHEEL_CIRCUMFERENCE = Math.PI * 6.25;
}
