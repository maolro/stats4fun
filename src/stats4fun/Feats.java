package stats4fun;

import java.util.*;


public class Feats {	 
		public static int dodge = 0;
		public static String dazzleText = "";
			
		public static void ClassFeats() {
			 PowerATK();
			 WeaponFocus();
			 if(Class.offHandWeapon=="Shield") {
				 ShieldFeats();
			 }
			 VitalStrike();
			 BullRush();
			 if(Class.lvl>=3) {
				 Class.Init+=2;
			 }
			 if(Class.lvl>=4) {
				 Class.Fort+=2;
			 }
			 Class.HP = Class.HP+Class.lvl;
		 }
		 public static void VitalStrike() {
			 int vitalStrike = Class.lvl/5;
			 if(vitalStrike>0) {
			 Class.WeaponDamage = Class.WeaponDamage*vitalStrike;
			 }
		 }
		 public static void PowerATK() {
			 int powerATK = 2 + (Class.BAB/4)*2;
			 String cleaveText = "";
			 Class.atkBonus = Class.atkBonus-powerATK/2;
			 if(Class.lvl>=2&&Class.mainHandWeapon != "Rapier") {
				 if(Class.mainHandWeapon == "Greatsword") {
					 powerATK = powerATK*2;
				 }
			 }
			 else {
				 powerATK = 0;
			 }
			 if(BaseRules.WeaponDamageType(Class.mainHandWeapon)=="Slashing") {
				 if(Class.lvl>=5) {
					 cleaveText = "\n If the first attack hits, do an extra attack against another enemy adjacent to the first.";
				 }
				 if(Class.lvl>=9) {
					 cleaveText = cleaveText+ "\n If this attack hits too, keep making attacks against enemies adjacent to tbe previous one. ";
				 }
			 }
			 Class.WeaponAtributes = Class.WeaponAtributes+cleaveText;
			 Class.WeaponDamage =  Class.WeaponDamage+powerATK;
		 }
		 public static void ShieldFeats(){
			 if(Class.lvl>=7) {
				 Class.ShieldBonus++;
			 }
			 ShieldBash();
			 if(Class.lvl>=16) {
				 Class.ShieldBonus++;
			 }
			 if(Class.lvl>=18) {
				 Class.WeaponAtributes = Class.WeaponAtributes+"\n on hit, do a Bull Rush Maneuver";
			 }
			 if(Class.lvl>=19) {
				 Class.MainWeaponPenalty = 0;
				 Class.OffWeaponPenalty = 0;
			 }
		 }
		 public static void WeaponFocus() {
			 Class.atkBonus++;
			 if(Class.lvl>=13) {
				 Class.atkBonus++;
			 }
			 if(Class.mainHandWeapon=="Rapier") {
				 if(Class.lvl>=5) {
					 dazzleText = "Dazzling Display: Do an intimidate check against all enemies within 30 feet.";
				 }
				 if(Class.lvl>=9) {
					 dazzleText = dazzleText+ "\n Demoralized creatures are also flat-footed for until the end of their next turn.";
				 }
			 }
			 if(Class.lvl>=17&&Class.mainHandWeapon=="Greatsword") {
				 int penet = 5;
				 if(Class.lvl>=19) {
					 penet+=5;
				 }
				 Class.WeaponAtributes = Class.WeaponAtributes+ "\n This attack ignores "+penet+" points of DR";;
			 }
		 }
		 public static String ImprovedCrit() {
			 if(Class.lvl >=12 && Class.crit =="20") {
				 return ". Crit 19-20";
			 }
			 else {
				 return "";
			 }
		 }
		 public static void Dodge() {
			 if(Class.lvl>=2&&Class.mainHandWeapon=="Rapier") {
				 dodge += 1 + Class.BAB/4;
				 if(Class.lvl>=8) {
					 dodge++;
				 }
				 if(Class.lvl>=18) {
					 Class.WeaponAtributes = Class.WeaponAtributes+ "\n Attack all targets within 5 feet.";
				 }
			 }
		 }
		 public static boolean ShieldBash() {
			 if(Class.lvl>=14) {
				 return true;
			 }
			 else {
				 return false;
			 }
		 }
		 public static String Slam() {
			 if(Class.lvl>=18) {
				 if(Class.offHandWeapon=="Shield") {
					 return ". On hit, do a Bull Rush maneuver";
				 }
				 else if(Class.mainHandWeapon=="Greatsword"){
					 return "\n On crit, do a Bull Rush maneuver. ";
				 }
				
				 else {
					 return "";
				 }
			 }
			 else {
				 return "";
			 }
		 }
	
		 public static void BullRush() {
			 ImpManeuver();
			 String BullRush = "";
			 if(Class.lvl>=11 && ImpManeuver().contains("Bull Rush")) {
				 BullRush = BullRush+"\n If a Bull Rush maneuver is succesful, do an opportunity attack.";
			 }
			 Class.WeaponAtributes=Class.WeaponAtributes+BullRush;
		 }
		 public static String ImpManeuver() {
			 if(Class.lvl>=6) {
				 List <String> maneuvers = new ArrayList<String>();
				 String text = "";
				 if(Class.offHandWeapon=="Shield"||Class.mainHandWeapon=="Greatsword") {
					 maneuvers.add("Bull Rush");
				 }
				 if(Class.mainHandWeapon=="Greatsword") {
					 maneuvers.add("Sunder");
				 }
				 if(Class.mainHandWeapon=="Rapier") {
					 maneuvers.add("Trip");
					 if(Class.lvl>=7) {
						 maneuvers.add("Disarm");
					 }
					 if(Class.lvl>=11) {
						 maneuvers.add("Feint");
					 }
				 }
				 for(int i=0;i<(maneuvers.size()-1);i++) {
					 text = text+maneuvers.get(i); 
					 text = text+", ";
				 }
				 text = text+maneuvers.get(maneuvers.size()-1); 
				 return "("+"+"+(Class.CMB+2)+" in "+text+")";
			 }
			 else {
				 return "";
			 }
		 }
}
