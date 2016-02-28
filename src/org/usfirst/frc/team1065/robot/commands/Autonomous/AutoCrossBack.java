package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossBack extends CommandGroup {
    
    public  AutoCrossBack() {
        addSequential(new AutoCross());
        addSequential(new RotateToAngle(.6,179,5.0));
        addSequential(new AutoCross());
    }
}
