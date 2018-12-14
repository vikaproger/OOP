
package editor;

import functions.InappropriateFunctionPointException;
import functions.TabulatedFunction;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TabulatedFunctionTableModel extends DefaultTableModel {

    private TabulatedFunction function;
    private Component parent;

    public TabulatedFunctionTableModel(TabulatedFunction function, Component parent) {
        this.function = function;
        this.parent = parent;
    }


    public int getRowCount() {
        if (function != null) {
            return function.getPointsCount();
        } else {
            return 0;
        }
    }


    public int getColumnCount() {
        return 2;
    }

    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "x";
            case 1:
                return "y";
            default:
                return "Undefined";
        }
    }

    public Class getColumnClass(int columnIndex) {
        return Double.class;
    }

    public boolean isCellEditable(int row, int column) {
        return row <= this.getRowCount() && column <= this.getColumnCount();
    }

    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return function.getPointX(row);
            case 1:
                return function.getPointY(row);
            default:
                return null;
        }
    }


    public void setValueAt(Object aValue, int row, int column) {
        switch (column) {
            case 0:
                try {
                    function.setPointX(row, (Double) aValue);
                } catch (InappropriateFunctionPointException e) {
                    JOptionPane.showMessageDialog(parent, e.getMessage());
                }
                break;
            case 1:
                function.setPointY(row, (Double) aValue);
        }
    }
}
