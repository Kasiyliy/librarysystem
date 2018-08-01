package com.sberteam.librarysustem.RESTControllers;

import com.sberteam.librarysustem.models.Parties;
import com.sberteam.librarysustem.repositories.PartiesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "rest/parties",produces = "application/json")
public class PartiesRestController {
    PartiesRepository partiesRepository;

    public PartiesRestController(PartiesRepository partiesRepository) {
        this.partiesRepository = partiesRepository;
    }

    @GetMapping("/getAll")
    public Iterable<Parties> getAll(){
        return partiesRepository.findAll();
    }

    @GetMapping("/getById/{id}")
    public Parties getById(@RequestParam Long id){
        Optional<Parties> party= partiesRepository.findById(id);
        return party.orElse(null);
    }

    @PostMapping(path={"/insert"})
    public void insert(@RequestBody Parties party){
        partiesRepository.save(party);
    }

    @PutMapping(path={"/update/{id}"})
    public Parties update(@PathVariable("id") Long id,@RequestBody Parties party){
        if(partiesRepository.findById(id).isPresent())
            party = partiesRepository.save(party);

        return party;
    }

    @DeleteMapping(path={"/delete/{id}"})
    public void delete(@PathVariable("id") Long id){
        if(partiesRepository.findById(id).isPresent())
            partiesRepository.deleteById(id);
    }
}
