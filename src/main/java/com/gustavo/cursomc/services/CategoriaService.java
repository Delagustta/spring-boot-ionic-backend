package com.gustavo.cursomc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.dto.CategoriaDTO;
import com.gustavo.cursomc.repositories.CategoriaRepository;
import com.gustavo.cursomc.services.exceptions.DataIntegrityException;
import com.gustavo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	

	public Categoria find(Integer id) {
		Categoria obj = repo.findOne(id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName());
		}
		return obj;
	}
	
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);   // Setando inicialmente o id como null garante que esta é uma nova categoria e não uma atualização 
		return repo.save(obj);
	}
	
	
	public Categoria update(Categoria obj) {
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		newObj.setNome(obj.getNome());
	}
	
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.delete(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos!");
		}
		
	}
	
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String oderBy, String direction){
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), oderBy);
		return repo.findAll(pageRequest);
	}
	
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}
	

}
