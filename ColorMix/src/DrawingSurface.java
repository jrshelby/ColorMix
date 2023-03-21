

import processing.core.PApplet;
import processing.core.PImage;

public class DrawingSurface extends PApplet {

	PImage img;


	public void settings() {
		setSize(800,600);
	}
	
	public void setup() {
		
	  img = loadImage("pic.png"); 
	}

	public void draw() {
	  // We're only going to process a portion of the image
	  // so let's set the whole image as the background first
	  
		PImage newImg = new PImage(800, 600);
		newImg.loadPixels();
		
		img.loadPixels();
		for (int i = 0; i < img.pixels.length; i++) {
			int x = i % 800;
			int y = i / 800;
			
			double forcePush = forceEquation(super.mouseX, super.mouseY, x, y);
			forcePush -= forceEquation(super.pmouseX, super.pmouseY, x, y);
			
			
		}
		
		
		image(img, 0, 0);
	  
	  
	}

	
	public double forceEquation(double x1, double y1, double x2, double y2) {
		double xdif = x1-x2;
		double ydif = y1-y2;
		return Math.pow((xdif*xdif+ydif+ydif), 0.25);
	}

}
