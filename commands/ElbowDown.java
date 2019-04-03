// Move elbow down.

package org.usfirst.frc6333.DeepSpace.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6333.DeepSpace.Robot;
//import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ElbowDown extends Command {

    public ElbowDown() {
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
        Robot.elbow_sub.moveElbow(-0.33);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        if(!Robot.operatorInterface.ElbowDownButton.get()){
            return true;
        }
        else if (!Robot.elbow_sub.getElbowStop()) {
            Robot.elbow_sub.ResetElbow();
            return true;
            }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.elbow_sub.stopElbow();
        Robot.elbow_sub.ResetElbow();
    }

    @Override
    protected void interrupted() {
        end();
    }
}
