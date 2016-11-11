package command;

import rootinformation.AbRootInfo;
import java.util.Calendar;
import gui.LayoutModelEnum;
/**
 * ʹ�� ����Ϣ���ϵ���Ϣ�Ͳ�������װһϵ���߼���������
 * @author Gangsta
 * command�������AbRootInfo�ӿڱ�̣��� ����Ϣ���� ��һϵ���߼�����
 *
 */

public abstract class AbRootInfoCommand{
	AbRootInfo rootInfo;
	public abstract void update();    		 							//ˢ�£�����ʱ�������µ�ǰ����
	public abstract void nextMonth();									//����
	public abstract void lastMonth();									//����
	public abstract void calendarChange(int Field,int value); //�������������������,flag�����Ƿ���Ե��ñ���¼
	public abstract void tempCalendarChange(int Field,int value);       //�޸���ʱ��������
	public abstract void memorandumSwitch();							//�л�������¼����			
	public abstract void layoutChange(LayoutModelEnum lyo);				//�޸���ʾ����
	
	//�շ�����ʲôҲ����
	public void nothing(){;}
}