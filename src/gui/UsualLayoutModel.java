package gui;

import java.util.Calendar;
import java.util.Date;

import javax.swing.*;
import java.awt.*;

import gui.LayoutModel;
import command.AbRootInfoCommand;
import controller.*;
/**
 * ͨ����ʾ
 * @author Gangsta
 *
 */
import java.text.DateFormat;

public class UsualLayoutModel extends  LayoutModel{
	JPanel all;
	FunctionArea functionArea;	
	CalendarArea calendarArea;
	
	public UsualLayoutModel(AbRootInfoCommand cmd){
		all=new JPanel();
		this.add(all);
		this.setViewportView(all);
		
		GridBagLayout gblayout=new GridBagLayout();
		all.setLayout(gblayout);
		GridBagConstraints constraints=new GridBagConstraints();
		
		functionArea=new FunctionArea(cmd);
		constraints.gridx=GridBagConstraints.REMAINDER;
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=1;
		constraints.weighty=3;
		gblayout.setConstraints(functionArea, constraints);
		all.add(functionArea);
		
		calendarArea=new CalendarArea(cmd);
		constraints.weighty=22;
		gblayout.setConstraints(calendarArea, constraints);
		all.add(calendarArea);
	}
	
	public void dataRefresh(Calendar cur,Calendar tmp){
		functionArea.dataRefresh(cur);
		calendarArea.dataRefresh(cur);
	}
}
//������
class CalendarArea extends JScrollPane{
	DayJButton [] djb;
	
	public CalendarArea(AbRootInfoCommand cmd){
		JPanel calendarAreaPanel=new JPanel();
		this.add(calendarAreaPanel);
		this.setViewportView(calendarAreaPanel);
		
		calendarAreaPanel.setLayout(new GridLayout(7,7));
		
		{
			SimpleJLabel sjl1=new SimpleJLabel("������",cmd);
			sjl1.setHorizontalAlignment(JLabel.CENTER);
			calendarAreaPanel.add(sjl1);
			SimpleJLabel sjl2=new SimpleJLabel("����һ",cmd);
			sjl2.setHorizontalAlignment(JLabel.CENTER);
			calendarAreaPanel.add(sjl2);
			SimpleJLabel sjl3=new SimpleJLabel("���ڶ�",cmd);
			sjl3.setHorizontalAlignment(JLabel.CENTER);
			calendarAreaPanel.add(sjl3);
			SimpleJLabel sjl4=new SimpleJLabel("������",cmd);
			sjl4.setHorizontalAlignment(JLabel.CENTER);
			calendarAreaPanel.add(sjl4);
			SimpleJLabel sjl5=new SimpleJLabel("������",cmd);
			sjl5.setHorizontalAlignment(JLabel.CENTER);
			calendarAreaPanel.add(sjl5);
			SimpleJLabel sjl6=new SimpleJLabel("������",cmd);
			sjl6.setHorizontalAlignment(JLabel.CENTER);
			calendarAreaPanel.add(sjl6);
			SimpleJLabel sjl7=new SimpleJLabel("������",cmd);
			sjl7.setHorizontalAlignment(JLabel.CENTER);
			calendarAreaPanel.add(sjl7);
		}
		//ע�⣬�����ڴ���ʱ����û�и����������ֵ�������������ֵ���Ǵ�rootInfo��ȡ����
		djb=new DayJButton[42];
		for(int i=0;i<42;i++){
			djb[i]=new DayJButton("",cmd);
			calendarAreaPanel.add(djb[i]);
		}
	}
	
	//***********************
	public void dataRefresh(Calendar cur){
		Calendar temp=(Calendar)cur.clone();
		
		temp.set(Calendar.DATE,1);
		int cut1=temp.get(Calendar.DAY_OF_WEEK);
		//���ϸ��µ�ʱ�䲹ȫ,�������SUNDAY������ζ�����¿�����Ŀ¼����ʾ
		if(cut1!=Calendar.SUNDAY){
			temp.roll(Calendar.MONTH, -1);
			int lastMonthMaxDay=temp.getActualMaximum(Calendar.DATE);
			for(int i=cut1-1;i>0;i--){
				djb[i-1].setCalendar(cur);
				djb[i-1].setText(String.valueOf(lastMonthMaxDay));
				lastMonthMaxDay--;
				djb[i-1].setBackground(Color.GRAY);
				djb[i-1].setDayBelongMonth(DayBelongMonth.LASTMONTH);
			}
		}
		//���뱾��
		int pos=cut1-1;    //����POS��ʾ�������е�λ�ã�i��ʾλ���е�ֵ
		for(int i=1;i<=cur.getActualMaximum(Calendar.DATE);i++,pos++ ){
			djb[pos].setCalendar(cur);
			djb[pos].setBackground(Color.white);
			djb[pos].setText(String.valueOf(i));
			djb[pos].setDayBelongMonth(DayBelongMonth.THISMONTH);
		}
		//��������
		for(int i=pos;i<42;i++){
			djb[i].setCalendar(cur);
			djb[i].setText(String.valueOf(i-pos+1));
			djb[i].setBackground(Color.GRAY);
			djb[i].setDayBelongMonth(DayBelongMonth.NEXTMONTH);
		}
	}	
}


//������
class FunctionArea extends JScrollPane{
	JPanel functionAreaPanel;
	TimeArea timeArea;
	SpaceArea spaceArea;
	ControlArea controlArea;	
	
	public FunctionArea(AbRootInfoCommand cmd){
		functionAreaPanel=new JPanel();
		this.add(functionAreaPanel);
		this.setViewportView(functionAreaPanel);
		timeArea=new TimeArea(cmd);
		spaceArea=new SpaceArea(cmd);		
		controlArea=new ControlArea(cmd);
		functionAreaPanel.add(timeArea);
		functionAreaPanel.add(spaceArea);
		functionAreaPanel.add(controlArea);
	}
	public void dataRefresh(Calendar cur){
		timeArea.dataRefresh(cur);
		spaceArea.dataRefresh(cur);
		controlArea.dataRefresh(cur);	
	}
}
class SpaceArea extends JPanel{
	public SpaceArea(AbRootInfoCommand cmd){;}
	public void dataRefresh(Calendar cur){	;	}
}
class ControlArea extends JPanel{
	LastMonthJButton jbLast;
	NextMonthJButton jbNext;
	//�����л�����δ����
	public ControlArea(AbRootInfoCommand cmd){
		jbLast=new LastMonthJButton("����",cmd);
		jbNext=new NextMonthJButton("����",cmd);
		this.add(jbLast);
		this.add(jbNext);
	}
	public void dataRefresh(Calendar cur){
		;
	}
}
class TimeArea extends JPanel{
	NumberJTextField jtfYear;
	NumberJTextField jtfMonth;
	NumberJTextField jtfDay;
	SimpleJLabel jlbYear;
	SimpleJLabel jlbMonth;
	SimpleJLabel jlbDay;
	UpdateJButton jbUpdate;
	
	public TimeArea(AbRootInfoCommand cmd){
		jtfYear=new NumberJTextField("",cmd,Calendar.YEAR);
		jlbYear=new SimpleJLabel("��",cmd);
		jtfMonth=new NumberJTextField("",cmd,Calendar.MONTH);
		jlbMonth=new SimpleJLabel("��",cmd);
		jtfDay=new NumberJTextField("",cmd,Calendar.DATE);	
		jlbDay=new SimpleJLabel("��",cmd);
		jbUpdate=new UpdateJButton("ȷ��",cmd);
		this.add(jtfYear);			
		this.add(jlbYear);		
		this.add(jtfMonth);	
		this.add(jlbMonth);
		this.add(jtfDay);
		this.add(jlbDay);
		this.add(jbUpdate);	
	}
	
	public void dataRefresh(Calendar cur){
		jtfYear.setText (  String.valueOf(cur.get(Calendar.YEAR))   );
		jtfMonth.setText(  String.valueOf(cur.get(Calendar.MONTH)+1)  );
		jtfDay.setText  (  String.valueOf(cur.get(Calendar.DATE))   );
	}
}