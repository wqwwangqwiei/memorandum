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
 * GuiObject�����沼���࣬������ʾ��ˢ�½����ã�������ˢ�µĽ����ί�д���
 * @author Gangsta
 * �������������� ����Ϣ��ʵ�ֹ۲���ģʽ������Ϊ�۲���
 * �����ĸ����ҽ�����ˢ�µĽ�����ƣ�
 * 		�ڱ�Ҫʱ����ȡ ����Ϣ�����Ϣ �����н����ˢ��
 */


//ע�⣬��ȻrootInfo��observable����SimpleRootInfo�����Ƕ��ڽӿڱ�̣�����Ӧ�����֣����Ըɸ��Ե����顣
public class GuiObject extends JFrame implements ObserverLayout{
	AbRootInfo rootInfo;     	//�۲���ģʽʹ��
	ObservableRootInfo observable;
	AbRootInfoCommand rootInfoCommand;
	ExternalLayoutSet layoutSet;
	LayoutModel layout;
	
	public GuiObject(final SimpleRootInfo rootInfo,final ObservableRootInfo observable,final AbRootInfoCommand rootInfoCommand){
		super("��������¼");
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
	
	//�Թ۲���ģʽ��ʵ�֣��ֵ����ĺ󣬽��и���
	public void observerUpdate(){
		Calendar currentCal=rootInfo.getCalendar();    //ȥȡ����
		Calendar tempCal=rootInfo.getTempCalendar();
		LayoutModelEnum layout=rootInfo.getLayout();
		
		//����ģʽ��ѡ��
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