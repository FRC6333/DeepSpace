//Stop the robot in an emergency.

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
