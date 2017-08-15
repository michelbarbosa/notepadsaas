package br.com.fiap.notepadsaas.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import br.com.fiap.notepadsaas.model.Nota;
import br.com.fiap.notepadsaas.repository.NotaRepository;

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
public class NotaController {
	private NotaRepository notaRepository;

	public NotaController(NotaRepository notaRepository) {
		this.notaRepository = notaRepository;
	}
	
	@GetMapping
	public List<Nota> findAll() {
		return notaRepository.findAll();
	}

	@GetMapping(value = "/titulo/{titulo}")
	private List<Nota> findByTitulo(@PathVariable(value = "titulo") String titulo) {
		return notaRepository.findByTitulo(titulo);
	}
	
	@PostMapping
	public void save(@RequestBody Nota nota) {
		notaRepository.save(nota);
	}
}
