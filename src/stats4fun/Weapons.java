package stats4fun;

public class Weapons {

	public static MeleeWeapon Greatsword = new MeleeWeapon(7, WeaponDamageType.Slashing);
	public static MeleeWeapon Longsword = new MeleeWeapon(4, 19, 2, WeaponDamageType.Slashing);
	public static MeleeWeapon Shortsword = new MeleeWeapon(3, 19, 2, WeaponDamageType.Piercing);
	public static MeleeWeapon Dagger = new MeleeWeapon(2, 19, 2, WeaponDamageType.Piercing);
	public static MeleeWeapon Shield = new MeleeWeapon(2, WeaponDamageType.Bludgeoning);
	public static MeleeWeapon Rapier = new MeleeWeapon(3, 18, 2, WeaponDamageType.Piercing);

}