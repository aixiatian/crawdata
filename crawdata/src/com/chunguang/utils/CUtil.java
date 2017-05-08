package com.chunguang.utils;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.http.HttpEntity;

public class CUtil {

	public static boolean isStrIn(String source,String str,String deli){
		if(isStrNull(source) || isStrNull(str))
			return false;
		return (deli + source + deli).contains(deli + str + deli);
	}
	
	public static boolean isStrIn(String source,String str){
		return isStrIn(source, str, ",");
	}
	
	public static boolean isStrNull(String str){
		return str == null || str.equals("") || str.equals("null");
	}
	
	public static boolean wirteFile(HttpEntity is,String outPath){
		FileOutputStream output = null;
		boolean res = true;
		try {
			output = new FileOutputStream(outPath);
			is.writeTo(output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res = false;
		}finally{
			try {
				output.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public static void writeFile(String str ,String out){
		FileWriter fw = null;
		try {
			fw = new FileWriter(out);
			fw.write(str);
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
