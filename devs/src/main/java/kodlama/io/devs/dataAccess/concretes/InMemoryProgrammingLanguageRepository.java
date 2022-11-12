package kodlama.io.devs.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kodlama.io.devs.dataAccess.abstracts.ProgrammingLanguageRepository;
import kodlama.io.devs.entities.concretes.ProgrammingLanguage;

@Repository
public class InMemoryProgrammingLanguageRepository implements ProgrammingLanguageRepository {

	List<ProgrammingLanguage> programmingLanguages;
	
	public InMemoryProgrammingLanguageRepository() {
		programmingLanguages=new ArrayList<ProgrammingLanguage>();
		programmingLanguages.add(new ProgrammingLanguage(1,"JAVA"));
		programmingLanguages.add(new ProgrammingLanguage(2,"C#"));
	}

	@Override
	public List<ProgrammingLanguage> getAll() {
		
		return programmingLanguages;
	}

	@Override
	public void add(ProgrammingLanguage programmingLanguage) {
		
		programmingLanguages.add(programmingLanguage);
	}

	@Override
	public void delete(int id) {
		ProgrammingLanguage progLangDelete = getById(id);
		programmingLanguages.remove(progLangDelete);
	}

	@Override
	public void update(ProgrammingLanguage programmingLanguage) {
		
		ProgrammingLanguage progLangUpdate = getById(programmingLanguage.getId());
		progLangUpdate.setName(programmingLanguage.getName());
	}

	@Override
	public ProgrammingLanguage getById(int id) {
		
		for (ProgrammingLanguage progLangGetById : programmingLanguages) {
			if(progLangGetById.getId()==id) {
				return progLangGetById;
			}
		}
		return null;
	}

}
