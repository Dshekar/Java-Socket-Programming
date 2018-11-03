package practice;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Aclient {
    public static void main(String[] args) throws Exception {
    try(Socket socket = new Socket("localhost", 25000)){
        System.out.println("Connected to Server....\n");
        //first it tries to connects with server
      BufferedImage image = ImageIO.read(socket.getInputStream());
      //bufferedImage is used to get image from client
      writeImage(image);//this function will save "server-screenshot" to D:\\client\Shot.jpg
      JLabel label = new JLabel(new ImageIcon(image));
      JFrame f = new JFrame("server screen");
      //this JLabel and JFrame will show the screenshot from server
      f.getContentPane().add(label);
      f.pack();
      f.setVisible(true);
      socket.close();
    }
  }
    public static void writeImage(BufferedImage Image) throws IOException{
        //code for checking if the path ="D:\\client" exists or not
        String pth="D://client";    
	File file = new File(pth);
	if (!file.exists()) {
        System.out.print("folder "+pth+" doesnt exist");
        file.mkdir();
        System.out.print("Folder "+pth+" created");
	}
        
        String path="D://client// Shot.jpg";
        ImageIO.write(Image, "jpg", new File(path));
    }
}
