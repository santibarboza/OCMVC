package view;

import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;


import model.OCModel;
import controller.OCController;

public class OCViewImpl implements OCView{
	private OCController ocController;
	//private OCModel ocModel;
	
	private JFrame ventanaPrincipal;
	private JFrame ventanaMemoria;
	//private JFrame ventanaHelp;
	
//	private String direccionInicio;
	private JButton botonAbrirArchivo; 
	private JButton botonVerAyuda;
	private JButton botonVerMemoria;
	private JButton botonCompilar;
	private JButton botonSiguiente;
	private JButton botonEjecutar;
	private JComboBox<String> tipoDeEjecucion;
	private TextArea contenidoArchivoActual;
	private JTextPane panelArchivoCompilado;
	private JTextField textoTutorial,direcccionDeInicioField;
	private JTable registrosTable,memoryTable;
	private JLabel lblArchivoOriginal,lblCompilado,lblDireccionInicio;
	private JLabel nombreArchivoActual,labelPc,labelInstruccion;

	OCViewImpl(OCController ocController, OCModel ocModel) {

	    this.ocController = ocController;
	//    this.ocModel = ocModel;

	    initialize();
	    initListeners();
	    updateView();
	}
	private void updateView() {
		
	}
	public void updateTextoTutorial(String texto){
		this.textoTutorial.setText(texto);
	}
	private void initListeners() {
		/*
	    userModel.setListener(new UserModelListener() {
	      @Override public void didUpdateUser() {
	        updateUserFields();
	      }
	    });
	    */
		botonAbrirArchivo.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  ocController.onEventAbrirArchivo();
    	  }
		});
		botonCompilar.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	  //  	  direccionInicio=direcccionDeInicioField.getText();
	    	  ocController.onEventCompilar(direcccionDeInicioField.getText());
    	  }
		});
		botonEjecutar.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  ocController.onEventEjecutar();
    	  }
		});		
		botonVerMemoria.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  ocController.onEventVerMemoria();
    	  }
		});	
		botonSiguiente.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  ocController.onEventSiguientePaso();
    	  }
		});
		botonVerAyuda.addActionListener(new ActionListener() {
	      public void actionPerformed(ActionEvent e) {
	    	  ocController.onEventVerAyuda();
    	  }
		});	

	}
	public void habilitarOpcionesdeEjecucion(){
		tipoDeEjecucion.setEnabled(true);
		botonEjecutar.setEnabled(true);
		registrosTable.setEnabled(true);
		botonVerMemoria.setEnabled(true);
    }
	private void initialize() {
		ventanaPrincipal = new JFrame();
		ventanaPrincipal.setTitle("OCUNS - VirtualMachine");
		ventanaPrincipal.setBounds(50, 50, 800, 520);
		ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventanaPrincipal.getContentPane().setLayout(null);
		
		botonAbrirArchivo = new JButton("Abrir Nuevo Archivo");
		botonAbrirArchivo.setBounds(12, 15, 199, 25);
		
		ventanaPrincipal.getContentPane().add(botonAbrirArchivo);
		
		textoTutorial = new JTextField();
		textoTutorial.setEditable(false);
		textoTutorial.setBackground(null);
		textoTutorial.setBorder(null);
		textoTutorial.setText("Para iniciar la Aplicación Elegí el Archivo a Compilar");
		textoTutorial.setBounds(12, 460, 770, 19);
				
		ventanaPrincipal.getContentPane().add(textoTutorial);
		textoTutorial.setColumns(10);
		
		nombreArchivoActual = new JLabel("");
		nombreArchivoActual.setBackground(null);
		nombreArchivoActual.setAutoscrolls(true);
		nombreArchivoActual.setBounds(236, 15, 534, 25);
		ventanaPrincipal.getContentPane().add(nombreArchivoActual);
		
		botonCompilar = new JButton("Compilar");
		botonCompilar.setEnabled(false);
		botonCompilar.setBounds(12, 83, 117, 25);
		ventanaPrincipal.getContentPane().add(botonCompilar);
		
		botonEjecutar = new JButton("Ejecutar");
		botonEjecutar.setEnabled(false);
		botonEjecutar.setBounds(653, 64, 117, 25);
		ventanaPrincipal.getContentPane().add(botonEjecutar);
		
		tipoDeEjecucion = new JComboBox<String>();
		tipoDeEjecucion.addItem("Ejecutar todo el Codigo");
		tipoDeEjecucion.addItem("Ejecutar de a una Instruccion");
		tipoDeEjecucion.setEnabled(false);
		tipoDeEjecucion.setBounds(328, 64, 271, 25);
		ventanaPrincipal.getContentPane().add(tipoDeEjecucion);
		
		contenidoArchivoActual = new TextArea();
		contenidoArchivoActual.setEnabled(false);
		contenidoArchivoActual.setEditable(false);
		contenidoArchivoActual.setBounds(30, 150, 200, 300);
		ventanaPrincipal.getContentPane().add(contenidoArchivoActual);
		
		lblArchivoOriginal = new JLabel("Archivo Original");
		lblArchivoOriginal.setEnabled(false);
		lblArchivoOriginal.setBounds(58, 125, 111, 15);
		ventanaPrincipal.getContentPane().add(lblArchivoOriginal);
		
		panelArchivoCompilado = new JTextPane();
		JScrollPane jsp = new JScrollPane(panelArchivoCompilado);
		jsp.setBounds(250, 150, 230, 300);
		ventanaPrincipal.getContentPane().add(jsp);
		
		direcccionDeInicioField = new JTextField();
		direcccionDeInicioField.setEnabled(false);
		direcccionDeInicioField.setText("00");
		direcccionDeInicioField.setBounds(100, 55, 30, 19);
		ventanaPrincipal.getContentPane().add(direcccionDeInicioField);
		direcccionDeInicioField.setColumns(10);
		
		lblDireccionInicio = new JLabel("Dir Inicio:");
		lblDireccionInicio.setEnabled(false);
		lblDireccionInicio.setBounds(20, 55, 70, 15);
		ventanaPrincipal.getContentPane().add(lblDireccionInicio);
		
		lblCompilado = new JLabel("Compilado");
		lblCompilado.setEnabled(false);
		lblCompilado.setBounds(236, 125, 74, 15);
		ventanaPrincipal.getContentPane().add(lblCompilado);
		
		String [][]a=new String[16][2];
		for(int i=0;i<16;i++){
			a[i][0]=("R"+Integer.toHexString(i)).toUpperCase();
			a[i][1]="";
		}
		String[]columnNames={"Registros","Contenido"};
		registrosTable = new JTable(a, columnNames);
		registrosTable.setEnabled(false);
		JScrollPane jsp2 = new JScrollPane(registrosTable);
		jsp2.setBounds(496, 170, 150, 280);
		ventanaPrincipal.getContentPane().add(jsp2);
		
		JLabel labelBancoDeRegistros = new JLabel("Banco de Registros");
		labelBancoDeRegistros.setEnabled(false);
		labelBancoDeRegistros.setBounds(503, 150, 137, 15);
		ventanaPrincipal.getContentPane().add(labelBancoDeRegistros);
		
		botonVerMemoria = new JButton("Ver Memoria");
		botonVerMemoria.setEnabled(false);
		botonVerMemoria.setBounds(659, 276, 123, 25);
		ventanaPrincipal.getContentPane().add(botonVerMemoria);
		
		botonSiguiente = new JButton("Siguiente");
		botonSiguiente.setEnabled(false);
		botonSiguiente.setBounds(659, 239, 123, 25);
		ventanaPrincipal.getContentPane().add(botonSiguiente);
		
		labelPc = new JLabel("PC=");
		labelPc.setEnabled(false);
		labelPc.setBounds(659, 174, 113, 19);
		ventanaPrincipal.getContentPane().add(labelPc);
		
		labelInstruccion = new JLabel("Intruccion:");
		labelInstruccion.setEnabled(false);
		labelInstruccion.setBounds(659, 197, 123, 30);
		ventanaPrincipal.getContentPane().add(labelInstruccion);
		
		botonVerAyuda = new JButton("Ayuda");
		botonVerAyuda.setBounds(659, 386, 123, 25);
		ventanaPrincipal.getContentPane().add(botonVerAyuda);

		
		JButton botonSobreMi = new JButton("Sobre Mi");
		botonSobreMi.setBounds(659, 423, 123, 25);
		ventanaPrincipal.getContentPane().add(botonSobreMi);
		
		ventanaMemoria=new JFrame();
		ventanaMemoria.setTitle("Memoria de OCUNS");
		ventanaMemoria.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		ventanaMemoria.setBounds(50, 50, 170, 520);
		ventanaMemoria.getContentPane().setLayout(null);
		ventanaMemoria.setVisible(false);
		
		String[]cNames={"Dir","Memoria"};
		String [][]b=new String[256][2];
		for(int i=0;i<16;i++){
			b[i][0]=("0"+Integer.toHexString(i)).toUpperCase();
			b[i][1]="";
		}for(int i=16;i<256;i++){
			b[i][0]=(""+Integer.toHexString(i)).toUpperCase();
			b[i][1]="";
		}
		
		memoryTable = new JTable(b, cNames);
		memoryTable.setEnabled(false);
		JScrollPane jsp3 = new JScrollPane(memoryTable);
		jsp3.setBounds(0, 0, 150, 490);
		ventanaMemoria.getContentPane().add(jsp3);
		
		//ventanaHelp = new VentanaHelp();
		//ventanaHelp.setVisible(false);
		//ventanaHelp.setTitle("Ayuda para OCUNS Virtual Machine");
		//ventanaHelp.setSize(600,500);
	}
}
