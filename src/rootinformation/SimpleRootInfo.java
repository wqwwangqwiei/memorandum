package rootinformation;

import rootinformation.ObserverLayout;
import rootinformation.ObservableRootInfo;
import gui.LayoutModelEnum;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * ����Ϣ�������һ��ʵ���࣬ʵ���� ����Ϣ�� �� ���沼���� �Ĺ۲���ģʽ
 * @author Gangsta
 *
 */

public class SimpleRootInfo extends AbRootInfo implements ObservableRootInfo{
	//�۲��� ������
	ArrayList<ObserverLayout> observerList;
	
	public SimpleRootInfo(){
		super();
		observerList = new ArrayList<ObserverLayout>();
	}
	
	//ʵ�ֹ۲���ģʽ//////////////////////////////////////
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
	
	//����ķ���ʵ�֣�ʵ�ֶ����ݵĲ���//////////////////////////
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
	//��д���� 
	//current ��ϵͳʱ�䱣��һ��
	//2 3 4��ʵ��
	
}













