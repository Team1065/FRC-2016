package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.RobotMap.TargetGoal;
import org.usfirst.frc.team1065.robot.RobotMap.TargetPosition;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.AutoDriveToPosition;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.SetShooterSpeed;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ShootHigh;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.ShootLow;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoShoot extends CommandGroup {
    
    public  AutoShoot(TargetGoal targetGoal, TargetPosition targetGoalPosition) {
    	addSequential(new AutoCross());
    	addSequential(new AutoDriveToPosition(targetGoalPosition));
    	
    	if(targetGoal == TargetGoal.Low){
    		addSequential(new DriveToDistance(.6, 12, 3));
    		addSequential(new ShootLow(5.0));
    	}
    	else{
    		addSequential(new SetShooterSpeed(3000));
    		addSequential(new ShootHigh(5.0));
    	}
    	
    }
}
