package com.jarogoose.taskmanager.summary;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
public class Task {

  @Id
  private long id;
  private String epic;
  private String story;
  private int pessimistic;
  private int optimistic;
  private String Descriptions;

  public Task(String epic, String story, int pessimistic, int optimistic, String descriptions) {
    this.id = System.currentTimeMillis();
    this.epic = epic;
    this.story = story;
    this.pessimistic = pessimistic;
    this.optimistic = optimistic;
    this.Descriptions = descriptions;
  }
}
