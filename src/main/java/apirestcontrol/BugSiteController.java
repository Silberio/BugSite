package apirestcontrol;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BugSiteController {

	private final InsectRepository repository;

	BugSiteController(InsectRepository repository) {
		this.repository = repository;
	}

	// get all bugs from the repo
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/bugs")
	List<InsectObject> getAll() { 
		
		return repository.findAll();
	}

	//	post a new bug
	// Example post:
	// curl -X POST localhost:8080/bugs -H "Content-type:application/json" -d "{\"title\":\"Moth\", \"description\":\"flying cutie\"}"
	@PostMapping("/bugs")
	InsectObject newInsect(@RequestBody InsectObject newInsect) {
		return repository.save(newInsect);
	}
	
	@GetMapping("/bugs/{id}")
	InsectObject getByID(@PathVariable Long id) {
		return repository.getOne(id);
	}
	
}
