package com.jay.controller;

import com.jay.mapper.SourceToDestinationMapper;
import com.jay.model.request.AddressChildSource;
import com.jay.model.request.AddressSource;
import com.jay.model.request.Source;
import com.jay.model.response.TargetResponseDto;
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

    TargetResponseDto targetResponseDto = sourceToDestinationMapper.toTargetResponse(origin);

    log.info("{}", targetResponseDto);
  }

  private Source originBuilder() {
    return Source.builder()
        .originName("SourceName")
        .originDescription("SourceDescription")
        .computedField(13)
        .address(addressBuilder())
        .build();
  }

  private AddressSource addressBuilder() {
    return AddressSource.builder()
        .street("Street")
        .city("City")
        .addressChildSource(addressChildSourceBuilder())
        .build();
  }

  private AddressChildSource addressChildSourceBuilder() {
    return AddressChildSource.builder()
        .userState("MH")
        .zipCode("12345")
        .build();
  }
}
