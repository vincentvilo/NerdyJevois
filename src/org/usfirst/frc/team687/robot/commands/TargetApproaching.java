package org.usfirst.frc.team687.robot.commands;

import org.usfirst.frc.team687.robot.Constants;
import org.usfirst.frc.team687.robot.Robot;
import org.usfirst.frc.team687.util.NerdyPID;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TargetApproaching extends Command {

    double x, Z;
    NerdyPID pid;
    
    public TargetApproaching() {
	SmartDashboard.putString("Current Command", "TargetApproaching");
	requires(Robot.drive);
	pid = new NerdyPID();
	pid.setPID(0.001,0,0.001);
	setTimeout(3.0);
    }

    protected void initialize() {
    }

    protected void execute() {
	x = (Constants.kCameraMountHeight-Constants.kCubeHeight)*(Math.tan((Constants.kVerticalFOV/2)-(Constants.kVerticalFOV*Robot.jevois.getTargetY()/Constants.kVerticalPixels)+(Constants.kCameraMountAngle-(Constants.kVerticalFOV/2))));
	System.out.println(x);
//	pid.calculate(x);
    }

    protected boolean isFinished() {
        return isTimedOut() || (x < Constants.kDistanceTolerance) ? true : false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
