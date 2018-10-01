package stats4fun;

public class Weapons {

	public static MeleeWeapon Greatsword = new MeleeWeapon("Greatsword", 7, WeaponDamageType.Slashing);
	public static MeleeWeapon Longsword = new MeleeWeapon("Longsword", 4, 19, 2, WeaponDamageType.Slashing);
	public static MeleeWeapon Shortsword = new MeleeWeapon("Shortsword", 3, 19, 2, WeaponDamageType.Piercing);
	public static MeleeWeapon Dagger = new MeleeWeapon("Dagger", 2, 19, 2, WeaponDamageType.Piercing);
	public static MeleeWeapon Shield = new MeleeWeapon("Shield Bash", 2, WeaponDamageType.Bludgeoning);
	public static MeleeWeapon Rapier = new MeleeWeapon("Rapier", 3, 18, 2, WeaponDamageType.Piercing);

}