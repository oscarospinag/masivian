package co.com.masivian.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.com.masivian.Dto.CierreDto;
import co.com.masivian.Dto.RuletaDto;
import co.com.masivian.service.RuletaService;

@RestController
@RequestMapping("/api")
public class RuletaController {
	
	@Autowired
	private RuletaService ruletaService;
	
	@PostMapping("/ruleta")
	public ResponseEntity<Long> save(@RequestBody RuletaDto RuletaDto) {
		ResponseEntity<Long> response = null ;
		RuletaDto dto =ruletaService.save(RuletaDto);
		if (dto!=null) {
			response = new ResponseEntity<Long>(dto.getId(), HttpStatus.CREATED);
		} else {
			response = new ResponseEntity<Long>(0L, HttpStatus.BAD_REQUEST);
		}
		
		return response;
	}
	
	@PutMapping("/apertura-ruleta/{id}")
	public ResponseEntity<String> aperturaRuleta(@PathVariable("id") Long id) {
		ResponseEntity<String> response = null ;
		String salida = ruletaService.aperturaRuleta(id);
		if (salida!=null && !salida.isEmpty()) {
			response = new ResponseEntity<String>(salida, HttpStatus.OK);
		} else {
			response = new ResponseEntity<String>("Error", HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@GetMapping("/cierre-ruleta/{id}")
	public ResponseEntity<CierreDto> cierreRuleta(@PathVariable("id") Long id) {
		ResponseEntity<CierreDto> response = null ;
		CierreDto salida = ruletaService.cierreRuleta(id);
		if (salida!=null) {
			response = new ResponseEntity<CierreDto>(salida, HttpStatus.OK);
		} else {
			response = new ResponseEntity<CierreDto>(salida, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@GetMapping("/ruleta")
	public @ResponseBody ResponseEntity<List<RuletaDto>> listar() {
		return new ResponseEntity<List<RuletaDto>>(ruletaService.all(), HttpStatus.OK);

	}

}
