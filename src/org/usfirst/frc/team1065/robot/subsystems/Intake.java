package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.IntakeManualControl;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Intake extends Subsystem {
    Talon intakeMotor;
    
	public Intake(){
		intakeMotor = new Talon(RobotMap.INTAKE_MOTOR_PORT);
		
		LiveWindow.addActuator("Intake","Intake Motor", intakeMotor);
	}

    public void initDefaultCommand() {
        setDefaultCommand(new IntakeManualControl());
    }
    
    public void in(double speed){
    	intakeMotor.set(Math.abs(speed));
    }
    
    public void out(double speed){
    	intakeMotor.set(- Math.abs(speed));
    }
    
    public void set(double speed){
    	intakeMotor.set(speed);
    }
}

