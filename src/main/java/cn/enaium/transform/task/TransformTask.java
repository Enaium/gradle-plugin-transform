package cn.enaium.transform.task;

import cn.enaium.transform.ITransform;
import cn.enaium.transform.TransformExtension;
import cn.enaium.transform.util.FileUtil;
import org.gradle.api.DefaultTask;

import java.io.File;

/**
 * Project: transform
 * Author: Enaium
 */
public class TransformTask extends DefaultTask {
    public TransformTask() {
        doLast(task -> {
            ITransform transform = this.getProject().getExtensions().getByType(TransformExtension.class).transform;
            File classes = new File(this.getProject().getBuildDir(), "classes");
            for (File file : new FileUtil().getFiles(classes)) {
                if (file.getName().endsWith(".class")) {
                    FileUtil.write(file, transform.transform(FileUtil.read(file)));
                }
            }
        });
    }
}