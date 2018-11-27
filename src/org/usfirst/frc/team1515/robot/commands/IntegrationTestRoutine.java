package org.usfirst.frc.team1515.robot.commands;

import org.usfirst.frc.team1515.robot.commands.movement.DriveForward;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class IntegrationTestRoutine extends CommandGroup {

    public IntegrationTestRoutine() {
    	addSequential(new DriveForward(36, 0.5));
        addSequential(new DriveForward(36, -0.5));
        addSequential(new Delay(0.5));
    }
}
