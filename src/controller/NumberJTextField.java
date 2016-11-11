package controller;

import controller.ControllerInterface;
import command.AbRootInfoCommand;

import javax.swing.*;
import java.awt.event.*;
import java.util.Calendar;


/**
 * 一个显示数字的文本域
 * @author Gangsta
 *
 */

public class NumberJTextField extends JTextField implements ControllerInterface{
	AbRootInfoCommand rootInfo;
	private int number;
	private int field;     //传入的值应该与Calendar的Field值相同
	
	public NumberJTextField(String s,AbRootInfoCommand rootInfo,int field){
		super(s);
		this.rootInfo=rootInfo;
		this.field=field;
		this.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e){				
					function();
				}
		});
	}
	
	public void function(){
		String s=getText();
		try{
			number=Integer.parseInt(s);
			switch(field){
			case Calendar.YEAR:
				if(number>3000 || number<1000){
					throw new NumberInputException();
				}
				break;
			case Calendar.MONTH:
				number--;
				if(number>13 || number<1){
					throw new NumberInputException();
				}
				break;	
			case Calendar.DATE:
				if(number>30 || number<0){
				throw new NumberInputException();
				}
				break;
			default :break;
			}					
		}catch(NumberFormatException exception1){
			rootInfo.update();
			return;
		}catch(NumberInputException exception2){
			rootInfo.update();
			return;
		}		
		rootInfo.tempCalendarChange(field,number);
	}
}

class NumberInputException extends Exception{
	public NumberInputException(){
		super();
	}
}