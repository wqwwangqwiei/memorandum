package command;

import rootinformation.AbRootInfo;
import java.util.Calendar;
import gui.LayoutModelEnum;
/**
 * AbRootInfoCommand的实现类，与SimpleRootInfo相对应
 * @author Gangsta
 * 
 */

public class SimpleRootInfoCommand extends AbRootInfoCommand{
	//命令实现
	public SimpleRootInfoCommand(AbRootInfo rootInfo){
		this.rootInfo=rootInfo;
	}
	
	public void update(){    		 	//刷新
		//需要保证临时日历与当前日历是两个不同的实例空间 
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
		System.out.println("切换到备忘录，暂未实现");
	}
	
	public void layoutChange(LayoutModelEnum lyo){
		rootInfo.setLayout(lyo);
		rootInfo.updateDisplay();
	}
	
}