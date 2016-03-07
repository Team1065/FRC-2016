package org.usfirst.frc.team1065.robot.commands.Autonomous;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.RobotMap.TargetGoal;
import org.usfirst.frc.team1065.robot.RobotMap.TargetPosition;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.AutoDriveToPosition;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveForTime;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.DriveToDistance;
import org.usfirst.frc.team1065.robot.commands.Autonomous.Utility.SetIntakeSpeed;
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
    		addParallel(new DriveToDistance(.65, 30, 5.0));
    		addSequential(new SetIntakeSpeed(RobotMap.INTAKE_OUT_SPEED, 2.0));
    		addSequential(new ShootLow(6.0));
    	}
    	else{
    		addParallel(new DriveToDistance(.65, 20, 5.0));
    		addSequential(new SetShooterSpeed(4600));
    		addSequential(new DriveForTime(0, 0, 1.0));
    		addSequential(new ShootHigh(5.0));
    	}
    }
}
