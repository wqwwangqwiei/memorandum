package controller;

import command.AbRootInfoCommand;
import controller.ControllerInterface;
import javax.swing.*;
import java.util.Calendar;
import java.awt.event.*;

//刷新按钮，将当前日期向临时日期进行更新
public class UpdateJButton extends JButton implements ControllerInterface{
	AbRootInfoCommand sjb;
	
	public UpdateJButton(String s,AbRootInfoCommand sjb){
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
		sjb.update();
	}
}
