package com.jarogoose.taskmanager.summary;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * In charge of all operations which collects data about tasks.
 */
@RestController
@Slf4j
@CrossOrigin(origins = "http://localhost:4200")
public class SummaryController {

  //  private Logger logger = LoggerFactory.getLogger(SummaryController.class);
  private TaskRepository taskRepository;

  @Autowired
  public SummaryController(TaskRepository taskRepository) {
    this.taskRepository = taskRepository;
  }

  @GetMapping("/tasks")
  public List<Task> loadTasks() {
    return (List<Task>) taskRepository.findAll();
  }

  @PostMapping("/tasks")
  public void submitTask(@RequestBody() Task task) {
    taskRepository.save(task);
  }

  @RequestMapping("/")
  public String index() {
    log.trace("A TRACE Message");
    log.debug("A DEBUG Message");
    log.info("An INFO Message");
    log.warn("A WARN Message");
    log.error("An ERROR Message");

    return "Howdy! Check out the Logs to see the output...";
  }
}
