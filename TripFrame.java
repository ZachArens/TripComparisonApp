import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import java.awt.Component;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.Color;

public class TripFrame extends JFrame {
	
	private int addTrip;
	private JButton deleteComparison, editComparison, btnEditVehicle, addVehicle, btnAddComparison;
	private JLabel numPassengers;
	private JPanel viewComp, addComparison, viewSummary;
	//private JPanel viewGraph;
	private JTabbedPane tabbedPane;
	private JLabel lblTravelTime;
	private JPanel pnlTopHalfAdd, pnlBottomHalfAdd;
	private JPanel pnlAddFlight, pnlAddCarVan, pnlAddTrain, pnlOwnedOrRental;
	private JPanel pnlAddNorth, pnlAddSouth;
	private JLabel lblTicketCost, lblFeesAndTaxes, lblParkingAndTaxi, lblNumberOfTickets;
	private JSpinner spnInputFlightHoursTravel;
	private JFormattedTextField ftFldTicketCost, ftFldFeesAndTaxes, ftFldParkingAndTaxi;
	private JLabel label ,label_1, label_6, label_7; //spacer labels
	private JSpinner spnFlightNumTickets, spnTrainNumTickets;
	private JTabbedPane tabVehicleType;
	private JLabel lblTrainHoursTravelTime, lblTrainTicketCost, lblTrainFeesTaxes, lblTrainParkTaxi, lblTrainNumTickets;
	private JFormattedTextField ftFldTrHrsTravelTime;
	private JFormattedTextField ftFldTrainTicketCost, ftFldTrainFeesTaxes, ftFldTrainParkTaxi;
	private JLabel lblRentalCarYesNo, lblRentalCostCar, lblInsuranceCostCar, lblMaxPassengersCar, lblMilesPerGallonCar, lblCostPerMileCar;
	private JFormattedTextField ftFldRentalCostCar,ftFldInsuranceCostCar, ftFldMpgCar, ftFldCostPerMileCar;
	private JSpinner spnMaxPassengersCar, spnTripPassengers;
	private JLabel lblVehiclesInThis;
	private JList<Vehicle> listVehicles;
	private JList<Comparison> listComparisonView;
	private JPanel panel, pnlNewTrip;
	private JLabel lblGiveThisComparison, lblTripName, lblTripPassengers, lblTripMiles, lblTripFuelCost;
	private JTextField txtComparisonName, txtTripName, txtTripMiles, txtTripFuelCost;
	private JMenuBar menuBar;
	private JMenu mnFile, mnAbout;
	private JMenuItem mntmNewTrip, mntmOpenTrip, mntmSaveTrip, mntmSaveTripAs, mntmQuit, mntmAboutTripComparison;
	private TripComparisonModel model;
	private JLabel lblAddVehicle;
	private JRadioButton rdbtnOwnCar, rdbtnNewRental;
	private ButtonGroup ownOrRental;
	private JLabel lblHourTravelTimeCar;
	private JSpinner spnMpgCar;
	private JPanel pnlComparisonButtons;
	private JButton btnSortByName;
	private JLabel lblTripComparisons;
	private JButton btnExportToText, btnExport2Text;	
	private int comparisonCount = 1;
	private JButton btnDeleteVehicle;
	private JPanel pnlVehicleChange, pnlSummaryButtons;	
	private JLabel lblTripSummary;
	private JTextArea txtarSummaryBox;
	private JScrollPane scrlSummaryBox;
	private JFormattedTextField ftFldInputFlHrsTravelTime;
	private JFormattedTextField ftFldCarHrsTravelTime;
	
	public TripFrame (TripComparisonModel model) {
		
		this.model = model;
		
		final int FRAME_WIDTH = 650;
		final int FRAME_HEIGHT = 650;
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
		//dialog window upon start and new
		pnlNewTrip = new JPanel();
		pnlNewTrip.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblTripName = new JLabel("Name this trip");
		pnlNewTrip.add(lblTripName);
		
		txtTripName = new JTextField();
		txtTripName.addFocusListener(focusListener);
		pnlNewTrip.add(txtTripName);
		
		lblTripPassengers = new JLabel("How many people traveling?");
		pnlNewTrip.add(lblTripPassengers);
		
		spnTripPassengers = new JSpinner();
		spnTripPassengers.addFocusListener(focusListener);
		pnlNewTrip.add(spnTripPassengers);
		
		lblTripMiles = new JLabel("How many miles to your destination?");
		pnlNewTrip.add(lblTripMiles);
		
		txtTripMiles = new JTextField();
		txtTripMiles.addFocusListener(focusListener);
		pnlNewTrip.add(txtTripMiles);
		
		lblTripFuelCost = new JLabel("Enter the average cost of fuel per gallon ($)");
		pnlNewTrip.add(lblTripFuelCost);
		
		txtTripFuelCost = new JTextField();
		txtTripFuelCost.addFocusListener(focusListener);
		pnlNewTrip.add(txtTripFuelCost);
		
		//Main tabbedPane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.addChangeListener(tabListener);
		getContentPane().setLayout(new GridLayout(1, 1, 0, 0));
		getContentPane().add(tabbedPane);
		
		//addComparison Pane
		addComparison = new JPanel();
		tabbedPane.addTab("Add/Edit Comparison", null, addComparison, null);
		addComparison.setLayout(new GridLayout(2, 2, 0, 0));
		
		//addComparison Pane - top Panel
		pnlTopHalfAdd = new JPanel();
		addComparison.add(pnlTopHalfAdd);
		pnlTopHalfAdd.setLayout(new BorderLayout(0, 0));
		
		pnlAddNorth = new JPanel();
		pnlTopHalfAdd.add(pnlAddNorth, BorderLayout.NORTH);
		pnlAddNorth.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblAddVehicle = new JLabel(" Add Vehicle");
		lblAddVehicle.setHorizontalAlignment(SwingConstants.LEFT);
		pnlAddNorth.add(lblAddVehicle);
		lblAddVehicle.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		
		numPassengers = new JLabel("# Passengers need a ride ");
		pnlAddNorth.add(numPassengers);
		numPassengers.setHorizontalAlignment(SwingConstants.RIGHT);
		
		
		//New Vehicle type tabbedPane
		tabVehicleType = new JTabbedPane(JTabbedPane.TOP);
		pnlTopHalfAdd.add(tabVehicleType, BorderLayout.CENTER);
		
		
		//Add Flight Tab
		pnlAddFlight = new JPanel();
		tabVehicleType.addTab("Flight", null, pnlAddFlight, null);
		pnlAddFlight.setLayout(new GridLayout(6, 2, 0, 0));
		
		lblTravelTime = new JLabel("Travel Time (in Hours)");
		lblTravelTime.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlAddFlight.add(lblTravelTime);
		
		ftFldInputFlHrsTravelTime = new JFormattedTextField();
		ftFldInputFlHrsTravelTime.setText("1");
		pnlAddFlight.add(ftFldInputFlHrsTravelTime);
		ftFldInputFlHrsTravelTime.addFocusListener(focusListener);
		
		lblTicketCost = new JLabel("Ticket Cost ($)");
		lblTicketCost.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddFlight.add(lblTicketCost);
		
		ftFldTicketCost = new JFormattedTextField();
		ftFldTicketCost.setText("0");
		pnlAddFlight.add(ftFldTicketCost);
		ftFldTicketCost.addFocusListener(focusListener);
		
		lblFeesAndTaxes = new JLabel("Fees and Taxes ($)");
		lblFeesAndTaxes.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddFlight.add(lblFeesAndTaxes);
		
		ftFldFeesAndTaxes = new JFormattedTextField();
		ftFldFeesAndTaxes.setText("0");
		pnlAddFlight.add(ftFldFeesAndTaxes);
		ftFldFeesAndTaxes.addFocusListener(focusListener);
		
		lblParkingAndTaxi = new JLabel("Parking and Taxi ($)");
		lblParkingAndTaxi.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddFlight.add(lblParkingAndTaxi);
		
		ftFldParkingAndTaxi = new JFormattedTextField();
		ftFldParkingAndTaxi.setText("0");
		pnlAddFlight.add(ftFldParkingAndTaxi);
		ftFldParkingAndTaxi.addFocusListener(focusListener);
		
		label = new JLabel("");
		pnlAddFlight.add(label);
		
		label_1 = new JLabel("");
		pnlAddFlight.add(label_1);
		

		
		lblNumberOfTickets = new JLabel("Number of Tickets");
		lblNumberOfTickets.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddFlight.add(lblNumberOfTickets);
		
		spnFlightNumTickets = new JSpinner();
		pnlAddFlight.add(spnFlightNumTickets);
		spnFlightNumTickets.addFocusListener(focusListener);
		
		
		//Add Car/Van Tab
		pnlAddCarVan = new JPanel();
		tabVehicleType.addTab("Car/Van", null, pnlAddCarVan, null);
		pnlAddCarVan.setLayout(new GridLayout(7, 0, 0, 0));
		
		lblRentalCarYesNo = new JLabel("Is this vehicle a rental?");
		lblRentalCarYesNo.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddCarVan.add(lblRentalCarYesNo);
		
		pnlOwnedOrRental = new JPanel();
		pnlAddCarVan.add(pnlOwnedOrRental);
		pnlOwnedOrRental.setLayout(new GridLayout(0, 2, 0, 0));
		
		rdbtnOwnCar = new JRadioButton("Your Own Car");
		rdbtnOwnCar.addActionListener(listener);
		pnlOwnedOrRental.add(rdbtnOwnCar);
		
		rdbtnNewRental = new JRadioButton("Rental Car");
		rdbtnNewRental.addActionListener(listener);
		pnlOwnedOrRental.add(rdbtnNewRental);
		
		ownOrRental = new ButtonGroup();
		ownOrRental.add(rdbtnOwnCar);
		ownOrRental.add(rdbtnNewRental);
		rdbtnOwnCar.setSelected(true);
		
		lblHourTravelTimeCar = new JLabel("Travel Time (in hours)");
		pnlAddCarVan.add(lblHourTravelTimeCar);
		lblHourTravelTimeCar.setHorizontalAlignment(SwingConstants.TRAILING);
		
		ftFldCarHrsTravelTime = new JFormattedTextField();
		pnlAddCarVan.add(ftFldCarHrsTravelTime);
		
		lblRentalCostCar = new JLabel("Rental Cost ($)");
		lblRentalCostCar.setForeground(Color.LIGHT_GRAY);
		lblRentalCostCar.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddCarVan.add(lblRentalCostCar);
		
		ftFldRentalCostCar = new JFormattedTextField();
		ftFldRentalCostCar.setText("0");
		ftFldRentalCostCar.setHorizontalAlignment(SwingConstants.TRAILING);
		ftFldRentalCostCar.setEnabled(false);
		pnlAddCarVan.add(ftFldRentalCostCar);
		ftFldRentalCostCar.addFocusListener(focusListener);
		
		lblInsuranceCostCar = new JLabel("Insurance Cost($)");
		lblInsuranceCostCar.setForeground(Color.LIGHT_GRAY);
		lblInsuranceCostCar.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddCarVan.add(lblInsuranceCostCar);
		
		ftFldInsuranceCostCar = new JFormattedTextField();
		ftFldInsuranceCostCar.setText("0");
		ftFldInsuranceCostCar.setHorizontalAlignment(SwingConstants.TRAILING);
		ftFldInsuranceCostCar.setEnabled(false);
		pnlAddCarVan.add(ftFldInsuranceCostCar);
		ftFldInsuranceCostCar.addFocusListener(focusListener);
		
		lblMaxPassengersCar = new JLabel("Max Passengers (Vehicle Capability)");
		lblMaxPassengersCar.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddCarVan.add(lblMaxPassengersCar);
		
		//TODO add spinmodel to max minimum value 1
		spnMaxPassengersCar = new JSpinner();
		pnlAddCarVan.add(spnMaxPassengersCar);
		spnMaxPassengersCar.addFocusListener(focusListener);
		
		lblMilesPerGallonCar = new JLabel("Miles Per Gallon (MPG)");
		lblMilesPerGallonCar.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMilesPerGallonCar.setToolTipText("Miles Per Gallon for this Vehicle");
		pnlAddCarVan.add(lblMilesPerGallonCar);
		
		spnMpgCar = new JSpinner();
		pnlAddCarVan.add(spnMpgCar);
		spnMpgCar.addFocusListener(focusListener);
		
		lblCostPerMileCar = new JLabel("Cost Per Mile ($)");
		lblCostPerMileCar.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddCarVan.add(lblCostPerMileCar);
		
		ftFldCostPerMileCar = new JFormattedTextField();
		ftFldCostPerMileCar.setText("0.55");
		ftFldCostPerMileCar.setHorizontalAlignment(SwingConstants.TRAILING);
		ftFldCostPerMileCar.setForeground(Color.BLACK);
		pnlAddCarVan.add(ftFldCostPerMileCar);
		ftFldCostPerMileCar.addFocusListener(focusListener);
		
		
		//Add Train Tab
		pnlAddTrain = new JPanel();
		tabVehicleType.addTab("Train", null, pnlAddTrain, null);
		pnlAddTrain.setLayout(new GridLayout(6, 2, 0, 0));
		
		lblTrainHoursTravelTime = new JLabel("Travel Time (in Hours)");
		lblTrainHoursTravelTime.setHorizontalAlignment(SwingConstants.RIGHT);
		pnlAddTrain.add(lblTrainHoursTravelTime);
		
		ftFldTrHrsTravelTime = new JFormattedTextField();
		ftFldTrHrsTravelTime.setText("1");
		pnlAddTrain.add(ftFldTrHrsTravelTime);
		ftFldTrHrsTravelTime.addFocusListener(focusListener);
		
		lblTrainTicketCost = new JLabel("Ticket Cost ($)");
		lblTrainTicketCost.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddTrain.add(lblTrainTicketCost);
		
		ftFldTrainTicketCost = new JFormattedTextField();
		ftFldTrainTicketCost.setText("0");
		pnlAddTrain.add(ftFldTrainTicketCost);
		ftFldTrainTicketCost.addFocusListener(focusListener);
		
		lblTrainFeesTaxes = new JLabel("Fees and Taxes ($)");
		lblTrainFeesTaxes.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddTrain.add(lblTrainFeesTaxes);
		
		ftFldTrainFeesTaxes = new JFormattedTextField();
		ftFldTrainFeesTaxes.setText("0");
		pnlAddTrain.add(ftFldTrainFeesTaxes);
		ftFldTrainFeesTaxes.addFocusListener(focusListener);
		
		lblTrainParkTaxi = new JLabel("Parking and Taxi ($)");
		lblTrainParkTaxi.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddTrain.add(lblTrainParkTaxi);
		
		ftFldTrainParkTaxi = new JFormattedTextField();
		ftFldTrainParkTaxi.setText("0");
		pnlAddTrain.add(ftFldTrainParkTaxi);
		ftFldTrainParkTaxi.addFocusListener(focusListener);
		
		label_6 = new JLabel("");
		pnlAddTrain.add(label_6);
		
		label_7 = new JLabel("");
		pnlAddTrain.add(label_7);
		
		lblTrainNumTickets = new JLabel("Number of Tickets");
		lblTrainNumTickets.setHorizontalAlignment(SwingConstants.TRAILING);
		pnlAddTrain.add(lblTrainNumTickets);
		
		spnTrainNumTickets = new JSpinner();
		pnlAddTrain.add(spnTrainNumTickets);
		spnTrainNumTickets.addFocusListener(focusListener);
		
		//Add/Edit Comparison - South Panel (Display)
		pnlAddSouth = new JPanel();
		pnlTopHalfAdd.add(pnlAddSouth, BorderLayout.SOUTH);
		pnlAddSouth.setLayout(new GridLayout(1, 0, 0, 0));
		
		pnlBottomHalfAdd = new JPanel();
		addComparison.add(pnlBottomHalfAdd);
		pnlBottomHalfAdd.setLayout(new BorderLayout(0, 0));
		
		lblVehiclesInThis = new JLabel(" Vehicles in This Comparison");
		lblVehiclesInThis.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		pnlBottomHalfAdd.add(lblVehiclesInThis, BorderLayout.NORTH);
		
		listVehicles = new JList<Vehicle>();
		listVehicles.setVisibleRowCount(5);
		listVehicles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		pnlBottomHalfAdd.add(listVehicles, BorderLayout.CENTER);
		
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.TRAILING);
		pnlBottomHalfAdd.add(panel, BorderLayout.SOUTH);
		
		lblGiveThisComparison = new JLabel("Give this Comparison a Name");
		panel.add(lblGiveThisComparison);
		
		txtComparisonName = new JTextField();
		txtComparisonName.setText("Comparison1");
		txtComparisonName.addFocusListener(focusListener);
		panel.add(txtComparisonName);
		txtComparisonName.setColumns(10);
		
		btnAddComparison = new JButton("Add Comparison");
		btnAddComparison.setEnabled(false);
		btnAddComparison.addActionListener(listener);
		panel.add(btnAddComparison);
		
		pnlVehicleChange = new JPanel();
		pnlAddSouth.add(pnlVehicleChange);
		
		btnEditVehicle = new JButton("Edit Vehicle");
		btnEditVehicle.setEnabled(false);
		pnlVehicleChange.add(btnEditVehicle);
		btnEditVehicle.addActionListener(listener);
		
		btnDeleteVehicle = new JButton("Delete Vehicle");
		btnDeleteVehicle.setEnabled(false);
		pnlVehicleChange.add(btnDeleteVehicle);
		btnDeleteVehicle.addActionListener(listener);
		
		addVehicle = new JButton("Add Vehicle");
		pnlAddSouth.add(addVehicle);
		addVehicle.addActionListener(listener);
		
		
		//View Comparisons Tab		
		viewComp = new JPanel();
		tabbedPane.addTab("View Comparisons", null, viewComp, null);

		viewComp.setBackground(SystemColor.window);
		viewComp.setLayout(new BorderLayout(0, 0));
		
		pnlComparisonButtons = new JPanel();
		viewComp.add(pnlComparisonButtons, BorderLayout.SOUTH);
		pnlComparisonButtons.setLayout(new GridLayout(0, 4, 0, 0));
		
		editComparison = new JButton("Edit Comparison");
		editComparison.addActionListener(listener);
		pnlComparisonButtons.add(editComparison);	
		
		deleteComparison = new JButton("Delete Comparison");
		deleteComparison.addActionListener(listener);
		pnlComparisonButtons.add(deleteComparison);
		
		btnSortByName = new JButton("Sort By Name");
		btnSortByName.addActionListener(listener);
		pnlComparisonButtons.add(btnSortByName);
		
		btnExportToText = new JButton("Export to Text File");
		btnExportToText.addActionListener(listener);
		pnlComparisonButtons.add(btnExportToText);
		
		listComparisonView = new JList<Comparison>();
		listComparisonView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listComparisonView.setFixedCellHeight(50);
		
		viewComp.add(listComparisonView, BorderLayout.CENTER);
		
		lblTripComparisons = new JLabel("Comparisons in this Trip");
		lblTripComparisons.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		viewComp.add(lblTripComparisons, BorderLayout.NORTH);
		viewComp.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{deleteComparison, editComparison}));
		
		
		//View Summary Tab
		viewSummary = new JPanel();
		tabbedPane.addTab("View Summary", null, viewSummary, null);		
		viewSummary.setLayout(new BorderLayout(0, 0));
		
		lblTripSummary = new JLabel("Trip Summary");
		lblTripSummary.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		viewSummary.add(lblTripSummary, BorderLayout.NORTH);
		
		txtarSummaryBox = new JTextArea();
		txtarSummaryBox.setText("No Summary Available");
		
		scrlSummaryBox = new JScrollPane(txtarSummaryBox);
		viewSummary.add(scrlSummaryBox, BorderLayout.CENTER);
				
		btnExport2Text = new JButton("Export to Text File");
		btnExport2Text.setHorizontalAlignment(SwingConstants.TRAILING);
		btnExport2Text.addActionListener(listener);
		
		pnlSummaryButtons = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlSummaryButtons.getLayout();
		flowLayout_1.setAlignment(FlowLayout.TRAILING);
		pnlSummaryButtons.add(btnExport2Text);
		
		viewSummary.add(pnlSummaryButtons, BorderLayout.SOUTH);
		
//		viewGraph = new JPanel();
//		tabbedPane.addTab("viewGraph", null, viewGraph, null);
		
		
		// Menu
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmNewTrip = new JMenuItem("New Trip");
		mntmNewTrip.addActionListener(listener);
		mntmNewTrip.setEnabled(false);
		mnFile.add(mntmNewTrip);
		
		mntmOpenTrip = new JMenuItem("Open Trip");
		mntmOpenTrip.setEnabled(false);
		mnFile.add(mntmOpenTrip);
		
		mntmSaveTrip = new JMenuItem("Save Trip");
		mntmSaveTrip.setEnabled(false);
		mnFile.add(mntmSaveTrip);
		
		mntmSaveTripAs = new JMenuItem("Save Trip As");
		mntmSaveTripAs.setEnabled(false);
		mnFile.add(mntmSaveTripAs);
		
		mntmQuit = new JMenuItem("Quit");
		mntmQuit.addActionListener(listener);
		mnFile.add(mntmQuit);
		
		mnAbout = new JMenu("About");
		
		menuBar.add(mnAbout);
		
		mntmAboutTripComparison = new JMenuItem("About Trip Comparison");
		mntmAboutTripComparison.addActionListener(listener);
		mnAbout.add(mntmAboutTripComparison);
		
		runNewTripDialog();
	}			
		
	//Opening dialog box to initiate trip
	public void runNewTripDialog() {
		while(model.getTrip() == null) {
				addTrip = JOptionPane.showConfirmDialog(null, pnlNewTrip, "New Trip",
					JOptionPane.OK_CANCEL_OPTION);
				
				txtTripName.requestFocusInWindow();
				
				String inputTripName = txtTripName.getText();
				Object inputPeopleTraveling= spnTripPassengers.getValue();;
				String inputFuelPrice = txtTripFuelCost.getText();
				String inputTripMiles = txtTripMiles.getText();
				
				try {
					spnTripPassengers.commitEdit();
				} catch (ParseException e){
					
				}
				
				boolean nameFilled = inputTripName != null && inputTripName.length() > 0;
				boolean passFilled = inputPeopleTraveling != null;
				boolean fuelFilled = inputFuelPrice != null && inputFuelPrice.length() > 0;
				boolean mileFilled = inputTripMiles != null && inputTripMiles.length() > 0;
			
			if (addTrip == JOptionPane.OK_OPTION && nameFilled && passFilled && fuelFilled && mileFilled) {
				
				int peopleTraveling = (Integer) inputPeopleTraveling;
				double fuelPrice = Double.parseDouble(inputFuelPrice);
				double tripMiles = Double.parseDouble(inputTripMiles); 
	
				model.newTrip(inputTripName, peopleTraveling, fuelPrice, tripMiles);
				numPassengers.setText(model.printPassengers());
				
				
			} else {
				JOptionPane.showMessageDialog(null, "No Trip was created.");
			} 
			
		}
		
	}
	
	//Refreshes the Vehicle ListBox with current Comparison's list of vehicles
	public void refreshVehicleView() {
		DefaultListModel<Vehicle> vehiclesToView = new DefaultListModel<Vehicle>();
		
		try {	
			for (Vehicle vehicle : model.getVehicles()) {
				vehiclesToView.addElement(vehicle);
			}
	
			listVehicles.setModel(vehiclesToView);
		
			
			if (model.getVehicles().isEmpty()) {
				btnEditVehicle.setEnabled(false);
				btnDeleteVehicle.setEnabled(false);
				btnAddComparison.setEnabled(false);
			} else {
				btnEditVehicle.setEnabled(true);
				btnDeleteVehicle.setEnabled(true);
				btnAddComparison.setEnabled(true);
			}
		} catch(NullPointerException e) {
			
		}
	}
	
	//Refreshes the Comparison ListBox with current Trip's list of Comparisons
	public void refreshComparisonView() {
		DefaultListModel<Comparison> comparisonsToView = new DefaultListModel<Comparison>();
		
		try {
			
		
			for (Comparison comparison : model.getComparisons()) {
				comparisonsToView.addElement(comparison);
			}
			
			listComparisonView.setModel(comparisonsToView);
			
			txtComparisonName.setText("Comparison" + comparisonCount);
		} catch(NullPointerException e) {
			
		}
	}
	
	//Refreshes the Summary TextArea with current Trip's list of Comparisons
	public void refreshSummaryView() {
		txtarSummaryBox.setText("" + model.getTrip());
	}
	
	private class ButtonListener implements ActionListener { 
			
		public void actionPerformed (ActionEvent event) {			
			
			//Button - Create a vehicle and add it this Comparison's List
			if (event.getSource() == addVehicle) {
				
				int numTickets, maxPassengers, mpg;
				double hoursTravelTime, ticketCost, feesTaxes, parkTaxiEtc, maintCostPerMile, rentalCost, insuranceCost;
				
				//create a new Vehicle - Airplane(Flight) and add it to this comparison's list
				if (pnlAddFlight.isVisible()) {
					
					hoursTravelTime = Double.parseDouble(ftFldInputFlHrsTravelTime.getText());
					ticketCost = Double.parseDouble(ftFldTicketCost.getText());
					feesTaxes = Double.parseDouble(ftFldFeesAndTaxes.getText());
					parkTaxiEtc = Double.parseDouble(ftFldParkingAndTaxi.getText());
					numTickets = (Integer) spnFlightNumTickets.getValue();
					
					for (int i = 0; i < numTickets; i++) {
						model.addFlight(hoursTravelTime, ticketCost, feesTaxes, parkTaxiEtc);
					}
					
					spnFlightNumTickets.setEnabled(true);
					
					//create a new Vehicle - Car and add it to this comparison's list
				} else if (pnlAddCarVan.isVisible() && rdbtnOwnCar.isSelected()) {
					
					hoursTravelTime = Double.parseDouble(ftFldCarHrsTravelTime.getText());
					maintCostPerMile = Double.parseDouble(ftFldCostPerMileCar.getText());
					mpg = (Integer) spnMpgCar.getValue();
					maxPassengers = (Integer) spnMaxPassengersCar.getValue();
					
					model.addOwnedCar(hoursTravelTime, maxPassengers, maintCostPerMile, mpg);
					
					//create a new Vehicle - Rental Car and add it to this comparison's list
				} else if (pnlAddCarVan.isVisible() && rdbtnNewRental.isSelected()) {
					hoursTravelTime = Double.parseDouble(ftFldCarHrsTravelTime.getText());
					maintCostPerMile = Double.parseDouble(ftFldCostPerMileCar.getText());
					mpg = (Integer) spnMpgCar.getValue();
					maxPassengers = (Integer) spnMaxPassengersCar.getValue();
					rentalCost = Double.parseDouble(ftFldRentalCostCar.getText());
					insuranceCost = Double.parseDouble(ftFldInsuranceCostCar.getText());
					
										
					model.addRentalCar(hoursTravelTime, maxPassengers, rentalCost, insuranceCost, maintCostPerMile, mpg);
					
					//create a new Vehicle - Train and add it to this comparison's list
				} else if (pnlAddTrain.isVisible()) {
					hoursTravelTime = Double.parseDouble(ftFldTrHrsTravelTime.getText());
					ticketCost = Double.parseDouble(ftFldTrainTicketCost.getText());
					feesTaxes = Double.parseDouble(ftFldTrainFeesTaxes.getText());
					parkTaxiEtc = Double.parseDouble(ftFldTrainParkTaxi.getText());
					numTickets = (Integer) spnTrainNumTickets.getValue();
					
					for (int i = 0; i < numTickets; i++) {
						model.addTrain(hoursTravelTime, ticketCost, feesTaxes, parkTaxiEtc);
					}
				} 
				
				numPassengers.setText(model.printPassengers());
				
				refreshVehicleView();
				
			}
			
			//Button - edit Vehicle
			if (event.getSource() == btnEditVehicle) {
				if (!listVehicles.isSelectionEmpty()) {
					int selectVehIndex = listVehicles.getSelectedIndex();
					ArrayList<String> selectedVehicleArray = model.pullVehicle(selectVehIndex);
					
					if (selectedVehicleArray.get(0).equals("Flight")) {
						tabVehicleType.setSelectedIndex(tabVehicleType.indexOfComponent(pnlAddFlight));
						
						ftFldInputFlHrsTravelTime.setText(selectedVehicleArray.get(2));
						ftFldTicketCost.setText(selectedVehicleArray.get(4));
						ftFldFeesAndTaxes.setText(selectedVehicleArray.get(5));
						ftFldParkingAndTaxi.setText(selectedVehicleArray.get(6));
						spnFlightNumTickets.setValue(1);
						spnFlightNumTickets.setEnabled(false);
						
					} else if (selectedVehicleArray.get(0).equals("Train")) {
						tabVehicleType.setSelectedIndex(tabVehicleType.indexOfComponent(pnlAddTrain));
						
						ftFldTrHrsTravelTime.setText(selectedVehicleArray.get(2));
						ftFldTrainTicketCost.setText(selectedVehicleArray.get(4));
						ftFldTrainFeesTaxes.setText(selectedVehicleArray.get(5));
						ftFldTrainParkTaxi.setText(selectedVehicleArray.get(6));
						spnTrainNumTickets.setValue(1);
						spnTrainNumTickets.setEnabled(false);
						
					} else if (selectedVehicleArray.get(0).equals("Rental Car")) {
						tabVehicleType.setSelectedIndex(tabVehicleType.indexOfComponent(pnlAddCarVan));
						
						rdbtnNewRental.setSelected(true);
						
						spnMpgCar.setValue(Integer.parseInt(selectedVehicleArray.get(6)));
						ftFldRentalCostCar.setText(selectedVehicleArray.get(4));
						ftFldInsuranceCostCar.setText(selectedVehicleArray.get(5));
						ftFldCarHrsTravelTime.setText(selectedVehicleArray.get(2));
						ftFldCostPerMileCar.setText(selectedVehicleArray.get(7));
						spnMaxPassengersCar.setValue(Integer.parseInt(selectedVehicleArray.get(3)));

					} else if (selectedVehicleArray.get(0).equals("Owned Car")) {
						pnlAddCarVan.setVisible(true);
						
						rdbtnOwnCar.setSelected(true);
						
						spnMpgCar.setValue(Integer.parseInt(selectedVehicleArray.get(6)));
						
						ftFldCarHrsTravelTime.setText(selectedVehicleArray.get(2));
						ftFldCostPerMileCar.setText(selectedVehicleArray.get(4));
						spnMaxPassengersCar.setValue(Integer.parseInt(selectedVehicleArray.get(3)));
						
					}
					
					//Refresh numPassengers and vehicleList
					numPassengers.setText(model.printPassengers());
					
					refreshVehicleView();
					
				}
			}
			//Button - Delete the selected Vehicle from the Comparison's List
			if(event.getSource() == btnDeleteVehicle) {
				int selectVehIndex = listVehicles.getSelectedIndex();
				model.pullVehicle(selectVehIndex);
				
				refreshVehicleView();
			}
			
			//Radio Button - Changes Car type to an Owned Vehicle and disables Rental fields
			if(event.getSource() == rdbtnOwnCar) {
				ftFldRentalCostCar.setEnabled(false);
				lblRentalCostCar.setForeground(Color.LIGHT_GRAY);
				ftFldInsuranceCostCar.setEnabled(false);
				lblInsuranceCostCar.setForeground(Color.LIGHT_GRAY);
			}
			
			//Radio Button - Changes Car type to an Rental Vehicle and enables Rental fields
			if(event.getSource() == rdbtnNewRental) {
				ftFldRentalCostCar.setEnabled(true);
				lblRentalCostCar.setForeground(Color.BLACK);
				ftFldInsuranceCostCar.setEnabled(true);
				lblInsuranceCostCar.setForeground(Color.BLACK);
			}
			
			//Button - add the Comparison from this window to this Trip's list
			if(event.getSource() == btnAddComparison) {
				
				model.submitComparison(txtComparisonName.getText());
				
				numPassengers.setText(model.printPassengers());
								
				tabbedPane.setSelectedIndex(tabbedPane.indexOfComponent(viewComp));
								
				comparisonCount++;
				
			}
			
			//Button - removes comparison from the trip's list and loads in window to edit
			if(event.getSource() == editComparison) {
				
				for (Component component: addComparison.getComponents()) {
					if (component.getClass() == ftFldTicketCost.getClass()) {
						((JFormattedTextField) component).setText("");
					}
				}
				
				int selectCompIndex = listComparisonView.getSelectedIndex();
				try {
					Comparison currentComparison = model.removeComparison(selectCompIndex);
								
					tabbedPane.setSelectedIndex(tabbedPane.indexOfComponent(addComparison));
				
					txtComparisonName.setText(currentComparison.getName());
				} catch (IndexOutOfBoundsException e) {
				
				} 
			}
			
			//Button - delete the selected comparison from the list
			if(event.getSource() == deleteComparison) {
				int deleteResult = JOptionPane.OK_CANCEL_OPTION;
				JOptionPane.showConfirmDialog(null, "Are you sure you would like to delete this comparison?" , "warning",
						deleteResult);
				if (deleteResult == JOptionPane.OK_OPTION) {
					int selectCompIndex = listComparisonView.getSelectedIndex();
					try {
						model.removeComparison(selectCompIndex);
					
						refreshComparisonView();
						
					} catch (IndexOutOfBoundsException e) {
						
					}
				}
			}
			
			//Button - sort comparisons by Name
			if(event.getSource() == btnSortByName) {
				
				model.getTrip().sortComparisons();
				refreshComparisonView();
				refreshSummaryView();
			}
			
			//Button - Export trip summary to text file
			if(event.getSource() == btnExport2Text || event.getSource() == btnExportToText) {				
				
				model.saveToTxtFile();
			}
			
			//Menu Button - Quit the program
			if(event.getSource() == mntmQuit) {
				
				System.exit(0);
			}
			
			//Menu Button - Show details about this program
			if(event.getSource() == mntmAboutTripComparison) {
				
				JOptionPane.showMessageDialog(null, "Trip Comparison App\nDeveloped by Zach Arens, 12.01.2018", "About", JOptionPane.DEFAULT_OPTION);
			}
			
			//Menu Button - Create a new Trip
			if (event.getSource() == mntmNewTrip) {
				
				runNewTripDialog();	
			}
			
		}
	}
	
	public class TabListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent e) {
			try {
				refreshVehicleView();
				refreshComparisonView();
				refreshSummaryView();
			} catch(NullPointerException error) {
				
			}
		}
	}
	
	public class FieldListener implements FocusListener {

		@Override
		public void focusGained(FocusEvent e) {
			Object activeField = e.getSource();
			JTextField jtxtField = new JTextField();
			JFormattedTextField ftFld = new JFormattedTextField();
			JSpinner jspinner = new JSpinner();
		
			if (activeField.getClass().equals(jtxtField.getClass())) {
				
				jtxtField = (JTextField) activeField;
				jtxtField.selectAll();
			} else if (activeField.getClass().equals(jspinner.getClass())) {
				jspinner = (JSpinner) activeField;
				
			} else if (activeField.getClass().equals(ftFld.getClass())) {
				
				ftFld = (JFormattedTextField) activeField;
				ftFld.selectAll();
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			
		} 
	}
	
	ChangeListener tabListener = new TabListener();
	FocusListener focusListener = new FieldListener();
	ActionListener listener = new ButtonListener();
		
}

