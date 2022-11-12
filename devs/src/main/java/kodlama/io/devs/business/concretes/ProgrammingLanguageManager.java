package kodlama.io.devs.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.devs.business.abstracts.ProgrammingLanguageService;
import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Service
public class ProgrammingLanguageManager implements ProgrammingLanguageService {

	private ProgrammingLanguageRepository programmingLanguageRepository;
	
	@Autowired
	public ProgrammingLanguageManager(ProgrammingLanguageRepository programmingLanguageRepository) {
		
		this.programmingLanguageRepository = programmingLanguageRepository;
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguageRepository.getAll();
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) throws Exception {
		
		if(programmingLanguage.getName().isEmpty()) {
			throw new Exception("This field can not be empty");
		}
		
		List<ProgrammingLanguage> progLanguages = programmingLanguageRepository.getAll();
		for (ProgrammingLanguage progLangCheck : progLanguages) {
			if(programmingLanguage.getName().equals(progLangCheck.getName())) {
				throw new Exception("This language already exist ! "); 
			}
		}
		programmingLanguageRepository.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		
		programmingLanguageRepository.delete(id);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) throws Exception {
		
		if(programmingLanguage.getName().isEmpty()) {
			throw new Exception("This field can not be empty");
		}
		
		List<ProgrammingLanguage> progLanguages = programmingLanguageRepository.getAll();
		for (ProgrammingLanguage progLangCheck : progLanguages) {
			if(programmingLanguage.getName().equals(progLangCheck.getName())) {
				throw new Exception("This language already exist ! "); 
			}
		}
		programmingLanguageRepository.update(programmingLanguage);
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		return programmingLanguageRepository.getById(id);
	}

}
