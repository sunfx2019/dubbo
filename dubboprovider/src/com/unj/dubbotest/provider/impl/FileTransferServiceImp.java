package com.unj.dubbotest.provider.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.unj.dubbotest.provider.FileTransferService;

public class FileTransferServiceImp implements FileTransferService{

	@Override
	public String sayHello(String name) {
		return "hello," + name;
	}

	@SuppressWarnings("unused")
	@Override
	public boolean writeBytesToFile(byte[] bytes, String filePath,
			String fileName) {
		
		System.out.println(bytes);
		if(true){
			return true;
		}
		
		boolean rtn = false;
		FileOutputStream fos = null;
		java.io.File myFilePath = null;
		try {
			myFilePath = new java.io.File(filePath);
			if (!myFilePath.exists()) {
				myFilePath.mkdir();
			}
			fos = new FileOutputStream(filePath + fileName);
			fos.write(bytes);
			fos.flush();
			rtn = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			myFilePath = null;
			try {
				fos.close();
			} catch (IOException iex) {
				iex.printStackTrace();
			}
		}
		return rtn;
	}

}
