public class Cudoviste
{	
	private String imeCudovista;
    
	private int maxHealth;
    private int currentHealth;
	
	private int maxStamina;
	private int currentStamina;
    
	private int power;
	private int speed;
	
	private String prviElement; //Fire, Nature, Earth, Air, Thunder, Water
	private String drugiElement;
	
	private int level;
	private int requiredXP;
	private int currentXP;

    public Cudoviste(String ime, int health, int stamina, int speed, int power, String element1, String element2)
    {
		this.imeCudovista = ime;
		
        this.maxHealth = health;
		this.currentHealth = this.maxHealth;
		
		this.maxStamina = stamina;
		this.currentStamina; = this.maxStamina;
		
		this.power = power;
		this.speed = speed;
		
		this.prviElement = element1;
		this.drugiElement = element2;
		
		this.level = 1;
		this.requiredXP = 100;
		this.currentXP = 0;
    }
	
	public String getImeCudovista()
	{
		return this.imeCudovista;
	}
	
	public int getMaxHealth()
	{
		return this.maxHealth;
	}
	
	public int getCurrentHealth()
	{
		return this.currentHealth;
	}
	
	public int getMaxStamina()
	{
		return this.maxStamina;
	}
	
	public int getCurrentStamina()
	{
		return this.currentStamina;
	}
	
	public int getPower()
	{
		return this.power;
	}
	
	public int getSpeed()
	{
		return this.speed;
	}
	
	public String getFirstElement()
	{
		return this.prviElement;
	}
	
	public String getSecondElement()
	{
		return this.drugiElement;
	}
	
	public int getLevel()
	{
		return this.level;
	}
	
	public int getRequiredXP()
	{
		return this.requiredXP;
	}
	
	public int getCurrentXP()
	{
		return this.currentXP;
	}
	
	public boolean damageRecieved(int damage)
	{
		this.currentHealth -= damage;
		
		if(this.currentHealth > 0)
		{
			return true; // ziv
		}
		else
		{
			return false; // mrtav
		}
	}
	
	public void healingRecieved(int healing)
	{
		this.currentHealth += healing;
		
		if(this.currentHealth > this.maxHealth)
		{
			this.currentHealth = this.maxHealth;
		}	
	}
	
	public void removeStamina(int stamina)
	{
		this.currentStamina -= stamina;
		
		if(this.currentStamina < 0)
		{
			this.currentStamina = 0;
		}
	}
	
	public void addStamina(int stamina)
	{
		this.currentStamina += stamina;
		
		if(this.currentStamina > this.maxStamina)
		{
			this.currentStamina = this.maxStamina;
		}
	}
	
	public void staminaRecharge()
	{
		this.currentStamina += this.maxStamina / 2;
		
		if(this.currentStamina > this.maxStamina)
		{
			this.currentStamina = this.maxStamina;
		}
	}
	
	public void setStamina()
	{
		this.currentStamina = this.maxStamina;
	}
	
	public void setHealth()
	{
		this.currentHealth = this.maxHealth;
	}
	
	public void addXP(int experience)
	{
		this.currentXP += experience;
		if(this.level >= 10)
		{
			return;
		}
		
		if(this.currentXP >= this.requiredXP)
		{
			this.level++;
			this.currentXP -= this.requiredXP;
			this.requiredXP += 10;
			
			this.maxHealth += 10;
			this.currentHealth = this.maxHealth;
			
			this.power += 10;
			this.speed += 10;
		}
	}

	public void setLevel(int level)
	{
		if(level > 10)
		{
			this.level = 10;
			level = 10;
		}
		else if(level < 1)
		{
			this.level = 1;
			level = 1;
		}
		else
		{
			this.level = level;
		}
		
		this.maxHealth += 10 * level - 10;
		this.currentHealth = this.maxHealth;
		
		this.power += 10 * level - 10;
		this.speed += 10 * level - 10;
	}
}