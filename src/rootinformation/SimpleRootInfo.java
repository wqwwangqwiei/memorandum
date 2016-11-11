package rootinformation;

import rootinformation.ObserverLayout;
import rootinformation.ObservableRootInfo;
import gui.LayoutModelEnum;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * 根信息集合类的一个实现类，实现了 根信息类 与 界面布置类 的观察者模式
 * @author Gangsta
 *
 */

public class SimpleRootInfo extends AbRootInfo implements ObservableRootInfo{
	//观察者 容器；
	ArrayList<ObserverLayout> observerList;
	
	public SimpleRootInfo(){
		super();
		observerList = new ArrayList<ObserverLayout>();
	}
	
	//实现观察者模式//////////////////////////////////////
	public void registerObserver(	ObserverLayout o	){
		observerList.add(o);	
	}
	public void removeObserver(		ObserverLayout o 	){
		while(observerList.contains(o)){
			observerList.remove(o);
		}
	}
	public void notifyObserver(	){
		Iterator<ObserverLayout> it=observerList.iterator();
		while(it.hasNext()){
			ObserverLayout ob=it.next();
			ob.observerUpdate();
		}
	}
	
	//父类的方法实现，实现对数据的操作//////////////////////////
	public boolean isChanged(){
		return changed;
	}
	public void setChanged(boolean b){          
		changed=b;
	}
	public void setCalendar(Calendar cal){
		this.setCalendar=cal;
	}
	public Calendar getCalendar(){
		return this.setCalendar;
	}
	public void setTempCalendar(Calendar cal){
		this.tempCalendar=cal;
	}
	public Calendar getTempCalendar(){
		return this.tempCalendar;
	}
	public void setLayout(LayoutModelEnum lyo){
		this.layout=lyo;
	}
	public LayoutModelEnum getLayout(){
		return this.layout;
	}
	public void updateDisplay(){	
		notifyObserver();
	}
	//待写代码 
	//current 与系统时间保持一致
	//2 3 4的实现
	
}













