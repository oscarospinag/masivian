package co.com.masivian.Dto;

import java.util.List;
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
