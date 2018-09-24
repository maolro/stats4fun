package stats4fun;

import java.util.List;

public class MeleeWeapon extends Weapon {
		public MeleeWeapon (int damage, int critRange, int critMult, WeaponDamageType DMGtype)
		{
			this.damage = damage;
			this.critRange = critRange;
			this.critMult = critMult;
			this.DMGtype = DMGtype;
		}
		
		public MeleeWeapon (int damage, WeaponDamageType DMGtype)
		{
			this.damage = damage;
			this.critRange = 20;
			this.critMult = 2;
			this.DMGtype = DMGtype;
		}	
		
		public int CalcDamage(boolean main) {
			if(main) {
				return damage = damage + BaseRules.calcMod(Class.STR);
			}
			else {
				return damage = damage + BaseRules.calcMod(Class.STR)/2;
			}
		}

}
