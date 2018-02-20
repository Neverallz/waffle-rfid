import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.imageio.ImageIO;
import com.phidget22.*;


public class testRFID{
	static DisplayImageHandler test ;
	static PhidgetsReaderManager pm;
	static String[] tags = {"0f000105cc","4500137a98","0f0002dd54","0f0002f31c","450013505d","4500136ea1"};
	static String[] tagImage = {"/Users/pedroloureiro/Desktop/RFID Media/ad.jpg","/Users/pedroloureiro/Desktop/RFID Media/xi.png"};
	static String [] serials = {"455701","455575"};

    public static final void main(String args[]) throws Exception {
        //Enable logging to stdout
        com.phidget22.Log.enable(LogLevel.INFO, null);
        
      
        RFID ch = new RFID();
        RFID sh = new RFID();
        
 
        //------------------------------------------------READERS------------------------------------------------
        
        //ch.setDeviceSerialNumber(455701);  // match device 12345
        ch.setHubPort(0);                 // match hub port 4
        //ch.setChannel(0);                 // match channel 1 port 4 dev 12345
        ch.open();                        // start matching
        
        //ch.setDeviceSerialNumber(455701);
        ch.addAttachListener(new AttachListener() {
        	
	   
			public void onAttach(AttachEvent ae) {
				RFID phid = (RFID) ae.getSource();
				try {
					if(phid.getDeviceClass() != DeviceClass.VINT){
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " attached");
					}
					else{
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " hub port " + phid.getHubPort() + " attached");
					}
				} catch (PhidgetException ex) {
					System.out.println(ex.getDescription());
				}
			}
        });


        ch.addDetachListener(new DetachListener() {
        	
			public void onDetach(DetachEvent de) {
				RFID phid = (RFID) de.getSource();
				try {
					if (phid.getDeviceClass() != DeviceClass.VINT) {
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " detached");
					} else {
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " hub port " + phid.getHubPort() + " detached");
					}
				} catch (PhidgetException ex) {
					System.out.println(ex.getDescription());
				}
			}
        });
        


        ch.addErrorListener(new ErrorListener() {
        	
			public void onError(ErrorEvent ee) {
				System.out.println("Error: " + ee.getDescription());
			}
        });
        
        //sh.setDeviceSerialNumber(455575);  // match device 12345
        sh.setHubPort(1);                 // match hub port 4
        //sh.setChannel(1);                 // match channel 1 port 4 dev 12345
        sh.open();                        // start matching
        
        //ch.setDeviceSerialNumber(455701);
        sh.addAttachListener(new AttachListener() {
        	
	   
			public void onAttach(AttachEvent ae2) {
				RFID phid = (RFID) ae2.getSource();
				try {
					if(phid.getDeviceClass() != DeviceClass.VINT){
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " attached");
					}
					else{
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " hub port " + phid.getHubPort() + " attached");
					}
				} catch (PhidgetException ex) {
					System.out.println(ex.getDescription());
				}
			}
        });


        sh.addDetachListener(new DetachListener() {
        	
			public void onDetach(DetachEvent de2) {
				RFID phid = (RFID) de2.getSource();
				try {
					if (phid.getDeviceClass() != DeviceClass.VINT) {
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " detached");
					} else {
						System.out.println("channel " + phid.getChannel() + " on device " + phid.getDeviceSerialNumber() + " hub port " + phid.getHubPort() + " detached");
					}
				} catch (PhidgetException ex) {
					System.out.println(ex.getDescription());
				}
			}
        });
        


        sh.addErrorListener(new ErrorListener() {
        	
			public void onError(ErrorEvent ee2) {
				System.out.println("Error: " + ee2.getDescription());
			}
        });
        
        //------------------------------------------------TAGS------------------------------------------------
        ch.addTagListener(new RFIDTagListener() {

			public void onTag(RFIDTagEvent e) {
				if(test==null)
				{

					try {
						test = new DisplayImageHandler();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else
				{
					try {
						test.PlaceOriginalImage();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			
				System.out.println("Tag read: " + e.getTag());
				if(Arrays.asList(tags).contains(e.getTag()))
				{
					System.out.println("Tag in array: " + e.getTag());
					test.displayImageByTag(tags, tagImage, e.getTag());
				}
			}
        });
        

        ch.addTagLostListener(new RFIDTagLostListener() {
        	
			public void onTagLost(RFIDTagLostEvent e) {
				//test.ReplaceImage();
				try {
					test.ReplaceImage();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println("Tag lost: " + e.getTag());
				
				
			}
        });
        
// 

        try {
             /*
            * Please review the Phidget22 channel matching documentation for details on the device
            * and class architecture of Phidget22, and how channels are matched to device features.
            */

            /*
            * Specifies the serial number of the device to attach to.
            * For VINT devices, this is the hub serial number.
            *
            * The default is any device.
            */
            //ch.setDeviceSerialNumber(<YOUR DEVICE SERIAL NUMBER>);
            /*
            * For VINT devices, this specifies the port the VINT device must be plugged into.
            *
            * The default is any port.
            */
            //ch.setHubPort(0);

            /*
            * Specifies that the channel should only match a VINT hub port.
            * The only valid channel id is 0.
            *
            * The default is 0 (false), meaning VINT hub ports will never match
            */
             //ch.setIsHubPortDevice(true);

            /*
            * Specifies which channel to attach to.  It is important that the channel of
            * the device is the same class as the channel that is being opened.
            *
            * The default is any channel.
            */
            //ch.setChannel(0);

            /*
            * In order to attach to a network Phidget, the program must connect to a Phidget22 Network Server.
            * In a normal environment this can be done automatically by enabling server discovery, which
            * will cause the client to discovery and connect to available servers.
            *
            * To force the channel to only match a network Phidget, set remote to 1.
            */
            // Net.enableServerDiscovery(ServerType.DEVICE);
            // ch.setIsRemote(true);

            System.out.println("Opening and waiting 5 seconds for attachment...");
            ch.open(50000);
            
            
            System.out.println("\n\nGathering data for 60 seconds\n\n");
            Thread.sleep(60000);

            ch.close();
            System.out.println("\nClosed RFID");

        } catch (PhidgetException ex) {
            System.out.println(ex.getDescription());
        }
    }
}
