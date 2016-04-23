package org.usfirst.frc.team1065.robot.commands.Autonomous.Utility;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap.StartingPosition;
import org.usfirst.frc.team1065.robot.RobotMap.TargetPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveToPosition extends CommandGroup {
    
	public  AutoDriveToPosition(StartingPosition startingPosition, TargetPosition targetPosition) {
    	
    	if(targetPosition == TargetPosition.Left){
    		switch(startingPosition){
    		    case FarLeft:
    		    	addSequential(new RotateToAngle(.55, 61.5, 5));
    		    	addSequential(new DriveToDistance(.5,72,5));
    		    	break;
    		    case Left:
    		    	break;
    		    case Middle:
    		    	break;
    		    case Right:
    		    	break;
    		    case FarRight:
    		    	break;
    			default:
    				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Center){
    		switch(startingPosition){
		    case FarLeft:
		    	break;
		    case Left:
		    	break;
		    case Middle:
		    	addSequential(new RotateToAngle(.5, 30, 5));
		    	addSequential(new DriveToDistance(.5,36,5));
		    	addSequential(new RotateToAngle(.5, 0, 5));
		    	addSequential(new DriveToDistance(.5,20,5));
		    	addSequential(new DriveForTime(.35,.35,2));
		    	addSequential(new DriveToDistance(-.35,36,5));
		    	break;
		    case Right:
		    	addSequential(new RotateToAngle(.5, -30, 5));
		    	addSequential(new DriveToDistance(.5,12,5));
		    	addSequential(new RotateToAngle(.5, 0, 5));
		    	addSequential(new DriveToDistance(.5,20,5));
		    	addSequential(new DriveForTime(.35,.35,2));
		    	addSequential(new DriveToDistance(-.35,36,5));
		    	break;
		    case FarRight:
		    	break;
			default:
				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Right){
    		switch(startingPosition){
		    case FarLeft:
		    	break;
		    case Left:
		    	break;
		    case Middle:
		    	break;
		    case Right:
		    	addSequential(new RotateToAngle(.5, 60, 5));
		    	addSequential(new DriveToDistance(.5,45,5));
		    	addSequential(new RotateToAngle(.55, 0, 5));
		    	addSequential(new DriveToDistance(.5,80,5));
		    	addSequential(new DriveForTime(.35,.35,1));
		    	addSequential(new DriveToDistance(-.35,17,5));
		    	addSequential(new RotateToAngle(.55, -65, 5));
		    	break;
		    case FarRight:
		    	addSequential(new RotateToAngle(.5, 30, 5));
		    	addSequential(new DriveToDistance(.5,15,5));
		    	addSequential(new RotateToAngle(.5, 0, 5));
		    	addSequential(new DriveToDistance(.5,110,5));
		    	addSequential(new DriveForTime(.35,.35,2));
		    	addSequential(new DriveToDistance(-.35,17,5));
		    	addSequential(new RotateToAngle(.55, -65, 5));
		    	break;
			default:
				break;
    		}
    	}
    }
}
