package jwd.knjizara.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import jwd.knjizara.model.Trka;
import jwd.knjizara.web.dto.TrkaDTO;




@Component
public class TrkaTOTrkaDTO implements Converter<Trka, TrkaDTO> {

	@Override
	public TrkaDTO convert(Trka trka) {
		TrkaDTO trkaDTO = new TrkaDTO();
		trkaDTO.setId(trka.getId());
//		trkaDTO.setNaziv(trka.getNaziv());
//		trkaDTO.setPIB(trka.getPIB());
//		trkaDTO.setDrzava(trka.getDrzava());
		return trkaDTO;
		}

		public List<TrkaDTO> convert(List<Trka> trke) {
			List<TrkaDTO> ret = new ArrayList<>();

			for (Trka i : trke) {
				ret.add(convert(i));
			}

			return ret;
	}

}