package stats4fun;

import java.util.*;

public class Class {
		public static String Class = "Fighter";
		public static Weapon mainHandWeapon = Weapons.Greatsword();
		public static String offHandWeapon = null;
		public static String armorType = "Plate";
		public static String crit = "20";
		public static int lvl = 20;
		public static int HD = 5;
		public static int HP;
		public static int AC = 10;
		public static int speed = 30;
		public static int STR = 10, DEX = 10, CON = 10, INT = 10, WIS = 10, CHA = 10;
		public static int BAB;
		public static int Fort, Will, Ref;
		public static int Init;
		public static int CMD, CMB, atkBonus;
		public static String DR="";
		public static int WeaponDamage = mainHandWeapon.CalcDamage(true)+BaseRules.calcMod(STR);
		public static String WeaponAtributes = "";
		public static int ShieldBonus = 2;
		public static int MainWeaponPenalty = 4;
		public static int OffWeaponPenalty = 4;

	public static void main(String[] args) {
		if (BaseRules.calcMod(DEX) <= BaseRules.calcMaxDexBonus(armorType)) {
			AC =  10 + BaseRules.calcMod(DEX) + BaseRules.calcArmorBonus(armorType);
		} else {
			AC = 10 + BaseRules.calcMaxDexBonus(armorType) + BaseRules.calcArmorBonus(armorType);
		}
		if (Class == "Fighter") {
			FighterClass.Fighter();
		} 
		if(Class=="Rogue") {
			RogueClass.Rogue();
		}
		Init = BaseRules.calcMod(DEX);
		CMD = BaseRules.calcCMD();
		CMB = CMD-10;
		HP = (HD + BaseRules.calcMod(CON)) * lvl;
		AC = AC + Feats.dodge;
		atkBonus = BAB+BaseRules.calcMod(BaseRules.AtkBonusModifier());
		WeaponDamage = (BaseRules.WeaponDamage(mainHandWeapon)+BaseRules.calcMod(STR));
		if(offHandWeapon=="Shield") {	
			AC = AC+ShieldBonus;
		}
		Feats.ClassFeats();
		PrintStats.PrintStats();
	}
}
