package com.example.demo.controller;

import com.example.demo.Entity.Designer;
import com.example.demo.Repository.DesignerRepo;
import com.example.demo.Service.DesignerService;
import com.example.demo.dto.DesignerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class DesignerController {
    @Autowired
    private DesignerRepo designerRepo;

	@Autowired
	private DesignerService designerService;


	@PostMapping(value = "/saveDesigner")
	public void saveDesigner(@RequestBody DesignerDTO dto) {
		designerService.saveDesigner(dto);
	}

	@GetMapping(value = "/getAllDesigners")
    public List<Designer> findAllDesigners(){
		return designerService.getAllDesigners();
    }



    @DeleteMapping(value = "/deleteAllDesigners")
	public void deleteAllDesigner(){
		designerService.deleteAllDesigners();
	}

	@DeleteMapping(value = "/deleteDesignerById/{id}")
	public void deleteById(@PathVariable ("id") Integer id){
		designerService.deleteById(id);
	}



//	@GetMapping(value = "/searchDesigner/{firstname}")
//    @Query(value = "select Firstname from designers where firstname=sanjeewa")
//    public List<Designer> searchDesigner(@PathVariable("firstname") String firstname){
//	    return designerService.findByName();
//    }



	@GetMapping(value = "/findDesignerById/{id}")
    public ResponseEntity<Designer> findDesignerById(@PathVariable ("id")Integer id) {

        Optional<Designer> designer = designerRepo.findById(id);
        if (designer.isPresent()){
            return new ResponseEntity<>(designer.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/find/{firstname}")
//    @Query(value = "select all from designers where firstname= 'Sanjeewa'")
    public Designer findDesigner(@PathVariable("firstname") String firstname){
	    return designerService.findByName(firstname);
    }


}
