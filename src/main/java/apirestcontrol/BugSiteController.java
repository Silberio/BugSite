package apirestcontrol;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BugSiteController {

	@Autowired
	private InsectRepository repository;

	BugSiteController(InsectRepository repository) {
		this.repository = repository;
	}


	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/bugs")
	public ResponseEntity getAll() { 
	   return ResponseEntity.ok(new HashMap<String, List<InsectObject>>() {{
		   put("bug", repository.findAll());
	   }});
	}
	
	//	post a new bug
	// it is posible to either post a bug with only title n description, but also additionally with an image URL
	@PostMapping("/bugs")
	InsectObject newInsect(@RequestBody InsectObject newInsect) {
		return repository.save(newInsect);
	}
	
	@GetMapping("/bugs/{id}")
	InsectObject getByID(@PathVariable Long id) {
		return repository.getOne(id);
	}

	
	public InsectRepository getRepository() {
		return repository;
	}
	
}
