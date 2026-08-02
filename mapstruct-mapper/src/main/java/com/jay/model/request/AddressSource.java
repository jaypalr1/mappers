package com.jay.model.request;

import lombok.Builder;

@Builder
public record AddressSource(
    String street,

    String city,

    AddressChildSource addressChildSource
) {

}
