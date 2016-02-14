package org.usfirst.frc.team1065.robot.commands.Autonomous.Utility;

import org.usfirst.frc.team1065.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveToDistance extends Command {
	double speed, distance;
    public DriveToDistance(double speed, double distance, double time) {
        requires(Robot.drive);
        
        this.speed = speed;
        this.distance = distance;
        this.setTimeout(time);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drive.resetEncoders();
    	Robot.drive.resetAngle();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drive.DriveStraight(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return  Math.abs(Robot.drive.getLeftEncoderDistance()) >= distance || this.isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
