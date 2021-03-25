package cn.enaium.transform;

import cn.enaium.transform.task.TransformTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.tasks.TaskProvider;

/**
 * Project: transform
 * Author: Enaium
 */
public class TransformPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        project.getExtensions().create("transformExtend", TransformExtension.class);
        TaskProvider<TransformTask> transformTask = project.getTasks().register("transformTask", TransformTask.class, t -> t.setGroup("transform"));
        project.getTasks().getByName("compileJava").finalizedBy(transformTask);
    }
}
