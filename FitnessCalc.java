public class FitnessCalc {

    static char[] solution = new char[10];

    /* Public methods */
    // Set a candidate solution as a byte array
    public static void setSolution(char[] newSolution) {
        solution = newSolution;
    }

    // To make it easier we can use this method to set our candidate solution
    // with string of 0s and 1s
    static void setSolution(String newSolution) {
        solution = new char[newSolution.length()];
        // Loop through each character of our string and save it in our byte
        // array
        for (int i = 0; i < newSolution.length(); i++) {
            solution[i] = newSolution.charAt(i);
        }
    }

    // Calculate inidividuals fittness by comparing it to our candidate solution
    static int getFitness(Individual individual) {
        int fitness = 0;
        // Loop through our individuals genes and compare them to our cadidates
        for (int i = 0; i < individual.size() && i < solution.length; i++) {
            //fitness += (-1 * (Math.abs(individual.getGene(i) - solution[i])));
            if(individual.getGene(i) == solution[i])
				fitness++;
        }
        return fitness;
    }
    
    // Get optimum fitness
    static int getMaxFitness() {
//        int maxFitness = 0;
		int maxFitness = solution.length;
        return maxFitness;
    }
    
    static int getLength()
    {
		return solution.length;
	}
    
    static String getSolution()
    {
		String s = "";
		
		for(int x = 0; x < solution.length; x++)
			s += solution[x];
			
		return s;
	}
}
