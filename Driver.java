import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Driver {

    public static void main(String[] args) 
    {
		/*
		java.util.Scanner scan = new java.util.Scanner(System.in);
        // Set a candidate solution
        FitnessCalc.setSolution("HELLOWORLD");

        // Create an initial population
        Population myPop = new Population(50, true);
        
        // Evolve our population until we reach an optimum solution
        int generationCount = 0;
        while (myPop.getFittest().getFitness() < FitnessCalc.getMaxFitness()) {
            generationCount++;
            System.out.println("Gener: " + generationCount
										 + "\tFittest: " + myPop.getFittest() + "(" + myPop.getFittest().getFitness() + ")"
										 + "\tSecond: " + myPop.getSecondFittest()+ "(" + myPop.getSecondFittest().getFitness() + ")");
            myPop = Algorithm.evolvePopulation(myPop);
        }
        System.out.println("Solution found!");
        System.out.println("Generation: " + generationCount);
        System.out.println("Genes:");
        System.out.println(myPop.getFittest());
        */
        
        // Input
		java.util.Scanner scan =  new java.util.Scanner(System.in);
		System.out.print("Input an alphabetic phrase: ");
		String solution = scan.nextLine();
		GUI g = new GUI(solution);

    }
}

class GUI extends JFrame
{
	Population myPop = new Population(100,true);
	String solution;
	int generation = 1;
	
	public GUI()
	{
		setSolution(buildSolution(10));
		buildFrame();
	}
	
	public GUI(String in)
	{
		setSolution(in);
		buildFrame();
	}
	
	public void setSolution(String s)
	{
		solution = s;
		FitnessCalc.setSolution(solution);
	}
	
	public String buildSolution(int size)
	{
		String s = "";
		
		for(int x = 0; x < size; x++)
		{
			s += Algorithm.generateCharacter();
		}
		
		return s;
	}
	
	public void buildFrame()
	{
		setSize(800,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setContentPane(new myPanel());
		setVisible(true);
	}
	
	class myPanel extends JPanel
	{
		JLabel solLab;
		JLabel genNum;
		JLabel solved;
		JTextArea pop;
		JButton evolve;
		
		public myPanel()
		{
			// Label for solution and generation #
			solLab = new JLabel(solution + "   Generation: ");
			add(solLab);
			
			genNum = new JLabel("" + generation);
			add(genNum);
			
			// Label for whether solution has been found
			solved = new JLabel("False");
				solved.setForeground(Color.RED);
			add(solved);
			
			// Text Area for current population
			pop = new JTextArea(myPop.toString(),30,64);
			JScrollPane popScroll = new JScrollPane(pop);
			add(popScroll);
			
			// Button for iteration and evolution
			evolve = new JButton("Evolve");
				evolve.addActionListener(new evolveListener());
			add(evolve);
		}
		
		public void update()
		{
			// Update Generation #
			genNum.setText("" + generation);
			
			// Update population
			pop.setText(myPop.toString());
			
			// Check if solution has been found
			if(solution.equals(myPop.getFittest().toString()))
			{
				// Change label to signify the solution has been found
				solved.setText("true");
				solved.setForeground(Color.GREEN);
			}
		}
	}
	
	class evolveListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			evolve();
		}
	}
	
	public void evolve()
	{
		myPop = Algorithm.evolvePopulation(myPop);
		generation++;
		myPanel content = (myPanel) getContentPane();
		content.update();
	}
}
