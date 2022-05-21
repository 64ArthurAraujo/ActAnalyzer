package actanalyzer.api.controller.insert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import actanalyzer.api.request.CategoryJsonRequest;
import actanalyzer.api.response.CategoryJsonResponse;
import actanalyzer.api.service.implementation.CategoryServiceInterface;
import actanalyzer.database.table.Category;

public class CategoryInsert {
	@Autowired
	private CategoryServiceInterface categoryService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/categories/", consumes = "application/json")
	public ResponseEntity<CategoryJsonResponse> createCategory(@RequestBody CategoryJsonRequest jsonRequest) {
		Category newCreatedCategory = categoryService.insert(jsonRequest.convertJsonToEntity());
		
		return new ResponseEntity<>(new CategoryJsonResponse(newCreatedCategory), HttpStatus.CREATED);
	}
}
