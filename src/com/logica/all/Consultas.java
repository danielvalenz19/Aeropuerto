/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.logica.all;

import com.jframe.grafico.FrmAdministrador;
import com.jframe.grafico.formulario;
import com.mysql.conexion.ClsConexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author hetzo
 */
public class Consultas {

    formulario fr = new formulario();
    FrmAdministrador frmAdministrador = new FrmAdministrador();

    public void accesoUsuario(String user, String pass) {
        // TODO add your handling code here:
        ClsConexion db = new ClsConexion();
        // Se inicializa a null
        String usuarioCorrecto = null;
        String passCorrecto = null;
        try {

            Connection cn = db.getConnection();
            PreparedStatement pst = cn.prepareStatement("SELECT nombre, clave FROM login");
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                usuarioCorrecto = rs.getString(1);
                passCorrecto = rs.getString(2);
            }

            if (user.equals(usuarioCorrecto) && pass.equals(passCorrecto)) {
                JOptionPane.showMessageDialog(null, "Login correcto Bienvenido " + user);
                frmAdministrador.setVisible(true);

            } else if (!user.equals(usuarioCorrecto) || pass.equals(passCorrecto)) {

                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                fr.setVisible(true);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e);
        }
    }
}
