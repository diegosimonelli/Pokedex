
public class Pokemon {
    private int attack;
    private int defense;
    private int speed;
    private String species = "";

    public Pokemon (String species) {
        setSpecies(species);
        setAttack(species.length() * 4 + 2);
        setDefense(species.length() * 2 + 7);
        setSpeed(species.length() * 3 + 5);
    }
    public int getAttack() {
        return attack;
    }
    public void setAttack(int newAttack) {
        attack = newAttack;
    }
    public int getDefense() {
        return defense;
    }
    public void setDefense(int newDefense) {
        defense = newDefense;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int newSpeed) {
        speed = newSpeed;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String newSpecies) {
        this.species = newSpecies;
    }
    public void evolve() {
        setSpeed(getSpeed() * 2);
        setAttack(getAttack() * 3);
        setDefense(getDefense() * 5);
    }
}
