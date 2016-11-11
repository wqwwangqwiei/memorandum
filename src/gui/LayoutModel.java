package gui;

import java.util.Calendar;
import javax.swing.*;

/**
 * 制定界面显示的模式对应的方法 的接口类,包含仅有的一个对象和相关操作(界面创建和界面刷新)
 * 必须用单例模式实现一个界面 
 * @author Gangsta
 * 子类与这个接口类 构成状态模式，子类实现各种界面状态
 * 使用方法：
 * 		文件的外部接口类封装了静态的各种子类状态；
 * 		直接调用外部接口类调用各种子类状态和方法；
 */
public abstract class LayoutModel extends JScrollPane{
	public abstract void dataRefresh(Calendar cur,Calendar tmp);
}
