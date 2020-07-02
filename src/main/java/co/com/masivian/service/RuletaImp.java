package co.com.masivian.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.com.masivian.Dto.ApuestaDto;
import co.com.masivian.Dto.CierreDto;
import co.com.masivian.Dto.RuletaDto;
import co.com.masivian.entities.Apuesta;
import co.com.masivian.entities.Ruleta;
import co.com.masivian.repository.RuletaRepository;

@Service
public class RuletaImp implements RuletaService {

	@Autowired
	private RuletaRepository repository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.masivian.service.RuletaService#all()
	 * 
	 * Method to List the roulettes
	 */
	@Override
	public List<RuletaDto> all() {
		List<RuletaDto> response = null;
		List<Ruleta> entities = (List<Ruleta>) repository.findAll();
		if (entities != null && entities.size() > 0) {
			response = new ArrayList<>();
			for (Ruleta entity : entities) {
				RuletaDto dto = new RuletaDto();
				List<ApuestaDto> dtoruleta = null;
				if (entity.getApuestaList() != null && !entity.getApuestaList().isEmpty()) {
					dtoruleta = new ArrayList<>();
					for (Apuesta list : entity.getApuestaList()) {
						ApuestaDto dtolista = new ApuestaDto();
						dtolista.setId(list.getId());
						dtolista.setValue(list.getValue());
						dtoruleta.add(dtolista);
					}
					dto.setApuestaList(dtoruleta);
				}
				dto.setId(entity.getId());
				dto.setName(entity.getName());
				dto.setStatus(entity.getStatus());
				response.add(dto);

			}
		}
		
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.masivian.service.RuletaService#save(co.com.masivian.Dto.RuletaDto)
	 * 
	 * method to record a roulette
	 */
	@Override
	public RuletaDto save(RuletaDto ruletaDto) {
		Ruleta ruleta = new Ruleta();
		ruleta.setId(ruletaDto.getId());
		ruleta.setName(ruletaDto.getName());
		ruleta.setStatus(ruletaDto.getStatus());
		Ruleta entityDB = repository.save(ruleta);
		RuletaDto dto = new RuletaDto();
		dto.setId(entityDB.getId());
		dto.setName(entityDB.getName());
		dto.setStatus(entityDB.getStatus());
		
		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * co.com.masivian.service.RuletaService#edit(co.com.masivian.Dto.RuletaDto)
	 */
	@Override
	public RuletaDto edit(RuletaDto ruletaDto) {
		Ruleta entityFind = repository.findById(ruletaDto.getId()).orElse(null);
		RuletaDto dto = new RuletaDto();
		if (entityFind != null) {
			entityFind.setStatus(ruletaDto.getStatus());
			Ruleta entityDB = repository.save(entityFind);
			dto.setId(entityDB.getId());
			dto.setName(entityDB.getName());
			dto.setStatus(entityDB.getStatus());
		}

		return dto;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.masivian.service.RuletaService#aperturaRuleta(java.lang.Long)
	 * 
	 * method that allows to see the state of the roulette
	 * 
	 */
	@Override
	public String aperturaRuleta(Long id) {
		String response = "";
		Ruleta entityFind = repository.findById(id).orElse(null);
		if (entityFind != null) {
			entityFind.setStatus(new Short("1"));
			Ruleta entityDB = repository.save(entityFind);
			response = entityDB != null && entityDB.getId() == 1 ? "Activado" : "Inactivo";
		}
		
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.masivian.service.RuletaService#cierreRuleta(java.lang.Long)
	 * 
	 * method to return the results of the bets from opening to closing
	 * 
	 * 
	 */
	@Override
	public CierreDto cierreRuleta(Long id) {
		CierreDto response = null;
		Ruleta entityFind = repository.findById(id).orElse(null);
		if (entityFind != null) {
			response = new CierreDto();
			response.setNombreRuleta(entityFind.getName());
			Double totalApuesta = 0D;
			List<ApuestaDto> apuestas = new ArrayList<>();
			for (Apuesta apuesta : entityFind.getApuestaList()) {
				totalApuesta += apuesta.getValue();
				ApuestaDto apu = new ApuestaDto();
				apu.setId(apuesta.getId());
				apu.setValue(apuesta.getValue());
				apu.setColor(apuesta.getColor());
				apu.setNumber(apuesta.getNumero());
				apuestas.add(apu);
				response.setApuestas(apuestas);
			}
			response.setTotalApuesta(totalApuesta);
		}
		return response;
	}

	@Override
	public void delete(long id) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see co.com.masivian.service.RuletaService#ruletaDtofindById(java.lang.Long)
	 * 
	 * 
	 * Method used to search by id
	 * 
	 * 
	 */
	@Override
	public RuletaDto ruletaDtofindById(Long id) {
		Ruleta entityDB = repository.findById(id).orElse(null);

		RuletaDto dto = new RuletaDto();
		dto.setId(entityDB.getId());
		dto.setName(entityDB.getName());
		dto.setStatus(entityDB.getStatus());
		
		return dto;
	}

}
