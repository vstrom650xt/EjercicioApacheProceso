package view;

import controller.Logica;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import static controller.Logica.getPid;

//import static controller.Logica.showProcess;

public class Pantalla extends  JDialog {
    private JPanel apachePanel;
    private JButton offSql;
    private JButton onSql;
    private JButton apaOn;
    private JButton apaOff;
    public JLabel ApacheText;
    public JLabel SQLtext;

    public int pidApache;
    public int  pidSQL;

    public Pantalla(){
        setContentPane(apachePanel);
        setModal(true);

        currentStatus();


        apaOn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.executeProcess(apaOn, "service", "apache2", "start");

                try {
                    pidApache = getPid("apache2");
                    if (pidApache >0){
                        apaOn.setBackground(Color.green);
                        apaOff.setBackground(Color.lightGray);
                    }
                    System.out.println(pidApache);
                } catch (Exception ex){
                    ex.printStackTrace();
                }
                ApacheText.setText("Apache PID: " + pidApache);
            }
        });

        apaOff.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.executeProcess(apaOff,"service", "apache2", "stop");
                try {
                    pidApache = getPid("apache2");
                    System.out.println(pidApache);
                    if (pidApache <0){
                        apaOn.setBackground(Color.lightGray);
                        apaOff.setBackground(Color.red);
                        ApacheText.setText("Apache apagado");

                    }
                } catch (Exception ex){
                    ex.printStackTrace();
                }

            }
        });
        onSql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.executeProcess(onSql,"service", "mariadb", "start");
                try {
                    pidSQL = getPid("mariadb");
                    System.out.println(pidSQL);
                    if (pidSQL >0){
                        onSql.setBackground(Color.green);
                        offSql.setBackground(Color.lightGray);

                    }
                } catch (Exception ex){
                    ex.printStackTrace();
                }


                SQLtext.setText("mariadb PID: " + pidSQL);

            }
        });

        offSql.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logica.executeProcess(offSql,"service", "mariadb", "stop");
                try {
                    pidSQL = getPid("mariadb");
                    System.out.println(pidSQL);
                    if (pidSQL<0){
                        onSql.setBackground(Color.lightGray);
                        offSql.setBackground(Color.red);
                    }
                } catch (Exception ex){
                    ex.printStackTrace();
                }
                SQLtext.setText("Mariadb apagado");
            }
        });


    }

    private void currentStatus() {
        try {
            int apache2 =Logica.getPid("apache2");
            int mariadb =Logica.getPid("mariadb");
            if (apache2<0){
                ApacheText.setText("Apache apagado");
            }else{
                ApacheText.setText("Apache encendido , PID " + apache2);
            }

            if (mariadb<0){
                SQLtext.setText("Mariadb apagado");
            }else {
                SQLtext.setText("Mariadb encendido , PID " + mariadb);
            }
        }catch (Exception e){
                e.printStackTrace();

        }
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
