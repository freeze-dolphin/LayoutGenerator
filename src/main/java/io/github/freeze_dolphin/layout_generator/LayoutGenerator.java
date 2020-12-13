package io.github.freeze_dolphin.layout_generator;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.alee.laf.WebLookAndFeel;

import io.github.freeze_dolphin.layout_generator.windows.LayoutGeneratorWindowCaller;

public class LayoutGenerator {

	public static void main(String[] args) {
		
		WebLookAndFeel.install();
		try {
			UIManager.setLookAndFeel(new WebLookAndFeel());
			UIManager.setLookAndFeel("com.alee.laf.WebLookAndFeel");
			UIManager.setLookAndFeel(WebLookAndFeel.class.getCanonicalName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		LayoutGeneratorWindowCaller.callReferringSizeWindow(args);
		
	}

}
