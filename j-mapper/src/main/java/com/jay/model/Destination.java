package com.jay.model;

import com.googlecode.jmapper.annotations.JMap;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Destination {

  @JMap
  private long id;

  @JMap("name")
  private String username;

  @JMap
  private String description;
}
