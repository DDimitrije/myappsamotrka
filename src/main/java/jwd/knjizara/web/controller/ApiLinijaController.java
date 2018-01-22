package jwd.knjizara.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jwd.knjizara.model.Linija;
import jwd.knjizara.model.Kupovina;
import jwd.knjizara.service.LinijaService;
import jwd.knjizara.service.KupovinaService;
import jwd.knjizara.support.LinijaDTOToLinija;
import jwd.knjizara.support.LinijaToLinijaDTO;
import jwd.knjizara.support.KupovinaToKupovinaDTO;
import jwd.knjizara.web.dto.LinijaDTO;
import jwd.knjizara.web.dto.KupovinaDTO;

@RestController
@RequestMapping("/api/linije")
public class ApiLinijaController {
	@Autowired
	private LinijaService linijaService;
	@Autowired
	private KupovinaService kupovinaService;
	@Autowired
	private LinijaToLinijaDTO toLinijaDTO;
	@Autowired
	private KupovinaToKupovinaDTO toKupovinaDTO;
	@Autowired
	private LinijaDTOToLinija toLinija;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<LinijaDTO>> get(
			@RequestParam(required=false) String destinacija,
			@RequestParam(required=false) Integer maxMesta,
			@RequestParam(required=false) String prevoznikNaziv,
			
			@RequestParam(defaultValue="0") int pageNum){

		Page<Linija> linije;
		
		if(destinacija != null || prevoznikNaziv != null || maxMesta!= null ) { 
			linije = linijaService.pretraga(destinacija, maxMesta,  prevoznikNaziv, pageNum); 
		
		}else{
			linije = linijaService.findAll(pageNum);
}	
	
		HttpHeaders headers = new HttpHeaders();
		headers.add("totalPages", Integer.toString(linije.getTotalPages()) );
		return  new ResponseEntity<>(
				toLinijaDTO.convert(linije.getContent()),
				headers,
				HttpStatus.OK);
		
}


	
	
	@RequestMapping(method=RequestMethod.GET,
					value="/{id}")
	public ResponseEntity<LinijaDTO> get(
			@PathVariable Long id){
		Linija linija = linijaService.findOne(id);
		
		if(linija==null){
			return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(
				toLinijaDTO.convert(linija),
				HttpStatus.OK);	
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<LinijaDTO> add(
			@RequestBody LinijaDTO novaLinija){
		
		Linija linija = toLinija.convert(novaLinija); 
		linijaService.save(linija);
		
		return new ResponseEntity<>(toLinijaDTO.convert(linija),
				HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{id}/kupovina")
	public ResponseEntity<KupovinaDTO> buy(@PathVariable Long id){
		
		Kupovina k = kupovinaService.buyABook(id);
		
		if(k == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<>(toKupovinaDTO.convert(k), HttpStatus.CREATED);
		}
		
	}
	
	@RequestMapping(method=RequestMethod.PUT,
			value="/{id}")
	public ResponseEntity<LinijaDTO> edit(
			@PathVariable Long id,
			@RequestBody LinijaDTO izmenjen){
		
		if(!id.equals(izmenjen.getId())){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Linija linija = toLinija.convert(izmenjen); 
		linijaService.save(linija);
		
		return new ResponseEntity<>(toLinijaDTO.convert(linija),
				HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,
			value="/{id}")
	public ResponseEntity<LinijaDTO> delete(@PathVariable Long id){
		linijaService.remove(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
