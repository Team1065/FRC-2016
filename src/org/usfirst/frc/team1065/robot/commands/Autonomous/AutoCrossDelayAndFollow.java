package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap.Obstacle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveForTime;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ResetDriveAngle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RotateToAngle;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossDelayAndFollow extends CommandGroup {
    
    public  AutoCrossDelayAndFollow() {
    	addSequential(new DriveForTime(0, 0, 3.0));
    	addSequential(new DriveToDistance(0.4, 45, 10.0));
    	
    	Obstacle obstacle = (Obstacle) Robot.obstacleChooser.getSelected();
        if(obstacle != Obstacle.LiftGate && obstacle != Obstacle.Seesaw){
        	addSequential(new RotateToAngle(0.4, 90, 10.0));
        }
        else{
        	addSequential(new RotateToAngle(0.4, -90, 10.0));
        }
        
        addSequential(new ResetDriveAngle());
    	addSequential(new AutoCross());
    }
}
