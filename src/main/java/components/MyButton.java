package components;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import images.Background;
import images.SpeakerImg;

public class MyButton extends JButton {

	private Color color = new Color(200, 170, 28);
	private Color overColor = new Color(220, 140, 0);
	private Font fontFamily = new Font("Arial", Font.BOLD, 25);
	private String text = "";
	private int height = 75;
	private int width = 100;

	public MyButton(String text) {
		setText(text);
		this.text = text;
		setFont(fontFamily);
		width += computeWidth();
		setBackground(color);
		setBorder(new LineBorder(Color.DARK_GRAY, 3));
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				setBounds(getBounds().x + 2, getBounds().y - 2, getWidth(), getHeight());

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(overColor);
				setBounds(getBounds().x - 2, getBounds().y + 2, getWidth(), getHeight());

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		});
	}

	public int computeWidth() {
		return text.length() * 13;
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

}