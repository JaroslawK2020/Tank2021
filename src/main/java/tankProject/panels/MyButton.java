package tankProject.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class MyButton extends JButton {
//	--------------button position and size
	private int positionX;
	private int positionY;
	private int width = 150;
	private int height = 75;
//	-------------button look
	private boolean over;
	private Color color;
	private Color overColor;
	private Color clickColor;
	private Color borderColor;
	private int radius = 0;
	
	public MyButton(int positionX, int positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
//		init color
		color = new Color(253, 170, 28);
		overColor = new Color(217, 90, 26);
		clickColor = new Color(222, 140, 0);
		borderColor = new Color(217, 90, 26);		
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(overColor);
				over = true;
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(color);
				over = false;
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(clickColor);
				System.out.println(clickColor);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				if(over)
					setBackground(overColor);
				else
					setBackground(color);
			}
			
		});
		
	}
	
	public MyButton(int positionX, int positionY, int width, int height) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.width = width;
		this.height = height;
//		init color
		setColor(Color.WHITE);
		overColor = new Color(253, 170, 28);
		clickColor = new Color(222, 140, 0);
		borderColor = new Color(217, 90, 26);
	}

	public boolean isOver() {
		return over;
	}

	public void setOver(boolean over) {
		this.over = over;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
		setBackground(color);
	}

	public Color getOverColor() {
		return overColor;
	}

	public void setOverColor(Color overColor) {
		this.overColor = overColor;
	}

	public Color getClickColor() {
		return clickColor;
	}

	public void setClickColor(Color clickColor) {
		this.clickColor = clickColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	

	@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
//			-------------paint border
			g2d.setColor(borderColor);
			g2d.fillRoundRect(0, 0, width, height, radius, radius);
//			-------------border set 2px
			g2d.setColor(getBackground());
			g2d.fillRoundRect(2, 2, width - 4, height - 4, radius, radius);
		
			super.paintComponent(g);
			
			
		}
}
