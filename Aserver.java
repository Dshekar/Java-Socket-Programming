import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Aserver {
	public static void main(String[] args) throws Exception {
	    
	
		try (ServerSocket serv = new ServerSocket(25000)) 
		{
	      System.out.println("waiting for the client...");
	      try (Socket socket = serv.accept()) 
	      {
	        System.out.println("client connected");
	        Thread.sleep(2000);
	        BufferedImage screencapture =getScreen(); 
	        ImageIO.write(screencapture, "jpg", socket.getOutputStream());
	        System.out.println(" screen shot from server sent");
	        
	      }
	    }
	  }
	
	public static BufferedImage getScreen() throws AWTException {
		Robot r = new Robot();
		Rectangle capture = 
				new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()); 
		BufferedImage Image = r.createScreenCapture(capture);
		return Image;
	}
}
