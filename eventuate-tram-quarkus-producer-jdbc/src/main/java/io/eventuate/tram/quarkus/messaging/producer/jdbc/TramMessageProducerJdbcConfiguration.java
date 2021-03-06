package io.eventuate.tram.quarkus.messaging.producer.jdbc;

import io.eventuate.common.id.IdGenerator;
import io.eventuate.common.jdbc.EventuateCommonJdbcOperations;
import io.eventuate.common.jdbc.EventuateSchema;
import io.eventuate.tram.messaging.producer.common.MessageProducerImplementation;
import io.eventuate.tram.messaging.producer.jdbc.MessageProducerJdbcImpl;

import javax.inject.Singleton;

@Singleton
public class TramMessageProducerJdbcConfiguration {

  @Singleton
  public MessageProducerImplementation messageProducerImplementation(EventuateCommonJdbcOperations eventuateCommonJdbcOperations,
                                                                     IdGenerator idGenerator,
                                                                     EventuateSchema eventuateSchema) {
    return new MessageProducerJdbcImpl(eventuateCommonJdbcOperations,
            idGenerator,
            eventuateSchema);
  }
}
