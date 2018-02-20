import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class DisplayImageHandler {
	JFrame frame=new JFrame();
	JLabel lbl=new JLabel();

    public static void main(String avg[]) throws IOException
    {
        DisplayImageHandler abc=new DisplayImageHandler();
        
      
    }

    public DisplayImageHandler() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("/Users/pedroloureiro/Desktop/RFID Media/ad.jpg"));
        ImageIcon icon=new ImageIcon(img);
        
        frame.setLayout(new FlowLayout());
        frame.setSize(1000,500);
        
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void ReplaceImage() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("/Users/pedroloureiro/Desktop/RFID Media/galaxy.png"));
        ImageIcon icon=new ImageIcon(img);

        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    public void PlaceOriginalImage() throws IOException
    {
        BufferedImage img=ImageIO.read(new File("/Users/pedroloureiro/Desktop/RFID Media/ad.jpg"));
        ImageIcon icon=new ImageIcon(img);

        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    
    
    public int getArrayIndexbyTag(String[] tags,String readTag)
    {
    			int index = -1;
    			for (int i=0;i<tags.length;i++) {
    			    if (tags[i].equals(readTag)) {
    			        index = i;
    			        break;
    			    }
    			}
    	
    	return index;
    }
    
    public void displayImageByTag(String[]tags, String[]tagImage, String readTag)
    {
    	int indexToDisplay = getArrayIndexbyTag(tags,readTag);
    	
    	 BufferedImage img;
		try {
			img = ImageIO.read(new File(tagImage[getArrayIndexbyTag(tags,readTag)]));
			ImageIcon icon=new ImageIcon(img);

	         lbl.setIcon(icon);
	         frame.add(lbl);
	         frame.setVisible(true);
	         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
    	
    }
    
}