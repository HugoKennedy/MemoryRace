package tsp.pro3600.memoryrace.interfaceswing;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import tsp.pro3600.memoryrace.connectionmodel.PhotoData;



public class FenetrePhotos extends JFrame {



	public FenetrePhotos(ArrayList<PhotoData> photos)
	{
        setSize(200, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MemoryRace");
        setResizable(true);
        setLayout(new GridLayout(photos.size(), 1));
        
        for (PhotoData photo : photos)
        {
        	ImageIcon icon = new ImageIcon(photo.getImageBytes());
        	ImageIcon resizedIcon = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        	JLabel label = new JLabel(resizedIcon);
        	this.add(label);
        	
        }
        setVisible(true);
        
	}
}
