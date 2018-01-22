package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Linija;
import jwd.knjizara.web.dto.LinijaDTO;

@Component
public class LinijaToLinijaDTO 
	implements Converter<Linija, LinijaDTO> {

	
	@Override
	public LinijaDTO convert(Linija source) {
		LinijaDTO dto = new LinijaDTO();
		dto.setId(source.getId());
		dto.setMesto(source.getMesto());
		dto.setCena_karte(source.getCena_karte());
		dto.setVreme_polaska(source.getVreme_polaska());
		dto.setDestinacija(source.getDestinacija());
		dto.setPrevoznikId(source.getPrevoznik().getId());
		dto.setPrevoznikNaziv(source.getPrevoznik().getNaziv());
		//dto.setPrevoznikNaziv(source.getPrevoznik().getNaziv());
		
		
		return dto;
	}
	
	public List<LinijaDTO> convert(List<Linija> linije){
		List<LinijaDTO> ret = new ArrayList<>();
		
		for(Linija k : linije){
			ret.add(convert(k));
		}
		
		return ret;
	}

}
