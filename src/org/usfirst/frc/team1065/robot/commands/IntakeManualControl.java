package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class IntakeManualControl extends Command {

    public IntakeManualControl() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.oi.getIntakeUpSwitch()){
    		Robot.intake.out(0.5);
    	}
    	else if(Robot.oi.getIntakeDownSwitch()){
    		//Check digital input in intake system once it is set up
    		Robot.intake.in(0.5);
    	}
    	else{
    		Robot.intake.set(0.0);
    	}
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
