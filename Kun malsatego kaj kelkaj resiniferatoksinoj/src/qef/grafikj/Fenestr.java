package qef.grafikj;

import java.awt.BorderLayout;
import java.awt.Transparency;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import qef.QefObjektj;
import qef.ilj.YargxilAzhj;

public class Fenestr extends JFrame implements WindowFocusListener {
	
	private static final long serialVersionUID = 1L;
	
	private final String titol;
	private final String titol1;
	
	private final ImageIcon icon;
	
	public Fenestr(final String titol) {
		
		this.titol = titol;
		this.titol1 = "Esperanto estas la plej bona lingvo en la tuta mondo, ecx pli bona ol Ido!";
		
		icon = new ImageIcon(YargxilAzhj.yargxBildn("/icons/icon.png", Transparency.TRANSLUCENT));
		
		agordFenestrn();
		
	}

	private void agordFenestrn() {
		
		setTitle(titol);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		addWindowFocusListener(this);
		setIconImage(icon.getImage());
		setLayout(new BorderLayout());
		add(QefObjektj.superfic, BorderLayout.CENTER);
		setUndecorated(true);
		setExtendedState(MAXIMIZED_BOTH);
		
		pack();
		
		setLocationRelativeTo(null);
		
		setVisible(true);
		
	}

	@Override
	public void windowGainedFocus(WindowEvent arg0) {
		setTitle(titol);
	}

	@Override
	public void windowLostFocus(WindowEvent arg0) {
		setTitle(titol1);
	}
	
}