package nprjava.back.fourth.thresholding;
import nprjava.back.third.edge.EdgeDetection;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

public class AdaptiveThresholding {
	public Mat adaptiveThresholding() throws Exception { // Return type is set to Mat because we need to 
	    // pass the output image of this method for further processing.
		
		
		EdgeDetection image = new EdgeDetection(); // Creating object called image, of EdgeDetection class
		Mat detected_edges_image = image.detectingEdges(); // Creating a Mat object to store the output image from the the previous class
		
		Mat feature_extracted_image = new Mat(); // Creating new Mat object to store the output after blurring and edge detection.
		
		Imgproc.adaptiveThreshold(detected_edges_image, feature_extracted_image, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 15, 15);
		
		
		
		
		
		/*
		 * AdaptiveThresholding -> Applies an adaptive threshold to an array. Threshold value is calculated
		 * for smaller regions. Parameters :-
		 * SourceImage,
		 * DestinationImage,
		 * MaxValue, 
		 * AdaptiveMethod -> Adaptive thresholding algorithm to be used 
		 * (ADAPTIVE_THRESh_MEAN_C -> The threshold value is the mean of the neighborhood area minus the constant C.), 
		 * ThresholdType -> BinaryThresholding technique used. (Explained while calculating CannyThresholdValue),
		 * BlockSize -> size of pixel neighborhood used to calculate the threshold value. (similar to kernel size)
		 * Constant -> required to calculate threshold. (mean of neighborhood area - constant C)
		 */
		

		String store_thresholded_image = "D:\\JAVA\\Images\\Threshold\\threshold.png";
		Imgcodecs.imwrite(store_thresholded_image, feature_extracted_image);

		
		System.out.println("---------------------------------------------------");
		System.out.println("Adaptive Thresholding Filter is successfully applied\n");
		System.out.println("---------------------------------------------------");
		
		System.out.println("____________________________________________________");
    	System.out.println("	ADAPTIVE THRESHOLDING PHASE COMPLETED");
    	System.out.println("____________________________________________________\n");
    	
    	System.out.println("******************************************************************************************************************************");
    	
    	System.out.println("____________________________________________________");
    	System.out.println("	BEGINNING OF BOUNDING BOX PHASE");
    	System.out.println("____________________________________________________\n");
		
//		HighGui.imshow("Thresholded Image", feature_extracted_image);
//        HighGui.waitKey();
//        
        return feature_extracted_image;
	}
}



 
 
