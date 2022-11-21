package br.com.robotica.vc.view;

import java.io.IOException;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import br.com.robotica.vc.core.ProcessaImagem;

public class CaptureVideo {
	static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}
	public static void main (String[] args) throws IOException {
		VideoCapture video = new VideoCapture(0);
		MyFrame frame = new MyFrame();
		
		frame.setVisible(true);
		
		if (video.isOpened()){
			Mat mat = new Mat();
			Mat matG = new Mat();
			while(true){
				video.read(mat);
				matG = ProcessaImagem.imageToGray(mat);
				frame.render(matG);
			}
		}
		
	}
}
