package com.alibaba.dubbo.demo.test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.unj.dubbotest.provider.DemoService;
import com.unj.dubbotest.provider.FileTransferService;

public class Consumer {

	@SuppressWarnings({ "rawtypes", "unused" })
	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "applicationContext.xml" });
		context.start();

		DemoService demoService = (DemoService) context.getBean("demoService");

		for (int i = 0; i < 10; i++) {
			String hello = demoService.sayHello("tom-" + i);
			System.out.println(hello);
		}

		List list = demoService.getUsers();
		if (list != null && list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("list[" + i + "]=" + list.get(i));
			}
		}

		
		if(true){
			return;
		}
		
		DataInputStream fis =  null;
		
		try {
			FileTransferService fileTransferService = (FileTransferService) context.getBean("fileTransferService");
			System.out.println(fileTransferService);
			//File file = new File("e:\\迅雷下载\\[阳光电影www.ygdy8.com].复仇者联盟2.HD.720p.中英双字幕.rmvb");
			File file = new File("C:\\Users\\sunfx\\Desktop\\创发科技\\4月任务\\4月版本分析说明书0407.rar");
			fis = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
			int read = 0;
			int bufferSize = 1024 * 8;
			byte[] buf = new byte[bufferSize];
			while ((read = fis.read(buf)) != -1) {
				fileTransferService.writeBytesToFile(buf, "e:\\receive", file.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(fis != null)
				fis.close();
		}

	}

}