package ekrani;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import izlaz.RadSaAutomobilima;
import izlaz.RadSaServisima;
import izlaz.RadSaServisnimKnjizicama;
import model.Automobil;
import model.Servis;
import model.ServisnaKnjizica;

public class ServisnaKnjizicaEkran extends JDialog {
	
	private static final long serialVersionUID = 1L;

	private ServisnaKnjizica servisnaKnjizica;
	
	private JTextField id, automobil;
	private DefaultListModel<String> servisiDlm;
	private JList<String> servisi;
	private JCheckBox obrisan;
	private JButton potvrdi, odustani;
	
	public ServisnaKnjizicaEkran(ServisnaKnjizica servisnaKnjizica) {
		super(null, "Servisna Knjizica", Dialog.ModalityType.DOCUMENT_MODAL);
		this.setModal(true);
		this.setSize(new Dimension(300, 200));
		this.setLocationRelativeTo(null);
		
		id = new JTextField();
		automobil = new JTextField();
		servisiDlm = new DefaultListModel<String>();
		for(Servis servis : servisnaKnjizica.getServisi()) {
			servisiDlm.addElement(servis.getId());
		}
		servisi = new JList<String>(servisiDlm);
		obrisan = new JCheckBox();

		potvrdi = new JButton("Potvrdi");
		odustani = new JButton("Odustani");
		
		postaviElemente();
		postaviFunkcionalnosti();
		
		this.servisnaKnjizica = servisnaKnjizica;
		popuniPodatke();
		
		this.setVisible(true);
	}
	
	private void postaviElemente() {
		GridLayout gl = new GridLayout(5, 2);
		this.setLayout(gl);
		
		this.add(new JLabel("ID: ", SwingConstants.RIGHT));
		this.add(id);
		this.id.setEditable(false);
		
		this.add(new JLabel("Automobil ID: ", SwingConstants.RIGHT));
		this.add(automobil);
		this.automobil.setEditable(false);
		
		this.add(new JLabel("Servisi: ", SwingConstants.RIGHT));
		this.add(servisi);
		
		this.add(new JLabel("Obrisan: ", SwingConstants.RIGHT));
		this.add(obrisan);
		
		this.add(potvrdi);
		this.add(odustani);
		
	}
	
	private void popuniPodatke() {
		id.setText(servisnaKnjizica.getId());
		automobil.setText(servisnaKnjizica.getAutomobil().getId());
		obrisan.setSelected(servisnaKnjizica.getObrisan());
	}
	
	private void postaviFunkcionalnosti() {
		this.potvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(servisnaKnjizica.getObrisan() != obrisan.isSelected()) {
					Automobil automobil = servisnaKnjizica.getAutomobil();
					automobil.setObrisan(obrisan.isSelected());
					RadSaAutomobilima.izmeniAutomobil(automobil);
					
					for(Servis servis : servisnaKnjizica.getServisi()) {
						servis.setObrisan(obrisan.isSelected());
						RadSaServisima.izmeniServis(servis);
					}
					servisnaKnjizica.setObrisan(obrisan.isSelected());
					RadSaServisnimKnjizicama.izmeniServisnuKnjizicu(servisnaKnjizica);
				}
				
				ugasi();
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
