package com.brs.controller;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.service.IRouteService;



@RestController
@RequestMapping(path="/route")
public class RouteController {
@Autowired
private IRouteService iRouteService;
@PostMapping("addRoute")
public ResponseEntity<Route> addRoute(@Valid@RequestBody Route route){
Route addRoute= iRouteService.addRoute(route);
    return new ResponseEntity<Route>(addRoute, HttpStatus.OK);
}

@PutMapping("updateRoute")
public ResponseEntity<Route> updateRoute(@Valid@RequestBody Route route) throws RouteNotFoundException {
return new ResponseEntity<Route>(iRouteService.updateRoute(route), HttpStatus.OK);
}

@DeleteMapping("deleteRoute/{id}")
public ResponseEntity<Route> deleteRoute(@PathVariable("id") long routeId) throws RouteNotFoundException{
return new ResponseEntity<Route>(iRouteService.deleteRoute(routeId),HttpStatus.OK);

}

@GetMapping("view/{id}")
public ResponseEntity<Route> getRouteById(@PathVariable("id") long routeId) throws RouteNotFoundException{
return new ResponseEntity<Route>(iRouteService.viewRoute(routeId) , HttpStatus.OK);
}

@GetMapping("viewAllRoute")
public ResponseEntity <List<Route>>getAllRoute(){
return new ResponseEntity<List<Route>>(iRouteService.viewAllRoute(), HttpStatus.OK);
}
}
