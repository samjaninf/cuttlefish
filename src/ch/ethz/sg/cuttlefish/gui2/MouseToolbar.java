package ch.ethz.sg.cuttlefish.gui2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import edu.uci.ics.jung.visualization.control.ModalGraphMouse;

public class MouseToolbar extends AbstractToolbar {

	private JButton transformingButton;
	private JButton pickingButton;
	private JButton editingButton;
	
	private static String transformingIconFile = "src/ch/ethz/sg/cuttlefish/gui2/icons/transforming.png";
	private static String pickingIconFile = "src/ch/ethz/sg/cuttlefish/gui2/icons/picking.png";
	private static String editingIconFile = "src/ch/ethz/sg/cuttlefish/gui2/icons/editing.png";
	
	public MouseToolbar(NetworkPanel networkPanel) {
		super(networkPanel);
		initialize();
		transformingButton.doClick();
	}
	
	private void initialize() {
		transformingButton = new JButton(new ImageIcon(transformingIconFile));
		pickingButton = new JButton(new ImageIcon(pickingIconFile));
		editingButton = new JButton(new ImageIcon(editingIconFile));
		
		this.add(transformingButton);
		this.add(pickingButton);
		this.add(editingButton);
		
		transformingButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				networkPanel.getMouse().setMode(ModalGraphMouse.Mode.TRANSFORMING);
				transformingButton.setEnabled(false);
				pickingButton.setEnabled(true);
				editingButton.setEnabled(true);
			}
		});
		
		pickingButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				networkPanel.getMouse().setMode(ModalGraphMouse.Mode.PICKING);
				transformingButton.setEnabled(true);
				pickingButton.setEnabled(false);
				editingButton.setEnabled(true);
			}
		});
		
		editingButton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				networkPanel.getMouse().setMode(ModalGraphMouse.Mode.EDITING);
				transformingButton.setEnabled(true);
				pickingButton.setEnabled(true);
				editingButton.setEnabled(false);
			}
		});
	}

}
