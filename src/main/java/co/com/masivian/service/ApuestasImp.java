package co.com.masivian.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import co.com.masivian.Dto.ApuestaDto;
import co.com.masivian.entities.Apuesta;
import co.com.masivian.repository.ApuestaRepository;

@Service
public class ApuestasImp implements ApuestaService {

	@Autowired
	private ApuestaRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.masivian.service.ApuestaService#all()
	 */
	@Override
	public ResponseEntity<List<ApuestaDto>> all() {

		List<ApuestaDto> response = null;
		List<Apuesta> entities = (List<Apuesta>) repository.findAll();
		if (entities != null && entities.size() > 0) {
			response = new ArrayList<>();
			for (Apuesta entity : entities) {
				ApuestaDto dto = new ApuestaDto();
				response.add(dto);
			}
			return new ResponseEntity<List<ApuestaDto>>(response, HttpStatus.ACCEPTED);
		}

		return new ResponseEntity<List<ApuestaDto>>(response, HttpStatus.BAD_REQUEST);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.masivian.service.ApuestaService#save(co.com.masivian.Dto.ApuestaDto)
	 * 
	 */
	@Override
	public ResponseEntity<ApuestaDto> save(ApuestaDto apuestaDto) {

		ApuestaDto response = null;
		Apuesta entity = new Apuesta();
		entity.setId(apuestaDto.getId());
		entity.setValue(apuestaDto.getValue());
		Apuesta entityDB = repository.save(entity);
		if (entityDB != null) {
			response = new ApuestaDto();
			
			return new ResponseEntity<ApuestaDto>(response, HttpStatus.CREATED);
		}
		
		return new ResponseEntity<ApuestaDto>(response, HttpStatus.BAD_REQUEST);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.masivian.service.ApuestaService#edit(co.com.masivian.Dto.ApuestaDto)
	 */
	@Override
	public ResponseEntity<ApuestaDto> edit(ApuestaDto apuestaDto) {

		ApuestaDto response = null;
		Apuesta entity = new Apuesta();
		entity.setId(apuestaDto.getId());
		entity.setValue(apuestaDto.getValue());
		Apuesta entityDB = repository.save(entity);
		if (entityDB != null) {

			return new ResponseEntity<ApuestaDto>(response, HttpStatus.CREATED);
		}

		return new ResponseEntity<ApuestaDto>(response, HttpStatus.BAD_REQUEST);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.masivian.service.ApuestaService#delete(long)
	 */
	@Override
	public void delete(long id) {
		Apuesta entity = repository.findById(id).orElse(null);
		if (entity != null) {
			repository.delete(entity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.masivian.service.ApuestaService#apuestaDtofindById(java.lang.Long)
	 */
	@Override
	public ResponseEntity<ApuestaDto> apuestaDtofindById(Long id) {
		ApuestaDto response = null;
		Apuesta entity = repository.findById(id).orElse(null);
		if (entity != null) {
			// response = new ApuestaDto(entity.getId(), entity.getValue(),
			// entity.getIdRuleta());
		}
		
		return new ResponseEntity<ApuestaDto>(response, HttpStatus.OK);
	}

}
