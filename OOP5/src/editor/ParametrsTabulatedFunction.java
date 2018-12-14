package editor;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

public class ParametrsTabulatedFunction  extends javax.swing.JDialog{

    public ParametrsTabulatedFunction(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();
    }

    public final int OK = 1;
    public final int CANCEL = 0;

    private double leftDomainBorder, rightDomainBorder;
    private int pointsCount;

    int state = CANCEL;

    ParametrsTabulatedFunction(MainFrame aThis) {
        super(aThis);
        initComponents();
    }
    private void OKButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_OKButtonMouseClicked

        try {
            leftDomainBorder = Double.parseDouble(LeftDomainBorderInput.getText());
            rightDomainBorder = Double.parseDouble(RightDomainBorderInput.getText());
            pointsCount = (int) PointsCountInput.getValue();
            state = OK;
            this.setVisible(false);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }//GEN-LAST:event_OKButtonMouseClicked

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelButtonMouseClicked

        state = CANCEL;
        this.setVisible(false);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        state = CANCEL;
    }
    private void LeftDomainBorderInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeftDomainBorderInputActionPerformed

    }

    public int showDialog() {
        this.setVisible(true);
        return state;
    }

    public double getLeftDomainBorder() {
        return leftDomainBorder;
    }

    public double getRightDomainBorder() {
        return rightDomainBorder;
    }

    public int getPointsCount() {
        return pointsCount;
    }

    private javax.swing.JButton CancelButton;
    private javax.swing.JLabel LeftDomainBorder;
    private javax.swing.JTextField LeftDomainBorderInput;
    private javax.swing.JButton OKButton;
    private javax.swing.JLabel PointCount;
    private javax.swing.JSpinner PointsCountInput;
    private javax.swing.JLabel RightDomainBorder;
    private javax.swing.JTextField RightDomainBorderInput;
}
