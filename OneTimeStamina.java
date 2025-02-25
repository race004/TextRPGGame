import java.util.Random;

public class OneTimeStamina extends Napad
{
	public(String ime, int damage, int hit, int staminaReq, String element)
	{
		super(ime, damage, hit, staminaReq, stamina, healing, element);	
	}
	
	public int staminaReductionReturn(int power)
	{
		Random rand = new Random();
		
		int probability = rand.nextInt(100) + 1;
		
		if(probability <= this.hitPercentage)
		{
			return this.damagePercentage;
		}
		else
		{
			return 0;
		}
	}
}