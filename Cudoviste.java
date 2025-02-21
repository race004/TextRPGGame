import java.util.Random;

public class Cudoviste
{
	private String imeCudovista;
    private int maxHealth;
    private int currentHealth;
    private int power;
	private String element; //Fire, Nature, Earth, Water

    public Cudoviste(String ime, int power, int health, String element)
    {
		this.imeCudovista = ime;
        this.maxHealth = health;
		this.currentHealth = this.maxHealth;
		this.power = power;
		this.element = element;
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
	
	public int getPower()
	{
		return this.power;
	}
	
	public String getElement()
	{
		return this.element;
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
	
	public void setHealth()
	{
		this.currentHealth = this.maxHealth;
	}
	
	public double compareElements(Cudoviste monster)
	{
		if(this.element == "fire" && monster.getElement() == "nature")
		{
			return 2;
		}
		
		if(this.element == "nature" && monster.getElement() == "earth")
		{
			return 2;
		}
		
		if(this.element == "earth" && monster.getElement() == "water")
		{
			return 2;
		}
		
		if(this.element == "water" && monster.getElement() == "fire")
		{
			return 2;
		}
		
		if(this.element.equals(monster.getElement()))
		{
			return 0.5;
		}
		
		return 1;
	}
}