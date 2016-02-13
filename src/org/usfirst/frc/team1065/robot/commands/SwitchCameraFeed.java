package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SwitchCameraFeed extends Command {
	
	public SwitchCameraFeed() {
        requires(Robot.camera);
    }

    protected void initialize() {
    }

	@Override
	protected void execute() {
		 boolean leftTrig = Robot.oi.getLeftJoystickTrigger();
		 
		 if(leftTrig){
			 Robot.camera.switchToFront();
			 
		 }
		 else
			 Robot.camera.switchToBack();
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}