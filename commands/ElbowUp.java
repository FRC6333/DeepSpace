//Move the elbow up.

package org.usfirst.frc6333.DeepSpace.commands;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class ElbowUp extends Command {

    public ElbowUp() {
        requires(Robot.elbow_sub);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.elbow_sub.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.elbow_sub.moveElbow(1.0);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
       if(!Robot.operatorInterface.ElbowUpButton.get()){
            return true;
        }
        else{
            return false;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.elbow_sub.stopElbow();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
