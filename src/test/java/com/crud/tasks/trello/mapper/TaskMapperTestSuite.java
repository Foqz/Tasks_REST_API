package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMapperTestSuite {
    @Autowired
    private TaskMapper taskMapper;
    @Test
    public void mapToTaskTest(){
        //Given
        TaskDto taskDto = new TaskDto(1L,"title1","content1");
        //When
        Task task = taskMapper.mapToTask(taskDto);
        //Then
        assertEquals(1L,(long)task.getId());
        assertEquals("title1",task.getTitle());
        assertEquals("content1",task.getContent());
    }
    @Test
    public void mapToTaskDtoTest(){
        //Given
        Task task = new Task(2L,"title2","content2");
        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);
        //Then
        assertEquals(2L,(long)taskDto.getId());
        assertEquals("title2",taskDto.getTitle());
        assertEquals("content2",taskDto.getContent());
    }
    @Test
    public void mapToTaskDtoListTest(){
        //Given
        Task task = new Task(3L,"title3","content3");
        List<Task> tasks = new ArrayList<>();
        tasks.add(task);
        //When
        List<TaskDto> taskDtoList = taskMapper.mapToTaskDtoList(tasks);
        //Then
        assertEquals(1,taskDtoList.size());
        assertEquals(3L,(long)taskDtoList.get(0).getId());
        assertEquals("title3",taskDtoList.get(0).getTitle());
        assertEquals("content3",taskDtoList.get(0).getContent());
    }
}
