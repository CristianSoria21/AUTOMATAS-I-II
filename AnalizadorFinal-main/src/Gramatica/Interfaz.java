package Gramatica;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interfaz extends javax.swing.JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
    private NumeroLinea nm;
    private JFileChooser jfc;
    private FileNameExtensionFilter filtro = new FileNameExtensionFilter("archivos TURING .TUR", "TUR");
    private String ruta = "";
    private FileOutputStream output; // flujo de salida de datos
    private FileInputStream input; // flujo de entrada de datos
    
    public Interfaz() {
        initComponents();
        setLocationRelativeTo(this);
	setResizable(false);
        getContentPane().setBackground(new Color(255,255,255));
        nm = new NumeroLinea(areaCodigo);
	jScrollPane1.setRowHeaderView(nm);
        btnNuevo.addActionListener((ActionListener) this);
	btnAbrir.addActionListener(this);
	btnGuardarComo.addActionListener(this);
	btnGuardar.addActionListener(this);
	btnSalir.addActionListener(this);
	btnAnalizar.addActionListener(this);
        jTabbedPane1.setEnabled(false);
        btnGuardar.setEnabled(false);
	btnGuardarComo.setEnabled(false);
	btnSalir.setEnabled(false);
        areaCodigo.setEnabled(false);
        areaTokens.setEnabled(false);
        areaPila.setEnabled(false);
        areaSimbolos.setEnabled(false);
        areaErrores.setEnabled(false);
        areaPosfija.setEnabled(false);
        areaIntermedio.setEnabled(false);
    }
    
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAbrir)
		{
			this.Abrir();
		}
		else if (e.getSource() == btnGuardarComo)
		{
			this.GuardarComo();
		}
		else if (e.getSource() == btnNuevo)
		{
			this.Nuevo();
		}
		else if (e.getSource() == btnGuardar)
		{
			this.Guardar();
		}
		else if (e.getSource() == btnSalir)
		{
			this.Cerrar();
		}
		else if (e.getSource() == btnAnalizar)
		{
                    
		}
    }
        
    private void Abrir()
	{
		try
		{
			jfc = new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setFileFilter(filtro);
			jfc.showOpenDialog(this);
			ruta = jfc.getSelectedFile().toString();
			try
			{
				output = new FileOutputStream(ruta, true);
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error en el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			String contenido = "";
			byte datos[] = new byte[30];
			int leidos = 0;
			try
			{
				input = new FileInputStream(ruta);
				do
				{
					leidos = input.read(datos);
					if (leidos != -1)
						contenido += new String(datos, 0, leidos);
				}
				while (leidos != -1);
				input.close();
				output.close();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error en el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
			areaCodigo.setText(contenido);
			areaCodigo.setEnabled(true);
                        areaTokens.setEnabled(true);
                        areaPila.setEnabled(true);
                        areaSimbolos.setEnabled(true);
                        areaErrores.setEnabled(true);
			btnNuevo.setEnabled(false);
			btnAbrir.setEnabled(false);
			btnGuardar.setEnabled(true);
			btnGuardarComo.setEnabled(true);
			btnSalir.setEnabled(true);
			btnAnalizar.setEnabled(true);
			btnAnalizar.setEnabled(true);
			jTabbedPane1.setEnabled(true);
                        areaPosfija.setEnabled(true);
                        areaIntermedio.setEnabled(true);
		}
		catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Error al abrir el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
    
    private void GuardarComo()
	{
		try
		{
			String contenido = areaCodigo.getText();
			jfc = new JFileChooser();
			jfc.setSelectedFile(new File("programa.TUR"));
			jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
			jfc.setFileFilter(filtro);
			int opcion = jfc.showSaveDialog(this);
			ruta = jfc.getSelectedFile().toString();
			File archivo = jfc.getSelectedFile();
			if (opcion == JFileChooser.APPROVE_OPTION)
			{
				if (archivo.exists())
				{
					int resultado = JOptionPane.showConfirmDialog(this, "Ya existe un archivo con el mismo nombre ¿Desea sobrescribirlo?", "Archivo ya existe", JOptionPane.YES_NO_OPTION);
					if (resultado == JOptionPane.YES_OPTION)
						try
						{
							output = new FileOutputStream(ruta);
							output.write(contenido.getBytes());
							output.close();
						}
						catch (IOException e)
						{
							JOptionPane.showMessageDialog(null, "Error en el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					else
						this.GuardarComo();
				}
				else
					try
					{
						output = new FileOutputStream(ruta);
						output.write(contenido.getBytes());
						output.close();
					}
					catch (IOException e)
					{
						JOptionPane.showMessageDialog(null, "Error en el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
			}
		}
		catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
    
    private void Nuevo()
	{
		areaCodigo.setEnabled(true);
                areaTokens.setEnabled(true);
                areaPila.setEnabled(true);
                areaSimbolos.setEnabled(true);
                areaErrores.setEnabled(true);
                areaPosfija.setEnabled(true);
                areaIntermedio.setEnabled(true);
		areaCodigo.setText("");
		btnNuevo.setEnabled(false);
		btnAbrir.setEnabled(false);
		btnGuardar.setEnabled(true);
		btnGuardarComo.setEnabled(true);
		btnSalir.setEnabled(true);
		btnAnalizar.setEnabled(true);
		jTabbedPane1.setEnabled(true);
	}
    
    private void Guardar()
	{
		try
		{
			String contenido = areaCodigo.getText();
			if (ruta.isEmpty())
				this.GuardarComo();
			try
			{
				output = new FileOutputStream(ruta);
				output.write(contenido.getBytes());
				output.close();
			}
			catch (IOException e)
			{
				JOptionPane.showMessageDialog(null, "Error en el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		catch (NullPointerException e)
		{
			JOptionPane.showMessageDialog(null, "Error al guardar el archivo", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}
    
    private void Cerrar()
	{
		int resultado = JOptionPane.showConfirmDialog(this, "¿Desea guardar antes de cerrar el archivo?", "Aviso", JOptionPane.YES_NO_OPTION);
		if (resultado == JOptionPane.YES_OPTION)
			if (ruta.isEmpty())
				this.GuardarComo();
			else
				this.Guardar();
		areaCodigo.setEnabled(false);
                areaTokens.setEnabled(false);
                areaPila.setEnabled(false);
                areaSimbolos.setEnabled(false);
                areaErrores.setEnabled(false);
		btnNuevo.setEnabled(true);
		btnAbrir.setEnabled(true);
		btnGuardar.setEnabled(false);
		btnGuardarComo.setEnabled(false);
		btnSalir.setEnabled(false);
		btnAnalizar.setEnabled(false);
		jTabbedPane1.setEnabled(false);
                areaPosfija.setEnabled(false);
                areaIntermedio.setEnabled(false);
                areaIntermedio.setText("");
                areaPosfija.setText("");
		ruta = "";
                areaCodigo.setText("");
                areaTokens.setText("");
                areaPila.setText("");
                areaErrores.setText("");
                areaSimbolos.setText("");
	}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane8 = new javax.swing.JScrollPane();
        areaTokens = new javax.swing.JTextArea();
        jScrollPane9 = new javax.swing.JScrollPane();
        areaPila = new javax.swing.JTextArea();
        jScrollPane10 = new javax.swing.JScrollPane();
        areaErrores = new javax.swing.JTextArea();
        jScrollPane11 = new javax.swing.JScrollPane();
        areaIntermedio = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        areaSimbolos = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        areaPosfija = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaCodigo = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        btnNuevo = new javax.swing.JMenuItem();
        btnAbrir = new javax.swing.JMenuItem();
        btnGuardar = new javax.swing.JMenuItem();
        btnGuardarComo = new javax.swing.JMenuItem();
        btnSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        btnAnalizar = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COMPILADOR TURING");
        setBackground(new java.awt.Color(51, 204, 255));

        jTabbedPane1.setBackground(new java.awt.Color(51, 204, 255));
        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        areaTokens.setEditable(false);
        areaTokens.setBackground(new java.awt.Color(255, 255, 255));
        areaTokens.setColumns(20);
        areaTokens.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        areaTokens.setRows(5);
        jScrollPane8.setViewportView(areaTokens);

        jTabbedPane1.addTab("Componentes", jScrollPane8);

        areaPila.setEditable(false);
        areaPila.setBackground(new java.awt.Color(255, 255, 255));
        areaPila.setColumns(20);
        areaPila.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        areaPila.setRows(5);
        jScrollPane9.setViewportView(areaPila);

        jTabbedPane1.addTab("Pila", jScrollPane9);

        areaErrores.setEditable(false);
        areaErrores.setBackground(new java.awt.Color(255, 255, 255));
        areaErrores.setColumns(20);
        areaErrores.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        areaErrores.setRows(5);
        jScrollPane10.setViewportView(areaErrores);

        jTabbedPane1.addTab("Errores", jScrollPane10);

        areaIntermedio.setEditable(false);
        areaIntermedio.setBackground(new java.awt.Color(255, 255, 255));
        areaIntermedio.setColumns(20);
        areaIntermedio.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        areaIntermedio.setRows(5);
        jScrollPane11.setViewportView(areaIntermedio);

        jTabbedPane1.addTab("Codigo Intermedio", jScrollPane11);

        areaSimbolos.setEditable(false);
        areaSimbolos.setBackground(new java.awt.Color(255, 255, 255));
        areaSimbolos.setColumns(20);
        areaSimbolos.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        areaSimbolos.setRows(5);
        jScrollPane5.setViewportView(areaSimbolos);

        jTabbedPane1.addTab("Tabla de Simbolos", jScrollPane5);

        jScrollPane6.setBackground(new java.awt.Color(204, 255, 0));

        areaPosfija.setEditable(false);
        areaPosfija.setBackground(new java.awt.Color(255, 255, 255));
        areaPosfija.setColumns(20);
        areaPosfija.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        areaPosfija.setRows(5);
        jScrollPane6.setViewportView(areaPosfija);

        jTabbedPane1.addTab("Notacion Posfija", jScrollPane6);

        areaCodigo.setColumns(20);
        areaCodigo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        areaCodigo.setRows(5);
        jScrollPane1.setViewportView(areaCodigo);

        jMenuBar1.setBackground(new java.awt.Color(51, 204, 255));

        jMenu1.setBackground(new java.awt.Color(0, 204, 204));
        jMenu1.setText("Archivo");

        btnNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gramatica/Iconos/nuevo_menu2.png"))); // NOI18N
        btnNuevo.setText("Nuevo ");
        jMenu1.add(btnNuevo);

        btnAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnAbrir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gramatica/Iconos/abrir_menu.png"))); // NOI18N
        btnAbrir.setText("Abrir");
        jMenu1.add(btnAbrir);

        btnGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gramatica/Iconos/guardar_menu.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(btnGuardar);

        btnGuardarComo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnGuardarComo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gramatica/Iconos/menu_GC.png"))); // NOI18N
        btnGuardarComo.setText("Guardar Como");
        jMenu1.add(btnGuardarComo);

        btnSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gramatica/Iconos/menu_salir.png"))); // NOI18N
        btnSalir.setText("Salir");
        jMenu1.add(btnSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ejecutar");

        btnAnalizar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        btnAnalizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gramatica/Iconos/ejecutar_menu.png"))); // NOI18N
        btnAnalizar.setText("Compilar");
        btnAnalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalizarActionPerformed(evt);
            }
        });
        jMenu2.add(btnAnalizar);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAnalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalizarActionPerformed
    areaTokens.setText("");
                areaPila.setText("");
                areaErrores.setText("");
                areaSimbolos.setText("");
                PrincipalF obp = new PrincipalF();
                
                obp.textoPila = "";          
                obp.textoTokens = "";
                obp.textoErrores = "";
                obp.textoCodigoInter = "";
                obp.textoNotacion = "";
                
                obp.Accion(obp.Entrada(obp.Separar(areaCodigo.getText().replaceAll("\\n", ""))));
                obp.mostrarSimbolos();
                areaPila.setText(obp.textoPila);
                areaTokens.setText(obp.textoTokens);
                areaErrores.setText(obp.textoErrores);
                areaSimbolos.setText(obp.textoSimbolos);
                areaIntermedio.setText(obp.textoCodigoInter);
                areaPosfija.setText(obp.textoNotacion);    }//GEN-LAST:event_btnAnalizarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaCodigo;
    private javax.swing.JTextArea areaErrores;
    private javax.swing.JTextArea areaIntermedio;
    private javax.swing.JTextArea areaPila;
    private javax.swing.JTextArea areaPosfija;
    private javax.swing.JTextArea areaSimbolos;
    private javax.swing.JTextArea areaTokens;
    private javax.swing.JMenuItem btnAbrir;
    private javax.swing.JMenuItem btnAnalizar;
    private javax.swing.JMenuItem btnGuardar;
    private javax.swing.JMenuItem btnGuardarComo;
    private javax.swing.JMenuItem btnNuevo;
    private javax.swing.JMenuItem btnSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

}