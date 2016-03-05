package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.ManualShooterControl;

import edu.wpi.first.wpilibj.Counter;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem {
    private VictorSP shooterMotor;
    private Counter shooterCounter;
    private PIDController shooterController;
    private Solenoid shooterHood;
    
    private double ratePIDPTerm, ratePIDITerm, ratePIDDTerm, ratePIDPeriod;
    
    public Shooter(){  	
    	shooterHood = new Solenoid(RobotMap.SHOOTER_HOOD_PORT);
    	
    	shooterMotor = new VictorSP(RobotMap.SHOOTER_MOTOR_PORT);
    	shooterMotor.setInverted(true);
    	//Banner
    	shooterCounter = new Counter(RobotMap.SHOOTER_COUNTER_PORT);
    	shooterCounter.setDistancePerPulse((1.0/4.0)*60.0);//4 counts per revolution. 60 to transform seconds to minutes
    	shooterCounter.setPIDSourceType(PIDSourceType.kRate);
    	shooterCounter.setSamplesToAverage(4);////5ms (1), 10ms (2), 20ms (5)
    	shooterCounter.setSemiPeriodMode(true);
    	shooterCounter.reset();
    	
    	ratePIDPTerm = 1.0;//Making P very high so it behaves as a bang bang Controller
    	ratePIDITerm = 0.0;
    	ratePIDDTerm = 0.0;
    	ratePIDPeriod = 0.01;//10 ms
    	
    	//Quad Encoder
    	/*
    	shooterCounter = new Counter(RobotMap.SHOOTER_ENCODER_PORT);
    	shooterCounter.setSemiPeriodMode(false); 
    	shooterCounter.setDistancePerPulse((1.0/360.0) * 60.0);
    	shooterCounter.setPIDSourceType(PIDSourceType.kRate);
    	shooterCounter.setSamplesToAverage(30);//5ms (30-120), 10ms (60-240)
    	shooterCounter.setSemiPeriodMode(true); 
    	
    	ratePIDPTerm = 100.0;//Making P very high so it behaves as a bang bang Controller
    	ratePIDITerm = 0.0;
    	ratePIDDTerm = 0.0;
    	ratePIDPeriod = 0.005;//5 ms
    	 */
    	
    	shooterController = new PIDController(ratePIDPTerm,ratePIDITerm, ratePIDDTerm, shooterCounter, shooterMotor, ratePIDPeriod);
    	shooterController.setOutputRange(0, 1);//don't allow reverse so that we can behave as a bang bang controller
    	shooterController.setAbsoluteTolerance(RobotMap.SHOOTER_TOLERANCE);
    	
    	LiveWindow.addActuator("Shooter", "Motor", shooterMotor);
    	LiveWindow.addActuator("Shooter", "PID Controller", shooterController);
    	LiveWindow.addSensor("Shooter", "Counter", shooterCounter);
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ManualShooterControl());
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
    
    public boolean isShooterOn(){
    	if(Math.abs(shooterMotor.get()) > 0.1 || shooterController.getSetpoint() > 10.0){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
    
    public boolean onTarget(){
    	if(shooterController.isEnabled() && shooterController.getSetpoint() > 10.0){
    		return shooterController.onTarget();
    	}
    	else{
    		return false;//turn off indicator if motor is at 0
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

