/*

Phidgets HelloWorld example for all devices

*/

import com.phidget22.*;

public class HelloWorldExample {

    public static void main(String[] args) throws Exception {

        Manager phidman = new Manager();
        
        phidman.addAttachListener((ManagerAttachEvent ev)->{
            Phidget phid = ev.getChannel();
            try{
            System.out.println("Hello device: " + phid.getDeviceName() + ", Serial Number: " + phid.getDeviceSerialNumber());
            }catch(PhidgetException ex){
                System.out.println(ex.getDescription());
            }
        });
       
        phidman.addDetachListener((ManagerDetachEvent ev) -> {
            Phidget phid = ev.getChannel();
            try{
            System.out.println("Goodbye device: " + phid.getDeviceName() + ", Serial Number: " + phid.getDeviceSerialNumber());
            }catch(PhidgetException ex){
                System.out.println(ex.getDescription());
            }
        });
		
        try {
            System.out.println("Opening...");
            phidman.open();
            System.out.println("Phidget simple playground (plug and unplug devices)");
            System.out.println("Press enter to end anytime");
            System.in.read();
            
            System.out.println("Closing...");
            phidman.close();
            
        } catch (PhidgetException ex) {
            System.out.println(ex.getDescription());
        }
    }
}
