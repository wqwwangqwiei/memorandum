package memorandum;

import gui.LayoutModel;
import rootinformation.GuiObject;
import rootinformation.SimpleRootInfo;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import command.SimpleRootInfoCommand;

public class Memorandum{
	GuiObject gui;
	SimpleRootInfo rootInfo;
	SimpleRootInfoCommand rootInfoCommand;
	
	public Memorandum(){
		rootInfo=new SimpleRootInfo();
		rootInfoCommand=new SimpleRootInfoCommand(rootInfo);
		gui=new GuiObject(rootInfo,rootInfo,rootInfoCommand);
	}
	
	public static void main(String [] args){
		new Memorandum();
		
	}
	
}