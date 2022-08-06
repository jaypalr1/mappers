package com.jay.controller;

import com.googlecode.jmapper.JMapper;
import com.googlecode.jmapper.api.JMapperAPI;
import com.jay.model.Destination;
import com.jay.model.Source;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JmapController {

  @GetMapping("/api")
  public void jMapApi() {
    JMapperAPI jmapperApi = new JMapperAPI()
        .add(JMapperAPI.mappedClass(Source.class)
            .add(JMapperAPI.attribute("id").value("id"))
            .add(JMapperAPI.attribute("username").value("email"))
            .add(JMapperAPI.attribute("description").value("description")));

    JMapper<Destination, Source> userMapper = new JMapper<>(Destination.class, Source.class,
        jmapperApi);

    Source user = new Source(1L, "name", "john@test.com", "description");

    log.info("{}", userMapper.getDestination(user));
  }

  @GetMapping("/annotation")
  public void jMapAnnotation() {
    JMapper<Destination, Source> userMapper = new JMapper<>(Destination.class, Source.class);

    Source user = new Source(1L, "sourceName", "john@test.com", "sourceDescription");

    log.info("{}", userMapper.getDestination(user));
  }
}
