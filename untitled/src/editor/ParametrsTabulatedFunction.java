
package editor;

import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;


public class ParametrsTabulatedFunction extends javax.swing.JDialog {


    public ParametrsTabulatedFunction(java.awt.Frame parent, boolean modal) {
        super(parent, modal); // конструктор формы окна

        initComponents(); // инициализирование компонентов
    }


    public final int OK = 1;


    public final int CANCEL = 0;

    private double leftDomainBorder, rightDomainBorder;
    private int pointsCount;

    int state = CANCEL;

    public ParametrsTabulatedFunction(MainFrame aThis) {
        super(aThis);
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LeftDomainBorderInput = new javax.swing.JTextField(); // тектовое поле, чтоы ввести
        RightDomainBorderInput = new javax.swing.JTextField();
        PointsCountInput = new javax.swing.JSpinner(); // спиннер
        LeftDomainBorder = new javax.swing.JLabel(); // надпись на экране
        RightDomainBorder = new javax.swing.JLabel();
        PointCount = new javax.swing.JLabel();
        OKButton = new javax.swing.JButton(); //добавляем кнопку
        CancelButton = new javax.swing.JButton();

        setModal(true); // делаем окно модальным
        setResizable(false); //блокирует работу пользователся
        addWindowListener(new java.awt.event.WindowAdapter() {  // создаю окно
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        LeftDomainBorderInput.setText("0");  // изначальное значение границы
        LeftDomainBorderInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeftDomainBorderInputActionPerformed(evt);
            }
        });

        RightDomainBorderInput.setText("10");

        PointsCountInput.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(2), Integer.valueOf(2), null, Integer.valueOf(1)));

        LeftDomainBorder.setText("Left domain border");

        RightDomainBorder.setText("Right domain border");

        PointCount.setText("Points count");

        OKButton.setText("OK");
        OKButton.addMouseListener(new java.awt.event.MouseAdapter() { // реакция на мышку
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                OKButtonMouseClicked(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LeftDomainBorder)
                            .addComponent(RightDomainBorder)
                            .addComponent(PointCount))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(RightDomainBorderInput)
                            .addComponent(LeftDomainBorderInput)
                            .addComponent(PointsCountInput, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                        .addGap(46, 46, 46))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(CancelButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(OKButton)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LeftDomainBorderInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LeftDomainBorder))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RightDomainBorderInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RightDomainBorder))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PointsCountInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PointCount))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(OKButton)
                    .addComponent(CancelButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OKButtonMouseClicked(java.awt.event.MouseEvent evt) {   // одобряет и изчезает
        try {
            leftDomainBorder = Double.parseDouble(LeftDomainBorderInput.getText());
            rightDomainBorder = Double.parseDouble(RightDomainBorderInput.getText());
            pointsCount = (int) PointsCountInput.getValue();
            state = OK;
            this.setVisible(false);
        } catch (NumberFormatException exception) {
            JOptionPane.showMessageDialog(this, exception.getMessage());
        }
    }

    private void CancelButtonMouseClicked(java.awt.event.MouseEvent evt) {

        state = CANCEL;
        this.setVisible(false);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        state = CANCEL;
    }

    private void LeftDomainBorderInputActionPerformed(java.awt.event.ActionEvent evt) {
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
