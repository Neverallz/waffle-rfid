import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import com.phidget22.*;
import java.util.*;

public class testManager {
	static List<Integer> serials = new ArrayList<Integer>();

	public static void main(String[] args) throws Exception {
		

        com.phidget22.Log.enable(LogLevel.INFO, null);
		  // Create and open the manager
		Manager manager = new Manager();
		
		  // define the attach handler
		  manager.addAttachListener((ManagerAttachEvent ev)->{
		            Phidget phid = ev.getChannel();
		            try{
		            	if(!serials.contains(phid.getDeviceSerialNumber()))
		                serials.add(phid.getDeviceSerialNumber());
		            }catch(PhidgetException ex){
		                System.out.println(ex.getDescription());
		            }
		  });
		
		  
		  try {
		      manager.open();
		  } catch (PhidgetException exception) {
		      printError(exception.getErrorCode(), exception.getDescription());
		  }
		  
		  // Wait for all of the attach events for already-attached Phidgets to resolve
		  Thread.sleep(1000);
		  
		  // Retrieve the list of attached Phidgets' serial numbers
		  serials.forEach(serial -> System.out.println("Phidget Serial Number: " + serial));
		 
		  
		  

	}

	private static void printError(ErrorCode errorCode, String description) {
		// TODO Auto-generated method stub
		
	}

	
	

}
