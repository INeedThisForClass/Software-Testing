package main;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class Login extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JButton jButtonLogin;
	private JButton jButtonCancel;
	private JLabel jLabelUsername;
	private JLabel jLabelPassword;
	private JPanel jPanel1;
	private JPasswordField txtpass;
	private JTextField txtuser;
	// End of variables declaration//GEN-END:variables

	/**
	 * Creates new form Login
	 */
	public Login() {
		initComponents();
	}

	public Login(MysqlDataSource ds) {
		initComponents();
		this.d = ds;
	}

	//method for testing that returns the password field
	public void setPassword(String pass) {
		txtpass.setText(pass);
	}

	//method for testing that returns the username field
	public void setUsername(String user) {
		txtuser.setText(user);
	}

	MysqlDataSource d;
	Connection con;
	PreparedStatement pst;

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jPanel1 = new JPanel();
		jLabelUsername = new JLabel();
		jLabelPassword = new JLabel();
		jButtonLogin = new JButton();
		jButtonCancel = new JButton();
		txtuser = new JTextField();
		txtpass = new JPasswordField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null,
				"Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
				javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 1, 18))); // NOI18N

		jLabelUsername.setText("UserName");

		jLabelPassword.setText("Password");

		jButtonLogin.setText("Login");
		jButtonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

					jButtonLoginActionPerformed(evt);

			}
		});

		jButtonCancel.setText("Cancel");
		jButtonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}

		});

		GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGroup(jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(50, 50, 50)
										.addGroup(jPanel1Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jLabelUsername)
												.addComponent(jLabelPassword))
										.addGap(52, 52, 52)
										.addGroup(jPanel1Layout
												.createParallelGroup(
														javax.swing.GroupLayout.Alignment.LEADING,
														false)
												.addComponent(txtuser)
												.addComponent(txtpass,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														177, Short.MAX_VALUE)))
								.addGroup(jPanel1Layout.createSequentialGroup()
										.addGap(136, 136, 136)
										.addComponent(jButtonLogin,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												97,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(jButtonCancel,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												116,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(25, Short.MAX_VALUE)));
		jPanel1Layout.setVerticalGroup(jPanel1Layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel1Layout.createSequentialGroup()
						.addGap(46, 46, 46)
						.addGroup(jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelUsername)
								.addComponent(txtuser,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(43, 43, 43)
						.addGroup(jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabelPassword)
								.addComponent(txtpass,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED,
								31, Short.MAX_VALUE)
						.addGroup(jPanel1Layout.createParallelGroup(
								javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButtonLogin,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										39,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButtonCancel,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										36,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(45, 45, 45)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(26, 26, 26)
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(44, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(30, 30, 30)
						.addComponent(jPanel1,
								javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(22, Short.MAX_VALUE)));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

	public boolean jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

		String username = txtuser.getText();
		String password = new String(txtpass.getPassword());

		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("login attempts failed");
			JOptionPane.showMessageDialog(this, "UserName or Password Blank");
			return false;
		} else {
			try {
				if(d == null) {
					d = new MysqlDataSource();
					d.setUser("root");
					d.setPassword("1234");
					d.setDatabaseName("airline");
				}
				con =  d.getConnection();

				pst = con.prepareStatement("select * from user where username = ? and password = ?");

				pst.setString(1, username);
				pst.setString(2, password);

				ResultSet rs;
				rs = pst.executeQuery();

				if (rs.next()) {
					Main m = new Main();
					this.setVisible(false);
					m.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(this,
							"UserName or Password do not Match");
					txtuser.setText("");
					txtpass.setText("");
					txtuser.requestFocus();
					return false;
				}

			} catch (SQLException ex) {
				System.out.println("error");
				Logger.getLogger(Login.class.getName()).log(Level.SEVERE, "Connection to Database Failed",
						ex);

			}
		}
		System.out.println("Executed Query");
		return true;
	}

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
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
					.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Login.class.getName())
					.log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

}
