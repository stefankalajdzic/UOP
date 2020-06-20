package ekrani;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import enumeracije.MarkaAutomobila;
import enumeracije.ModelAutomobila;
import izlaz.RadSaDelovima;
import model.Deo;

public class DeloviEkran extends JDialog {
	
	private Deo deo;
	
	private JTextField id, naziv, cenaDela;
	private JComboBox marka, model;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public DeloviEkran() {
		super(null, "Deo", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 200));
		this.setLocationRelativeTo(null);
		
		id = new JTextField();
		marka = new JComboBox(MarkaAutomobila.values());
		model = new JComboBox(ModelAutomobila.values());
		naziv = new JTextField();
		cenaDela = new JTextField();
		obrisan = new JCheckBox();
		
		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");

		postaviElemente();
		postaviFunkcionalnosti();
		
		if(deo != null) {
			this.deo = deo;
			popuniPodatke();
		}
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {
		GridLayout gl = new GridLayout(7, 2);
		this.setLayout(gl);

		this.add(new JLabel("ID: ", SwingConstants.RIGHT));
		this.add(id);
		this.id.setEditable(false);

		this.add(new JLabel("Marka: ", SwingConstants.RIGHT));
		this.add(marka);
		
		this.add(new JLabel("Model: ", SwingConstants.RIGHT));
		this.add(model);

		this.add(new JLabel("Naziv: ", SwingConstants.RIGHT));
		this.add(naziv);
		
		this.add(new JLabel("Cena: ", SwingConstants.RIGHT));
		this.add(cenaDela);
		
		this.add(new JLabel("Obrisan: ", SwingConstants.RIGHT));
		this.add(obrisan);
		
		this.add(potvrdi);
		this.add(odustani);
	}
	
	private void popuniPodatke() {
		id.setText(deo.getId());
		marka.setSelectedIndex(deo.getMarka().ordinal());
		model.setSelectedIndex(deo.getModel().ordinal());
		naziv.setText(deo.getNaziv());
		cenaDela.setText(Float.toString(deo.getCena()));
		obrisan.setSelected(deo.getObrisan());
	}
	
	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Boolean izmena = true;
				
				if(deo == null) {
					deo = new Deo();
					izmena = false;
				}
				
				Float cena = (float) 0.0;
				try {
					cena = Float.parseFloat(cenaDela.getText());
				} catch (Exception ex) { }
				
				deo.setMarka(MarkaAutomobila.values()[marka.getSelectedIndex()]);
				deo.setModel(ModelAutomobila.values()[model.getSelectedIndex()]);
				deo.setNaziv(naziv.getText());
				deo.setCena(cena);
				deo.setObrisan(obrisan.isSelected());
				
				if(izmena) {
//					RadSaDelovima.izmeniDeo(deo);
				} else {
//					RadSaDelovima.dodajDeo(deo);
				}
			}
		});
		this.odustani.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ugasi();
			}
		});
	}
	
	private void ugasi() {
		this.dispose();
	}
}
