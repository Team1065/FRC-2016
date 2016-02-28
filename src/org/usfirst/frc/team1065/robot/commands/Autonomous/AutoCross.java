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
    
    public  AutoCross() {
    	Obstacle obstacle = (Obstacle) Robot.obstacleChooser.getSelected();
    	switch(obstacle){
    		case LowBar:
    		case RoughTerrian:
    		case RockWall:
    		case Moat:
    		case Ramparts:
    			addSequential(new DriveToDistance(0.5, 135, 15.0));
    			break;
    		case LiftGate:
    		case Seesaw:
    			addSequential(new ExtendManipulator(1.0));
    			addSequential(new DriveToDistance(-0.5, 135, 15.0));
    			addSequential(new RetractManipulator(1.0));
    			addSequential(new RotateToAngle(.6, 180, 15.0));
    			addSequential(new ResetDriveAngle());
    			break;
    		case Drawbridge:
    		case Door:
			default:
				addSequential(new AutoReach());
				break;
    	}
    }
}
