package co.com.masivian.service;

import java.util.List;
import org.springframework.http.ResponseEntity;
import co.com.masivian.Dto.ApuestaDto;


public interface ApuestaService {
	
	public ResponseEntity<List<ApuestaDto>>all();

	public ResponseEntity<ApuestaDto> save(ApuestaDto apuestaDto);

	public ResponseEntity<ApuestaDto> edit(ApuestaDto apuestaDto);

	void delete(long id);

	public ResponseEntity<ApuestaDto> apuestaDtofindById(Long id);

}
