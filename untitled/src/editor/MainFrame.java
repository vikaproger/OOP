/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import functions.Function;
import functions.FunctionPoint;
import functions.FunctionPointIndexOutOfBoundsException;
import functions.InappropriateFunctionPointException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author LOZZA
 */
public class MainFrame extends javax.swing.JFrame {

    private ParametrsTabulatedFunction parametersDialog;
    private DocumentTabulatedFunction function;
    private JFileChooser fileChooser;
    private InputClassLoader loader;


    public MainFrame() {
        initComponents();
        parametersDialog = new ParametrsTabulatedFunction(this);
        function = new DocumentTabulatedFunction();
        loader = new InputClassLoader();
        fileChooser = new JFileChooser();
        function.newFunction(0, 10, 11);
        TabulatedFunctionTableModel tableModel = new TabulatedFunctionTableModel(function, this);
        TableFunction.setModel(tableModel);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TableScroll = new javax.swing.JScrollPane();
        TableFunction = new javax.swing.JTable();
        editX = new javax.swing.JTextField();
        editY = new javax.swing.JTextField();
        labelX = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        Add = new javax.swing.JButton();
        Delete = new javax.swing.JButton();
        MainMenu = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        New = new javax.swing.JMenuItem();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        SaveAs = new javax.swing.JMenuItem();
        Exit = new javax.swing.JMenuItem();
        Tabulated = new javax.swing.JMenu();
        TabulatedFunction = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TableFunction.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        TableScroll.setViewportView(TableFunction);

        editY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editYActionPerformed(evt);
            }
        });

        labelX.setText("New point x");

        labelY.setText("New point y");

        Add.setText("Add");
        Add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AddMouseClicked(evt);
            }
        });
        Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddActionPerformed(evt);
            }
        });

        Delete.setText("Delete");
        Delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeleteMouseClicked(evt);
            }
        });

        File.setText("File");
        File.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                FileMouseClicked(evt);
            }
        });

        New.setText("New");
        New.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NewMouseClicked(evt);
            }
        });
        New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewActionPerformed(evt);
            }
        });
        File.add(New);

        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        File.add(Open);

        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        File.add(Save);

        SaveAs.setText("Save as");
        SaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveAsActionPerformed(evt);
            }
        });
        File.add(SaveAs);

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        File.add(Exit);

        MainMenu.add(File);

        Tabulated.setText("Tabulate");

        TabulatedFunction.setText("Tabulate function");
        TabulatedFunction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TabulatedFunctionActionPerformed(evt);
            }
        });
        Tabulated.add(TabulatedFunction);

        MainMenu.add(Tabulated);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TableScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelX)
                    .addComponent(labelY))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editY, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editX, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(109, 109, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(TableScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(editX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelX))
                        .addGap(55, 55, 55))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Add)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Delete)
                            .addComponent(editY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelY))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        if (function.isFileNameAssigned()) {
            try {
                function.saveFunction();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        } else {
            SaveAsActionPerformed(evt);
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void editYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editYActionPerformed

    }//GEN-LAST:event_editYActionPerformed

    private void NewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NewMouseClicked
    }//GEN-LAST:event_NewMouseClicked

    private void FileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_FileMouseClicked
    }//GEN-LAST:event_FileMouseClicked

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AddMouseClicked

        try {
            double x = Double.parseDouble(editX.getText());
            double y = Double.parseDouble(editY.getText());
            function.addPoint(new FunctionPoint(x, y));
            TableFunction.revalidate();
            TableFunction.repaint();
        } catch (NumberFormatException | InappropriateFunctionPointException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }//GEN-LAST:event_AddMouseClicked

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewActionPerformed

        if (parametersDialog.showDialog() == parametersDialog.OK) {
            function.newFunction(parametersDialog.getLeftDomainBorder(), parametersDialog.getRightDomainBorder(), parametersDialog.getPointsCount());
            TableFunction.revalidate();
            TableFunction.repaint();
        }
    }//GEN-LAST:event_NewActionPerformed

    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveAsActionPerformed
        // TODO add your handling code here:
        if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String fileName = fileChooser.getSelectedFile().getAbsolutePath();
        try {
            function.saveFunctionAs(fileName);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
        TableFunction.revalidate();
        TableFunction.repaint();
    }//GEN-LAST:event_SaveAsActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // TODO add your handling code here:
        if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String fileName = fileChooser.getSelectedFile().getAbsolutePath();
        try {
            function.loadFunction(fileName);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        TableFunction.revalidate();
        TableFunction.repaint();
    }//GEN-LAST:event_OpenActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        if (function.isModified()) {
            if (JOptionPane.showOptionDialog(this, "Function is modified. Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes") == 0) {
                dispose();
            } else {
                return;
            }
        }
        dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (function.isModified()) {
            if (JOptionPane.showOptionDialog(this, "Function is modified. Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes") == 0) {
                dispose();
            } else {
                return;
            }
        }
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeleteMouseClicked
        // TODO add your handling code here:
        try {
            int index = TableFunction.getSelectedRow();

            function.deletePoint(index);
            TableFunction.revalidate();
            TableFunction.repaint();

        } catch (FunctionPointIndexOutOfBoundsException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        } catch (IllegalStateException exception) {
            JOptionPane.showMessageDialog(this, "Должно остаться минимум 2 точки в таблице");
        }

    }//GEN-LAST:event_DeleteMouseClicked

    private void TabulatedFunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TabulatedFunctionActionPerformed
        // TODO add your handling code here:
        if (fileChooser.showOpenDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        String fileName = fileChooser.getSelectedFile().getPath();

        try {
            Class functionClass = null;
            Function function = null;
            functionClass = loader.loadClassFromFile(fileName);
            function = (Function) functionClass.newInstance();
            if (parametersDialog.showDialog() == parametersDialog.CANCEL) {
                return;
            }
            this.function.tabulateFunction(function, parametersDialog.getLeftDomainBorder(), parametersDialog.getRightDomainBorder(), parametersDialog.getPointsCount());
            TableFunction.revalidate();
            TableFunction.repaint();
        } catch (InstantiationException e1) {
            JOptionPane.showMessageDialog(this, "Unable to create instance");
        } catch (IllegalAccessException e1) {
            JOptionPane.showMessageDialog(this, "Illegal access exception");
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(this, "IOException");
        } catch (ClassFormatError e1) {
            JOptionPane.showMessageDialog(this, "Указанный файл не является байт-кодом класса Java");
        }
    }//GEN-LAST:event_TabulatedFunctionActionPerformed

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AddActionPerformed

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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Add;
    private javax.swing.JButton Delete;
    private javax.swing.JMenuItem Exit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenuItem New;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Save;
    private javax.swing.JMenuItem SaveAs;
    private javax.swing.JTable TableFunction;
    private javax.swing.JScrollPane TableScroll;
    private javax.swing.JMenu Tabulated;
    private javax.swing.JMenuItem TabulatedFunction;
    private javax.swing.JTextField editX;
    private javax.swing.JTextField editY;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    // End of variables declaration//GEN-END:variables
}
