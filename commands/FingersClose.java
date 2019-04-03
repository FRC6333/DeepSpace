//Close the fingers.

package org.usfirst.frc6333.DeepSpace.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class FingersClose extends Command {

    public FingersClose() {
        requires(Robot.fingers_sub);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        Robot.fingers_sub.disable();
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.fingers_sub.moveFingers(0.75);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(!Robot.operatorInterface.FingerCloseButton.get()){
            return true;
        } 
       if (!Robot.fingers_sub.getFingerStop()){
            Robot.fingers_sub.ResetFingers();
            return true;
        }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.fingers_sub.stopFingers();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
