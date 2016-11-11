package controller;

import command.AbRootInfoCommand;
import controller.ControllerInterface;
import javax.swing.*;
import java.util.Calendar;
import java.awt.event.*;
import controller.DayBelongMonth;
//实现
public class DayJButton extends JButton implements ControllerInterface{
	AbRootInfoCommand cmd;
	Calendar cal;
	DayBelongMonth belong;
	
	public DayJButton(String s,AbRootInfoCommand cmd){
		super(s);
		this.cmd=cmd;
		this.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e){ 
						function();
					}
		});
	}
	public void setCalendar(final Calendar cal){
		this.cal=cal;
	}
	public void setDayBelongMonth(DayBelongMonth belong){
		this.belong=belong;
	}
	
	public void function(){
		String s=this.getText();
		int number;
		try{
			number=Integer.parseInt(s);
			if(number>31 || number<0){
				throw new NumberInputException();
			}
		}catch(NumberFormatException exception1){
			return;
		}catch(NumberInputException exception2){
			return;
		}	
		//按钮保证操作的目标
		if(belong==DayBelongMonth.THISMONTH && cal.get(Calendar.DATE)==number){
			cmd.memorandumSwitch();
		}
		else{
			//注意，这里的次序不能反过来，否则程序错误
			//如11.10-》10.31。因为先变更日子，可能出现11月31，但没有这一天。先变更月份就不会错误。
			if(belong==DayBelongMonth.LASTMONTH){
				cmd.lastMonth();
			}
			if(belong==DayBelongMonth.NEXTMONTH){
				cmd.nextMonth();
			}
			cmd.calendarChange(Calendar.DATE, number);
		}
	}
}


