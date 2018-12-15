/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package editor;

import java.io.FileInputStream;
import java.io.IOException;


public class InputClassLoader extends ClassLoader {

    public Class loadClassFromFile(String fileName) throws IOException { //открытие класса из файла
        byte[] b = loadClassData(fileName);
        return defineClass(null, b, 0, b.length);
    }

    private byte[] loadClassData(String filename) throws IOException {  // открывает данные класса
        FileInputStream in = new FileInputStream(filename);
        byte[] fileContent = new byte[in.available()];
        in.read(fileContent);
        in.close();
        return fileContent;
    }

}
