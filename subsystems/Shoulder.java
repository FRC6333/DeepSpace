// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc6333.DeepSpace.subsystems;


//import org.usfirst.frc6333.DeepSpace.commands.*;
//import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

//import edu.wpi.first.wpilibj.PIDOutput;
//import edu.wpi.first.wpilibj.PIDSource;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 *
 */
public class Shoulder extends PIDSubsystem {


    private WPI_VictorSPX shoulder_motor;
    private Encoder shoulderEncoder;
    private DigitalInput Shoulder_Stop;
    private boolean Shoulder_PID_Running;

    public Shoulder() {
    
        //MC 5
     
        
        super("Shoulder", 0.003, 0.001, 0.00);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        getPIDController().setName("Shoulder", "PIDSubsystem Controller");
        shoulder_motor = new WPI_VictorSPX(5);
        addChild("ShoulderMotor",shoulder_motor);
        shoulderEncoder = new Encoder(10, 11, false, EncodingType.k1X);
        addChild("ShoulderEncoder",shoulderEncoder);
        shoulderEncoder.setDistancePerPulse(1.0);
        shoulderEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
        LiveWindow.add(getPIDController());
    
        Shoulder_Stop = new DigitalInput(13);
       
        Shoulder_PID_Running = false;
    }

    @Override
    public void initDefaultCommand() {
      
        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
        return shoulderEncoder.pidGet();

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }

    @Override
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        shoulder_motor.pidWrite(output);
        //this.moveShoulder(output);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }
    
    public void moveShoulder(double speed){
        shoulder_motor.set(speed);
    }
    
    public void stopShoulder(){
        shoulder_motor.set(0);
    }

    public int getShoulderEncoderCount(){
        return shoulderEncoder.get();
    }
    
    public boolean getShoulderStop(){
        return Shoulder_Stop.get();
    }

    public void ResetShoulder(){
        shoulderEncoder.reset();
    }
    
    public void set_PID_Running(boolean value) {
        Shoulder_PID_Running = value;
    }

    public boolean get_PID_Status() {
        return Shoulder_PID_Running;
    }

   @Override
    public void periodic() {
        // Put code here to be run every loop       
        SmartDashboard.putNumber("Shoulder Encoder", getShoulderEncoderCount());
        SmartDashboard.putBoolean("Shoulder Stop", getShoulderStop());
        
    }

}

