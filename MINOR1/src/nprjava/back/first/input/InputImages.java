package nprjava.back.first.input;

import java.util.concurrent.TimeUnit;

import nprjava.front.second.UserInterface;
import nprjava.front.seventh.OriginalDisplay;

/*
  * org.opencv.core -> This is a base class for all more or less complex
  * algorithms in OpenCV especially for classes of algorithms, for which there 
  * can be multiple implementations.
  */
import org.opencv.core.Core;
import org.opencv.core.Mat;
/*
 * In OpenCV (java) images are store using the Mat object. It is an
 * n-dimensional array and is used to store image data in terms of pixel values.
 * Mat -> Matrix.
 */
import org.opencv.core.Size; 
// Contains necessary methods and classes that are used to resize an image.
import org.opencv.imgcodecs.Imgcodecs;
/*
 * The Imgcodecs class provides methods to read and write the images. Images 
 * can be stored in a matrix and transformations can be performed on it.
 */
import org.opencv.imgproc.Imgproc;
// Contains various methods that help in processing images.
import org.opencv.highgui.HighGui; // Displaying image.

  
@SuppressWarnings("serial")
public class InputImages extends UserInterface{
  
	
    
    public Mat downSampling() throws Exception { // Return type is set to Mat because we need to 
    // pass the output image of this method for further processing.
    
    	
    	System.out.println("____________________________________________________");
    	System.out.println("	BEGINNING OF DOWNSAMPLING PHASE");
    	System.out.println("____________________________________________________\n");
  
        // Load OpenCV library
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); // this helps to load 
        // the OpenCV libraries.
        
//        String img_loc = "D:\\JAVA\\Sample_Images\\Kaggle\\1 (82).jpeg"; // Location of image 
        
        UserInterface newob = new UserInterface();
        OriginalDisplay odj = new OriginalDisplay();
//        String img_loc = "D:\\\\JAVA\\\\Sample_Images\\\\Images\\\\car2ehh\\\\2.jpg";
        TimeUnit.SECONDS.sleep((long) 3.5);
        String img_loc = odj.OriginalDisplay();
//        String img_loc = newob.details_method();
//        System.out.println(img_loc);
//        TimeUnit.SECONDS.sleep((long) 2.5);
        
        
        Mat src = Imgcodecs.imread(img_loc); // Reading the image and storing in
        // a matrix object (Mat src)
        
        System.out.println("----------------------------------------------------");
        System.out.println("The size of the original image = " + src.size());
        
        double width_original = src.size().width; // width
        double height_original = src.size().height; // height
        
        double downscaling_width_factor = 3;	// d_h_f must be less than d_w_f
        double downscaling_height_factor = 2;
        
        /*
         * Value of downscaling_width_factor is larger due to 2 reasons :-
         * 1) We can compress more image data in the horizontal direction 
         * because the width of a license plate is greater than height.
         * 2) Large d_w_f also makes the characters of license plate more 
         * compact which help in later steps (feature extraction). 
         */
        
        double final_width = width_original/downscaling_width_factor;	
        double final_height = height_original/downscaling_height_factor;
        // final widths and heights for resizing.
        
        System.out.println("----------------------------------------------------");
        System.out.println("Original Width = " + width_original + "\nOriginal Height = " + height_original);
        System.out.println("----------------------------------------------------");
        System.out.println("Final Width = " + final_width + "\nFinal Height = " + final_height);
        System.out.println("----------------------------------------------------");
        
        
        Mat resizeimage = new Mat(); 
        // New Mat object to store the downsampled image 
        Size scaleSize = new Size(final_width, final_height);
        // Defining the size for the downsampled image in Size Object->(scaleSize)
        
        Imgproc.resize(src, resizeimage, scaleSize, 0, 0, Imgproc.INTER_AREA);
        /*
         * Applying the resize function with the following parameters :-
         * SourceImage, 
         * DestinationImage, 
         * SizeRequired (width, height), 
         * ScalingFactor(dx, dy), 
         * InterpolationMethod
         * 
         * We have used INTER_AREA because it works best when we need to shrink an image.
         * INTER_AREA is BilinearInterpolation with coefficients 1 and 0
         * 
         * TO BE FURTHER EXPLAINED
         * 
         */
        
        System.out.println("The size of the final image = " + resizeimage.size());
        System.out.println("---------------------------------------------------");
        
        System.out.println("\n____________________________________________________");
    	System.out.println("	  DOWNSAMPLING PHASE COMPLETED");
    	System.out.println("____________________________________________________\n");
    	
    	System.out.println("******************************************************************************************************************************\n");
    	
//    	HighGui.imshow("Original Image", src);
//    	HighGui.waitKey();
//        
//        HighGui.imshow("Downsampled Image", resizeimage); // Displaying the output
//        HighGui.waitKey(); // Specified so that the output doesn't disappear.
//        
        System.out.println("____________________________________________________");
    	System.out.println("	BEGINNING OF GRAYSCALE CONVERSION PHASE");
    	System.out.println("____________________________________________________\n");
    	String store_downscaled_image = "D:\\JAVA\\WORKSPACE\\MINOR1\\Images\\Downscaled\\downscale.png";
		Imgcodecs.imwrite(store_downscaled_image, resizeimage);
    	
        return resizeimage; // Returning the resizeimage so that further
        // actions can be performed on it.
        
            
    }
}