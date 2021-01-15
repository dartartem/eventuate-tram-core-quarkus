package io.eventuate.tram.quarkus.commands;

import io.eventuate.tram.commands.consumer.CommandDispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;

@ApplicationScoped
public class CommandDispatcherInitializer {
  private Logger logger = LoggerFactory.getLogger(getClass());

  @Inject
  Instance<CommandDispatcher> commandDispatchers;

  @PostConstruct
  public void init() {
    logger.info("initializing command dispatchers");
    commandDispatchers.stream().forEach(CommandDispatcher::initialize);
    logger.info("initialized command dispatchers");
  }
}
