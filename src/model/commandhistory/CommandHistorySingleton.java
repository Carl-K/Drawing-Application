package model.commandhistory;

import java.util.Stack;

public class CommandHistorySingleton implements ICommandHistory {
	
	private Stack<IExecutable> undos = new Stack<IExecutable>();;
	private Stack<IExecutable> redos = new Stack<IExecutable>();
	
	private static CommandHistorySingleton commandHistorySingleton = new CommandHistorySingleton();
	
	private CommandHistorySingleton()
	{
		
	}
	
	public static void add(IExecutable commandIn)
	{
		commandHistorySingleton.addCommand(commandIn);
	}
	
	public void addCommand(IExecutable commandIn)
	{
		undos.push(commandIn);
		redos.removeIf((command) -> { return true; });
	}
	
	public static void undo()
	{
		commandHistorySingleton.undoMostRecentCommand();
	}
	
	public void undoMostRecentCommand()
	{
		if (undos.size() > 0)
		{
			IExecutable command = undos.pop();
			command.undo();
			redos.push(command);
		}
	}
	
	public static void redo()
	{
		commandHistorySingleton.redoMostRecentCommand();
	}
	
	public void redoMostRecentCommand()
	{
		if (redos.size() > 0)
		{
			IExecutable command = redos.pop();
			command.execute();
			undos.push(command);
		}
	}
}
