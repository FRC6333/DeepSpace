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
import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class WristUp extends Command {

    public WristUp() {

        requires(Robot.wrist_sub);

    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.wrist_sub.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.wrist_sub.moveWrist(0.5);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
     if(!Robot.operatorInterface.WristUpButton.get()){
            return true;
        }
        else{
            return false;
        }
    
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.wrist_sub.stopWrist();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
