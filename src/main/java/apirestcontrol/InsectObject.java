package apirestcontrol;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;

@Data
@Entity
//@JsonRootName(value = "bug")
public class InsectObject {
	
	  private @Id @GeneratedValue Long id;
	  private String title;
	  private String description;
	  private String imageURL;
	  
	  InsectObject() {}
	  
	  InsectObject(String title, String description) {
		  this.title = title;
		  this.description = description;
	  }

	  InsectObject(String title, String description, String imageURL) {
		  this.title = title;
		  this.description = description;
		  this.imageURL = imageURL;
	  }
}
