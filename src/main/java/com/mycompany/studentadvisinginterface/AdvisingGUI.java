/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.studentadvisinginterface;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class and GUI of the project which manages data entry and is interacted with by the user
 * @author Leah J., Nikolei M., Sayaad A.
 */
public class AdvisingGUI extends javax.swing.JFrame {
    private String degreeSelected;
    private int semesterSelected = 0 ;
    private String status = "";
    private double gpa = 0.0 ;
    private boolean exempt = false;
    private DcitDegree dcitDegree;
    private int count = 0;


    /**
     * Creates new form AdvisingGUI
     */
    public AdvisingGUI() {
        initComponents();
        gpaPanel.setVisible(false);
        exemptionPanel.setVisible(false);
        
        
    }
    
    /** 
     * Retrieves the semester selected from the form
     * @return semesterSelected
     */
    //getters
    public int getSemester(){
        return semesterSelected;
    }
    
    /** 
     * Retrieves the status selected from the form
     * @return String
     */
    public String getStatus(){
        return status;
    }
    
    /** 
     * Retrieves the GPA entered in the form
     * @return double
     */
    public double getGpa(){
        return gpa;
    }
    
    /** 
     * Retrieves the exempt status of the user from the form
     * @return boolean
     */
    public boolean getExempt(){
        return exempt;
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        semester = new javax.swing.ButtonGroup();
        studentStatus = new javax.swing.ButtonGroup();
        exemptionChoice = new javax.swing.ButtonGroup();
        gpaButtonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        degree = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        semester1 = new javax.swing.JRadioButton();
        semester2 = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        fullTime = new javax.swing.JRadioButton();
        partTime = new javax.swing.JRadioButton();
        recommendCourseList = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        result = new javax.swing.JTextArea();
        exemptionPanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        exemptionYes = new javax.swing.JRadioButton();
        exemptionNo = new javax.swing.JRadioButton();
        gpaPanel = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        lessGpa = new javax.swing.JRadioButton();
        moreGpa = new javax.swing.JRadioButton();
        buttonReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Choose Degree:");

        degree.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--", "Computer Science (Special)", "Computer Science with Management (Special)", "Major in Computer Science", "Minor in Computer Science", "Information Technology (Special)", "Information Technology with Management (Special)", "Major in Information Technology", "Minor in Information Technology", " " }));
        degree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                degreeActionPerformed(evt);
            }
        });

        jLabel2.setText("Choose Semester:");

        semester.add(semester1);
        semester1.setText("Semester 1");
        semester1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester1ActionPerformed(evt);
            }
        });

        semester.add(semester2);
        semester2.setText("Semester 2");
        semester2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semester2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Academic Advising Application");

        jLabel4.setText("Current Status:");

        studentStatus.add(fullTime);
        fullTime.setText("Full-time");
        fullTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fullTimeActionPerformed(evt);
            }
        });

        studentStatus.add(partTime);
        partTime.setText("Part-time");
        partTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                partTimeActionPerformed(evt);
            }
        });

        recommendCourseList.setText("Generate");
        recommendCourseList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                recommendCourseListMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                recommendCourseListMousePressed(evt);
            }
        });
        recommendCourseList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recommendCourseListActionPerformed(evt);
            }
        });

        result.setEditable(false);
        result.setColumns(20);
        result.setRows(5);
        result.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(result);

        jLabel5.setText("Did you take Pure Math or N1 Math?");

        exemptionChoice.add(exemptionYes);
        exemptionYes.setText("Yes");
        exemptionYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exemptionYesActionPerformed(evt);
            }
        });

        exemptionChoice.add(exemptionNo);
        exemptionNo.setText("No");
        exemptionNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exemptionNoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout exemptionPanelLayout = new javax.swing.GroupLayout(exemptionPanel);
        exemptionPanel.setLayout(exemptionPanelLayout);
        exemptionPanelLayout.setHorizontalGroup(
            exemptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exemptionPanelLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(37, 37, 37)
                .addComponent(exemptionYes)
                .addGap(53, 53, 53)
                .addComponent(exemptionNo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        exemptionPanelLayout.setVerticalGroup(
            exemptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exemptionPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(exemptionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(exemptionYes)
                    .addComponent(exemptionNo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel6.setText("GPA:");

        gpaButtonGroup.add(lessGpa);
        lessGpa.setText("< 2.0");
        lessGpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lessGpaActionPerformed(evt);
            }
        });

        gpaButtonGroup.add(moreGpa);
        moreGpa.setText("2.0 - 4.0");
        moreGpa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moreGpaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gpaPanelLayout = new javax.swing.GroupLayout(gpaPanel);
        gpaPanel.setLayout(gpaPanelLayout);
        gpaPanelLayout.setHorizontalGroup(
            gpaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gpaPanelLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel6)
                .addGap(63, 63, 63)
                .addComponent(lessGpa)
                .addGap(55, 55, 55)
                .addComponent(moreGpa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        gpaPanelLayout.setVerticalGroup(
            gpaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gpaPanelLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(gpaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gpaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lessGpa)
                        .addComponent(moreGpa))))
        );

        buttonReset.setText("Reset");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(exemptionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(gpaPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(101, 101, 101)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(semester1)
                                            .addComponent(fullTime))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(semester2)
                                            .addComponent(partTime))
                                        .addGap(10, 10, 10)))))
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(recommendCourseList)
                        .addGap(104, 104, 104)
                        .addComponent(buttonReset)))
                .addContainerGap(98, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(degree, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(semester1)
                    .addComponent(semester2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fullTime)
                    .addComponent(partTime))
                .addGap(18, 18, 18)
                .addComponent(exemptionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(gpaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recommendCourseList)
                    .addComponent(buttonReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    /** 
     * @param (Special)"))
     */
    private void semester1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester1ActionPerformed
        // TODO add your handling code here:
        
        semesterSelected = 1;
        gpaPanel.setVisible(false);
    }//GEN-LAST:event_semester1ActionPerformed

    
    /** 
     * @param (Special)"))
     */
    private void fullTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fullTimeActionPerformed
        // TODO add your handling code here:
        status = "Full-time";
        
    }//GEN-LAST:event_fullTimeActionPerformed

    
    /** 
     * @param (Special)"))
     */
    private void degreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_degreeActionPerformed
        // TODO add your handling code here:
        
        degreeSelected = degree.getSelectedItem().toString();
        
        if((degreeSelected.equals("Computer Science (Special)"))||(degreeSelected.equals("Information Technology (Special)"))){
            exemptionPanel.setVisible(true);
            boolean exempt = true;
        }else{
            exemptionPanel.setVisible(false);
            boolean exempt = false;
        }
        
        if(degreeSelected.equals("Computer Science (Special)")){
            dcitDegree = new CompSciSpecial();
        }else if(degreeSelected.equals("Computer Science with Management (Special)")){
            dcitDegree = new CompSciManagement();   
        }else if (degreeSelected.equals("Major in Computer Science")){
            dcitDegree = new CompSciMajor();
        }else if (degreeSelected.equals("Minor in Computer Science")){
            dcitDegree = new CompSciMinor();
        }else if (degreeSelected.equals("Information Technology (Special)")){
            dcitDegree = new InfoTechSpecial();
        }else if (degreeSelected.equals("Information Technology with Management (Special)")){
            dcitDegree = new InfoTechManagement();
        }else if (degreeSelected.equals("Major in Information Technology")){
            dcitDegree = new InfoTechMajor();
        }else if (degreeSelected.equals("Minor in Information Technology")){
            dcitDegree = new InfoTechMinor();
        }  
        
        
    }//GEN-LAST:event_degreeActionPerformed

    
    /** 
     * @param )
     */
    private void recommendCourseListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_recommendCourseListActionPerformed

        ArrayList <String> L1 = dcitDegree.getS1CourseList();
        ArrayList <String> L2 = dcitDegree.getS2CourseList();
        //count++;
        
        degreeSelected = degree.getSelectedItem().toString();
        if( (degreeSelected.equals("--Select--"))||(status.equals(""))||(semesterSelected == 0) ||((gpaPanel.isShowing() && gpa == 0.0) )){
            result.setText("Please fill out ALL fields");
        }else{
            result.setText(null);
            result.setText(dcitDegree.recommendCourses(semesterSelected, status, gpa, L1, L2,exempt));

            
            
            
        }
    }//GEN-LAST:event_recommendCourseListActionPerformed

    
    /** 
     * @param args[]
     */
    private void semester2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semester2ActionPerformed
        // TODO add your handling code here:
        semesterSelected = 2;
        gpaPanel.setVisible(true);
        exemptionPanel.setVisible(false);
        
        
    }//GEN-LAST:event_semester2ActionPerformed

    
    /** 
     * @param args[]
     */
    private void partTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_partTimeActionPerformed
        // TODO add your handling code here:
        status = "Part-time";
        
        
    }//GEN-LAST:event_partTimeActionPerformed

    
    /** 
     * @param args[]
     */
    private void exemptionYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exemptionYesActionPerformed
        // TODO add your handling code here:
        exempt = true;
    }//GEN-LAST:event_exemptionYesActionPerformed

    
    /** 
     * @param args[]
     */
    private void recommendCourseListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recommendCourseListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_recommendCourseListMouseClicked

    
    /** 
     * @param args[]
     */
    private void lessGpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lessGpaActionPerformed
        // TODO add your handling code here:
        gpa = 1.0;
    }//GEN-LAST:event_lessGpaActionPerformed

    
    /** 
     * @param args[]
     */
    private void moreGpaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moreGpaActionPerformed
        // TODO add your handling code here:
        gpa = 2.0;
    }//GEN-LAST:event_moreGpaActionPerformed

    
    /** 
     * @param args[]
     */
    private void exemptionNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exemptionNoActionPerformed
        // TODO add your handling code here:
        exempt = false;
    }//GEN-LAST:event_exemptionNoActionPerformed

    
    /** 
     * @param args[]
     */
    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        
        semester.clearSelection();
        studentStatus.clearSelection();
        exemptionChoice.clearSelection();
        gpaButtonGroup.clearSelection();
        degree.setSelectedIndex(0);
        result.setText("");
        gpaPanel.setVisible(false);
        exemptionPanel.setVisible(false);
        
    }//GEN-LAST:event_buttonResetActionPerformed

    
    /** 
     * @param args[]
     */
    private void recommendCourseListMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_recommendCourseListMousePressed
        // TODO add your handling code here:
   
    }//GEN-LAST:event_recommendCourseListMousePressed

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
            java.util.logging.Logger.getLogger(AdvisingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdvisingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdvisingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdvisingGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdvisingGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonReset;
    private javax.swing.JComboBox<String> degree;
    private javax.swing.ButtonGroup exemptionChoice;
    private javax.swing.JRadioButton exemptionNo;
    private javax.swing.JPanel exemptionPanel;
    private javax.swing.JRadioButton exemptionYes;
    private javax.swing.JRadioButton fullTime;
    private javax.swing.ButtonGroup gpaButtonGroup;
    private javax.swing.JPanel gpaPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton lessGpa;
    private javax.swing.JRadioButton moreGpa;
    private javax.swing.JRadioButton partTime;
    private javax.swing.JButton recommendCourseList;
    private javax.swing.JTextArea result;
    private javax.swing.ButtonGroup semester;
    private javax.swing.JRadioButton semester1;
    private javax.swing.JRadioButton semester2;
    private javax.swing.ButtonGroup studentStatus;
    // End of variables declaration//GEN-END:variables
}
