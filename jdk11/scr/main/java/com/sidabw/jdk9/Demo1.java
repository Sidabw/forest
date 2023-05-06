package com.sidabw.jdk9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author shaogz 2023/5/6 14:46
 */
public class Demo1 {

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream f1= null;
        try {
            f1 = new FileInputStream("");
            int read = f1.read();
            System.out.println(read);
        } catch (IOException e) {
        } finally {
            try {
                if (f1 != null)
                    f1.close();
            } catch (Exception e) {}
        }

        //jdk1.7提供的try-with-resource，不用手动关闭资源了
        try (FileInputStream f = new FileInputStream("")){
            int read = f.read();
            System.out.println(read);
        } catch (IOException e) {

        }

        //jdk1.9提供的另一种写法
        FileInputStream f = new FileInputStream("");
        try(f) {

        } catch (IOException e) {

        }

    }
}
