package gui;

/**
 * ExternalLayoutSet创建并提供当前所有的LayoutModel模式
 * 时
 * @author Gangsta
 * 使用注意：
 * 		UsualLayoutModel和SnakeLayoutModel是LayoutModel的两个实现子类,不对外公开
 * 		使用时只能通过ExternalLayoutSet的引用进行访问，用来LayoutModel的引用赋值。
 */

//这个类表明了界面类型的种类集合
public enum LayoutModelEnum{
	USUALLAYOUT,SNAKELAYOUT
}

