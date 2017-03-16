package swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemButListener implements ActionListener {
	//возврат к первоначальному положению по нажатию Отмена
	private JPanel p;
	private JButton b2;
	private JButton b3;
	private JTextField t1;
	private JTextField t2;
	private JLabel l3;
	private JButton b1;
	
	public RemButListener(JPanel panel, JButton button2, JButton button3, JTextField input1, JTextField input2, JLabel label3, JButton button1) {
		p = panel;
		b2 = button2;
		b3 = button3;
		t1 = input1;
		t2 = input2;
		l3 = label3;
		b1 = button1;
	}

	public void actionPerformed(ActionEvent e) {
		p.remove(b2);
		p.remove(b3);
		p.repaint();
		t1.setText("");
		t2.setText("");
		l3.setText("");
		b1.setEnabled(true);
	}

}
