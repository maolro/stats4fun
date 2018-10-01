package stats4fun;

public class WizardClass {
	public static String school = "";
	public static void Wizard() {
		Class.HD = 3;
		Class.INT = BaseRules.MainScoreIncrease();
		Class.CHA = BaseRules.ThirdScoreIncrease();
		Class.DEX = BaseRules.SecondScoreIncrease();
		Class.CON = Class.CON + 2;
		Class.STR = Class.STR - 2;              
		Class.BAB = Class.lvl/2;
		Class.Fort = Class.lvl / 3 + BaseRules.calcMod(Class.CON);
		Class.Ref = Class.lvl / 3 + BaseRules.calcMod(Class.DEX);
		Class.Will = 2 + Class.lvl / 2 + BaseRules.calcMod(Class.WIS);
	}
	public static void spellList() {
		String lvl1 = "Mage Armor, Magic Missile";
		String lvl2 = "";
		String lvl3;
	}
	public static void schoolSpell(String lvl1, String lvl2, String lvl3) {
		if(school=="Evocation") {
			lvl1+=", Burning Hands";
			lvl1+=", Burning Hands";
			lvl2+=", Scorching Ray";
			lvl2+=", Shatter";
			lvl2+=", Resist Energy";
		}
		
	}
	
}
