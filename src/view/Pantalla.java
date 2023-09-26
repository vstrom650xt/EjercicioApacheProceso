package view;

import controller.Logica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pantalla extends  JDialog {
    private JPanel apachePanel;
    private JButton offSql;
    private JButton onSql;
    private JButton apaOn;
    private JButton apaOff;
    private JLabel ApacheText;
    private JLabel SQLtext;

    public Pantalla(){
        setContentPane(apachePanel);
        setModal(true);

        apaOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.startApache();
            }
        });

        apaOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.stopApache();

            }
        });
        onSql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.startSQL();

            }
        });

        offSql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.stopSQL();
            }

        });

    //    ApacheText.setText();

   //     SQLtext.setText();




    }





}
