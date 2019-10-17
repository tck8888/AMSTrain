package com.tck.asm.hello;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/**
 * description:</br>
 * created on: 2019/10/17 19:37</br>
 *
 * @author tck
 * @version 1.0
 */
public class AddFieldVisitor extends ClassVisitor {
    public AddFieldVisitor(int api) {
        super(api);
    }

    public AddFieldVisitor(int api, ClassVisitor classVisitor) {
        super(api, classVisitor);
    }


    @Override
    public void visitEnd() {
        super.visitEnd();
        FieldVisitor fv1 = cv.visitField(Opcodes.ACC_PUBLIC, "xyzffff", "Ljava/lang/String;", null, null);
        if (fv1 != null) fv1.visitEnd();
        FieldVisitor fv2 = cv.visitField(Opcodes.ACC_PRIVATE, "xyz", "I", null, null);
        if (fv2 != null) fv2.visitEnd();
    }
}
