public class Theory
{
    private int murderer;
    private int location;
    private int weapon;

    // Constructor
    public Theory(int murdererNum, int locationNum, int weaponNum)
    {
        setMurderer(murdererNum);
        setLocation(locationNum);
        setWeapon(weaponNum);
    }

    // Accessor Methods
    public int getMurderer()
    {
        return murderer;
    }
    public int getLocation()
    {
        return location;
    }
    public int getWeapon()
    {
        return murderer;
    }

    // Mutator Methods
    public void setMurderer(int murderer)
    {
        this.murderer = murderer;
    }
    public void setLocation(int location)
    {
        this.location = location;
    }
    public void setWeapon(int weapon)
    {
        this.weapon = weapon;
    }
}
