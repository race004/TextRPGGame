import java.util.Random;

public class Stun extends OneTime
{
	private int turn;
	
	public(String ime, int damage, int hit, int staminaReq, String element, int turn)
	{
		super(ime, damage, hit, staminaReq, stamina, healing, element);
		this.turn = turn;
	}
}