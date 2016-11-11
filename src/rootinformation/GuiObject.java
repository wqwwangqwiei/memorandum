package rootinformation;

import javax.swing.*;
import java.util.Calendar;

import command.AbRootInfoCommand;
import rootinformation.AbRootInfo;
import rootinformation.ObserverLayout;
import rootinformation.ObservableRootInfo;
import gui.LayoutModel;
import gui.LayoutModelEnum;
import gui.ExternalLayoutSet;

/**
 * GuiObject即界面布置类，用作显示和刷新界面用，仅负责被刷新的界面的委托代理
 * @author Gangsta
 * 框架组件，首先与 根信息类实现观察者模式，这里为观察者
 * 这个类的负责且仅负责被刷新的界面控制：
 * 		在必要时，获取 跟信息类的信息 ，进行界面的刷新
 */


//注意，虽然rootInfo和observable都是SimpleRootInfo，但是对于接口编程，两者应该区分，各自干各自的事情。
public class GuiObject extends JFrame implements ObserverLayout{
	AbRootInfo rootInfo;     	//观察者模式使用
	ObservableRootInfo observable;
	AbRootInfoCommand rootInfoCommand;
	ExternalLayoutSet layoutSet;
	LayoutModel layout;
	
	public GuiObject(final SimpleRootInfo rootInfo,final ObservableRootInfo observable,final AbRootInfoCommand rootInfoCommand){
		super("日历备忘录");
		this.rootInfo=rootInfo;
		this.observable=observable;
		this.rootInfoCommand=rootInfoCommand;
		observable.registerObserver(this);	
		layoutSet=new ExternalLayoutSet(rootInfoCommand);		
		layout=layoutSet.getUsualLayoutModel();
		
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		observerUpdate();
	}
	
	//对观察者模式的实现，街道更改后，进行更新
	public void observerUpdate(){
		Calendar currentCal=rootInfo.getCalendar();    //去取数据
		Calendar tempCal=rootInfo.getTempCalendar();
		LayoutModelEnum layout=rootInfo.getLayout();
		
		//进行模式的选择
		memorandumModelDisplay(currentCal,tempCal,layoutModelSelect(layout)); 
	}
	
	public void memorandumModelDisplay(Calendar cur,Calendar tmp,LayoutModel lyo){
		this.remove(layout);
		this.add(lyo);
		lyo.dataRefresh(cur,tmp);
	}
	
	public LayoutModel layoutModelSelect(LayoutModelEnum lyo){
		switch(lyo){
			case USUALLAYOUT:
				return layoutSet.getUsualLayoutModel();
			case SNAKELAYOUT:
				return  layoutSet.getSnakeLayoutModel();
			default:
				return layoutSet.getUsualLayoutModel();
		}
	}
	
}