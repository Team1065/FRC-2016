package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoReach extends CommandGroup {
    
    public  AutoReach() {
        addSequential(new DriveToDistance(0.5, 50, 5.0));
    }
}