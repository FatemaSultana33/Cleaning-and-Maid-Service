
package ctwo;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ProjectandService extends javax.swing.JFrame {

    
    public ProjectandService() {
        initComponents();
        setLocationRelativeTo(null);
         show_user();
    }
public Connection connection;  
    public ArrayList<User1>userList()
    {
      ArrayList<User1>userList = new ArrayList<>();

         try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=checkpointnotwo;selectMethod=cursor", "sa", "123456");
         
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("select P.ProjectId,P.ServiceId,P.ServiceFee,P.Deadline,P.CurrentStatus,O.ServiceName,O.Cost,O.Unit from Project P inner join OurService O on P.ServiceId=O.ServiceId order by ServiceFee");
            
        
             User1 user;
            
            while(resultSet.next())
         {
            user = new User1(resultSet.getInt("ProjectId"),resultSet.getInt("ServiceId"),resultSet.getString("ServiceFee"),resultSet.getString("Deadline"),resultSet.getString("CurrentStatus"),resultSet.getString("ServiceName"),resultSet.getString("Cost"),resultSet.getString("Unit"));
            userList.add(user);;
           // userList.add(user);

         }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
         return userList;
    
    
    
    }
      
 public void show_user()
 {
   ArrayList<User1>list = userList();
   DefaultTableModel model =(DefaultTableModel) ProjectandServiceTable.getModel();
   Object[] row = new Object[8];


   for(int i = 0;i<list.size();i++)
   {
     row[0]=list.get(i).getProjectId();
     row[1]=list.get(i).getServiceId();
     row[2]=list.get(i).getServiceFee();
     row[3]=list.get(i).getDeadline();
     row[4]=list.get(i).getCurrentStatus();
     row[5]=list.get(i).getServiceName();
     row[6]=list.get(i).getCost();
     row[7]=list.get(i).getUnit();
     
    
     model.addRow(row);
   
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ProjectandServiceTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Search = new javax.swing.JTextField();
        ProjectId = new javax.swing.JTextField();
        ServiceId = new javax.swing.JTextField();
        ServiceFee = new javax.swing.JTextField();
        Deadline = new javax.swing.JTextField();
        CurrentStatus = new javax.swing.JTextField();
        ServiceName = new javax.swing.JTextField();
        Cost = new javax.swing.JTextField();
        Unit = new javax.swing.JTextField();
        Clear = new javax.swing.JButton();
        BackToProject = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1228, 780));
        setMinimumSize(new java.awt.Dimension(1228, 780));
        setPreferredSize(new java.awt.Dimension(1228, 780));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(250, 250, 250));
        jLabel2.setText("Cleaning &");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 150, 50));

        jLabel3.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(250, 250, 250));
        jLabel3.setText("Maid Service");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 256, 160, 60));

        jLabel4.setBackground(new java.awt.Color(255, 204, 0));
        jLabel4.setOpaque(true);
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 180, 630));

        ProjectandServiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ProjectId", "ServiceId", "ServiceFee", "Deadline", "CurrentStatus", "ServiceName", "Cost", "Unit"
            }
        ));
        ProjectandServiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProjectandServiceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ProjectandServiceTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(182, 0, 800, 180));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("ProjectId");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 70, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ServiceId");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 70, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("ServiceFee");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 300, 80, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Deadline");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("CurrentStatus");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 100, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("ServiceName");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Cost");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 460, 50, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Unit");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 500, 50, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Search(Enter ProjectId)");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 170, 30));

        Search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchKeyReleased(evt);
            }
        });
        jPanel1.add(Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 220, 200, 30));

        ProjectId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProjectIdActionPerformed(evt);
            }
        });
        jPanel1.add(ProjectId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 210, 30));
        jPanel1.add(ServiceId, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 210, 30));

        ServiceFee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ServiceFeeActionPerformed(evt);
            }
        });
        jPanel1.add(ServiceFee, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 210, 30));
        jPanel1.add(Deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 210, 30));

        CurrentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurrentStatusActionPerformed(evt);
            }
        });
        jPanel1.add(CurrentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 210, 30));
        jPanel1.add(ServiceName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 210, 30));
        jPanel1.add(Cost, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 210, 30));
        jPanel1.add(Unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 210, 30));

        Clear.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        Clear.setText("CLEAR");
        Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearActionPerformed(evt);
            }
        });
        jPanel1.add(Clear, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 90, -1));

        BackToProject.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        BackToProject.setText("Back to Project");
        BackToProject.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackToProjectActionPerformed(evt);
            }
        });
        jPanel1.add(BackToProject, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 988, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ServiceFeeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ServiceFeeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ServiceFeeActionPerformed

    private void ProjectandServiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProjectandServiceTableMouseClicked
       int i = ProjectandServiceTable.getSelectedRow();
        TableModel model = ProjectandServiceTable.getModel();
        
        ServiceId.setText(model.getValueAt(i,1).toString());
        ServiceFee.setText(model.getValueAt(i,2).toString());
        Deadline.setText(model.getValueAt(i,3).toString());
        CurrentStatus.setText(model.getValueAt(i,4).toString());
        ServiceName.setText(model.getValueAt(i,5).toString());
        Cost.setText(model.getValueAt(i,6).toString());
        Unit.setText(model.getValueAt(i,7).toString());
        
    }//GEN-LAST:event_ProjectandServiceTableMouseClicked

    private void SearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchKeyReleased
        try {
           
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://localhost:1433;databaseName=checkpointnotwo;selectMethod=cursor", "sa", "123456");
            
            String sql ="select P.ProjectId,P.ServiceId,P.ServiceFee,P.Deadline,P.CurrentStatus,O.ServiceName,O.Cost,O.Unit from Project P inner join OurService O on P.ServiceId=O.ServiceId where  ProjectId=?";
            PreparedStatement pst = connection.prepareStatement(sql);
            pst.setString(1, Search.getText());
            ResultSet rs =pst.executeQuery();
            if(rs.next())
            {
              String setProjectId = rs.getString("ProjectId");
             ProjectId.setText(setProjectId);
              String setServiceId = rs.getString("ServiceId");
              ServiceId.setText(setServiceId);
             String setServiceFee= rs.getString("ServiceFee");
             ServiceFee.setText(setServiceFee);
             String setDeadline= rs.getString("Deadline");
             Deadline.setText(setDeadline);
             String setCurrentStatus= rs.getString("CurrentStatus");
             CurrentStatus.setText(setCurrentStatus);
             String setServiceName= rs.getString("ServiceName");
             ServiceName.setText(setServiceName);
             String setCost= rs.getString("Cost");
             Cost.setText(setCost);
             String setUnit= rs.getString("Unit");
             Unit.setText(setUnit);
              
            
            }
         }
         catch(Exception e)
         {
             JOptionPane.showMessageDialog(null, e);
         
         }
    }//GEN-LAST:event_SearchKeyReleased

    private void BackToProjectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackToProjectActionPerformed
         Project as=new Project();
         as.setVisible(true);
         new ProjectandService ().setVisible(false);
         dispose();
    }//GEN-LAST:event_BackToProjectActionPerformed

    private void ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearActionPerformed
        ProjectId.setText("");
         ServiceId.setText("");
         ServiceFee.setText("");
         Deadline.setText("");
         CurrentStatus.setText("");
         ServiceName.setText("");
         Cost.setText("");
         Unit.setText("");
         
    }//GEN-LAST:event_ClearActionPerformed

    private void ProjectIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProjectIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProjectIdActionPerformed

    private void CurrentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurrentStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CurrentStatusActionPerformed

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
            java.util.logging.Logger.getLogger(ProjectandService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProjectandService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProjectandService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProjectandService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProjectandService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackToProject;
    private javax.swing.JButton Clear;
    private javax.swing.JTextField Cost;
    private javax.swing.JTextField CurrentStatus;
    private javax.swing.JTextField Deadline;
    private javax.swing.JTextField ProjectId;
    private javax.swing.JTable ProjectandServiceTable;
    private javax.swing.JTextField Search;
    private javax.swing.JTextField ServiceFee;
    private javax.swing.JTextField ServiceId;
    private javax.swing.JTextField ServiceName;
    private javax.swing.JTextField Unit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}