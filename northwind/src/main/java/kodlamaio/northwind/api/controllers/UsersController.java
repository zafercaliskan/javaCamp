package kodlamaio.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.UserService;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.ErrorDataResult;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.validation.FieldError;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping(value="/api/users")
public class UsersController {
	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}

	@PostMapping(value="/add")
	public ResponseEntity<?> add(@Valid @RequestBody User user) {
		return ResponseEntity.ok(this.userService.add(user)) ;
	}

	//AOP global ex. handler
	//Herşeyin temeli base'i objecttir
	@ExceptionHandler(MethodArgumentNotValidException.class) //Bütün validation hatalarını yakalar. Type sonuna veriyoruz.
	@ResponseStatus(HttpStatus.BAD_REQUEST) //Default olarak 500 hatası döner.
	public ErrorDataResult<Object> handleValidationException
	(MethodArgumentNotValidException exceptions){
		Map<String,String> validationErrors = new HashMap<String, String>(); //c#da dictionary demek map
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) { //exceptionsdan gelen değerler. Her bir field error için
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage()); //Herbir hatayı yukarıdaki map'e(dictionary'e) ekleriz.
		}

		//ErrorDataResult'a geçirmek gerek. 
		ErrorDataResult<Object> errors 
		= new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
		return errors; //hataları döndürür.
	}
	
	
}
//200 get 
//201 add
//300
//400
//500