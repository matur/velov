package com.wingz.domain;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * Created by MMATUR on 14JsonIdentityInfo/10/2015.
 */
@Getter
@Setter
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
public class Station implements Comparable<Station> {

    @JsonProperty
    private Integer id;

    @JsonProperty
    private String name;

    @JsonProperty
    private List<Link> links;

    @JsonProperty
    private String longitude;

    @JsonProperty
    private String latitude;

    private double minDistance = Double.POSITIVE_INFINITY;

    public Station previousStation;

    @Override
    public int compareTo(Station other) {
        return Double.compare(minDistance, other.minDistance);
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
