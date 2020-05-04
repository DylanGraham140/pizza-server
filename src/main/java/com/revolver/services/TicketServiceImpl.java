package com.revolver.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.revolver.entities.Ticket;
import com.revolver.repositories.PizzaRepository;
import com.revolver.repositories.TicketRepository;
import com.revolver.repositories.ToppingRepository;
import com.revolver.repositories.UserRepository;

@Component
@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	TicketRepository tr;

	@Autowired
	UserRepository ur;
	
	@Autowired
	PizzaRepository pr;
	
	@Autowired
	ToppingRepository tor;

	@Override
	public Ticket createTicket(Ticket ticket) {
		if (ticket.getStatus() == null) {
			ticket.setStatus("pending");
		}
		System.out.println(ticket.getPizzas());
		return tr.save(ticket);
		
	}

	@Override
	public Set<Ticket> findTicketByUsername(String username) {
		return ur.findByUsername(username).getTickets();
	}
	
	
}
