package io.eventuate.tram.quarkus.events.publisher;

import io.eventuate.tram.events.common.DomainEventNameMapping;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisherImpl;
import io.eventuate.tram.messaging.producer.MessageProducer;

import javax.enterprise.inject.Instance;
import javax.inject.Singleton;

@Singleton
public class TramEventsPublisherConfiguration {

  @Singleton
  public DomainEventPublisher domainEventPublisher(Instance<MessageProducer> messageProducer,
                                                   Instance<DomainEventNameMapping> domainEventNameMapping) {
    return new DomainEventPublisherImpl(messageProducer.get(), domainEventNameMapping.get());
  }
}
