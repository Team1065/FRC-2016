package org.usfirst.frc.team1065.robot.commands.Autonomous.Utility;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PosDriveSignature extends CommandGroup {
	
	/**
	 * Use: PosDriveSignature(angle 1, distance 1)
	**/
	
	public PosDriveSignature(double ang1, double dist1)
	{		
		addSequential(new RotateToAngle(.5, ang1, ang1/36));
		addSequential(new DriveToDistance(.6, dist1, dist1/4));
	}
	
	/**
	 * Use: PosDriveSignature(angle 1, distance 1, angle 2, distance 2)
	**/
	
	public PosDriveSignature(double ang1, double dist1, double ang2, double dist2)
	{		
		addSequential(new RotateToAngle(.5, ang1, ang1/36));
		addSequential(new DriveToDistance(.6, dist1, dist1/4));
		addSequential(new RotateToAngle(.5, ang2, (ang2-ang1)/36));
		addSequential(new DriveToDistance(.6, dist2, dist2/4));
	}
	
	/**
	 * Use: PosDriveSignature(angle 1, distance 1, angle 2, distance 2, angle 3, distance 3)
	**/
	
	public PosDriveSignature(double ang1, double dist1, double ang2, double dist2, double ang3, double dist3)
	{		
		addSequential(new RotateToAngle(.5, ang1, ang1/36));
		addSequential(new DriveToDistance(.6, dist1, dist1/4));
		addSequential(new RotateToAngle(.5, ang2, (ang2-ang1)/36));
		addSequential(new DriveToDistance(.6, dist2, dist2/4));
		addSequential(new RotateToAngle(.5, ang3, (ang3-(ang2-ang1))/36));
		addSequential(new DriveToDistance(.6, dist3, dist3/4));
		
	}

}

