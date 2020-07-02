package co.com.masivian.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import co.com.masivian.Dto.ApuestaDto;
import co.com.masivian.service.ApuestaService;

@RestController
@RequestMapping("/api")
public class ApuestaController {
	
	@Autowired
	private ApuestaService apuestaService;
	
	@GetMapping("/apuesta")
	public @ResponseBody ResponseEntity<List<ApuestaDto>> listar() {
		return (ResponseEntity<List<ApuestaDto>>) apuestaService.all();
	}
	
	@PostMapping("/apuesta")
	public ResponseEntity<ApuestaDto> agregar(@RequestBody ApuestaDto apuestaDto) {
		ResponseEntity<ApuestaDto> dto = apuestaService.save(apuestaDto);
		return dto;
	}
	 


}
