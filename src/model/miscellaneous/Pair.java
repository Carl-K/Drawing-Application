package model.miscellaneous;

public class Pair<T, K>
{
	final T value1;
	final K value2;
	
	public Pair(T value1In, K value2In)
	{
		value1 = value1In;
		value2 = value2In;
	}
	
	public T getValue1()
	{
		return value1;
	}
	
	public K getValue2()
	{
		return value2;
	}
}
