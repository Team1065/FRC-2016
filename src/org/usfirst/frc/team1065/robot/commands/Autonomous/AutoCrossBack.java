package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap.Obstacle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ExtendManipulator;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ResetDriveAngle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RetractManipulator;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.RotateToAngle;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ShootLow;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoCrossBack extends CommandGroup {
    
    public  AutoCrossBack() {
        addSequential(new AutoCross());
        addSequential(new ShootLow(3.0));
        
        Obstacle obstacle = (Obstacle) Robot.obstacleChooser.getSelected();
        //Rotate if we are not  crossing the portcullis or seesaw because we traverse those backwards
        if(obstacle != Obstacle.LiftGate && obstacle != Obstacle.Seesaw){
        	addSequential(new RotateToAngle(.4,180,6.0));
        }
        
        addSequential(new AutoCross());
    }
}
