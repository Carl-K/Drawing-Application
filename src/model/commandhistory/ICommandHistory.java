package model.commandhistory;

public interface ICommandHistory
{
	public void addCommand(IExecutable commandIn);
	public void undoMostRecentCommand();
	public void redoMostRecentCommand();
}
