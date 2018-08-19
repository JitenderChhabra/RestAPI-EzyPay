package com.ezypay.common;

import java.io.File;
import java.io.FileInputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

public class FileUtils {

	public FileUtils() {
		// TODO Auto-generated constructor stub
	}
	
	public static String readFile(String path) throws Exception {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
			FileChannel fc = stream.getChannel();
			MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0,
					fc.size());
			/* Instead of using default, pass in a decoder. */
			String returnString = Charset.defaultCharset().decode(bb).toString();
			return returnString;			
		} finally {
			stream.close();
		}
	}	
	
}
