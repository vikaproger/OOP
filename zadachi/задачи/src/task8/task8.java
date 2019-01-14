package task8;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class task8 {
    public static void main(String[] args) {
        final JFrame frame = new JFrame();              //создаем форму
        frame.setTitle("ООП Экзамен");                  //устанавливаем название формы
        frame.setSize(200, 100);            //размеры
        frame.setResizable(false);                          //чтобы нельзя было изменить
        JButton okButton = new JButton("ОК");       //создаем кнопку
        okButton.setSize(100,50);           //устанавливаем размеры
        okButton.addActionListener(new ActionListener(){        //обработчик события
            @Override
            public void actionPerformed(ActionEvent event){
                frame.dispose();
            }       //при нажатии на нее форма закрывается
        });
        frame.add(okButton);        //добавляем кнопку
        frame.setVisible(true);         //делаем ее видимой
    }
}
