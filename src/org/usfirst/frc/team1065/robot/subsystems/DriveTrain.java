package org.usfirst.frc.team1065.robot.subsystems;

import org.usfirst.frc.team1065.robot.RobotMap;
import org.usfirst.frc.team1065.robot.commands.DriveWithJoysticks;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.CounterBase;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends Subsystem {
	private Talon leftTalon, rightTalon;
	//distance and rotate will be done in command
	//straight pid(angle)= setL&R(speed-pidGet, speed+pidGet), rates straight to motors
    private PIDController straightPID, leftRatePID, rightRatePID;
	private Encoder leftEncoder, rightEncoder;
	private AHRS navX;
	
	private static double ratePIDPTerm, ratePIDITerm, ratePIDDTerm;
    
    public DriveTrain(){
    	leftEncoder = new Encoder(RobotMap.LEFT_DRIVE_ENCODER_PORT_A,RobotMap.LEFT_DRIVE_ENCODER_PORT_B,true,CounterBase.EncodingType.k1X);
    	rightEncoder = new Encoder(RobotMap.RIGHT_DRIVE_ENCODER_PORT_A,RobotMap.RIGHT_DRIVE_ENCODER_PORT_B,false,CounterBase.EncodingType.k1X);
    	leftEncoder.setDistancePerPulse((RobotMap.DRIVE_WHEEL_DIAMETER * Math.PI)/(RobotMap.DRIVE_ENCODERS_COUNTS_PER_REV));
    	rightEncoder.setDistancePerPulse((RobotMap.DRIVE_WHEEL_DIAMETER * Math.PI)/(RobotMap.DRIVE_ENCODERS_COUNTS_PER_REV));
    	leftEncoder.setPIDSourceType(PIDSourceType.kRate);
    	rightEncoder.setPIDSourceType(PIDSourceType.kRate);
    	
    	leftTalon = new Talon(RobotMap.LEFT_DRIVE_MOTOR_PORT);
    	rightTalon = new Talon(RobotMap.RIGHT_DRIVE_MOTOR_PORT);
    	rightTalon.setInverted(true);
    	
    	ratePIDPTerm = 0.0;
    	ratePIDITerm = 0.0;
    	ratePIDDTerm = 0.0;
    	
    	leftRatePID = new PIDController(ratePIDPTerm,ratePIDITerm, ratePIDDTerm, leftEncoder, leftTalon);
    	rightRatePID = new PIDController(ratePIDPTerm,ratePIDITerm, ratePIDDTerm, rightEncoder, rightTalon);
    	leftRatePID.setInputRange(-RobotMap.DRIVE_TOP_SPEED, RobotMap.DRIVE_TOP_SPEED);
    	rightRatePID.setInputRange(-RobotMap.DRIVE_TOP_SPEED, RobotMap.DRIVE_TOP_SPEED);
    	
    	try {
    		navX = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex ) {
            System.out.println("Error instantiating navX MXP:  " + ex.getMessage());
        }
    	
    	LiveWindow.addActuator("DriveTrain","Left Motor Controller", leftTalon);
    	LiveWindow.addActuator("DriveTrain","Right Motor Controller", rightTalon);
    	LiveWindow.addActuator("DriveTrain","Left Motor PID", leftRatePID);
    	LiveWindow.addActuator("DriveTrain","Right Motor PID", rightRatePID);
    	LiveWindow.addSensor("DriveTrain", "Left Encoder", leftEncoder);
    	LiveWindow.addSensor("DriveTrain", "Right Encoder", rightEncoder);
    	LiveWindow.addSensor("DriveTrain", "NavX", navX);
    }

    //setL&R, if encoderEnable LRate.setSetpoint(lspeed * MaxSpeed)...
    
    public void initDefaultCommand() {
        setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed){
    	leftTalon.set(leftSpeed);
    	rightTalon.set(rightSpeed);
    }
    
    public void resetEncoders() {
    	leftEncoder.reset();
    	rightEncoder.reset();
	}

	public double getRightEncoderDistance() {
		return rightEncoder.getDistance();
	}

	public double getLeftEncoderDistance() {
		return leftEncoder.getDistance();
	}
	
	public void resetAngle(){
		navX.zeroYaw();
	}
	
	public double getAngle(){
		return navX.getAngle();
	}
}

