package view;

import controller.Logica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import static controller.Logica.showProcess;

public class Pantalla extends  JDialog {
    private JPanel apachePanel;
    private JButton offSql;
    private JButton onSql;
    private JButton apaOn;
    private JButton apaOff;
    public JLabel ApacheText;
    public JLabel SQLtext;

    public Pantalla(){
        setContentPane(apachePanel);
        setModal(true);

        apaOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    Logica.executeProcess(apaOn,"service", "apache2", "start");
                ApacheText.setText(String.valueOf(Logica.showOutPut( Logica.executeProcess(apaOn,"service", "mariadb", "start"))));
            }
        });

        apaOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        //        Logica.executeProcess(apaOff,"service", "apache2", "stop");
                ApacheText.setText(String.valueOf(Logica.showOutPut( Logica.executeProcess(apaOff,"service", "mariadb", "stop"))));


            }
        });
        onSql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //    Logica.executeProcess(onSql,"service", "mariadb", "start");
                SQLtext.setText(String.valueOf(Logica.showOutPut( Logica.executeProcess(onSql,"service", "mariadb", "start"))));

            }
        });

        offSql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
          //      Logica.executeProcess(offSql,"service", "mariadb", "start");
                SQLtext.setText(String.valueOf(Logica.showOutPut( Logica.executeProcess(offSql,"service", "mariadb", "stop"))));

            }

        });



    //   ApacheText.setText(String.valueOf(Logica.showOutPut( Logica.executeProcess(offSql,"service", "mariadb", "start"))));





    }


    public JLabel getApacheText() {
        return ApacheText;
    }

    public void setApacheText(JLabel apacheText) {
        ApacheText = apacheText;
    }

    public JLabel getSQLtext() {
        return SQLtext;
    }

    public void setSQLtext(JLabel SQLtext) {
        this.SQLtext = SQLtext;
    }



}
