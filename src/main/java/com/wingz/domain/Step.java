package com.wingz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by MMATUR on 14/10/2015.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Step {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private double distance;

    @JsonProperty("distance_from_begining")
    private double distanceFromBegining;

}
