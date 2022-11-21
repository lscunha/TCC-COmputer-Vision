package br.com.robotica.vc.view;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.JFrame;

import org.opencv.core.Mat;

public class MyFrame {
	private final JFrame frame;
	private final MyPanel panel;

	public MyFrame() {
		// JFrame which holds JPanel
		frame = new JFrame();
		frame.getContentPane().setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// JPanel which is used for drawing image
		panel = new MyPanel();
		frame.getContentPane().add(panel);
	}

	public void setVisible(boolean visible) {
		frame.setVisible(visible);
	}

	public void render(BufferedImage image) {
		panel.setImage(image);
		panel.repaint();
		frame.pack();
	}

	public void render(Mat image) {
		Image i = toBufferedImage(image);
		panel.setImage(i);
		panel.repaint();
		frame.pack();
	}

	public static Image toBufferedImage(Mat m) {
		// Code from
		// http://stackoverflow.com/questions/15670933/opencv-java-load-image-to-gui

		// Check if image is grayscale or color
		int type = BufferedImage.TYPE_BYTE_GRAY;
		if (m.channels() > 1) {
			type = BufferedImage.TYPE_3BYTE_BGR;
		}

		// Transfer bytes from Mat to BufferedImage
		int bufferSize = m.channels() * m.cols() * m.rows();
		byte[] b = new byte[bufferSize];
		m.get(0, 0, b); // get all the pixels
		BufferedImage image = new BufferedImage(100, 100, type);
		if (m.cols() > 0) {
			image = new BufferedImage(m.cols(), m.rows(), type);
		}

		final byte[] targetPixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(b, 0, targetPixels, 0, b.length);
		return image;
	}

}
