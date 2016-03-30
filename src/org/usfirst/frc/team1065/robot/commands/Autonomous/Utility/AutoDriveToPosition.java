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
    		    	addSequential(new RotateToAngle(.55, 60, 5));
    		    	addSequential(new DriveToDistance(.5,65,5));
    		    	break;
    		    case Left:
    		    	addSequential(new PosDriveSignature(6,98,58,10));
    		    	break;
    		    case Middle:
    		    	addSequential(new PosDriveSignature(-24,105,58,10));
    		    	break;
    		    case Right:
    		    	addSequential(new PosDriveSignature(-42,129,58,10));
    		    	break;
    		    case FarRight:
    		    	addSequential(new PosDriveSignature(-55,162,58,10));
    		    	break;
    			default:
    				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Center){
    		switch(startingPosition){
		    case FarLeft:
		    	addSequential(new PosDriveSignature(65,130,-1,10));
		    	break;
		    case Left:
		    	addSequential(new PosDriveSignature(52,93,-1,10));
		    	break;
		    case Middle:
		    	addSequential(new PosDriveSignature(25,65,-1,10));
		    	break;
		    case Right:
		    	addSequential(new PosDriveSignature(-20,63,0,10));
		    	break;
		    case FarRight:
		    	addSequential(new PosDriveSignature(-50,88,0,10));
		    	break;
			default:
				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Right){
    		switch(startingPosition){
		    case FarLeft:
		    	addSequential(new PosDriveSignature(91,189,-1,97,-58,10));
		    	break;
		    case Left:
		    	addSequential(new PosDriveSignature(58,173,-58,10));
		    	break;
		    case Middle:
		    	addSequential(new PosDriveSignature(47,138,-58,10));
		    	break;
		    case Right:
		    	addSequential(new RotateToAngle(.5, 60, 5));
		    	addSequential(new DriveToDistance(.5,45,5));
		    	addSequential(new RotateToAngle(.55, 0, 5));
		    	addSequential(new DriveToDistance(.5,75,5));
		    	addSequential(new DriveForTime(.35,.35,1));
		    	addSequential(new DriveToDistance(-.35,13.5,5));
		    	addSequential(new RotateToAngle(.55, -60, 5));
		    	addSequential(new DriveToDistance(.4,12,5));
		    	break;
		    case FarRight:
		    	addSequential(new RotateToAngle(.5, 0, 5));
		    	addSequential(new DriveToDistance(.5,120,5));
		    	addSequential(new DriveForTime(.35,.35,2));
		    	addSequential(new DriveToDistance(-.35,13.5,5));
		    	addSequential(new RotateToAngle(.55, -60, 5));
		    	addSequential(new DriveToDistance(.4,12,5));
		    	break;
			default:
				break;
    		}
    	}
    }
}
