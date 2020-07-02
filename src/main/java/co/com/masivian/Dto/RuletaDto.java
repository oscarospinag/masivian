package co.com.masivian.Dto;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RuletaDto {
	
	private long id;
    private String name;   
    private Short status; 
    private List<ApuestaDto> apuestaList;
    
	public RuletaDto(long id, String name, Short status, List<ApuestaDto> apuestaList) {
		
		this.id = id;
		this.name = name;
		this.status = status;
		this.apuestaList = apuestaList;
	}

	public RuletaDto() {
		super();
	}
	
	
    
    
    
    

}
