package controller;

import command.AbRootInfoCommand;
import controller.ControllerInterface;
import javax.swing.*;
import java.util.Calendar;
import java.awt.event.*;

//ʵ��
public class NextMonthJButton extends JButton implements ControllerInterface{
	AbRootInfoCommand sjb;
	
	public NextMonthJButton(String s,AbRootInfoCommand sjb){
		super(s);
		this.sjb=sjb;
		this.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){ 
						function();
					}
		});
	}
	
	public void function(){
		sjb.nextMonth();
	}
}
