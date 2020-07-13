import java.util.*;

public class MainPokedex {

    public static void main(String[] args) {
        Scanner insert = new Scanner(System.in);
        boolean checkRegion = false;
        Pokedex pokedex;
        int pokemons = 0;

        while (!checkRegion) {
            try {
                System.out.println("Welcome to your new PokeDex!");
                System.out.print("How many Pokemon are in your region: ");
                pokemons = insert.nextInt();

                if (Math.round(pokemons) != pokemons || (pokemons < 1)) {
                    System.out.println("\nThat's not a valid choice. Try again.\n");
                } else {
                    checkRegion = true;
                }
            }
            catch (InputMismatchException abc) {
                System.out.println("\nThat's not a valid choice. Try again.\n");
                insert.nextLine();
                pokemons = 0;
            }

        }
        pokedex = new Pokedex(pokemons);
        System.out.println("\nYour new Pokedex can hold " + pokemons + " Pokemon. Let's start using it!");

        int menuChoice = 0;

        while (menuChoice != 6) {
            try {
                System.out.println("\n1. List Pokemon");
                System.out.println("2. Add Pokemon");
                System.out.println("3. Check Pokemon Stats");
                System.out.println("4. Evolve Pokemon");
                System.out.println("5. Sort Pokemon");
                System.out.println("6. Exit");
                System.out.print("\nWhat would you like to do? ");
                menuChoice = insert.nextInt();
                if ((Math.round(menuChoice) != menuChoice) || (menuChoice > 6) || (menuChoice <= 0))
                    throw new InputMismatchException();
            }
            catch (InputMismatchException e) {
                System.out.println("\nThat's not a valid choice. Try again.");
                insert.nextLine();
                menuChoice = 0;
            }



            if (menuChoice == 1) {
                String[] listPokemon = pokedex.listPokemon();
                if (listPokemon == null) {
                    System.out.println("Empty");
                } else {
                    for (int index = 0; index < listPokemon.length; index++) {
                        System.out.println((index + 1) + ". " + listPokemon[index]);
                    }
                }
            }
            else if (menuChoice == 2) {
                System.out.print("\nPlease enter the Pokemon's Species: ");
                String species = insert.next();
                pokedex.addPokemon(species);
            }
            else if (menuChoice == 3) {
                String nameSpecies;
                System.out.print("\nPlease enter the Pokemon of interest: ");
                nameSpecies = insert.next();
                int[] pArray = pokedex.checkStats(nameSpecies);
                if (pArray[0] == 0) {
                    System.out.println("Missing");
                }
                else {
                    System.out.println("\nThe stats for " + nameSpecies + " are: ");
                    System.out.println("Attack: " + pArray[0]);
                    System.out.println("Defense: " + pArray[1]);
                    System.out.println("Speed: " + pArray[2]);
                }

            }
            else if (menuChoice == 4) {
                String nameSpecies = "";
                System.out.print("\nPlease enter the Pokemon of interest: ");
                nameSpecies = insert.next();
                boolean pArray = pokedex.evolvePokemon(nameSpecies);
                if (pArray){
                    System.out.println(nameSpecies + " has evolved!");
                }
            }
            else if (menuChoice == 5) {
                pokedex.sortPokedex();
            }
            else if (menuChoice == 6) {
                System.exit(0);
            }

        }
    }
}
