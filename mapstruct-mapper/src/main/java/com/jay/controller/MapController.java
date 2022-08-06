package com.jay.controller;

import com.jay.mapper.SourceToDestinationMapper;
import com.jay.model.Destination;
import com.jay.model.Origin;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MapController {

  private final SourceToDestinationMapper sourceToDestinationMapper;

  @GetMapping("/")
  public void mapFields() {
    var origin = originBuilder();
    Destination destination = sourceToDestinationMapper.toDestination(origin);

    log.info("{}", destination);
  }

  private Origin originBuilder() {
    return Origin.builder()
        .originName("SourceName")
        .originDescription("SourceDescription")
        .build();
  }
}
