// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6333.DeepSpace.commands;
import edu.wpi.first.wpilibj.command.Command;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class Emergency extends Command {

    public Emergency() {

        requires(Robot.shoulder_sub);
        requires(Robot.elbow_sub);
        requires(Robot.wrist_sub);
        requires(Robot.fingers_sub);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.elbow_sub.disable();
        Robot.wrist_sub.disable();
        Robot.shoulder_sub.disable();
        Robot.fingers_sub.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {

        Robot.elbow_sub.stopElbow();
        Robot.wrist_sub.stopWrist();
        Robot.shoulder_sub.stopShoulder();
        Robot.fingers_sub.stopFingers();
 

    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
       
            return true;
    
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
       Robot.DriveTrain_sub.stop();
       Robot.elbow_sub.stopElbow();
       Robot.shoulder_sub.stopShoulder();
       Robot.wrist_sub.stopWrist();
       Robot.fingers_sub.stopFingers();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
