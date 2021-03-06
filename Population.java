public class Population {

    Individual[] individuals;

    // Constructors
    
    // Create a population
    public Population(int populationSize, boolean initialise) {
        individuals = new Individual[populationSize];
        // Initialise population
        if (initialise) {
            // Loop and create individuals
            for (int i = 0; i < size(); i++) {
                Individual newIndividual = new Individual();
                newIndividual.generateIndividual();
                saveIndividual(i, newIndividual);
            }
        }
    }

    public Individual getFittest() {
        Individual fittest = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
                fittest = getIndividual(i);
            }
        }
        return fittest;
    }

    public Individual getSecondFittest() {
        Individual fittest = individuals[0];
        Individual second = individuals[0];
        // Loop through individuals to find fittest
        for (int i = 0; i < size(); i++) {
            if (fittest.getFitness() <= getIndividual(i).getFitness()) {
				second = fittest;
                fittest = getIndividual(i);
            }
        }
        return second;
    }

    // Public methods 
    // Get population size
    public int size() {
        return individuals.length;
    }

    // Save individual
    public void saveIndividual(int index, Individual indiv) {
        individuals[index] = indiv;
    }

    // Getters
    public Individual getIndividual(int index) {
        return individuals[index];
    }
    
    public String toString()
    {
		String all = "";
		
		for(int x = 0; x < individuals.length; x++)
		{
			all += "" + x + ": " + getIndividual(x).toString() + "\t-   " + getIndividual(x).getFitness() + "\n";
		}
		
		return all;
	}
}
