package controller;

import command.AbRootInfoCommand;
import controller.ControllerInterface;
import javax.swing.*;
import java.util.Calendar;
import java.awt.event.*;
import controller.DayBelongMonth;
//ʵ��
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
		//��ť��֤������Ŀ��
		if(belong==DayBelongMonth.THISMONTH && cal.get(Calendar.DATE)==number){
			cmd.memorandumSwitch();
		}
		else{
			//ע�⣬����Ĵ����ܷ�����������������
			//��11.10-��10.31����Ϊ�ȱ�����ӣ����ܳ���11��31����û����һ�졣�ȱ���·ݾͲ������
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


