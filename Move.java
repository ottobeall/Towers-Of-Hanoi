public class Move {
	/*
	This program outputs a set of instructions to solve the Towers of Hanoi puzzle, with discs numbered
	starting at the smallest disc of 1. The discs all start at a position A, and end at position C.
	Adjust the number of discs by adjusting the integer numberOfDiscs ->
	 */
	static int numberOfDiscs = 5;
	int disc;
	char position;
	public Move(int disc, char position)
	{
		this.disc = disc;
		this.position = position;
	}
	public Move reversePositions(char position1, char position2)
	{
		if(position == position1)
		{
			return new Move(disc, position2);
		}
		else if(position == position2)
		{
			return new Move(disc, position1);
		}
		else
		{
			return new Move(disc, position);
		}
	}
	public String instructions()
	{
		return "Move disc " + disc + " to position " + position + ".";
	}
	public static void main(String[] args)
	{
		Move[] oldMoves = new Move[1];
		oldMoves[0] = new Move(1,'C');
		Move[] newMoves = new Move[1];
		for(int j = 0; j < numberOfDiscs - 1; j++)
		{
			newMoves = new Move[oldMoves.length * 2 + 1];
			for(int i = 0; i < oldMoves.length; i++)
			{
				newMoves[i] = oldMoves[i].reversePositions('B', 'C');
			}
			newMoves[oldMoves.length] = new Move(j + 2,'C');
			for(int i = 0; i < oldMoves.length; i++)
			{
				newMoves[i + oldMoves.length + 1] = oldMoves[i].reversePositions('A', 'B');
			}
			oldMoves = newMoves;
		}
		for(int i = 0; i < oldMoves.length; i++)
		{
			System.out.println(oldMoves[i].instructions());
		}
	}
}
