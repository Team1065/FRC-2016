
package org.usfirst.frc.team1065.robot;

import org.usfirst.frc.team1065.robot.RobotMap.Obstacle;
import org.usfirst.frc.team1065.robot.RobotMap.Position;
import org.usfirst.frc.team1065.robot.commands.Autonomous.AutoReach;
import org.usfirst.frc.team1065.robot.subsystems.CameraSystem;
import org.usfirst.frc.team1065.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1065.robot.subsystems.Intake;
import org.usfirst.frc.team1065.robot.subsystems.Lighting;
import org.usfirst.frc.team1065.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain drive;
	public static Intake intake;
	public static Shooter shooter;
	public static Lighting lighting;
	public static CameraSystem camera;
	
    public static SendableChooser positionChooser;
    public static SendableChooser obstacleChooser;
    public static SendableChooser commandChooser;
    Command autonomousCommand;

    public void robotInit() {
		oi = new OI();
		drive = new DriveTrain();
		intake = new Intake();
		shooter = new Shooter();
		lighting = new Lighting();
		camera = new CameraSystem();
		
		positionChooser = new SendableChooser();
		positionChooser.addDefault("Far Left", Position.FarLeft);
		positionChooser.addObject("Left", Position.Left);
		positionChooser.addObject("Middle", Position.Middle);
		positionChooser.addObject("Right", Position.Right);
		positionChooser.addObject("Far Right", Position.FarRight);
        SmartDashboard.putData("Position Chooser", positionChooser);
		
        obstacleChooser.addDefault("Portcullis (Lift Gate)", Obstacle.LiftGate);
        obstacleChooser.addObject("Cheval de Frise (Seesaw)", Obstacle.Seesaw);
        obstacleChooser.addObject("Moat", Obstacle.Moat);
        obstacleChooser.addObject("Ramparts", Obstacle.Ramparts);
        obstacleChooser.addObject("Drawbridge", Obstacle.Drawbridge);
        obstacleChooser.addObject("Sally Port (Door)", Obstacle.Door);
        obstacleChooser.addObject("Rock Wall", Obstacle.RockWall);
        obstacleChooser.addObject("Rough Terrain", Obstacle.RoughTerrian);
        obstacleChooser.addObject("Low Bar", Obstacle.LowBar);
        SmartDashboard.putData("Obstacle Chooser", obstacleChooser);
		
        commandChooser.addDefault("Reach", new AutoReach());
        /*commandChooser.addObject("Cross", new AutoCross());
        commandChooser.addObject("Cross Back", new AutoCrossBack());
        commandChooser.addObject("Shoot High Left", new AutoHighLeft());
        commandChooser.addObject("Shoot High Center", new AutoHighCenter());
        commandChooser.addObject("Shoot High Right", new AutoHighRight());
        commandChooser.addObject("Shoot Low Left", new AutoLowLeft());
        commandChooser.addObject("Shoot Low right", new AutoLowRight());*/
        SmartDashboard.putData("Command Chooser", commandChooser);
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    	if(oi.getDriveOverride()){
    		drive.disableRateControllers();
    	}
    	else{
    		drive.enableRateControllers();
    	}
    	
    	if(oi.getShooterOverride()){
    		shooter.disablePIDController();
    	}
    	else{
    		shooter.enablePIDController();
    	}
    	
    	autonomousCommand = (Command)commandChooser.getSelected();
        if (autonomousCommand != null){
        	autonomousCommand.start();
        }
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
    	if (autonomousCommand != null){
    		autonomousCommand.cancel();
    	}
    }

    public void disabledInit(){

    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
