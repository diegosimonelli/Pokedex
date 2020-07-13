
public class Pokedex {
    private Pokemon[] pokeArray;
    private int size;
    private int numPokemon;


    public void setNumPokemon(int numPokemon) {
        this.numPokemon = numPokemon;
    }

    public void setPokeArray(Pokemon[] pokeArray) {
        this.pokeArray = pokeArray;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumPokemon() {
        return numPokemon;
    }

    public int getSize() {
        return size;
    }

    public Pokemon[] getPokeArray() {
        return pokeArray;
    }

    public Pokedex(int size) {
        setSize(size);
        setPokeArray(new Pokemon[size]);
        setNumPokemon(0);
    }

    public String[] listPokemon() {
        String[] namePokemon = new String[numPokemon];

        if(numPokemon == 0) {
            return null;
        }
        else {

            for (int index = 0; index < numPokemon; index++) {

                namePokemon[index] = pokeArray[index].getSpecies();
            }
        }
        return namePokemon;

    }
    public boolean addPokemon(String species) {
        if(numPokemon >= size) {
            System.out.println("Out of space :(");
            return false;
        }

        for (int index = 0; index < numPokemon; index++) {
            if (getPokeArray()[index].getSpecies().equalsIgnoreCase(species)) {
                System.out.println("Duplicate");
                return false;
            }
        }
        if (numPokemon < size) {
            pokeArray[numPokemon] = new Pokemon(species);
            numPokemon++;
            return true;
        }

        return false;
    }
    public int[] checkStats(String species) {
        int[] stats = new int[3];
        for (int index = 0; index < numPokemon; index++) {
            if (pokeArray[index].getSpecies().equalsIgnoreCase(species)) {
                stats[0] = pokeArray[index].getAttack();
                stats[1] = pokeArray[index].getDefense();
                stats[2] = pokeArray[index].getSpeed();

            }
        }
        return stats;
    }
    public void sortPokedex() {
        Pokemon sorter;
        for (int index = 0; index < numPokemon; index++) {
            for (int jindex = index + 1; jindex < numPokemon; jindex++) {
                if (pokeArray[index].getSpecies().compareToIgnoreCase(pokeArray[jindex].getSpecies()) > 0) {
                    sorter = pokeArray[index];
                    pokeArray[index] = pokeArray[jindex];
                    pokeArray[jindex] = sorter;
                }
            }
        }
    }
    public boolean evolvePokemon(String species) {
        boolean pArray = false;

        for (int index = 0; index < numPokemon; index++) {
            if (pokeArray[index].getSpecies().equalsIgnoreCase(species)) {
                pokeArray[index].evolve();
                pArray = true;
                break;
            }
            else {
                pArray = false;
            }
        }
        if (!pArray){
            System.out.println("Missing");
        }
        return pArray;
    }
}
