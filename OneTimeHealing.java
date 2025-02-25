import java.util.Random;

public class OneTimeHealing extends Napad
{
	public(String ime, int damage, int hit, int staminaReq, String element)
	{
		super(ime, damage, hit, staminaReq, stamina, healing, element);	
	}
	
	public int healingReturn(int power)
	{
		Random rand = new Random();
		
		int probability = rand.nextInt(100) + 1;
		
		if(probability <= this.hitPercentage)
		{
			return power * this.damagePercentage / 100;
		}
		else
		{
			return 0;
		}
	}
}