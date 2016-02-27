package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap.Obstacle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveForTime;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;

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
    			addSequential(new DriveToDistance(0.5, 120, 10.0));
    			break;
    		case LiftGate:
    		case Seesaw:
    		case Drawbridge:
    		case Door:
			default:
				addSequential(new AutoReach());
				break;
    	}
    }
}
