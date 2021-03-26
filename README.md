# Transform

## Install 

```groovy
plugins {
    id "cn.enaium.transform" version "1.1"
}

dependencies {
    compileClasspath('cn.enaium:transform:1.1')
}
```

or

```groovy
buildscript {
  repositories {
    maven {
      url "https://plugins.gradle.org/m2/"
    }
  }
  dependencies {
    classpath "cn.enaium:transform:1.1"
  }
}

apply plugin: "cn.enaium.transform"
```

## Example

```groovy
transformExtend {
    transform = new ITransform() {
        @Override
        byte[] transform(byte[] basic) {
            ClassReader classReader = new ClassReader(basic)
            ClassWriter classWriter = new ClassWriter(0);
            classReader.accept(new ClassVisitor(Opcodes.ASM5, classWriter) {
                @Override
                void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
                    println name
                    super.visit(version, access, name, signature, superName, interfaces)
                }
            }, 0)
            return classWriter.toByteArray()
        }
    }
}

compileJava.finalizedBy(transformTask)
```