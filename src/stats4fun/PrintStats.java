package stats4fun;

public class PrintStats {
	public static void PrintStats() {
		printAC();
		printHP();
		System.out.println("Speed: "+Class.speed+" ft");
		System.out.println("______________________________");
		System.out.println("STR  "+"DEX  "+"CON  "+"INT  "+"WIS  "+"CHA  ");
		System.out.println(" "+Class.STR+"   "+Class.DEX+"   "+Class.CON+"   "+Class.INT+"   "+Class.WIS+"   "+Class.CHA);
		System.out.println("______________________________");
		System.out.println("Saves: Fort +"+Class.Fort+", Ref +"+Class.Ref+", Will +"+Class.Will);
		BaseRules.Skills();
		System.out.println("Initiative: +"+Class.Init);
		System.out.println("CMB: +"+Class.CMB+Feats.ImpManeuver()+"  CMD: "+Class.CMD+"   ");
		if(Class.DR!="") {		System.out.println("DR: "+Class.DR);	}
		System.out.println("______________________________");
		if(Class.Class=="Fighter") {
			FighterClass.FighterTraits();
		}
		if(Class.Class=="Rogue") {
			RogueClass.RogueTraits();
		}
		if(Class.mainHandWeapon==Weapons.Rapier) {
			System.out.println("Mobility: +4 AC against opportunity attacks from movement");
			if(Class.lvl>=19) {
				System.out.println("Deadly Stroke: this creature deals x2 damage and 1 CON bleed against flat-footed creatures");
			}
		}
		System.out.println("______________________________");
		System.out.println("ACTIONS");
		BaseRules.printActions();
		
	}
	public static void printAC() {
		String ACprint = "AC: "+Class.AC+" (";
		if(BaseRules.calcMaxDexBonus(Class.armorType)>=BaseRules.calcMod(Class.DEX)) {
				ACprint = ACprint+"+"+BaseRules.calcMod(Class.DEX)+" Dex, +"+(BaseRules.calcArmorBonus(Class.armorType))+" Armor";
		}
		else {
				ACprint = ACprint+"+"+FighterClass.armorTraining()+" Dex, +"+(BaseRules.calcArmorBonus(Class.armorType))+" Armor";
		}
		if(Class.offHandWeapon == Weapons.Shield) {
				ACprint = ACprint+", +2 Shield";
		}
		if(Feats.dodge>0) {
			ACprint = ACprint+", +"+Feats.dodge+" Dodge";
		}
		System.out.println(ACprint+")");
	}
	public static void printHP() {
		System.out.println("HP: "+Class.HP+" ("+Class.lvl+"d"+(Class.HD-1)*2+"+"+BaseRules.calcMod(Class.CON)*Class.lvl+")");
	}
}