package com.wingz.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.wingz.domain.Graph;
import com.wingz.domain.Station;
import com.wingz.domain.Step;

/**
 * Created by MMATUR on 14/10/2015.
 */
@RestController
@RequestMapping("/solve.json")
public class SolveController {


    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<List<Step>> solve(@RequestParam("begin") int begin, @RequestParam("end") int end,
            @RequestBody List<Station> stations) {

        return new ResponseEntity<>(new Graph(stations).solve(begin, end), HttpStatus.OK);

    }
}
