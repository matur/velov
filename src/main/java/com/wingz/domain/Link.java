package com.wingz.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MMATUR on 14/10/2015.
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Link {

    @JsonProperty
    private int id;

    @JsonProperty
    private double distance;
}
