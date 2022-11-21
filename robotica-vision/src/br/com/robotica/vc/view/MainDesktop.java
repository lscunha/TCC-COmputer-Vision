package br.com.robotica.vc.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.opencv.core.Mat;

import br.com.robotica.vc.core.ProcessaImagem;

public class MainDesktop {
	public static void main(String[] args) throws IOException {
						
		MyFrame frame = new MyFrame();
		MyFrame frameGray = new MyFrame();
		MyFrame frameBW = new MyFrame();
		MyFrame frameCircles  = new MyFrame();
		
		frame.setVisible(true);
		frameGray.setVisible(true);
		frameBW.setVisible(true);
		frameCircles.setVisible(true);
		
		File file = new File("image/biscoito.jpg");
		BufferedImage img = ImageIO.read(file);
		
		Mat mat = ProcessaImagem.imageToGray("image/biscoito.jpg");
		Mat matBW = ProcessaImagem.imageToBlackWhite(mat);
		frame.render(img);
		
		frameGray.render(mat);
		frameBW.render(matBW);
		frameCircles.render(ProcessaImagem.countObject("image/biscoito.jpg"));

	}

}
