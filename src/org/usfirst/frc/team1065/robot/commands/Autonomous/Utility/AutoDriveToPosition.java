package org.usfirst.frc.team1065.robot.commands.Autonomous.Utility;

import javax.swing.text.Position;

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
    		    	addSequential(new PosDriveSignature(19.5,140,60,60)); //needs to be checked
    		    	break;
    		    case Left:
    		    	addSequential(new PosDriveSignature(0,120,60,60)); //exact measurements needed
    		    	break;
    		    case Middle:
    		    	addSequential(new PosDriveSignature(-30,130,60,60)); //exact measurements needed
    		    	break;
    		    case Right:
    		    	addSequential(new PosDriveSignature(-45,140,60,60)); //exact measurements needed
    		    	break;
    		    case FarRight:
    		    	addSequential(new PosDriveSignature(-60,180,60,60)); //exact measurements needed
    		    	break;
    			default:
    				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Center){
    		switch(initialPosition){
		    case FarLeft:
		    	addSequential(new PosDriveSignature(45,190,0,60)); //needs to be checked
		    	break;
		    case Left:
		    	addSequential(new PosDriveSignature(31,155,0,60)); //needs to be checked
		    	break;
		    case Middle:
		    	addSequential(new PosDriveSignature(12,70,0,60)); //needs to be checked
		    	break;
		    case Right:
		    	addSequential(new PosDriveSignature(-10,135,0,60)); //needs to be checked
		    	break;
		    case FarRight:
		    	addSequential(new PosDriveSignature(-30,145,0,60)); //needs to be checked
		    	break;
			default:
				break;
    		}
    	}
    	else if(targetPosition == TargetPosition.Right){
    		switch(initialPosition){
		    case FarLeft:
		    	addSequential(new PosDriveSignature(60,240,0,40,-45,20)); //exact measurements needed
		    	break;
		    case Left:
		    	addSequential(new PosDriveSignature(60,190,0,65,-45,20)); //exact measurements needed
		    	break;
		    case Middle:
		    	addSequential(new PosDriveSignature(45,140,0,40,-45,20)); //exact measurements needed
		    	break;
		    case Right:
		    	addSequential(new PosDriveSignature(30,140,-45,20)); //exact measurements needed
		    	break;
		    case FarRight:
		    	addSequential(new PosDriveSignature(0,140,-45,20)); //exact measurements needed
		    	break;
			default:
				break;
    		}
    	}
    }
}
