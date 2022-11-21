package br.com.robotica.vc.util;

import org.opencv.core.Core;

public class HoughCircles {

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        new HoughCirclesRun().run(args);

	}

}
