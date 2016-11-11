package command;

import rootinformation.AbRootInfo;
import java.util.Calendar;
import gui.LayoutModelEnum;
/**
 * 使用 根信息集合的信息和操作，封装一系列逻辑操作命令
 * @author Gangsta
 * command命令针对AbRootInfo接口编程，对 根信息集合 的一系列逻辑操作
 *
 */

public abstract class AbRootInfoCommand{
	AbRootInfo rootInfo;
	public abstract void update();    		 							//刷新，用临时日历更新当前日历
	public abstract void nextMonth();									//下月
	public abstract void lastMonth();									//上月
	public abstract void calendarChange(int Field,int value); //传入参数更改日历界面,flag用作是否可以调用备忘录
	public abstract void tempCalendarChange(int Field,int value);       //修改临时日历界面
	public abstract void memorandumSwitch();							//切换到备忘录界面			
	public abstract void layoutChange(LayoutModelEnum lyo);				//修改显示界面
	
	//空方法，什么也不做
	public void nothing(){;}
}