package com.brs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.brs.entity.Route;
import com.brs.exceptions.RouteNotFoundException;
import com.brs.repository.IRouteRepository;




@Service
@Transactional
public class RouteService implements IRouteService{

@Autowired
private IRouteRepository routeRepo;

    @Override
public Route addRoute(Route route) {
// TODO Auto-generated method stub
    Route newRoute = routeRepo.save(route);
System.out.println(newRoute+"******");
return newRoute;

}


@Override
public Route updateRoute(Route route) {
// TODO Auto-generated method stub
Route retrievedRoute = null;
try {
retrievedRoute = routeRepo.findById((long) route.getRouteId()).orElseThrow(RouteNotFoundException::new);
}
catch(Exception e){
e.printStackTrace();
}
retrievedRoute.setRouteId(route.getRouteId());
retrievedRoute.setRouteFrom(route.getRouteFrom());
retrievedRoute.setRouteTo(route.getRouteTo());
retrievedRoute.setDistance(route.getDistance());



Route updatedBooking = routeRepo.save(retrievedRoute);
return updatedBooking;
}


@Override
public Route viewRoute(long id) {
// TODO Auto-generated method stub
Route retVal=null;
try {
retVal = routeRepo.findById((long) id).orElseThrow(RouteNotFoundException::new);
} catch (RouteNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return retVal;

}


@Override
public Route deleteRoute(long id) {
// TODO Auto-generated method stub
Route retrVal = null;
try {
retrVal=routeRepo.findById((long) id).orElseThrow(RouteNotFoundException::new);
routeRepo.deleteById((long) id);

} catch (RouteNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
return retrVal;

}


@Override
public List<Route> viewAllRoute() {
// TODO Auto-generated method stub
List<Route> retVal = null;
retVal = routeRepo.findAll();
return retVal;
}


}