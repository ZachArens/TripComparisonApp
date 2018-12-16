import javax.swing.JFrame;

public class TripComparisonApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TripComparisonModel model = new TripComparisonModel();
		TripFrame frame = new TripFrame(model);
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Trip Comparison Calculator");
		frame.setVisible(true);
	}

}
