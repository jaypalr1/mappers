package com.jay.model.request;

import lombok.Builder;

@Builder
public record Source(

    String originName,

    String originDescription,

    int computedField,

    AddressSource address
) {

}
