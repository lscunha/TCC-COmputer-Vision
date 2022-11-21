package br.com.robotica.vc.core;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ProcessaImagem{
	
	static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	
	public static Mat imageToGray(String pathFile) throws IOException{
		
		Mat source = Imgcodecs.imread(pathFile);

		Mat destination = new Mat();
		
		Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);
		
		return destination;
	}
	
	public static Mat imageToGray(Mat source) throws IOException{
				
		Mat destination = new Mat();
		
		Imgproc.cvtColor(source, destination, Imgproc.COLOR_RGB2GRAY);
		
		return destination;
	}
	
	public static Mat imageToBlackWhite(Mat source) throws IOException{
		
		Mat destination = new Mat();
		
		Imgproc.threshold(source, destination, 240.0, 255.0, Imgproc.THRESH_BINARY);
		
		return destination;
	}
	
	public static Mat countObject(String pathFile) throws IOException{		
		Mat originalMat = Imgcodecs.imread(pathFile);
		Mat grayMat = new Mat();
	    Mat cannyEdges = new Mat();
	    	   	    
	    Imgproc.cvtColor(originalMat, grayMat, Imgproc.COLOR_BGR2GRAY);
	    	    
	    Imgproc.Canny(grayMat, cannyEdges, 100, 180);
	   	
		return cannyEdges;
	}
}
