package com.ssafy.util;

public class DBClose {

	public static void close(AutoCloseable...autoCloseable) {
		for(AutoCloseable ac : autoCloseable) {
			if(ac != null) {
				try {
					ac.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
