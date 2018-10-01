package stats4fun;

import java.util.*;


public class Feats {	 
		public static int dodge = 0;
		public static String dazzleText = "";
		public static String maneuvers = "";
		
		
		public static void FighterFeats() {
			Class.atkBonus++;
			VitalStrike();
			if(Class.offHandWeapon==null) {
				TwoHandFeats();
			}
			else if(Class.offHandWeapon==Weapons.Shield) {
				ShieldFeats();
			}
			if(Class.lvl>=3) {
				Class.Init+=2;
			}
			if(Class.lvl>=4) {
				Class.Fort+=2;
			}
			if(Class.lvl>=8) {
				Class.HD++;
			}
			if(Class.lvl>=12) {
				Class.mainHandWeapon.critRange--;
			}
			if(Class.lvl>=13) {
				Class.atkBonus++;
			}
		}
		
		public static int shieldBonus() {
			return Class.mainHandWeapon.CalcDamage(true);
		}
		 public static void VitalStrike() {
			 int vitalStrike = Class.lvl/5;
			 if(vitalStrike>0) {
			 Class.WeaponDamage = Class.WeaponDamage*vitalStrike;
			 }
		 }
		 
		 public static void TwoHandFeats() {
				 String weaponText = "";
				 PowerATK();
				 if(Class.lvl>=2) {
					 weaponText = "\n If the first attack hits, do an extra attack against another enemy adjacent to the first.";
				 }
				 if(Class.lvl>=5) {
					 maneuvers = "(+"+Class.CMB+ "in Bull Rush";
				 }
				 if(Class.lvl>=6) {
					 maneuvers+= ", Sunder)";
				 }
				 if(Class.lvl>=7) {
					 weaponText = weaponText+ "\n If this attack hits too, keep making attacks against enemies adjacent to tbe previous one. ";
				 }
				 if(Class.lvl>=16) {
					 weaponText = weaponText+"\n This attack ignores 5 points of DR";
				 }
				 if(Class.lvl>=19) {
					 weaponText = weaponText+"\n This attack ignores 10 points of DR";
				 }
				 Class.WeaponAtributes+=weaponText;
		 }
		 
		 public static void ShieldFeats() {			 
			 String weaponText = "";
			 PowerATK();
			 if(Class.lvl>=2) {
				 weaponText = "\n If the first attack hits, do an extra attack against another enemy adjacent to the first.";
			 }
			 if(Class.lvl>=5) {
				 maneuvers = "(+"+Class.CMB+ "in Bull Rush";
			 }
			 if(Class.lvl>=6) {
				 maneuvers+= ", Sunder)";
			 }
			 if(Class.lvl>=7) {
				 weaponText = weaponText+ "\n If this attack hits too, keep making attacks against enemies adjacent to tbe previous one. ";
			 }
			 if(Class.lvl>=16) {
				 weaponText = weaponText+"\n This attack ignores 5 points of DR";
			 }
			 if(Class.lvl>=19) {
				 weaponText = weaponText+"\n This attack ignores 10 points of DR";
			 }
			 Class.WeaponAtributes+=weaponText;
	 }

		 public static void PowerATK() {
			 int bonus = Class.BAB/4;
			 Class.WeaponDamage += bonus*2;
			 Class.atkBonus -= bonus;
		 }
}
