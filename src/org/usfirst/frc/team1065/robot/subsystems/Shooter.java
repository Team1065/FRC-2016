package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    private Talon shooterMotor;
    private Counter shooterCounter;
    private PIDController shooterController;
    
    private static double ratePIDPTerm, ratePIDITerm, ratePIDDTerm, ratePIDPeriod;
    
    public Shooter(){
    	shooterMotor = new Talon(RobotMap.SHOOTER_MOTOR_PORT);
    	shooterCounter = new Counter(RobotMap.SHOOTER_COUNTER_PORT);
    	shooterCounter.setDistancePerPulse(.5 * 60);//.5 revolution per pulse. 60 to transform seconds to minutes
    	shooterCounter.setPIDSourceType(PIDSourceType.kRate);
    	shooterCounter.setSamplesToAverage(10);
    	shooterCounter.setSemiPeriodMode(true);
    	
    	ratePIDPTerm = 100.0;//Making P very high so it behaves as a bang bang Controller
    	ratePIDITerm = 0.0;
    	ratePIDDTerm = 0.0;
    	ratePIDPeriod = 0.01;//10 ms, might want to make it 5 ms or 20 ms depending on the performance and CPU usage
    	
    	shooterController = new PIDController(ratePIDPTerm,ratePIDITerm, ratePIDDTerm, shooterCounter, shooterMotor, ratePIDPeriod);
    	shooterController.setOutputRange(0, 1.0);//don't allow reverse so that we can behave as a bang bang controller
    	shooterController.setAbsoluteTolerance(RobotMap.SHOOTER_TOLERANCE);
    	
    	LiveWindow.addActuator("Shooter", "Motor", shooterMotor);
    	LiveWindow.addActuator("Shooter", "PID Controller", shooterController);
    	LiveWindow.addSensor("Shooter", "Counter", shooterCounter);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void enablePIDController(){
    	if(!shooterController.isEnabled()){
    		shooterController.enable();
    	}
    }
    
    public void disablePIDController(){
    	if(shooterController.isEnabled()){
    		shooterController.disable();
    	}
    }
    
    public boolean onTarget(){
    	if(shooterController.isEnabled()){
    		return shooterController.onTarget();
    	}
    	else{
    		return true;
    	}
    }
    
    public void set(double speed){
    	//check if we should be setting the motor or the controller
    	if(shooterController.isEnabled()){
    		shooterController.setSetpoint(speed);
    	}
    	else{
    		shooterMotor.set(speed);
    	}
    	
    	//TODO: delete
    	SmartDashboard.putNumber("Shooter Speed", shooterCounter.getRate());
    }
}

