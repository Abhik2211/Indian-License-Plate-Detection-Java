package nprjava.back.second.togray;
import nprjava.back.first.input.InputImages; // Importing the InputImages class
import org.opencv.core.Mat; // Importing Mat class
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc; // Importing Imgproc class for processing tools.
import org.opencv.highgui.HighGui; // Importing HighGui class for displaying.

public class GrayScale {
	public Mat grayscaleConversion() throws Exception{ // Return type is set to Mat because we need to 
	    // pass the output image of this method for further processing.
		
		
		InputImages image = new InputImages(); // Creating object called image, of InputImages class
		Mat resizedimage = image.downSampling(); // Creating a Mat object to store the output image from the the previous class
		
		System.out.println("---------------------------------------------------");
		System.out.println("Resized Image Configuration : " + resizedimage);
		System.out.println("---------------------------------------------------");
		
		Mat grayscale_image = new Mat(); // Creating a new Mat object to store 
		// the output image after grayscale conversion.
		
		Imgproc.cvtColor(resizedimage, grayscale_image, Imgproc.COLOR_RGB2GRAY);
		// cvtColor -> Converts an image from one color space to another. Parameters are :-
		// SourceImage, 
		// DestinationImage, 
		// ConvertTo -> conversion from one color mode to another
		
		System.out.println("---------------------------------------------------");
		System.out.println("Grayscale Image Configuration" + grayscale_image);
		System.out.println("---------------------------------------------------\n");
		
		
		
		/*
		 * CV_8UC3 -> an 8 bit unsigned integer matrix with 3 channels. Suggesting
		 * that it is RGB (or BGR) image.
		 * 
		 * CV_8UC1 -> an 8 bit unsigned integer matrix with a single channel.
		 * Suggesting that it is grayscale image.
		 * 
		 * Signed Integer -> Stored using 2's complement. Contains both positive and negative values (-1 to -128) and (0 to 127)
		 * 
		 * Unsigned Integer -> It can hold a large positive value and no negative values. Ideal for intensity value that range
		 * from 0 to 255. 
		 */
		
		System.out.println("____________________________________________________");
    	System.out.println("	GRAYSCALE CONVERSION PHASE COMPLETED");
    	System.out.println("____________________________________________________\n");
    	
    	System.out.println("******************************************************************************************************************************");
		
    	System.out.println("____________________________________________________");
    	System.out.println("	BEGINNING OF EDGE DETECTION PHASE");
    	System.out.println("____________________________________________________\n");
    	
//		HighGui.imshow("Grayscale Image", grayscale_image);
//        HighGui.waitKey();
//        
        
		
		return grayscale_image;
	}
}
