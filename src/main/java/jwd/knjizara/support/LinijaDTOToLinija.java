package jwd.knjizara.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Linija;
import jwd.knjizara.service.LinijaService;
import jwd.knjizara.service.PrevoznikService;
import jwd.knjizara.web.dto.LinijaDTO;


@Component
public class LinijaDTOToLinija 
	implements Converter<LinijaDTO, Linija>{
	
	@Autowired
	private LinijaService linijaService;
	@Autowired
	private PrevoznikService prevoznikService;
	
	
	@Override
	public Linija convert(LinijaDTO source) {
		Linija linija;
		if(source.getId()==null){
			linija = new Linija();
			linija.setPrevoznik(prevoznikService.findOne(source.getPrevoznikId()));
			//linija.setVrstaPiva(vrstaService.findOne(source.getVrstaPivaId()));
		}else{
			linija = linijaService.findOne(source.getId());
		}
		linija.setMesto(source.getMesto());
		linija.setCena_karte(source.getCena_karte());
		linija.setVreme_polaska(source.getVreme_polaska());
		linija.setDestinacija(source.getDestinacija());
		linija.setPrevoznik(prevoznikService.findOne(source.getPrevoznikId()));
	
		return linija;
	}

}