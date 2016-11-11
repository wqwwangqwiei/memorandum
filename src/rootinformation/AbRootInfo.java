package rootinformation;

import java.util.Calendar;
import java.util.Date;
import gui.LayoutModelEnum;

/**
 * 日历备忘录的 完备信息集及操作 的类，应该以此为父类进行实现和拓展
 * 信息及操作应该包括：
 * 1、时间信息
 * 		系统时间，用作秒表 ；
 * 		设置时间，用作界面刷新的时间依赖；
 * 		临时时间，用作用户修改时间但为刷新时的临时记录；
 * 2、备忘录信息
 * 		备忘录文件引用，用作保存备忘录信息用
 * 3、用户信息
 * 		用户信息文件引用，用作保存用户信息
 * 4、操作类
 * 		包括对所有信息的存盘及读取和安全控制
 * @author Gangsta
 * 使用注意：
 * 1、	此接口有日历备忘录的必要信息，如果需要拓展其他信息，在子类实现中添加；
 * 2、	完备信息及与命令集合成对，命令信息集合提供对此完备信息集的操作；
 * 3、	完备信息集合 与 界面布置类接口构成观察者模式，完备信息集合为可观察者，布置类为观察者；
 */

public abstract class AbRootInfo{
	/* 备注：
	 * 2 3 4类信息暂不提供，下次更新
	 * 仅实时间信息和观察者模式
	 */
	protected Date currentTime;               //当前时钟
	protected Calendar setCalendar;           //显示的依据
	protected Calendar tempCalendar;		  //用作用户修改时间，在刷新前的临时记录；
	protected LayoutModelEnum layout;       //显示的模式
	protected boolean changed;                //改变标志位
	
	public AbRootInfo(){
		currentTime = new Date(	System.currentTimeMillis() );  
		setCalendar = Calendar.getInstance();
		setCalendar.setTime(currentTime);
		tempCalendar= (Calendar)setCalendar.clone(); 		//临时时间是一个副本
		layout = LayoutModelEnum.USUALLAYOUT;		
		changed=false;
	}
	
	//通用方法,阻止对数据的随便访问
	public abstract boolean isChanged();          	          	
	public abstract void setChanged(boolean b);
	
	public abstract void setCalendar(Calendar cal);
	public abstract Calendar getCalendar();
	
	public abstract void setTempCalendar(Calendar cal);
	public abstract Calendar getTempCalendar();
	
	public abstract void setLayout(LayoutModelEnum cal);
	public abstract LayoutModelEnum getLayout();
	
	public abstract void updateDisplay();   			//用于显示类显示
		
}

