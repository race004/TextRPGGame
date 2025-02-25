import java.util.Random;

public class OverTime extends Napad
{
	private int turn;
	
	public(String ime, int damage, int hit, int staminaReq, String element, int turn)
	{
		super(ime, damage, hit, staminaReq, element);
		this.turn = turn;
	}
	
	public int getTurn()
	{
		return this.turn;
	}
}