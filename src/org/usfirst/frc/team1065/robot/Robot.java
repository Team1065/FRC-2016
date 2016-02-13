
package org.usfirst.frc.team1065.robot;

import org.usfirst.frc.team1065.robot.subsystems.DriveTrain;
import org.usfirst.frc.team1065.robot.subsystems.Intake;
import org.usfirst.frc.team1065.robot.subsystems.Lighting;
import org.usfirst.frc.team1065.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


public class Robot extends IterativeRobot {

	public static OI oi;
	public static DriveTrain drive;
	public static Intake intake;
	public static Shooter shooter;
	public static Lighting lighting;

    public void robotInit() {
		oi = new OI();
		drive = new DriveTrain();
		intake = new Intake();
		shooter = new Shooter();
		lighting = new Lighting();
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
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
