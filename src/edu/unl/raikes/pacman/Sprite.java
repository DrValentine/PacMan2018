package edu.unl.raikes.pacman;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Sprite class defines functions used by every object displayable by an image.
 * @author svalentine5
 *
 */
@SuppressWarnings("serial")
public abstract class Sprite extends JComponent {

	/**
	 * Loads and returns an image from a specified filepath
	 * @param filepath the path of the desired image
	 * @return the image at the specified filepath
	 */
	public static BufferedImage loadImage(String filepath) {
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(filepath));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
		return img;
	}
	
	/**
	 * Draws an image with a provided graphics context.
	 * @param g the graphics context upon which to draw the image
	 * @param img the image to be drawn
	 * @param top the number of pixels from the top of the parent component's origin
	 * @param left the number of pixels from the left of the parent component's origin
	 * @param width the desired width of the image
	 * @param height the desired height of the image
	 */
	public void drawImage(Graphics g, BufferedImage img, double top, double left, double width, double height) {
		AffineTransform tx = new AffineTransform();
        tx.translate(top, left); // x/y set here
        tx.scale( width/img.getWidth(),height/img.getHeight());
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
        BufferedImage newImage = new BufferedImage(img.getWidth(), img.getHeight(), img.getType()); 
		op.filter(img, newImage);
		g.setColor(Color.BLACK);
		((Graphics2D) g).fill(new Rectangle2D.Double(top, left, width, height));
		((Graphics2D) g).drawImage(img, tx, this);
	}
	
	/** 
	 * Makes a copy of an image and rotates it a specified number of degrees
	 * @param image the image to be rotated
	 * @param n the number of degrees to rotate the image
	 * @return the rotated copy of the input image 
	 */
	public static BufferedImage rotateImg(final BufferedImage image, final int n) { // n rotation in degrees
		double rotationRequired = Math.toRadians(n);
		double locationX = image.getWidth() / 2;
		double locationY = image.getHeight() / 2;
		AffineTransform tx = AffineTransform.getRotateInstance(rotationRequired, locationX, locationY);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType()); 
		op.filter(image, newImage);

		return newImage;
	}
	
	/** 
	 * Makes a copy of an image and reflects it vertically
	 * @param image the image to be reflected
	 * @return the reflected copy of the input image 
	 */
	public static BufferedImage reflectImgVertically(final BufferedImage image) { // n rotation in degrees
		AffineTransform tx = AffineTransform.getScaleInstance(1, -1);
		tx.translate(0, -image.getHeight(null));
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType()); 
		op.filter(image, newImage);

		return newImage;
	}
	
	/** 
	 * Makes a copy of an image and reflects it horizontally
	 * @param image the image to be reflected
	 * @return the reflected copy of the input image 
	 */
	public static BufferedImage reflectImgHorizontally(final BufferedImage image) { // n rotation in degrees
		AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
		tx.translate(-image.getWidth(null), 0);
		AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
		BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), image.getType()); 
		op.filter(image, newImage);

		return newImage;
	}
	
	/**
	 * Creates a new image that superimposes the second image atop the first.
	 * @param bottomImage the image that will appear underneath
	 * @param topImage the image that will appear atop
	 * @return a new image that is a compilation of the passed in files
	 */
	public static BufferedImage superimposeImages(final BufferedImage bottomImage, final BufferedImage topImage) {
		// create the new image, canvas size is the max. of both image sizes
		int w = Math.max(bottomImage.getWidth(), topImage.getWidth());
		int h = Math.max(bottomImage.getHeight(), topImage.getHeight());
		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		// paint both images, preserving the alpha channels
		Graphics g = combined.getGraphics();
		g.drawImage(bottomImage, 0, 0, null);
		g.drawImage(topImage, 0, 0, null);

		// return the combined image
		return combined;
	}
	
	/**
	 * Returns the BufferedImage that represents the Sprite.
	 * @return
	 */
	public abstract BufferedImage getImage();
}