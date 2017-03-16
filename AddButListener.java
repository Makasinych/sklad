package swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddButListener implements ActionListener{ 
	//добавление кнопок Купить и Отмена, изменение данных коллекции, вывод уведомлений по некоторым ситуациям ситуациям
	private JPanel p;
	private JLabel l3;
	private JTextField t1;
	private JTextField t2;
	private JButton b2;
	private JButton b3;
	private ArrayList<String> ars1;
	private JButton b1;
	
	public AddButListener(JPanel panel, JTextField input1, JTextField input2, JButton button2, JButton button3, JLabel label3, ArrayList<String> ars, JButton button1) {
			p = panel;
			t1 = input1;
			t2 = input2;
			b2 = button2;
			b3 = button3;
			l3 = label3;	
			ars1 = ars;
			b1 = button1;
	}
	public void actionPerformed(ActionEvent e) {	        
			String message = "";
			String text1 = t1.getText();
			String text2 = t2.getText();
			if(text1.equals("") || text2.equals("")){
				message += "Одно из полей ввода пустое!"; 
				JOptionPane.showMessageDialog(null, message, "Внимание!", (int) JOptionPane.CENTER_ALIGNMENT);
			}else{
				try {
					proverka(text1, text2, p, l3);
				} catch (IOException e1) {
					e1.printStackTrace();
				}								
			}
			
		}
	public void proverka(String text1, String text2, JPanel p, JLabel l3) throws IOException{
			int j = 0;
			for(int i = 0; i < ars1.size(); i+=3){					
				if(text1.equals(ars1.get(i))){
					float price = Float.parseFloat(ars1.get(i + 1));
					float kol = Float.parseFloat(ars1.get(i + 2));
					float weight = Float.parseFloat(text2);
					if(weight <= kol){						
						text1 = ars1.get(i) + " | Цена за 100 грамм: " + price + " р | Итого: " + summa(price, weight) + " р";
						l3.setText(text1);							
						String pay = Float.toString(kol - weight);
						ars1.set(i+2, pay);						
						p.add(b2).setBounds(70, 200, 100, 23);
						p.add(b3).setBounds(220, 200, 100, 23);
						b1.setEnabled(false);
					}else{
						JOptionPane.showMessageDialog(null, "Извините, но на складе осталось " + kol + " кг товара!", "Внимание!", (int) JOptionPane.CENTER_ALIGNMENT);
					}
					j = 0;
					break;
				}else{
					j = 1;
				}
			}			
			if(j == 1){
				JOptionPane.showMessageDialog(null, "Извините, такого товара нет!", "Внимание!", (int) JOptionPane.CENTER_ALIGNMENT);
				t1.setText("");
				t2.setText("");				
			}				
			p.repaint();			
	}

	private float summa(float price, float weight) {
		float sum = weight*10*price;
		return sum;
	}
}
