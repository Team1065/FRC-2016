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
    		switch(initialPosition){
		    case FarLeft:
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
    	else if(targetPosition == TargetPosition.Right){
    		switch(initialPosition){
		    case FarLeft:
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
    }
}
