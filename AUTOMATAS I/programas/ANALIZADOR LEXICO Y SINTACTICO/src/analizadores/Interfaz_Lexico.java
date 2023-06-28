package analizadores;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Interfaz_Lexico extends JFrame
{

	JButton Analizar, limpiar;
	JTextArea txtArea1, txtArea2;
	JMenuBar gpb;
	Label et;

	public Interfaz_Lexico()
	{
		setTitle("ANALIZADOR LEXICO");
		setSize(800, 600);
		setLocationRelativeTo(this);

		et = new Label("");
		limpiar = new JButton("Limpiar");
		Analizar = new JButton("Analizar");
		Font fuenteFont = new Font("Dialog", Font.BOLD, 14);

		txtArea1 = new JTextArea(26, 30);
		txtArea1.setLineWrap(true);
		txtArea1.setFont(fuenteFont);
		txtArea1.setBorder(new LineBorder(Color.LIGHT_GRAY));

		txtArea2 = new JTextArea(26, 30);
		txtArea2.setLineWrap(true);
		txtArea2.setEditable(false);
		txtArea2.setForeground(Color.BLUE);
		txtArea2.setBackground(new Color(231, 231, 231));
		txtArea2.setFont(fuenteFont);
		txtArea2.setBorder(new LineBorder(Color.LIGHT_GRAY));

		Panel p1 = new Panel();
		p1.add(Analizar);
		p1.add(limpiar);
		add(p1, BorderLayout.NORTH);

		Panel p2 = new Panel();
		p2.add(txtArea1);
		p2.add(et);
		p2.add(txtArea2);
		add(p2, BorderLayout.CENTER);

		Analizar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				File archivo = new File("Archivo.txt");
				PrintWriter escribir;
				ClassLexico lexico = new ClassLexico();
				try
				{
					escribir = new PrintWriter(archivo);
					escribir.print(txtArea1.getText());
					escribir.close();

				} catch (FileNotFoundException e1)
				{
					e1.printStackTrace();
				}

				LinkedList<String> list = lexico.LeerCodigo(archivo);

				for (int x = 0; x < list.size(); x++)
				{
					txtArea2.append(list.get(x));
				}
				
				lexico.mostrarsint();

			}
		});

		limpiar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				txtArea1.setText("");
			}
		});

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args)
	{
		new Interfaz_Lexico();
	}
}
