package rootinformation;

/**
 * ��������¼�� �걸��Ϣ�������� ����ӿ�
 * @author Gangsta
 * �ƶ��� ����Ϣ�� �� ���沼���� �۲���ģʽ�ӿڣ��걸��Ϣ����Ϊ�ɹ۲��ߣ�������Ϊ�۲��ߣ�din
 * �ƶ� ����Ϣ�� �����е�һЩ����
 * 
 * ���ù۲����Լ�ȡ��Ϣ��ģʽ
 */

public interface ObservableRootInfo {
	public void registerObserver(	ObserverLayout o	);
	public void removeObserver(		ObserverLayout o 	);
	public void notifyObserver(		 					);
	
}
