//Get ready to pick up a hatch off the ground.

package org.usfirst.frc6333.DeepSpace.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class GotoGround extends Command {

    public GotoGround() {
        requires(Robot.elbow_sub);
    }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
        setInterruptible(true);
        
        /* Order of Arm Operations
        *   1. Adjust Elbow
        *   2. Adjust Wrist
        *   3. Adjust Shoulder
        */

        Robot.elbow_sub.setSetpoint(1000);
        Robot.elbow_sub.enable();
        Robot.elbow_sub.set_PID_Running(true);
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if (Robot.elbow_sub.getElbowEncoderCount() > 900 || Robot.elbow_sub.getElbowEncoderCount() < 1100)
            return true;
        else
            return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.elbow_sub.disable();
        Robot.elbow_sub.set_PID_Running(false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
        end();
    }
}
