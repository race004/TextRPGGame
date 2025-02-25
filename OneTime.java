import java.util.Random;

public class OneTime extends Napad
{
	public(String ime, int damage, int hit, int staminaReq, String element)
	{
		super(ime, damage, hit, staminaReq, stamina, healing, element);
	}
	
	public double elementCompatibility(Cudoviste monster)
	{
		if(element == "physical")
		{
			return 1;
		}
		
		if(element.equals(monster.getFirstElement()) || element.equals(monster.getSecondElement()))
		{
			return 0.5;
		}
		
		if(element == "fire" && monster.getFirstElement() == "nature" || monster.getSecondElement() == "nature")
		{
			return 2;
		}
		if(element == "nature" && monster.getFirstElement() == "earth" || monster.getSecondElement() == "earth")
		{
			return 2;
		}
		if(element == "earth" && monster.getFirstElement() == "air" || monster.getSecondElement() == "air")
		{
			return 2;
		}
		if(element == "air" && monster.getFirstElement() == "thunder" || monster.getSecondElement() == "thunder")
		{
			return 2;
		}
		if(element == "thunder" && monster.getFirstElement() == "water" || monster.getSecondElement() == "water")
		{
			return 2;
		}
		if(element == "water" && monster.getFirstElement() == "fire" || monster.getSecondElement() == "fire")
		{
			return 2;
		}
		
		return 1;
	}
}