//Drive the robot with a joystick.

package org.usfirst.frc6333.DeepSpace.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc6333.DeepSpace.Robot;

/**
 *
 */
public class DriveWithJoystick extends Command {

    public DriveWithJoystick() { 
        requires(Robot.DriveTrain_sub);
     }

    // Called just before this Command runs the first time
    @Override
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    @Override
    protected void execute() {
        Robot.DriveTrain_sub.DriveFull(Robot.operatorInterface.mainJoy);
    }

    // Make this return true when this Command no longer needs to run execute()
    @Override
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    @Override
    protected void end() {
        Robot.DriveTrain_sub.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    @Override
    protected void interrupted() {
    }
}
