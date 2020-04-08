package com.example.springboot.productb.service;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.productb.client.creditCustomer;
import com.example.springboot.productb.client.customerCust;
import com.example.springboot.productb.dto.bankCreditDto;
import com.example.springboot.productb.dto.customerDto;
import com.example.springboot.productb.model.bankProduct;
import com.example.springboot.productb.repository.IBankProductRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class IBankProductServiceImpl implements IBankProductService {

	private static final Logger log = LoggerFactory.getLogger(IBankProductServiceImpl.class);

	@Autowired
	private IBankProductRepository repository;

	@Autowired
	private customerCust ccustomer;

	@Autowired
	private creditCustomer ccredito;

	@Override
	public Flux<bankProduct> findAll() {
		return repository.findAll();
	}

	@Override
	public Mono<bankProduct> findById(String id) {
		return repository.findById(id);
	}

	@Override
	public Mono<bankProduct> save(bankProduct bp) {

		return repository.save(bp);
	}

	@Override
	public Mono<bankProduct> update(bankProduct bp, String id) {
		return repository.findById(id).flatMap(b -> {
			// Fecha joinAt
			if (bp.getJointAt() == null) {
				b.setJointAt(new Date());
			} else {
				b.setJointAt(bp.getJointAt());
			}
			// Fecha updateAt
			if (bp.getUpdateAt() == null) {
				b.setUpdateAt(new Date());
			} else {
				b.setUpdateAt(bp.getUpdateAt());
			}

			// Bank
			if (bp.getBank() == null) {
				b.setBank(b.getBank());
			} else {
				b.setBank(bp.getBank());
			}
			// ProductName
			if (bp.getProductName() == null) {
				b.setProductName(b.getProductName());
			} else {
				b.setProductName(bp.getProductName());
			}

			// Type
			if (bp.getClientType() == null) {
				b.setClientType(b.getClientType());
			} else {
				b.setClientType(bp.getClientType());
			}
			// NumAccount
			if (bp.getNumAccount() == null) {
				b.setNumAccount(b.getNumAccount());
			} else {
				b.setNumAccount(bp.getNumAccount());
			}
			// NameOwner
			if (bp.getNameOwner() == null) {
				b.setNameOwner(b.getNameOwner());
			} else {
				b.setNameOwner(bp.getNameOwner());
			}
			// NumDoc
			if (bp.getNumDoc() == null) {
				b.setNumDoc(b.getNumDoc());
			} else {
				b.setNumDoc(bp.getNumDoc());
			}
			// Amount
			if (bp.getAmount() == null) {
				b.setAmount(b.getAmount());
			} else {
				b.setAmount(bp.getAmount());
			}

			// nuevo campo amountAvailable
			if (bp.getAmountAvailable() == null) {
				b.setAmountAvailable(b.getAmountAvailable());
			} else {
				b.setAmountAvailable(bp.getAmountAvailable());
			}

			return repository.save(b);
		});
	}

	@Override
	public Mono<Void> delete(bankProduct bp) {
		return repository.delete(bp);
	}

	// -------------------------------------->
	// Métodos del cliente Client
	@Override
	public Flux<customerDto> findAllClients() {
		return ccustomer.fillAllCustomer();
	}

	@Override
	public Mono<customerDto> createById(String id) {
		return ccustomer.createById(id);
	}

	@Override
	public Mono<customerDto> updateBank(String bank, String id) {
		return ccustomer.createById(id).flatMap(c -> {
			if (c.getBank() == null) {
				c.setBank(c.getBank());
			} else {
				c.setBank(bank);
			}

			return ccustomer.save(c);
		});
	}

	// ---------------------------------------->
	// Métodos propios

	// ---------------------Buscar_Por_NumDoc
	@Override
	public Mono<bankProduct> findByNumDoc(String numDoc) {

		return repository.findByNumDoc(numDoc);
	}

	
	// ---------------------Buscar_por_Tipo
	@Override
	public Flux<bankProduct> findByType(String clientType) {

		return repository.findByType(clientType);
	}

	
	// -------------------Buscar_por_Banco
	@Override
	public Flux<bankProduct> findByBank(String bank) {
		return repository.findByBank(bank);
	}

	
	// ------------------- Buscar por número de cuenta
	@Override
	public Mono<bankProduct> findByNumAccount(String numAccount) {
		return repository.findByNumAccount(numAccount);
	}

	
	// ------------------ Depositar
	@Override
	public Mono<bankProduct> depositB(Double amount, String numAccount) {
		return repository.findByNumAccount(numAccount).flatMap(b -> {
			if ((b.getAmountAvailable() + amount) > b.getAmount()) {
				return Mono.error(new InterruptedException("No se puede superar el límiete"));
			} else {
				b.setAmountAvailable(b.getAmountAvailable() + amount);

				return repository.save(b);
			}
		});
	}

	
	// ------------------ Retirar
	@Override
	public Mono<bankProduct> retiroB(Double amount, String numAccount) {
		return repository.findByNumAccount(numAccount).flatMap(b -> {
			if (amount > b.getAmountAvailable()) {
				return Mono.error(new InterruptedException("No puede retirar un monto superior al total."));
			} else if (amount > b.getAmountAvailable()) {
				return Mono.error(new InterruptedException("No puede retirar un monto superior al disponible."));
			} else {
				b.setAmountAvailable(b.getAmountAvailable() - amount);

				return repository.save(b);
			}
		});
	}


	// Métodos del cliente Crédito
	
	@Override
	public Mono<bankCreditDto> depositC(Double amount, String numAccountC, String numAccountB) {

		return repository.findByNumAccount(numAccountB).flatMap(b -> {

			b.setAmountAvailable(b.getAmountAvailable() - amount);

			repository.save(b).subscribe();

			log.info(b.getAmountAvailable().toString());

			return ccredito.depositC(amount, numAccountC);
		});
	}

	@Override
	public Mono<bankCreditDto> retiroC(Double amount, String numAccountC, String numAccountB) {

		return repository.findByNumAccount(numAccountB).flatMap(b -> {
			b.setAmountAvailable(b.getAmountAvailable() + amount);

			repository.save(b).subscribe();

			log.info(b.getAmountAvailable().toString());

			return ccredito.retiroC(amount, numAccountC);
		});
	}

}
