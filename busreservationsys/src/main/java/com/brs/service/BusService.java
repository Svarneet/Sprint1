package com.brs.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.brs.exceptions.BusNotFoundException;
import com.brs.entity.Bus;
import com.brs.repository.IBusRepository;
@Service
@Transactional
public class BusService implements IBusService{
@Autowired
	private IBusRepository busrepo;
	@Override
	public Bus addBus(Bus bus) {
		return busrepo.save(bus);
	}
	@Override
	public Bus updateBus(Bus bus) {
		Bus updateBus=null;
		try {
				updateBus=busrepo.findById(bus.getBusId()).orElseThrow(BusNotFoundException::new );
			
		}catch(BusNotFoundException e){
			
			e.printStackTrace();
		}
		updateBus.setBusId(bus.getBusId());
		updateBus.setBusName(bus.getBusName());
		updateBus.setDriverName(bus.getDriverName());
		updateBus.setBusType(bus.getBusType());
		updateBus.setRouteFrom(bus.getRouteFrom());
		updateBus.setRouteTo(bus.getRouteTo());
		updateBus.setArrivalTime(bus.getArrivalTime());
		updateBus.setDepartureTime(bus.getDepartureTime());
		updateBus.setSeats(bus.getSeats());
		updateBus.setAvaiableSeats(bus.getAvaiableSeats());
		return busrepo.save(updateBus);
	}
	@Override
	public Bus deleteBus(int busId)  {
		Bus bus=null;
		try {
			bus=busrepo.findById(busId).orElseThrow(BusNotFoundException::new);
			busrepo.delete(bus);
		} catch (BusNotFoundException e) {
			e.printStackTrace();
		}
		return bus;
	}
	@Override
	public Bus viewBus(int busId) throws BusNotFoundException{
		Bus b=null;
		try {
			b=busrepo.findById(busId).orElseThrow(BusNotFoundException::new);
		}catch(BusNotFoundException e){
			e.printStackTrace();
		}
		return b;
	}
	@Override
	public List<Bus> viewBusByType(String busType) throws BusNotFoundException{
		
		 
		/*
		 * try { Bus b=busrepo.findOne(busType). }catch(BusNotFoundException e){
		 * e.printStackTrace(); } return b;
		 */
		 
		return null;
	}
	@Override
	public List<Bus> viewAllBus() {
		
		return busrepo.findAll();
	}
}