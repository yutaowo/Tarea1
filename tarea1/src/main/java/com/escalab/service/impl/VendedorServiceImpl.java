package com.escalab.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.escalab.model.Vendedor;
import com.escalab.repo.IVendedorRepo;
import com.escalab.service.IVendedorService;

@Service
public class VendedorServiceImpl implements IVendedorService {
	
	@Autowired
	private IVendedorRepo repo;

	@Override
	public Vendedor registrar(Vendedor vend) {
		return repo.save(vend);
	}

	@Override
	public Vendedor modificar(Vendedor vend) {
		return repo.save(vend);
	}

	@Override
	public List<Vendedor> listar() {
		return repo.findAll();
	}

	@Override
	public Vendedor leerPorId(Integer id) {
		Optional<Vendedor> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Vendedor();
	}

	@Override
	public boolean eliminar(Integer id) {
		repo.deleteById(id);
		return true;
	}

	@Override
	public Page<Vendedor> listarPageable(Pageable pageable) {
		return repo.findAll(pageable);
	}
}
