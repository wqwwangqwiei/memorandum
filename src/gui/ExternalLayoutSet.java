package gui;

import command.AbRootInfoCommand;
import gui.LayoutModel;

public class ExternalLayoutSet{
	SnakeLayoutModel SNAKELAYOUT;
	UsualLayoutModel USUALLAYOUT;
	
	public  ExternalLayoutSet(AbRootInfoCommand rootInfoCommand){
		SNAKELAYOUT=new SnakeLayoutModel(rootInfoCommand);
		USUALLAYOUT=new UsualLayoutModel(rootInfoCommand);
	}
	
	public LayoutModel getSnakeLayoutModel(){
		return SNAKELAYOUT;
	}
	
	public LayoutModel getUsualLayoutModel(){
		return USUALLAYOUT;
	}
}