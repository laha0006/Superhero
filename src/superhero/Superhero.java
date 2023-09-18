package superhero;

public class Superhero {
    private String name;
    private String realName;
    private boolean isHuman;
    private String superPower;
    private int creationYear;
    private int strength;

    public Superhero(String name, String realName, boolean isHuman, String superPower, int creationYear, int strength) {
        this.name = name;
        this.realName = realName;
        this.isHuman = isHuman;
        this.superPower = superPower;
        this.creationYear = creationYear;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public boolean isHuman() {
        return isHuman;
    }

    public void setHuman(boolean human) {
        isHuman = human;
    }

    public String getSuperPower() {
        return superPower;
    }

    public void setSuperPower(String superPower) {
        this.superPower = superPower;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public String toString() {
        return "superhero.Superhero{" +
                "\nname='" + name + '\'' +
                "\n, realName='" + realName + '\'' +
                "\n, isHuman=" + isHuman +
                "\n, superPower='" + superPower + '\'' +
                "\n, creationYear=" + creationYear +
                "\n, strength=" + strength +
                '}';
    }
}
