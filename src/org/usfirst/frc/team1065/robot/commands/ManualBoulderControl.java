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
    	
    	if(Robot.oi.getIntakeOutSwitch()){
    		Robot.intake.setIntakeOut(RobotMap.INTAKE_OUT_SPEED);
    		
    		if(Robot.oi.getRightJoystickTrigger()){
    			Robot.intake.setQueuingDown(RobotMap.QUEUING_DOWN_SPEED);
    		}
    		else{
    			Robot.intake.setQueuingDown(0.0);
    		}
    	}
    	else if(Robot.oi.getIntakeInSwitch()){
    		
    		if((Robot.oi.getRightJoystickTrigger() && true)){//took out requirement for shooter to be at speed
				Robot.intake.setQueuingUp(RobotMap.QUEUING_SHOOTING_SPEED);
			}
    		else if(!Robot.intake.getQueuingIR()){//took out requirement for shooter to be at speed
				Robot.intake.setQueuingUp(RobotMap.QUEUING_UP_SPEED);
			}
			else{
				Robot.intake.setQueuingDown(0.0);
			}
    		
    		
    		if(Robot.intake.getQueuingIR()){
    			Robot.intake.setIntakeOut(0.0);//might want reverse
    		}
    		else{
    			Robot.intake.setIntakeIn(RobotMap.INTAKE_IN_SPEED);
    		}
    	}
    	else{
    		Robot.intake.setIntake(0.0);
    		Robot.intake.setQueuing(0.0);
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
