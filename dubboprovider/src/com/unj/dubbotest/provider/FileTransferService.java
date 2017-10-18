package com.unj.dubbotest.provider;

public interface FileTransferService {

	public String sayHello(String name);

	public boolean writeBytesToFile(byte bytes[], String filePath,
			String fileName);

}
