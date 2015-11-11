/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package healthcare.UserInterface.SystemAdministratorWorkArea;

import healthcare.Enterprise.Enterprise;
import healthcare.Enterprise.Enterprise.EnterpriseType;
import healthcare.Ecosystem.EcoSystem;
import healthcare.Network.CompositeNetwork;
import healthcare.Network.Network;
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
public class ManageRegionalNetworksJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem system;
    private Network network;
    /**
     * Creates new form ManageSubnetworkJPanel
     */
    public ManageRegionalNetworksJPanel(JPanel upc, EcoSystem system, Network network) {
        initComponents();
        this.userProcessContainer = upc;
        this.system = system;
        this.network = network;
        populateNetworkTable();
        
    }
    
      private void populateNetworkTable(){
        DefaultTableModel model = (DefaultTableModel) tblSubnetwork.getModel();
                
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
      
        private boolean validateFields()
        {
            if(txtName.getText().isEmpty())
            {
                return false;
            }
            return true;
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
        tblSubnetwork = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnSubmit = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        btnBack = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSubnetwork.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblSubnetwork);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 63, 404, 91));

        jLabel1.setText("Name");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(166, 259, -1, -1));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(332, 254, -1, -1));
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(216, 253, 93, -1));

        btnBack.setText("<< Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 289, -1, -1));

        btnRemove.setText("Remove");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(353, 188, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed

        if(!this.validateFields())
        {
            JOptionPane.showMessageDialog(null, "Please enter valid details");
            return;
        }
        String name = txtName.getText();
        Network net = null;
        if(this.network != null)
        {
            net = new CompositeNetwork();
            net.setName(name);
            this.network.Add(net);
        }
        else
        {
            net = system.createAndAddNetwork(name);
        }
        net.setName(name);
        Logger logger = Logger.getLogger(this.getClass().toString());
        logger.log(Level.INFO,String.format("New Regional Network:%s added ",net.getName()));
        populateNetworkTable();
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.userProcessContainer.remove(this);

        CardLayout layout = (CardLayout)this.userProcessContainer.getLayout();
        layout.previous(this.userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblSubnetwork.getSelectedRow();
        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Error", "Select a row to remove", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Network network = (Network)tblSubnetwork.getValueAt(selectedRow, 0);
        this.system.removeNetwork(network);
        //populateNetworkTable();
    }//GEN-LAST:event_btnRemoveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSubnetwork;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
