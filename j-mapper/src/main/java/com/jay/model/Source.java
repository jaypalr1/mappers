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
public class Source {

  @JMap
  private long id;

  @JMap("username")
  private String name;

  @JMap
  private String email;

  @JMap
  private String description;
}
