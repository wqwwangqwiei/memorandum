package rootinformation;

/**
 * 日历备忘录的 完备信息集及操作 的类接口
 * @author Gangsta
 * 制定了 根信息类 与 界面布置类 观察者模式接口，完备信息集合为可观察者，布置类为观察者；din
 * 制定 跟信息类 必须有的一些方法
 * 
 * 采用观察者自己取信息的模式
 */

public interface ObservableRootInfo {
	public void registerObserver(	ObserverLayout o	);
	public void removeObserver(		ObserverLayout o 	);
	public void notifyObserver(		 					);
	
}
