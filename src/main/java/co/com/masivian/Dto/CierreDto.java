package co.com.masivian.Dto;

import java.util.List;

import co.com.masivian.entities.Ruleta;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CierreDto {
	
	private String nombreRuleta;
	private List<ApuestaDto> apuestas;
	private Double totalApuesta;  
	
	public CierreDto() {
		super();
	}
	
	
    
    

}
