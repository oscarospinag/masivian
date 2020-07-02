package co.com.masivian.service;

import java.util.List;
import co.com.masivian.Dto.CierreDto;
import co.com.masivian.Dto.RuletaDto;

public interface RuletaService {

	public List<RuletaDto> all();

	public RuletaDto save(RuletaDto ruletaDto);

	public RuletaDto edit(RuletaDto ruletaDto);

	void delete(long id);

	public RuletaDto ruletaDtofindById(Long id);

	public String aperturaRuleta(Long id);

	public CierreDto cierreRuleta(Long id);

}
