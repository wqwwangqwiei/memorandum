package command;

import rootinformation.AbRootInfo;
import java.util.Calendar;
import gui.LayoutModelEnum;
/**
 * AbRootInfoCommand��ʵ���࣬��SimpleRootInfo���Ӧ
 * @author Gangsta
 * 
 */

public class SimpleRootInfoCommand extends AbRootInfoCommand{
	//����ʵ��
	public SimpleRootInfoCommand(AbRootInfo rootInfo){
		this.rootInfo=rootInfo;
	}
	
	public void update(){    		 	//ˢ��
		//��Ҫ��֤��ʱ�����뵱ǰ������������ͬ��ʵ���ռ� 
		rootInfo.setCalendar((Calendar)rootInfo.getTempCalendar().clone());   
		System.gc();     
		rootInfo.updateDisplay();
	}
	
	public void nextMonth(){			//
		rootInfo.getCalendar().add(Calendar.MONTH,1);
		rootInfo.setTempCalendar( (Calendar)rootInfo.getCalendar().clone()  );
		System.gc(); 
		rootInfo.updateDisplay();
	}
	
	public void lastMonth(){			//
		rootInfo.getCalendar().add(Calendar.MONTH,-1);
		rootInfo.setTempCalendar( (Calendar)rootInfo.getCalendar().clone()  );
		System.gc(); 
		rootInfo.updateDisplay();
	}
	
	public void calendarChange(int field,int value){
		Calendar temp=rootInfo.getCalendar();
		temp.set(field, value);
		rootInfo.setTempCalendar( (Calendar)rootInfo.getCalendar().clone()  );
		System.gc(); 
		rootInfo.updateDisplay();
	}

	public void tempCalendarChange(int field,int value){	
		Calendar temp=rootInfo.getTempCalendar();
		temp.set(field, value);
	}
	
	public void memorandumSwitch(){
		System.out.println("�л�������¼����δʵ��");
	}
	
	public void layoutChange(LayoutModelEnum lyo){
		rootInfo.setLayout(lyo);
		rootInfo.updateDisplay();
	}
	
}