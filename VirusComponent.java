import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.geom.Line2D;

/**
Keeps track of the proportion of infected people over time
*/
public class VirusComponent extends JComponent
{
	private double[] infection; 
	private int frameSize;
	
	/**
	Creates a component of class VirusComponent
	@param size The number of timesteps stored in the infection array
	*/
	public VirusComponent(int frameSize, double[] infection)
	{
		super();
		this.frameSize = frameSize;
		this.infection = infection;
	}
	
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D)g;
		
		double infectiond = (double)infection.length;
		
		int width = getWidth();
		int height = getHeight();
		
		g2.setColor(Color.BLACK);
		Line2D yAxis = new Line2D.Double(width / 10, height / 8, width / 10, (height / 8) * 7);
		Line2D xAxis = new Line2D.Double(width / 10, (height / 8) * 7, (width / 14) * 14, (height / 8) * 7);
		g2.drawString("Infections", width / 10, height / 9);
		g2.drawString("Time", width / 2, (height / 12) * 11);
		g2.draw(xAxis);
		g2.draw(yAxis);
		
		for(int i = 0; i < infection.length; i++)
		{
			double id = (double)i;
			double x = ((((width / 12) * 10) / infectiond) * id) + width / 9;
			double y = (height * (1.0 - infection[i]));
			
			Rectangle pixel = new Rectangle((int)x, (int)y, 2, 3);
			g2.fill(pixel);
		}
	}
}