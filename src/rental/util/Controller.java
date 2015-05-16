/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rental.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.Locale;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import rental.database.ConnectionDB;
import rental.database.Query;

/**
 *
 * @author Alfian Hidayat
 */
public class Controller {

    ConnectionDB cdb = new ConnectionDB();

    public String autoKode(String query, String kd) {
        String kode = "";
        ResultSet rs = cdb.executeQuery(query);
        try {
            while (rs.next()) {
                if (rs.getInt(1) == 0) {
                    kode = kd + "00001";
                } else {
                    int auto = rs.getInt(1) + 1;
                    String no = String.valueOf(auto);
                    int noLong = no.length();
                    for (int i = 0; i < 5 - noLong; i++) {
                        no = "0" + no;
                    }
                    kode = kd + no;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: \n" + e.toString(),
                    "Kesalahan", JOptionPane.WARNING_MESSAGE);
        } finally {
            try {
                rs.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
        return kode;
    }

    public String currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public String addDate(int q) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, q);
        return dateFormat.format(cal.getTime());
    }

    public String toRupiahFormat(String nominal) {
        Locale locale = null;
        NumberFormat rupiahFormat = null;
        String rupiah = "Rp. ";
        locale = new Locale("ca", "CA");
        rupiahFormat = NumberFormat.getCurrencyInstance(locale);
        rupiah = rupiah + rupiahFormat.format(Double.parseDouble(nominal)).substring(4);
        return rupiah;
    }

    public String getSelectedButtonText(ButtonGroup buttonGroup) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }

}
