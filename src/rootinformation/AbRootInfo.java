package rootinformation;

import java.util.Calendar;
import java.util.Date;
import gui.LayoutModelEnum;

/**
 * ��������¼�� �걸��Ϣ�������� ���࣬Ӧ���Դ�Ϊ�������ʵ�ֺ���չ
 * ��Ϣ������Ӧ�ð�����
 * 1��ʱ����Ϣ
 * 		ϵͳʱ�䣬������� ��
 * 		����ʱ�䣬��������ˢ�µ�ʱ��������
 * 		��ʱʱ�䣬�����û��޸�ʱ�䵫Ϊˢ��ʱ����ʱ��¼��
 * 2������¼��Ϣ
 * 		����¼�ļ����ã��������汸��¼��Ϣ��
 * 3���û���Ϣ
 * 		�û���Ϣ�ļ����ã����������û���Ϣ
 * 4��������
 * 		������������Ϣ�Ĵ��̼���ȡ�Ͱ�ȫ����
 * @author Gangsta
 * ʹ��ע�⣺
 * 1��	�˽ӿ�����������¼�ı�Ҫ��Ϣ�������Ҫ��չ������Ϣ��������ʵ������ӣ�
 * 2��	�걸��Ϣ��������ϳɶԣ�������Ϣ�����ṩ�Դ��걸��Ϣ���Ĳ�����
 * 3��	�걸��Ϣ���� �� ���沼����ӿڹ��ɹ۲���ģʽ���걸��Ϣ����Ϊ�ɹ۲��ߣ�������Ϊ�۲��ߣ�
 */

public abstract class AbRootInfo{
	/* ��ע��
	 * 2 3 4����Ϣ�ݲ��ṩ���´θ���
	 * ��ʵʱ����Ϣ�͹۲���ģʽ
	 */
	protected Date currentTime;               //��ǰʱ��
	protected Calendar setCalendar;           //��ʾ������
	protected Calendar tempCalendar;		  //�����û��޸�ʱ�䣬��ˢ��ǰ����ʱ��¼��
	protected LayoutModelEnum layout;       //��ʾ��ģʽ
	protected boolean changed;                //�ı��־λ
	
	public AbRootInfo(){
		currentTime = new Date(	System.currentTimeMillis() );  
		setCalendar = Calendar.getInstance();
		setCalendar.setTime(currentTime);
		tempCalendar= (Calendar)setCalendar.clone(); 		//��ʱʱ����һ������
		layout = LayoutModelEnum.USUALLAYOUT;		
		changed=false;
	}
	
	//ͨ�÷���,��ֹ�����ݵ�������
	public abstract boolean isChanged();          	          	
	public abstract void setChanged(boolean b);
	
	public abstract void setCalendar(Calendar cal);
	public abstract Calendar getCalendar();
	
	public abstract void setTempCalendar(Calendar cal);
	public abstract Calendar getTempCalendar();
	
	public abstract void setLayout(LayoutModelEnum cal);
	public abstract LayoutModelEnum getLayout();
	
	public abstract void updateDisplay();   			//������ʾ����ʾ
		
}

