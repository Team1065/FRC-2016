package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap.Obstacle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveForTime;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ExtendManipulator;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ResetDriveAngle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RetractManipulator;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCross extends CommandGroup {
    
    public  AutoCross(Obstacle obstacle) {
    	addSequential(new ResetDriveAngle());
    	switch(obstacle){
    		case LowBar:
    			addSequential(new DriveToDistance(0.4, 214, 15.0));
    			addSequential(new RotateToAngle(.5, 0, 2.0));
    			break;
    		case RoughTerrian:
    		case Moat:
    		case Ramparts:
    			addSequential(new DriveToDistance(0.65, 170, 15.0));
    			addSequential(new RotateToAngle(.55, 0, 2.0));
    			break;
    		case RockWall:
    			addSequential(new DriveToDistance(0.65, 170, 15.0));
    			addSequential(new RotateToAngle(.55, 0, 2.0));
    			break;
    		case LiftGate:
    		case Seesaw:
    			addSequential(new ExtendManipulator(2.0));
    			addSequential(new DriveToDistance(-0.5, 170, 15.0));
    			addSequential(new RetractManipulator(1.0));
    			addSequential(new RotateToAngle(.55, 180, 15.0));
    			addSequential(new ResetDriveAngle());
    			break;
    		case Drawbridge:
    		case Door:
			default:
				//addSequential(new AutoReach());
				addSequential(new DriveToDistance(0.4, 135, 15.0));
    			addSequential(new RotateToAngle(.5, 0, 2.0));
				break;
    	}
    }
}
