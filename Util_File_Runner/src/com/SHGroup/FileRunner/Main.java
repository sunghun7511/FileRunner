package com.SHGroup.FileRunner;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main extends Thread{
	public static void main(String[] args){
		new Main().start();
	}
	public String fpath = "C:/Users/SH/Desktop/";
	@Override
	public void run(){
		ArrayList<File> files = new ArrayList<File>();
		File folder = new File(fpath);
		{
			LinkedList<File> tfiles = new LinkedList<File>();
			tfiles.addAll(Arrays.asList(folder.listFiles()));
			while(!tfiles.isEmpty()){
				File now = tfiles.pop();
				if(now.isDirectory()){
					tfiles.addAll(Arrays.asList(now.listFiles()));
					continue;
				}
				files.add(now);
			}
		}
		for(File f : files){
			try{
				Desktop.getDesktop().open(f);
				sleep(500l);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}
}
