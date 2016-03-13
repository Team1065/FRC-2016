package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoReach extends CommandGroup {
    
    public  AutoReach() {
    	//addSequential(new DriveToDistance(0.4, 50, 15.0));
    	addSequential(new DriveToDistance(0.4, 135, 15.0));
		addSequential(new RotateToAngle(.5, 0, 15.0));
    }
}