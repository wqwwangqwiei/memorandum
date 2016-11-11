package rootinformation;

/**
 * 日历备忘录的 界面布局  的一个类接口
 * @author Gangsta
 * 制定了 根信息类 与 界面布置类 观察者模式接口，完备信息集合为可观察者，布置类为观察者；
 * 
 * 采用观察者自己取信息的模式
 */

public interface ObserverLayout {
	public void observerUpdate();
}
