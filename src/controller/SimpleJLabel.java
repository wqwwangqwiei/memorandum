package controller;

import command.AbRootInfoCommand;
import controller.ControllerInterface;
import javax.swing.*;

//�����ʲôҲ�����İ�ť
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