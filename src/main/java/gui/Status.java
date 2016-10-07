package gui;


import java.util.Random;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.Direction;
import com.googlecode.lanterna.gui2.GridLayout;
import com.googlecode.lanterna.gui2.Label;
import com.googlecode.lanterna.gui2.LinearLayout;
import com.googlecode.lanterna.gui2.Panel;

public class Status {
	private Panel pStatus;
	private Label lblHP,
		lblStamina,
		lblPower;
	
	public Status() {
		pStatus = new Panel(new GridLayout(2));
		
		pStatus.addComponent(new Label("HP"));
		pStatus.addComponent(createLabel(lblHP, "HP"));
		
		pStatus.addComponent(new Label("Stamina"));
		pStatus.addComponent(createLabel(lblStamina, "Stamina"));
		
		pStatus.addComponent(new Label("Power"));
		pStatus.addComponent(createLabel(lblPower, "Power"));
		
		
	}
	
	private Label createLabel(Label lblValue, String lbl) {
		lblValue = new Label(String.valueOf((new Random().nextInt(100))));
		lblValue.setBackgroundColor(TextColor.ANSI.BLACK);
		lblValue.setForegroundColor(TextColor.ANSI.YELLOW);
		
		return lblValue;
	}

	public Panel getpStatus() {
		return pStatus;
	}

	public void setpStatus(Panel pStatus) {
		this.pStatus = pStatus;
	}

	public Label getLblHP() {
		return lblHP;
	}

	public void setLblHP(Label lblHP) {
		this.lblHP = lblHP;
	}

	public Label getLblStamina() {
		return lblStamina;
	}

	public void setLblStamina(Label lblStamina) {
		this.lblStamina = lblStamina;
	}

	public Label getLblPower() {
		return lblPower;
	}

	public void setLblPower(Label lblPower) {
		this.lblPower = lblPower;
	}
	
	

}
