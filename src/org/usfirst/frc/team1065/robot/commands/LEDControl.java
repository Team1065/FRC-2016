package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class LEDControl extends Command {

	double blinkTimer;
    public LEDControl() {
    	requires(Robot.lighting);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	blinkTimer = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	boolean allLightsState = false;
    	
    	if(Robot.intake.getQueuingIR()){
    		if(blinkTimer % 1.0 < 0.5){
    			allLightsState = true;//blinking
    		}
    		blinkTimer += 0.020;// about 20 ms cycle
    	}
    	else if(Robot.shooter.onTarget()){
    		allLightsState = true;
    	}
    	
    	Robot.lighting.setLeftLED(allLightsState);
    	Robot.lighting.setFrontLED(allLightsState);
    	Robot.lighting.setRightLED(allLightsState);
    	Robot.lighting.setBackLED(allLightsState);
    	
    	SmartDashboard.putBoolean(" Boulder in Intake", Robot.intake.getQueuingIR());
    	SmartDashboard.putBoolean(" Shooter at Speed", Robot.shooter.onTarget());
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
