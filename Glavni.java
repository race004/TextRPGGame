import java.util.Scanner;
import java.util.Random;

public class Glavni
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
		Random rand = new Random();

		Cudoviste fireMonster = new Cudoviste("Fire Monster", 120, 80, "fire");
		Cudoviste natureMonster = new Cudoviste("Nature Monster", 80, 120, "nature");
		Cudoviste earthMonster = new Cudoviste("Earth Monster", 60, 140, "earth");
		Cudoviste waterMonster = new Cudoviste("Water Monster", 100, 100, "water");
		
		Napad[] napadi = new Napad[4];
		
		napadi[0] = new Napad("Lite Attack", 40, 100, false);
		napadi[1] = new Napad("Normal Attack", 50, 80, false);
		napadi[2] = new Napad("Heavy Attack", 80, 50, false);
		napadi[3] = new Napad("Healing", 50, 80, true);
		
		System.out.println("Choose monster:");
		ispisCudovista(1, fireMonster);
		ispisCudovista(2, natureMonster);
		ispisCudovista(3, earthMonster);
		ispisCudovista(4, waterMonster);
		
		Cudoviste igrac = null;
		boolean ponoviti = true;
		
		while(ponoviti)
		{
			System.out.print("Choice: ");
			int broj = sc.nextInt();
			switch(broj)
			{
				case 1:
					igrac = new Cudoviste("Fire Monster", 120, 80, "fire");
					ponoviti = false;
					break;
				case 2:
					igrac = new Cudoviste("Nature Monster", 80, 120, "nature");
					ponoviti = false;
					break;
				case 3:
					igrac = new Cudoviste("Earth Monster", 60, 140, "earth");
					ponoviti = false;
					break;
				case 4:
					igrac = new Cudoviste("Water Monster", 100, 100, "water");
					ponoviti = false;
					break;
			}
		}
		
		Cudoviste[] redosled = new Cudoviste[4];
		switch(igrac.getElement())
		{
			case "fire":	
				redosled[0] = natureMonster;
				redosled[1] = earthMonster;
				redosled[2] = waterMonster;
				redosled[3] = fireMonster;
				break;
			case "nature":
				redosled[0] = earthMonster;
				redosled[1] = waterMonster;
				redosled[2] = fireMonster;
				redosled[3] = natureMonster;
				break;
			case "earth":
				redosled[0] = waterMonster;
				redosled[1] = fireMonster;
				redosled[2] = natureMonster;
				redosled[3] = earthMonster;
				break;
			case "water":
				redosled[0] = fireMonster;
				redosled[1] = natureMonster;
				redosled[2] = earthMonster;
				redosled[3] = waterMonster;
				break;
		}
		
		boolean zivIgrac = true;
		int brojPobeda = 0;
		
		do
		{
			Cudoviste protivnik = redosled[brojPobeda];
			while(igrac.getCurrentHealth() > 0 && protivnik.getCurrentHealth() > 0)
			{
				System.out.println("-----------------------------------");
				System.out.println("Your Monster:");
				ispisTrenutnogStanja(igrac);
				System.out.println("Your Enemy:");
				ispisTrenutnogStanja(protivnik);
				
				System.out.println("Choose attack:");
				for(int i = 0; i < 4; i++)
				{
					int broj = i + 1;
					System.out.print(broj + ". ");
					ispisPoteza(napadi[i], igrac, protivnik);
				}
				ponoviti = true;
				Napad izborNapada = null;
				while(ponoviti)
				{
					System.out.print("Choice: ");
					int izbor = sc.nextInt();
					if(izbor >= 1 && izbor <= 4)
					{
						izborNapada = napadi[izbor - 1];
						ponoviti = false;
					}
				}
				if(izborNapada.getHealing())
				{
					int healing = izborNapada.healingReturn(igrac.getPower());
					igrac.healingRecieved(healing);
				}
				else
				{
					int damage = izborNapada.damageReturn(igrac.getPower(), igrac.compareElements(protivnik));
					if(!protivnik.damageRecieved(damage))
					{
						break;
					}
				}
				
				int izbor = rand.nextInt(4);
				izborNapada = napadi[izbor];
				
				if(izborNapada.getHealing())
				{
					int healing = izborNapada.healingReturn(protivnik.getPower());
					protivnik.healingRecieved(healing);
				}
				else
				{
					int damage = izborNapada.damageReturn(protivnik.getPower(), protivnik.compareElements(igrac));
					if(!igrac.damageRecieved(damage))
					{
						zivIgrac = false;
						break;
					}
				}
			}
			
			if(zivIgrac)
			{
				igrac.setHealth();
				System.out.println("You defeated your enemy!");
				System.out.println("-----------------------------------");
			}
			
			brojPobeda++;
		}
		while(zivIgrac && brojPobeda < 4);
		
		if(brojPobeda == 4 && zivIgrac)
		{
			System.out.println("Congratulations!");
		}
		else
		{
			System.out.println("You lost, try again!");
		}
	}
	
	public static void ispisCudovista(int broj, Cudoviste monster)
	{
		System.out.println(broj + ". " + monster.getImeCudovista());
		System.out.println("Element: " + monster.getElement());
		System.out.println("Health: " + monster.getMaxHealth());
		System.out.println("Power: " + monster.getPower());
		System.out.println();
	}
	
	public static void ispisTrenutnogStanja(Cudoviste monster)
	{
		System.out.println(monster.getImeCudovista() + " (" + monster.getElement() + "):");
		System.out.println("Power - " + monster.getPower());
		System.out.println("Health - " + monster.getCurrentHealth() + "/" + monster.getMaxHealth());
		System.out.println();
	}
	
	public static void ispisPoteza(Napad napad, Cudoviste igrac, Cudoviste protivnik)
	{
		if(napad.getHealing())
		{
			int healing = napad.getDamagePercentage() * igrac.getPower() / 100;
			System.out.println(napad.getName() + ": healing - " + healing + " // accuracy - " + napad.getHitPercentage());
		}
		else
		{
			double primary = napad.getDamagePercentage() * igrac.getPower() / 100 * igrac.compareElements(protivnik);
			int damage = (int) primary;
			System.out.println(napad.getName() + ": attack - " + damage + " // accuracy - " + napad.getHitPercentage());
		}
	}
}