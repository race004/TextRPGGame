import java.util.Random;

public class Napad
{
	private String imeNapada;
    private int damagePercentage;
	private int hitPercentage;
	private boolean healing; // false - damage , true - healing
	
	public Napad(String ime, int damage, int hit, boolean healing)
	{
		this.imeNapada = ime;
		this.damagePercentage = damage;
		this.hitPercentage = hit;
		this.healing = healing;
	}
	
	public String getName()
	{
		return this.imeNapada;
	}
	
	public int getDamagePercentage()
	{
		return this.damagePercentage;
	}
	
	public int getHitPercentage()
	{
		return this.hitPercentage;
	}
	
	public boolean getHealing()
	{
		return this.healing;
	}
	
	public int healingReturn(int power)
	{
		Random rand = new Random();
		
		int probability = rand.nextInt(100) + 1;
		
		if(probability <= this.hitPercentage)
		{
			return power * damagePercentage / 100;
		}
		else
		{
			return 0;
		}
	}
	
	public int damageReturn(int power, double multiplier)
	{
		Random rand = new Random();
		
		int probability = rand.nextInt(100) + 1;
		
		if(probability <= this.hitPercentage)
		{
			double primary = power * damagePercentage / 100 * multiplier;
			return (int) primary;
		}
		else
		{
			return 0;
		}
	}
}