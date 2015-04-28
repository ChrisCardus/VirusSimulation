import javax.swing.JFrame;

/**
Draws the frame and holds the data it requires
*/
public class VirusViewer
{
	public static void main(String[] args)
	{
		Population pop = new Population(400, 0.5, 0.5, 0.3);
		double[] infection = new double[1000];
		
		for(int i = 0; i < infection.length; i++)
		{
			pop.update();
			infection[i] = pop.proportionInfected();
		}
		
		int frameSize = 500;
		
		VirusComponent vir = new VirusComponent(frameSize, infection);
		
		JFrame frame = new JFrame("Graph showing infection proportion over time");
		frame.setTitle("Virus Viewer");
		frame.setSize(frameSize, frameSize);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(vir);
		frame.setVisible(true);
		
	}
}