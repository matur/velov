package com.wingz.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Created by MMATUR on 15/10/2015.
 */
public class Graph {

    private List<Station> stations;

    public Graph(List<Station> stations) {
        this.stations = stations;
    }

    public Station getStation(final int id) throws NoSuchElementException {
        return stations.stream().filter(o -> o.getId().equals(id)).findFirst().get();
    }

    public List<Step> solve(int begin, int end) throws NoSuchElementException {
        computePaths(getStation(begin));
        return getShortestPathTo(getStation(end));
    }

    private void computePaths(Station sourceStation) {
        sourceStation.setMinDistance(0);
        PriorityQueue<Station> stepsQueue = new PriorityQueue<>();
        stepsQueue.add(sourceStation);

        while (!stepsQueue.isEmpty()) {
            Station station = stepsQueue.poll();
            // Visit each link exiting station
            for (Link l : station.getLinks()) {
                Station s = getStation(l.getId());
                double distanceThroughStation = station.getMinDistance() + l.getDistance();
                if (distanceThroughStation < s.getMinDistance()) {
                    stepsQueue.remove(s);
                    s.setMinDistance(distanceThroughStation);
                    s.setPreviousStation(station);
                    stepsQueue.add(s);
                }
            }
        }
    }

    private static List<Step> getShortestPathTo(Station target) {
        List<Step> steps = new ArrayList<>();
        for (Station s = target; s != null; s = s.getPreviousStation()) {
            double diff = (s.getPreviousStation() == null) ? 0 : s.getPreviousStation().getMinDistance();
            steps.add(new Step(s.getId(), s.getMinDistance() - diff, s.getMinDistance()));
        }
        Collections.reverse(steps);
        return steps;
    }
}


