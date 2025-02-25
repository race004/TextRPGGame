import java.util.Random;

public class OneTimeDamage extends Napad
{
	public(String ime, int damage, int hit, int staminaReq, String element)
	{
		super(ime, damage, hit, staminaReq, stamina, healing, element);	
	}
	
	public int damageReturn(int power, double multiplier)
	{
		Random rand = new Random();
		
		int probability = rand.nextInt(100) + 1;
		
		if(probability <= this.hitPercentage)
		{
			double primary = power * this.damagePercentage / 100 * multiplier;
			return (int) primary;
		}
		else
		{
			return 0;
		}
	}
}