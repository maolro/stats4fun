package stats4fun;

import java.util.*;

public class BaseRules {
		// converts stat value to modifier
		
		public static int calcMod(int mod) {
			mod = (mod-10)/2;
			return mod;
		}
		public static int calcCMD() {
			return 10+Class.BAB+calcMod(Class.STR)+calcMod(Class.DEX);
		}
		// calculates AC bonus given by armor
		public static int calcArmorBonus(String armor) {
			int armorBonus;
			if(armor == "Padded") {
				armorBonus = 1;
			}
			else if(armor == "Leather") {
				armorBonus = 2;
			}
			else if(armor == "Studded Leather") {
				armorBonus = 3;
			}
			else if(armor == "Chain Shirt"||armor == "Hide") {
				armorBonus = 4;
			}
			else if(armor == "Scale Mail") {
				armorBonus = 5;
			}
			else if(armor == "Chainmail"||armor == "Breastplate") {
				armorBonus = 6;
			}
			else if(armor == "Splint mail"||armor == "Banded mail") {
				armorBonus = 7;
			}
			else if(armor == "Half plate") {
				armorBonus = 8;
			}
			else if(armor == "Plate") {
				armorBonus = 9;
			}
			else {
				armorBonus = 0;
			}
			return armorBonus;
		}
	// calculates max DEX bonus allowed by armor
	public static int calcMaxDexBonus(String armor) {
		int maxDexBonus;
		if(armor == "Padded") {
			maxDexBonus = 8;
		}
		else if(armor == "Leather") {
			maxDexBonus = 6;
		}
		else if(armor == "Studded Leather") {
			maxDexBonus = 5;
		}
		else if(armor == "Chain Shirt"||armor == "Hide") {
			maxDexBonus = 4;
		}
		else if(armor == "Scale Mail"||armor == "Breastplate") {
			maxDexBonus = 3;
		}
		else if(armor == "Chainmail") {
			maxDexBonus = 2;
		}
		else if(armor == "Banded mail"||armor == "Plate") {
			maxDexBonus = 1;
		}
		else if(armor == "Half plate"||armor == "Splint") {
			maxDexBonus = 0;
		}
		else {
			maxDexBonus = 50;
		}
		return maxDexBonus;
	}
	// AC calculate method
	public static int calcAC(int DEX, String armorType) {
		int AC;
		if(BaseRules.calcMod(DEX)<=BaseRules.calcMaxDexBonus(armorType)) {
			AC = 10 + BaseRules.calcMod(DEX) + BaseRules.calcArmorBonus(armorType);
			return AC;
		}
		else {
			AC = 10 + BaseRules.calcMaxDexBonus(armorType) + BaseRules.calcArmorBonus(armorType);
			return AC;
		}
	}
	// weapon damage calculate method
	public static String WeaponDamageType(String weaponName) {
		if(weaponName.equals("Dagger")||weaponName.equals("Halberd")||weaponName.equals("Longbow")||weaponName.equals("Rapier")) {
			return "Piercing";
		}
		else if(weaponName.equals("Longsword")||weaponName.equals("Greatsword")||weaponName.equals("Greataxe")) {
			return "Slashing";
		}
		else {
			return "Bludgeoning";
		}
	}
	public static void offHandWeapon(String weaponName, int AC) {
		if(weaponName == "Shield") {
			AC = AC+2;
		}
		else {
			WeaponDamage(weaponName);
		}
	}
	public static int MainScoreIncrease() {
		if (Class.lvl >= 16) {
			return 19;
		}

		else if (Class.lvl >= 4) {
			return 17;
		}
		else {
			return 15;

		}
	}
	public static int SecondScoreIncrease() {
		if (Class.lvl >= 20) {
			return 18;
		}

		else if (Class.lvl >= 8) {
			return 17;
		}
		else {
			return 14;

		}
	}
	public static int ThirdScoreIncrease() {
		if (Class.lvl >= 12) {
			return 15;
		}

		else {
			return 13;

		}
	}
	public static int AtkBonusModifier() {
		if(Class.mainHandWeapon == "Longbow"||Class.mainHandWeapon == "Rapier"||Class.mainHandWeapon == "Shortsword") {
			return 1;
		}
		else {
			return 0;
		}
	}
	public static void Skills() {
		int STR = calcMod(Class.STR);
		int DEX = calcMod(Class.DEX);
		int INT = calcMod(Class.INT);
		int WIS = calcMod(Class.WIS);
		int CHA = calcMod(Class.CHA);

		System.out.print("Skills: ");
		if(Class.Class=="Fighter") {
			System.out.print("Climb +"+(STR+Class.lvl)+(", "));
			System.out.print("Intimidate +"+(CHA+Class.lvl)+"\n");
		}
		if(Class.Class=="Rogue") {
			System.out.print("Acrobatics +"+(DEX+Class.lvl)+(", "));
			System.out.print("Bluff +"+(CHA+Class.lvl)+(", "));
			System.out.print("Disable Device +"+(DEX+Class.lvl)+(", "));
			System.out.print("Perception +"+(WIS+Class.lvl)+(", "));
			System.out.print("Stealth +"+(DEX+Class.lvl)+(", "));
			System.out.print("\n Climb +"+(STR+Class.lvl)+(", "));
			System.out.print("Diplomacy +"+(CHA+Class.lvl)+(", "));
			if(Class.INT>=2) {
				System.out.print("Sleight of Hand +"+(DEX+Class.lvl)+(", "));
				System.out.print("Climb +"+(STR+Class.lvl)+(", "));
			}
			if(Class.INT>=3) {
				System.out.print("Disguise +"+(CHA+Class.lvl)+(", "));
			}
			if(Class.INT>=4) {
				System.out.print("Use Magic Device +"+(INT+Class.lvl)+(", "));
			}
			System.out.print("Escape Artist +"+(DEX+Class.lvl)+"\n");
		}
	}
	public static void printActions() {
		String multiATK = "";
		String mainHandAction = Class.mainHandWeapon+": ";
		String offHandAction = "";
		if(Class.offHandWeapon==null||(Class.offHandWeapon=="Shield"&&Feats.ShieldBash()==false)) {
			mainHandAction = mainHandAction+"+"+Class.atkBonus+" to hit, "+(Class.WeaponDamage)+" "+BaseRules.WeaponDamageType(Class.mainHandWeapon);
		}
		else if(Class.offHandWeapon=="Shield"&&Feats.ShieldBash()==true) {
			multiATK = "Multiattack: "+Class.mainHandWeapon+" + Shield Bash";
			mainHandAction = mainHandAction+"+"+(Class.atkBonus-Class.MainWeaponPenalty)+" to hit, "+(Class.WeaponDamage)+" "+BaseRules.WeaponDamageType(Class.mainHandWeapon);
			offHandAction = "Shield Bash: "+"+"+(Class.atkBonus-Class.OffWeaponPenalty)+" to hit, "+(2+BaseRules.calcMod(Class.STR)+" Bludgeoning"+Feats.ImprovedCrit());
		}
		else {
			multiATK = "Multiattack: "+Class.mainHandWeapon+" + "+Class.offHandWeapon;
			mainHandAction = mainHandAction+"+"+(Class.atkBonus-Class.MainWeaponPenalty)+" to hit, "+(Class.WeaponDamage)+" "+BaseRules.WeaponDamageType(Class.mainHandWeapon);
			offHandAction = Class.offHandWeapon+": "+"+"+(Class.atkBonus-Class.OffWeaponPenalty)+" to hit, "+(Class.WeaponDamage)+" "+BaseRules.WeaponDamageType(Class.mainHandWeapon);
		}
		if(Class.crit!="20") {	
			mainHandAction = mainHandAction+". Class.crit "+Class.crit;	
			if(offHandAction!="") {offHandAction = offHandAction+". Class.crit "+Class.crit;}
		}
		if(Class.mainHandWeapon=="Rapier"&&Class.lvl>=9) {
			multiATK =  "Multiattack: "+Class.mainHandWeapon + " + move "+Class.speed+" feet";
		}
		if(multiATK!="") {		System.out.println(multiATK);	}
		mainHandAction = mainHandAction+Class.WeaponAtributes;
		System.out.println(mainHandAction);
		if(Class.mainHandWeapon!= null ||Class.mainHandWeapon!= "Shield") {
			System.out.println(offHandAction);
		}
		if(Feats.dazzleText!="") {
			System.out.println(Feats.dazzleText);
		}
		
	}
}

