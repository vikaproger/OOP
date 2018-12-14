
package editor;

import functions.Function;
import functions.FunctionPoint;
import functions.FunctionPointIndexOutOfBoundsException;
import functions.InappropriateFunctionPointException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
    }

    private void editYActionPerformed(java.awt.event.ActionEvent evt) {}

    private void NewMouseClicked(java.awt.event.MouseEvent evt) {}

    private void FileMouseClicked(java.awt.event.MouseEvent evt) {}

    private void AddMouseClicked(java.awt.event.MouseEvent evt) {
        try {
            double x = Double.parseDouble(editX.getText());
            double y = Double.parseDouble(editY.getText());
            function.addPoint(new FunctionPoint(x, y));
            TableFunction.revalidate();
            TableFunction.repaint();
        } catch (NumberFormatException | InappropriateFunctionPointException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }

    private void NewActionPerformed(java.awt.event.ActionEvent evt) {
        if (parametersDialog.showDialog() == parametersDialog.OK) {
            function.newFunction(parametersDialog.getLeftDomainBorder(), parametersDialog.getRightDomainBorder(), parametersDialog.getPointsCount());
            TableFunction.revalidate();
            TableFunction.repaint();
        }
    }

    private void SaveAsActionPerformed(java.awt.event.ActionEvent evt) {

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
    }

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {
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
    }

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {
        if (function.isModified()) {
            if (JOptionPane.showOptionDialog(this, "Function is modified. Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes") == 0) {
                dispose();
            } else {
                return;
            }
        }
        dispose();
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        if (function.isModified()) {
            if (JOptionPane.showOptionDialog(this, "Function is modified. Are you sure you want to exit?", "Exit", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{"Yes", "No"}, "Yes") == 0) {
                dispose();
            } else {
                return;
            }
        }
        dispose();
    }

    private void DeleteMouseClicked(java.awt.event.MouseEvent evt) {
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

    }

    private void TabulatedFunctionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TabulatedFunctionActionPerformed

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
    }

    private void AddActionPerformed(java.awt.event.ActionEvent evt) {}


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }


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

}
