package com.example.fastprep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CPU
{
	@Autowired
	private HardDisk hardDisk;
	
	@Autowired
	public CPU(HardDisk hardDisk)
	{
		this.hardDisk=hardDisk;
	}

	public CPU(String string, int i)
	{
		// TODO Auto-generated constructor stub
	}
	@Autowired
	public void setHardDisk(HardDisk hardDisk)
	{
		this.hardDisk=hardDisk;
	}
}
