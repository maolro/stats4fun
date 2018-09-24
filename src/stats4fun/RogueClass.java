package stats4fun;


public class RogueClass {
	public static void Rogue() {
		Class.HD = 5;
		Class.DEX = BaseRules.MainScoreIncrease();
		Class.CON = BaseRules.ThirdScoreIncrease();
		Class.INT = BaseRules.SecondScoreIncrease();
		Class.WIS = Class.WIS - 2;
		Class.CHA = Class.CHA + 2	;              
		Class.BAB = Class.lvl/2+Class.lvl/4;
		Class.Fort = 2 + Class.lvl / 3 + BaseRules.calcMod(Class.CON);
		Class.Ref = Class.lvl / 2 + 2 + BaseRules.calcMod(Class.DEX);
		Class.Will = Class.lvl / 3 + BaseRules.calcMod(Class.WIS);

	}
	public static void RogueTraits() {
		System.out.println(SneakATK());
		System.out.println("Trapfinding: +"+Class.lvl/2+" in perception checks to find traps");
		if(Class.lvl>=2) {
			System.out.println(evasion());
		}
		if(Class.lvl>=3) {
			System.out.println("Trap Sense: +"+(Class.lvl/3)+" on reflex saves and AC against traps");
		}
		if(Class.lvl>=4) {
			System.out.println("Uncanny Dodge: This creature can't be caught flat-footed and doesn't lose DEX bonus if the attacker is invisible");
			System.out.println("Surprise Attack: During the surprise round, enemies are considered flat-footed to this creature");
		}
		if(Class.lvl>=8) {
			System.out.println("Quick Disable: This creature takes 1 round to disable a trap");
			System.out.println("Improved Uncanny Dodge: This creature can'tbe flanked except by rogues of level "+(Class.lvl+4)+" or higher");
		}
		if(Class.lvl>=12) {
			System.out.println("Defensive Roll (1/Day): ");
		}
		if(Class.lvl>=16) {
			System.out.println("Slippery Mind: If this creature fails an enchantment spell save, it can repeat that save 1 round later");
		}
		if(Class.lvl>=18) {
			System.out.println("Opportunist (1/Round): This creature makes an opportunity atttack against an enemy who has just taken damage");
		}
	}
	public static String SneakATK() {
		String SneakATK = "Sneak Attack: +"+(Class.lvl+1)/2*3.5+" damage";
		if(Class.lvl>=20) {
			SneakATK = SneakATK+" and DC "+(10+Class.lvl/2+Class.INT)+" Fort or dead";
		}
		SneakATK = SneakATK+" if the target is flat-footed or this creature is flanking it";
		return SneakATK;
	}
	public static  String evasion() {
		String evasion = "Evasion: When this creature is hit by an effect that deals 1/2 damage on a sucessful save, \n it deals no damage on a sucessful save";
		if(Class.lvl>=10) {
			evasion = evasion+" and half damage on a succesful save";
		}
		return evasion;
	}
}
