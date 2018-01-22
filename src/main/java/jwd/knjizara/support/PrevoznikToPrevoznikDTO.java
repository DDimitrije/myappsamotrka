package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;


import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Prevoznik;
import jwd.knjizara.web.dto.PrevoznikDTO;

@Component
public class PrevoznikToPrevoznikDTO 
	implements Converter<Prevoznik, PrevoznikDTO> {

	@Override
	public PrevoznikDTO convert(Prevoznik prevoznik) {
		PrevoznikDTO prevoznikDTO = new PrevoznikDTO();
		prevoznikDTO.setId(prevoznik.getId());
		prevoznikDTO.setNaziv(prevoznik.getNaziv());
		prevoznikDTO.setPIB(prevoznik.getPIB());
		prevoznikDTO.setAdresa(prevoznik.getAdresa());
		return prevoznikDTO;
	}
	
	public List<PrevoznikDTO> convert(List<Prevoznik> prevoznici) {
		List<PrevoznikDTO> ret = new ArrayList<>();
		
		for(Prevoznik i: prevoznici){
			ret.add(convert(i));
		}
		
		return ret;
	}
}