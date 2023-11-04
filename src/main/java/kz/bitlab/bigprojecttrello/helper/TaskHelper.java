package kz.bitlab.bigprojecttrello.helper;

import kz.bitlab.bigprojecttrello.model.TaskStatus;
import org.springframework.stereotype.Component;

@Component("taskHelper")
public class TaskHelper {

    public String getClassNameByStatus(TaskStatus taskStatus){
        if(TaskStatus.DONE.equals(taskStatus)){
            return "text-success";
        }else if(TaskStatus.TODO.equals(taskStatus)){
            return "text-primary";
        }else if (TaskStatus.INTEST.equals(taskStatus)){
            return "text-warning";
        }else if(TaskStatus.FAILED.equals(taskStatus)){
            return "text-danger";
        }else {
            return "";
        }
    }
}
