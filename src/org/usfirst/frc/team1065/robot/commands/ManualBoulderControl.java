package org.usfirst.frc.team1065.robot.commands;

import org.usfirst.frc.team1065.robot.Robot;
import org.usfirst.frc.team1065.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class ManualBoulderControl extends Command {

    public ManualBoulderControl() {
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//intake roller
    	if(Robot.oi.getIntakeUpSwitch()){
    		Robot.intake.setIntakeOut(RobotMap.INTAKE_OUT_SPEED);
    	}
    	else if(Robot.oi.getIntakeDownSwitch()){
    		if(Robot.intake.getTopIR()){
    			Robot.intake.setIntake(0.0);
    		}
    		else{
    			Robot.intake.setIntakeIn(RobotMap.INTAKE_IN_SPEED);
    		}
    	}
    	else{
    		Robot.intake.setIntake(0.0);
    	}
    	
    	//queuing roller
    	if(Robot.oi.getRightJoystickTrigger()){
    		if(Robot.oi.getIntakeUpSwitch()){
        		//might want to either add a delay or check the speed of the intake to make sure it is up to speed.
        		Robot.intake.setQueuingDown(RobotMap.QUEUING_DOWN_SPEED);
        	}
    		else{
    			if(true){//shooter at speed
    				Robot.intake.setQueuingUp(RobotMap.QUEUING_UP_SPEED);
    			}
    			else if(!Robot.intake.getBottomIR()){
    				Robot.intake.setQueuingDown(RobotMap.QUEUING_DOWN_SPEED);
    			}
    			else{
    				//TODO: shooter set speed here
    				Robot.intake.setQueuing(0.0);
    			}
    		}
    	}
    	else{
    		if(Robot.oi.getIntakeDownSwitch() && !Robot.intake.getTopIR()){
    			Robot.intake.setQueuingUp(RobotMap.QUEUING_UP_SPEED);
    		}
    		else{
    			Robot.intake.setQueuing(0.0);
    		}
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
