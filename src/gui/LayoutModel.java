package gui;

import java.util.Calendar;
import javax.swing.*;

/**
 * �ƶ�������ʾ��ģʽ��Ӧ�ķ��� �Ľӿ���,�������е�һ���������ز���(���洴���ͽ���ˢ��)
 * �����õ���ģʽʵ��һ������ 
 * @author Gangsta
 * ����������ӿ��� ����״̬ģʽ������ʵ�ָ��ֽ���״̬
 * ʹ�÷�����
 * 		�ļ����ⲿ�ӿ����װ�˾�̬�ĸ�������״̬��
 * 		ֱ�ӵ����ⲿ�ӿ�����ø�������״̬�ͷ�����
 */
public abstract class LayoutModel extends JScrollPane{
	public abstract void dataRefresh(Calendar cur,Calendar tmp);
}
