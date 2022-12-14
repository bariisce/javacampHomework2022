package kodlama.io.devs.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@RestController
@RequestMapping("/api/programmingLanguages")
public class ProgrammingLanguagesController {
	
	private ProgrammingLanguageService programmingLanguageService;
	
	@Autowired
	public ProgrammingLanguagesController(ProgrammingLanguageService programmingLanguageService) {
		
		this.programmingLanguageService = programmingLanguageService;
	}
	
	@GetMapping("/getall")
	public List<ProgrammingLanguage> getAll(){
		return programmingLanguageService.getAll();
	}
	
	@PostMapping("/add")
	public void add(ProgrammingLanguage programmingLanguage) throws Exception{
		programmingLanguageService.add(programmingLanguage);
	}
	
	@DeleteMapping("/delete")
	public void delete(int id) {
		programmingLanguageService.delete(id);
	}
	
	@PostMapping("/update")
	public void update(ProgrammingLanguage programmingLanguage) throws Exception{
		programmingLanguageService.update(programmingLanguage);
	}
	
	@GetMapping("/getbyid")
	public ProgrammingLanguage getById(int id) {
		return programmingLanguageService.getById(id);
	}
	
	
}
