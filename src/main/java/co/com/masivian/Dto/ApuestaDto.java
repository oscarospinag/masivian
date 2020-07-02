package co.com.masivian.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApuestaDto {
	
    private Long id;
    private Double value;
    private String color;
    private int number;
	
    public ApuestaDto() {
		
	}
}
