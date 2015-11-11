/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.SystemAdministratorWorkArea;

import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.Network;
import healthcare.Network.Network.NetworkType;
import healthcare.Network.NetworkFactory;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Muddassar
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private Network network;
    /**
     * Creates new form ManageNetworkJPanel
     */
    public ManageNetworkJPanel(JPanel userProcessContainer, EcoSystem system, Network network) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.system = system;
        this.network = network;
        
        populateNetworkTable();
        populateNetworkTypes();
    }
    
      private void populateNetworkTable(){
        DefaultTableModel model = (DefaultTableModel)tblNetwork.getModel();
        
        model.setRowCount(0);
        ArrayList<Network> networkList = null;
        if(network != null)
        {
            networkList = network.getChildNetworks();
        }
        else
        {
            networkList = system.getNetworkList();
        }
        for (Network network : networkList){
            Object[] row = new Object[1];
            row[0] = network;
            model.addRow(row);
        }
    }
      
      private void populateNetworkTypes()
      {
          this.cmbNetworkType.removeAllItems();
          for(NetworkType type : Network.NetworkType.values())
          {
              cmbNetworkType.addItem(type);
          }
      }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblNetwork = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        cmbNetworkType = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblNetwork.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblNetwork);
        if (tblNetwork.getColumnModel().getColumnCount() > 0) {
            tblNetwork.getColumnModel().getColumn(0).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 63, 404, 91));

        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 261, -1, -1));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(385, 254, -1, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 255, 148, -1));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 289, -1, -1));

        add(cmbNetworkType, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 192, 156, -1));

        jLabel2.setText("Network Type");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 196, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private boolean validateFields()
    {
        if(txtName.getText().isEmpty())
        {
            return false;
        }
        return true;
    }
    
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        if(!this.validateFields())
        {
            JOptionPane.showMessageDialog(null, "Please enter valid details");
            return;
        }
        String name = txtName.getText();
        NetworkType type = (NetworkType)cmbNetworkType.getSelectedItem();
        Network net = NetworkFactory.createNetwork(type);
        net.setName(name);
        if(this.network != null )
        {
            this.network.Add(net);
        }
        else
        {
            system.getNetworkList().add(net);
        }
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("New Network: of type:%s added",net.getName(),type.getValue()));
        populateNetworkTable();
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.userProcessContainer.remove(this);
        
        CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
        layout.previous(this.userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JComboBox cmbNetworkType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblNetwork;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}