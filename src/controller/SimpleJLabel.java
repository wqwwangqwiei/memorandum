package controller;

import command.AbRootInfoCommand;
import controller.ControllerInterface;
import javax.swing.*;

//点击后什么也不做的按钮
public class SimpleJLabel extends JLabel implements ControllerInterface{
	AbRootInfoCommand sjb;
	
	public SimpleJLabel(String s,AbRootInfoCommand sjb){
		super(s);
		this.sjb=sjb;
	}
	
	public void function(){
		sjb.nothing();
	}
}