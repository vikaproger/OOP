/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import functions.InappropriateFunctionPointException;
import functions.TabulatedFunction;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LOZZA
 */
public class TabulatedFunctionTableModel extends DefaultTableModel {

    private TabulatedFunction function;
    private Component parent;

    public TabulatedFunctionTableModel(TabulatedFunction function, Component parent) {  // конструкто таблицы
        this.function = function;
        this.parent = parent;
    }


    public int getRowCount() {  //количество точек
        if (function != null) {
            return function.getPointsCount();
        } else {
            return 0;
        }
    }

    public int getColumnCount() {
        return 2;
    }  // количество столбцов

    public String getColumnName(int column) { // возвращает номер столбца по номеру
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


    public boolean isCellEditable(int row, int column) { // можно ли редактировать ячейку или нет
        return row <= this.getRowCount() && column <= this.getColumnCount();
    }


    public Object getValueAt(int row, int column) { //берет значение указанной ячейки
        switch (column) {
            case 0:
                return function.getPointX(row);
            case 1:
                return function.getPointY(row);
            default:
                return null;
        }
    }


    public void setValueAt(Object aValue, int row, int column) { // меняет значение указанной ячейки
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
