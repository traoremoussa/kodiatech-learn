package dao;

import model.Task;

import java.util.List;

public interface ITaskDAO {
    public void saveTask();
   public void updateTask();
        public void deleteTask();
    public Task getTaskById();
    public List<Task>getAllTask();
}
