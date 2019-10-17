package com.tck.asm.hello;


import org.apache.commons.io.FileUtils;
import org.objectweb.asm.*;

import java.io.File;
import java.io.IOException;

import static org.objectweb.asm.Opcodes.ASM5;

/**
 * description:</br>
 * created on: 2019/10/17 18:42</br>
 *
 * @author tck
 * @version 1.0
 */
public class Hello {

    public static void main(String[] args) throws Exception {

        File targetFile = new File("D:\\java_project\\ASMTrain\\build\\classes\\java\\main\\com\\tck\\asm\\hello\\Receiver.class");
        byte[] bytes = FileUtils.readFileToByteArray(targetFile);
        ClassReader cr = new ClassReader(bytes);
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new AddFieldVisitor(ASM5, cw);

        cr.accept(cv, ClassReader.SKIP_CODE | ClassReader.SKIP_DEBUG);
        byte[] bytes1 = cw.toByteArray();
        FileUtils.writeByteArrayToFile(targetFile, bytes1);

    }
}
