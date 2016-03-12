package org.usfirst.frc.team1065.robot.commands.Autonomous.Utility;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap.StartingPosition;
import org.usfirst.frc.team1065.robot.RobotMap.TargetPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoDriveToPosition extends CommandGroup {
    
	public  AutoDriveToPosition(TargetPosition targetPosition) {
    	StartingPosition initialPosition = (StartingPosition) Robot.positionChooser.getSelected();
    	
    	if(targetPosition == TargetPosition.Left){
    		switch(initialPosition){
    		    case FarLeft:
    		    	addSequential(new PosDriveSignature(30,110,57.5,10)); //not tested in the field
    		    	break;
    		    case Left:
    		    	addSequential(new PosDriveSignature(6,98,56,10)); //not tested in the field
    		    	break;
    		    case Middle:
    		    	addSequential(new PosDriveSignature(-24,105,56,10)); //not tested in the field
    		    	break;
    		    case Right:
    		    	addSequential(new PosDriveSignature(-42,129,56,10)); //not tested in the field
    		    	break;
    		    case FarRight:
    		    	addSequential(new PosDriveSignature(-55,162,56,10)); //not tested in the field
    		    	break;
    			default:
    				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Center){
    		switch(initialPosition){
		    case FarLeft:
		    	addSequential(new PosDriveSignature(65,130,-1,10)); //not tested in the field
		    	break;
		    case Left:
		    	addSequential(new PosDriveSignature(52,93,-1,10)); //not tested in the field
		    	break;
		    case Middle:
		    	addSequential(new PosDriveSignature(25,65,-1,10)); //not tested in the field
		    	break;
		    case Right:
		    	addSequential(new PosDriveSignature(-20,63,0,10)); //not tested in the field
		    	break;
		    case FarRight:
		    	addSequential(new PosDriveSignature(-50,88,0,10)); //not tested in the field
		    	break;
			default:
				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Right){
    		switch(initialPosition){
		    case FarLeft:
		    	addSequential(new PosDriveSignature(91,189,-1,97,-55,10)); //not tested in the field
		    	break;
		    case Left:
		    	addSequential(new PosDriveSignature(58,173,-55,10)); //not tested in the field
		    	break;
		    case Middle:
		    	addSequential(new PosDriveSignature(47,138,-55,10)); //not tested in the field
		    	break;
		    case Right:
		    	addSequential(new PosDriveSignature(30,110,-55,10)); //not tested in the field
		    	break;
		    case FarRight:
		    	addSequential(new PosDriveSignature(6,97,-55,10)); //not tested in the field
		    	break;
			default:
				break;
    		}
    	}
    }
}
