package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap.Obstacle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveForTime;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossDelayAndFollow extends CommandGroup {
    
    public  AutoCrossDelayAndFollow() {
    	addSequential(new DriveForTime(0, 0, 3.0));
    	addSequential(new DriveToDistance(0.4, 30, 10.0));
    	addSequential(new RotateToAngle(0.6, 90, 10.0));
    	addSequential(new AutoCross());
    }
}
