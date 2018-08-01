package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.DocTypes;
import com.sberteam.librarysustem.repositories.DocTypesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/rest/docTypes",produces = "application/json")
public class DocTypesRestController {

    private DocTypesRepository docTypesRepository;

    public DocTypesRestController(DocTypesRepository docTypesRepository) {
        this.docTypesRepository = docTypesRepository;
    }

    @GetMapping("/getAll")
    public Iterable<DocTypes> getAll(){
        return docTypesRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public DocTypes getById(@RequestParam Long id){
        Optional<DocTypes> docTypes= docTypesRepository.findById(id);
        return docTypes.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody DocTypes docTypes){
        docTypesRepository.save(docTypes);
    }

    @PutMapping(path={"/update/{id}"})
    public DocTypes update(@PathVariable("id") Long id,@RequestBody DocTypes docTypes){
        if(docTypesRepository.findById(id).isPresent())
            docTypes = docTypesRepository.save(docTypes);

        return docTypes;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(docTypesRepository.findById(id).isPresent())
            docTypesRepository.deleteById(id);
    }
}
