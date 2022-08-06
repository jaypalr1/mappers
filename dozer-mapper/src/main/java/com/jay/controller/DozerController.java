package com.jay.controller;

import com.jay.model.Destination;
import com.jay.model.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DozerController {

  private final DozerBeanMapper dozerBeanMapper;

  @GetMapping("/")
  public void dozer() {
    Destination dest = dozerBeanMapper.map(sourceBuilder(), Destination.class);
    log.info("{}", dest);
  }

  //Did not get value
  @GetMapping("/custom-api")
  public void customMapping() {
    BeanMappingBuilder builder = new BeanMappingBuilder() {
      @Override
      protected void configure() {
        mapping(Source.class, Destination.class)
            .fields("name", "name")
            .fields("description", "description");
      }
    };

    var res = builder.build().getClassMaps().get(0).getFieldMaps();
    System.out.println(res.get(0).getDestFieldName());

  }

  private Source sourceBuilder() {
    return Source.builder()
        .name("SourceName")
        .description("SourceDescription")
        .build();
  }
}
