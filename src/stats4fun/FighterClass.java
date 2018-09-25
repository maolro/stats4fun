package stats4fun;

public class FighterClass {
	public static void Fighter() {
		Class.HD = 6;
		if(BaseRules.AtkBonusModifier()==1) {
			Class.DEX = BaseRules.MainScoreIncrease();
			Class.STR = BaseRules.ThirdScoreIncrease();
		}
		else {
			Class.STR = BaseRules.MainScoreIncrease();
			Class.DEX = BaseRules.ThirdScoreIncrease();
		}
		Class.CON = BaseRules.SecondScoreIncrease();
		Class.WIS = Class.WIS + 2;
		Class.CHA = Class.CHA - 2;              
		Class.BAB = Class.lvl;
		Class.Fort = 2 + Class.lvl / 2 + BaseRules.calcMod(Class.CON);
		Class.Ref = Class.lvl / 3 + BaseRules.calcMod(Class.DEX);
		Class.Will = Class.lvl / 3 + BaseRules.calcMod(Class.WIS);
		Class.atkBonus = Class.atkBonus+weaponTraining();
		Class.WeaponDamage = Class.WeaponDamage+weaponTraining();
		if (BaseRules.calcMod(Class.DEX) <= armorTraining()) {
			Class.AC =  10 + BaseRules.calcMod(Class.DEX) + BaseRules.calcArmorBonus(Class.armorType);
		} else {
			Class.AC = 10 + armorTraining() + BaseRules.calcArmorBonus(Class.armorType);
		}
		if(Class.lvl>=18) {
			Class.DR="5/-";
		}
		
	}
	
	public static int armorTraining() {
		if (BaseRules.calcMod(Class.DEX) > (BaseRules.calcMaxDexBonus(Class.armorType) + Class.lvl/5)) {
				return BaseRules.calcMaxDexBonus(Class.armorType);
			}
	    else {
			return BaseRules.calcMod(Class.DEX);
		}
	}
	public static int weaponTraining() {
		if(Class.lvl>16) {
			return 4;
		}
		if(Class.lvl>12) {
			return 3;
		}
		if(Class.lvl>7) {
			return 2;
		}
		if(Class.lvl>4) {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static void FighterTraits() {
		if(Class.lvl>1) {
			System.out.println("Bravery: +"+(1+Class.lvl/4)+" against fear");
		}
		if(Class.mainHandWeapon==Weapons.Greatsword&&Class.lvl>=12) {
			System.out.println("Improved Sunder: If this creature attempts a sunder and is succesful, deal "+Class.WeaponDamage+" damage to the weapon's wielder");
		}
	}

}
