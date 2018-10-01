package stats4fun;

import java.util.List;

public abstract class Weapon {
	int damage;
	int critRange = 20;
	int critMult = 2;
	WeaponDamageType DMGtype;
	List<String> special;
	String weaponName;
	
	public abstract int CalcDamage(boolean main);
}



