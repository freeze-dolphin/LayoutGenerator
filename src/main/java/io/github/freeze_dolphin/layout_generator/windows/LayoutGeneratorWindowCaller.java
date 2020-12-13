package io.github.freeze_dolphin.layout_generator.windows;

public class LayoutGeneratorWindowCaller {
	
	public static void callReferringSizeWindow(String[] args) {
		ReferringSize.call(args);
	}
	
	public static void initializeGenerator(int size) {
		Generator.call(size);
	}
	
}
